from flask import Flask, render_template, url_for, request, redirect
from flask_login import LoginManager, login_user, login_required
import connection
from secrets import token_hex
import User
from werkzeug.security import check_password_hash,generate_password_hash
from datetime import date, timedelta

app = Flask(__name__)
app.secret_key = 'secret_key'
login_manager = LoginManager()
login_manager.init_app(app)

# Connection with database
db_connection = connection.connection()


@login_manager.user_loader
def load_user(user_id):
    '''Returns object user given the user_id in the DB'''
    admin_info = db_connection.get_admin(user_id)
    user = User.Admin_user(admin_info[0], admin_info[1])
    return user

# --------- Dashboard endpoints --------------

@app.route('/', methods=['GET', 'POST'])
def login_page():
    '''Login admin page and login method'''
    if request.method == 'POST':
        FORM_USER = request.form.get('usuario')
        FORM_PASS = request.form.get('contraseña')

        try:
            USER_DB_INFO = db_connection.get_admin(FORM_USER)
        except Exception as e:
            return ({'error' : 'Error del servidor',
                    'message' : 'Error al obtener la información de la BD',
                    'details' :
                        str(e)},
                    500)

        if FORM_USER and FORM_PASS:
            if USER_DB_INFO:
                if USER_DB_INFO[0] == FORM_USER and check_password_hash(USER_DB_INFO[1], FORM_PASS):
                    login_user(load_user(FORM_USER))
                    return redirect('/dashboard')
            return {'error' : 'Unauthorized', 'message' : 'Not valid credentials', 
                    'details' : 'Not valid user or password'}, 401
        return {'error' : 'Bad request', 'message' : 'Missing requiered parameter(s)',
                'details' : 'Missing requiered parameter(s) \'usuario\' or \'contraseña\''}, 400

    return render_template('login.html', stylesheet=url_for('static', filename='css/login.css'))


@app.route('/dashboard')
@login_required
def dashboard():
    '''Admin dashboard page'''
    return render_template('pagina.html', stylesheet=url_for('static', filename='css/styles.css'),
                           graficasjs=url_for('static', filename='js/graficas.js'))


@app.route('/queries/get-comedores')
@login_required
def get_comedor():
    '''Returns name and id of all community kitchens'''
    try:
        lista_comedores = db_connection.get_comedores()
    except Exception as e:
        return ({'error' : 'Error del servidor',
                'message' : 'Error al obtener la información de la BD',
                'details' :
                    str(e)},
                500)
    
    dict_comedores = {}

    for register in lista_comedores:
        dict_comedores[register[1]] = register[0]

    return dict_comedores


@app.route('/queries/get-top-ventas')
@login_required
def get_top_ventas():
    '''Top 10 sales number per community kitchen'''
    try:
        result = db_connection.get_top_ventas()
    except Exception as e:
        return ({'error' : 'Error del servidor',
                'message' : 'Error al obtener la información de la BD',
                'details' :
                    str(e)},
                500)
    
    dict_ventas = {}

    for register in result:
        dict_ventas[register[1]] = register[2]

    return dict_ventas

@app.route('/queries/get-ventas-dia')
@login_required
def get_ventas_x_dia():
    '''Returns the sales per day given a specific "Comedor"'''
    id_comedor = request.args.get('idComedor')

    if not id_comedor:
        return {'error' : 'Bad request', 'message' : 'Missing requiered parameter', 
                'details' : 'Missing requiered parameter \'idComedor\''}, 400

    try:
        resultado = db_connection.get_ventasDia_comedor(int(id_comedor))
    except Exception as e:
        return ({'error' : 'Error del servidor', 
                'message' : 'Error al obtener la información de la BD', 
                'details' : str(e)}, 500)
    
    dict_ventas_dia = {'lunes' : 0, 'martes' : 0, 'miércoles' : 0, 
                       'jueves' : 0, 'viernes' : 0, 'sábado' : 0, 
                       'domingo' : 0}

    for register in resultado:
        dict_ventas_dia[register[0]] = register[1]

    return dict_ventas_dia

@app.route('/queries/get-ventas-hora')
@login_required
def get_ventasHora():
    '''Returns the number of sales by hour of a community kitchen'''
    id_comedor = request.args.get('idComedor')

    if not id_comedor:
        return {'error' : 'Bad request', 'message' : 'Missing requiered parameter', 
                'details' : 'Missing requiered parameter \'idComedor\''}, 400

    try:
        resultado = db_connection.get_ventasHora_comedor(int(id_comedor))
    except Exception as e:
        return ({'error' : 'Error del servidor', 
                'message' : 'Error al obtener la información de la BD', 
                'details' : str(e)}, 500)
    
    dict_ventas_hora = {t : 0 for t in range(24)}

    for register in resultado:
        dict_ventas_hora[register[0]] = register[1]

    return dict_ventas_hora

@app.route('/queries/get-num-dependencias')
@login_required
def get_dependencias():
    '''Returns the number of dependants'''
    try:
        dependencias = db_connection.get_num_dependencia()
    except Exception as e:
        return ({'error' : 'Error del servidor',
                'message' : 'Error al obtener la información de la BD',
                'details' :
                    str(e)},
                500)
    
    dict_num_dependencias = {'Dependiente' : 0, 'Independiente' : 0}

    for register in dependencias:
        dict_num_dependencias[register[0]] = register[1]

    return dict_num_dependencias

@app.route('/queries/get-cant-sexos')
@login_required
def get_tipoPoblacion():
    '''Returns the sex of the clients of all kitchens'''
    try:
        resultado = db_connection.get_sexo_clientes()
    except Exception as e:
        return ({'error' : 'Error del servidor',
                'message' : 'Error al obtener la información de la BD',
                'details' :
                    str(e)},
                500)
    
    dict_sexos = {'M' : 0, 'H' : 0}

    for register in resultado:
        dict_sexos[register[0]] = register[1]

    return dict_sexos

@app.route('/queries/get-donaciones')
@login_required
def get_donaciones():
    '''Returns the number of donations of a community kitchen'''
    id_comedor = request.args.get('idComedor')

    if not id_comedor:
        return {'error' : 'Bad request', 'message' : 'Missing requiered parameter',
                'details' : 'Missing requiered parameter \'idComedor\''}, 400
    
    try:
        resultado = db_connection.get_cantidad_donaciones_comedor(int(id_comedor))
    except Exception as e:
        return ({'error' : 'Error del servidor',
                'message' : 'Error al obtener la información de la BD',
                'details' :
                    str(e)},
                500)

    if not resultado:
        resultado = []

    try:
        num1 = resultado[0][0]
    except IndexError:
        num1 = 0

    try:
        num2 = resultado[1][0]
    except IndexError:
        num2 = 0

    resultado = [num1,num2]

    return {"No donaciones": resultado[0], "Donaciones": resultado[1]}

@app.route('/queries/get-edades')
@login_required
def get_rangosEdades():
    '''Returns the ranges and the quantity of clients per age range'''
    try:
        resultado = db_connection.get_rangos_edades_comedor()
    except Exception as e:
        return ({'error' : 'Error del servidor',
                'message' : 'Error al obtener la información de la BD',
                'details' :
                    str(e)},
                500)
    
    dict_edades = {'Niños' : 0, 'Estudiantes adolescentes (12 - 19)' : 0, 
                   'Adultos (20 - 65)' : 0, 'Adultos Mayores (65+)' : 0}

    for register in resultado:
        dict_edades[register[0]] = register[1]

    return dict_edades

@app.route('/queries/get-metas')
@login_required
def get_metas():
    '''Returns the number of sales in the last 30 days of a community kitchen'''
    id_comedor = request.args.get('idComedor')

    if not id_comedor:
        return {'error' : 'Bad request',
                'message' : 'Missing requiered parameter',
                'details' : 'Missing requiered parameter \'idComedor\''}, 400
    
    try:
        resultado = db_connection.get_metas_comedor(int(id_comedor))
    except Exception as e:
        return ({'error' : 'Error del servidor',
                'message' : 'Error al obtener la información de la BD',
                'details' :
                    str(e)},
                500)
    
    dict_metas = {}

    date_now = date.today()
    for i in range(30):
        dict_metas[str(date_now - timedelta(days=i))] = 0

    for register in resultado:
        dict_metas[str(register[0])] = register[1]

    return dict_metas

@app.route('/queries/get-cierres')
@login_required
def get_cierres():
    '''Returns the number of times different kitchens closed'''
    try:
        resultado = db_connection.get_cierres()
    except Exception as e:
        return ({'error' : 'Error del servidor',
                'message' : 'Error al obtener la información de la BD',
                'details' :
                    str(e)},
                500)
    dict_cierres = {}

    for register in resultado:
        dict_cierres[register[0]] = register[1]

    return dict_cierres

@app.route('/queries/get-evaluaciones')
@login_required
def get_califs():
    '''Returns the average of a kitchen different categories'''
    id_comedor = request.args.get('idComedor')
    
    if not id_comedor:
        return {'error' : 'Bad request',
                'message' : 'Missing requiered parameter',
                'details' : 'Missing requiered parameter \'idComedor\''}, 400
    
    try:
        resultado = db_connection.get_calificaciones(int(id_comedor))
    except Exception as e:
        return ({'error' : 'Error del servidor',
                'message' : 'Error al obtener la información de la BD',
                'details' :
                    str(e)},
                500)
    
    try:
        dict_calificaciones = {'Servicio' : round(resultado[1], 2), 
                                'Higiene' : round(resultado[2], 2), 
                                'Calidad' : round(resultado[3], 2)}
    except TypeError:
        dict_calificaciones = {'Servicio' : 0, 'Higiene' : 0, 'Calidad' : 0}

    return dict_calificaciones

# --------- App "Comedor" endpoints --------------

@app.route('/app/comedor/login', methods = ['POST'])
def app_comedor_login():
    JSON = dict(request.get_json())

    JSON_USER = JSON.get('usuario')
    JSON_PASSW = JSON.get('contraseña')

    if not JSON_USER or not JSON_PASSW:
        return {'error': 'Bad request',
                'message': 'Missing required parameter(s)',
                'details' : 'Missing required parameter(s) \'usuario\' or \'contraseña\''}, 400

    try:
        COMEDOR_DB_INFO = db_connection.get_comedor(JSON_USER)
    except Exception as e:
        return ({'error' : 'Error del servidor',
                 'message' : 
                    'Error al recuperar información del usuario de la BD',
                 'details' : str(e)}), 500
    
    valid_credentials = False

    for register in COMEDOR_DB_INFO:
        if JSON_USER == register[1] and check_password_hash(register[2], JSON_PASSW):
            valid_credentials = True
            break

    if valid_credentials:
        TOKEN = token_hex(16)
        try:
            db_connection.login_comedor(TOKEN, register[0])
            return {'token': TOKEN}, 200
        except Exception as e:
            return {'error': 'Error del servidor',
                    'message': 'Error al insertar la información del usuario en la BD',
                    'details': str(e)}, 500
    else:
        return {'error': 'Unauthorized',
                'message' : 'Not valid credentials',
                'details' : 'Not valid user or password'}, 401


@app.route('/app/comedor/generar-pedido', methods=['POST'])
def generar_pedido():

    JSON = dict(request.get_json())

    TOKEN = JSON.get('token')
    if not TOKEN:
        return {'error': 'Bad request',
                'message': 'Missing required parameter',
                'details' : 'Missing required parameter \'token\''}, 400

    try:
        COMEDOR_INFO = db_connection.get_token_comedor(TOKEN)
    except Exception as e:
        return ({'error' : 'Error del servidor',
                 'message' : 
                    'Error al recuperar token de la BD',
                 'details' : str(e)}), 500
    
    if not COMEDOR_INFO:
        return {'error': 'Unauthorized',
                'message' : 'Not valid token',
                'details' : 'Not valid token'}, 401

    DONACION = JSON.get('donacion')
    RESPONSABLE = JSON.get('responsable')
    DEPENDIENTE = JSON.get('dependiente')
    IDCOMIDA = JSON.get('idComida')

    if not (RESPONSABLE and DEPENDIENTE and IDCOMIDA and DONACION is not None):
        return {'error': 'Bad request',
                'message': 'Missing required parameter(s)',
                'details' : 'Missing required parameter(s) \'donacion\' or \'responsable\' or \'dependiente\' or \'idComida\''}, 400

    try:
        return {'idPedido' : db_connection.generar_pedido(DONACION,
                                                          RESPONSABLE, DEPENDIENTE,
                                                          COMEDOR_INFO[1], IDCOMIDA)}, 200
    except Exception as e:
        return {'error': 'Error del servidor',
                'message': 'Error al insertar la información del pedido en la BD',
                'details': str(e)}, 500


@app.route('/app/comedor/<token>/get-dependientes')
def get_dependientes_cliente(token):

    try:
        COMEDOR_INFO = db_connection.get_token_comedor(token)
    except Exception as e:
        return ({'error' : 'Error del servidor',
                 'message' : 
                    'Error al recuperar token de la BD',
                 'details' : str(e)}), 500
    
    if not COMEDOR_INFO:
        return {'error' : 'Unauthorized',
                'message' : 'token no valido',
                'details' : f'No existe un token autorizado {token}'}, 401
    
    CURP_RESPONSABLE = request.args.get('curp-responsable')

    if not CURP_RESPONSABLE:
        return {'error' : 'Bad request',
                'message' : 'Missing requiered query parameter',
                'details' : 'Missing requiered query parameter \'curp-responsable\''}, 400

    try:
        return {'dependientes' : db_connection.get_dependencias_cliente(CURP_RESPONSABLE)}
    except Exception as e:
        return {'error': 'Error del servidor',
                'message': 'Error al obtener la información de la BD',
                'details': str(e)}, 500

@app.route('/app/comedor/publicar-menu', methods=['POST'])
def publicar_menu():
    JSON = dict(request.get_json())

    TOKEN_JSON = JSON.get('token')

    if TOKEN_JSON:
        try:
            COMEDOR_INFO = db_connection.get_token_comedor(TOKEN_JSON)
        except Exception as e:
            return ({'error' : 'Error del servidor',
                    'message' : 
                        'Error al recuperar token de la BD',
                    'details' : str(e)}), 500
    else:
        return {'error' : 'Bad request',
                'message' : 'Missing requiered parameter',
                'details' : 'Missing requiered parameter \'token\''}, 400
    
    if not COMEDOR_INFO:
        return {'error' : 'Unauthorized',
                'message' : 'token no valido',
                'details' : f'No existe un token autorizado {TOKEN_JSON}'}, 401
    
    ENTRADA_JSON = JSON.get('entrada')
    PLATO_JSON = JSON.get('plato')
    POSTRE_JSON = JSON.get('postre')

    if not (ENTRADA_JSON and PLATO_JSON and POSTRE_JSON):
        return {'error' : 'Bad request',
                'message' : 'Missing requiered parameter(s)',
                'details' : 'Missing requiered parameter(s) \'entrada\' or \'plato\' or \'postre\''}, 400
    
    try:
        return {'idComida' : db_connection.publicar_menu(TOKEN_JSON,ENTRADA_JSON,PLATO_JSON,POSTRE_JSON)}, 200
    except Exception as e:
        return {'error': 'Error del servidor',
                'message': 'Error al insertar la información del pedido en la BD',
                'details': str(e)}, 500
    
@app.route('/app/comedor/<token>/get-clientes')
def get_clientes(token):

    try:
        COMEDOR_INFO = db_connection.get_token_comedor(token)
    except Exception as e:
        return ({'error' : 'Error del servidor',
                 'message' : 
                    'Error al recuperar token de la BD',
                 'details' : str(e)}), 500

    if not COMEDOR_INFO:
        return {'error' : 'Unauthorized',
                'message' : 'token no valido',
                'details' : f'No existe un token autorizado {token}'}, 401
    
    try:
        return {'clientes' : db_connection.get_clientes()}
    except Exception as e:
        return {'error': 'Error del servidor',
                'message': 'Error al obtener la información de la BD',
                'details': str(e)}, 500
    
@app.route('/app/comedor/registrar-cliente', methods=['POST'])
def app_comedor_registrar_cliente():
    JSON = dict(request.get_json())

    TOKEN_JSON = JSON.get('token')

    if TOKEN_JSON:
        try:
            COMEDOR_INFO = db_connection.get_token_comedor(TOKEN_JSON)
        except Exception as e:
            return ({'error' : 'Error del servidor',
                    'message' : 
                        'Error al recuperar token de la BD',
                    'details' : str(e)}), 500
    else:
        return {'error' : 'Bad request',
                'message' : 'Missing requiered parameter',
                'details' : 'Missing requiered parameter \'token\''}, 400
    
    if not COMEDOR_INFO:
        return {'error' : 'Unauthorized',
                'message' : 'token no valido',
                'details' : f'No existe un token autorizado {TOKEN_JSON}'}, 401
    
    CURP_JSON = JSON.get('curp')
    NOMBRE_JSON = JSON.get('nombre')
    APELLIDOP_JSON = JSON.get('apellidop')
    APELLIDOM_JSON = JSON.get('apellidom')
    ANIO_NACIMIENTO = JSON.get('añoNacimiento')
    CONDICION_JSON = JSON.get('condicion')
    CONTRASENA_JSON = JSON.get('contraseña')
    CURP_RESPONSABLE_JSON = JSON.get('curp-responsable')

    if not (CURP_JSON and NOMBRE_JSON and
        APELLIDOP_JSON and APELLIDOM_JSON and
        ANIO_NACIMIENTO and
        CONDICION_JSON and CONTRASENA_JSON and CURP_RESPONSABLE_JSON):
        return {'error' : 'Bad request',
                'message' : 'Missing requiered parameter(s)',
                'details' : '''Missing requiered parameter(s) \'curp\'
                    or \'nombre\' or \'apellidop\' 
                    or \'apellidom\' or \'condicion\'
                    or \'contraseña\' or \'curp-responsable\''''}, 400
    
    SEXO_JSON = CURP_JSON[10]
    FECHA_NACIMIENTO_JSON = ANIO_NACIMIENTO + '-' + CURP_JSON[6:8] + '-' + CURP_JSON[8:10]

    try:
        db_connection.registrar_cliente(CURP_JSON,NOMBRE_JSON,APELLIDOP_JSON,
                                        APELLIDOM_JSON,SEXO_JSON,FECHA_NACIMIENTO_JSON,
                                        CONDICION_JSON,generate_password_hash(CONTRASENA_JSON))
        db_connection.registrar_dependientes(CURP_RESPONSABLE_JSON,CURP_JSON)
    except Exception as e:
        return ({'error' : 'Error del servidor',
                 'message' : 
                    'Error al insertar la información del usuario en la BD',
                 'details' : str(e)}), 500
    
    return {'message' : 'Usuario registrado',
            'details' : f'Se ha registrado correctamente al usuario {CURP_JSON}'}, 200
    

@app.route('/app/comedor/<token>/get-donaciones-dia')
def app_comedor_get_donaciones(token):
    try:
        COMEDOR_INFO = db_connection.get_token_comedor(token)
    except Exception as e:
        return ({'error' : 'Error del servidor',
                 'message' : 
                    'Error al recuperar token de la BD',
                 'details' : str(e)}), 500

    if not COMEDOR_INFO:
        return {'error' : 'Unauthorized',
                'message' : 'token no valido',
                'details' : f'No existe un token autorizado {token}'}, 401
    
    IDCOMEDOR = COMEDOR_INFO[1]
    
    try:
        resultado = db_connection.get_donaciones_comedor_dia(int(IDCOMEDOR))
    except Exception as e:
        return ({'error' : 'Error del servidor',
                 'message' : 
                    'Error al insertar la información del usuario en la BD',
                 'details' : str(e)}), 500

    if not resultado:
        resultado = []

    try:
        num1 = resultado[0][0]
    except IndexError:
        num1 = 0

    try:
        num2 = resultado[1][0]
    except IndexError:
        num2 = 0

    resultado = [num1,num2]

    return {"No donaciones": resultado[0], "Donaciones": resultado[1]}

@app.route('/app/comedor/publicar-anuncio', methods=['POST'])
def publicar_anuncio():
    JSON = dict(request.get_json())

    TOKEN_JSON = JSON.get('token')

    if not TOKEN_JSON:
        return {'error' : 'Bad request',
                'message' : 'Missing requiered parameter',
                'details' : 'Missing requiered parameter \'token\''}, 400
    
    CONTENIDO_ANUNCIO_JSON = JSON.get('contenido')
    CIERRE_ANUNCIO_JSON = JSON.get('cierre')

    if not (CONTENIDO_ANUNCIO_JSON and str(CIERRE_ANUNCIO_JSON)):
        return {'error' : 'Bad request',
                'message' : 'Missing requiered parameter(s)',
                'details' : 'Missing requiered parameter(s) \'contenido\' or \'cierre\''}, 400
    
    try:
        db_connection.publicar_anuncio(TOKEN_JSON,CONTENIDO_ANUNCIO_JSON,CIERRE_ANUNCIO_JSON)
    except Exception as e:
        return ({'error' : 'Error del servidor',
                 'message' : 
                    'Error al insertar la información del usuario en la BD',
                 'details' : str(e)}), 500
    
    return {'message' : 'Anuncio publicado',
            'details' : 'Se ha publicado correctamente el anuncio'}, 200
    

# --------- App "Clientes" endpoints --------------

@app.route('/app/clientes/login', methods = ['POST'])
def app_clientes_login():
    JSON = dict(request.get_json())

    JSON_USER = JSON.get('usuario')
    JSON_PASS = JSON.get('contraseña')

    if not JSON_USER or not JSON_PASS:
        return {'error': 'Bad request',
                'message': 'Missing required parameter(s)',
                'details' : 'Missing required parameter(s) \'usuario\' or \'contraseña\''}, 400
    
    try:
        CLIENTE_DB_INFO = db_connection.get_cliente(JSON_USER)
    except Exception as e:
        return ({'error' : 'Error del servidor',
                 'message' : 
                    'Error al recuperar información del usuario de la BD',
                 'details' : str(e)}), 500

    if CLIENTE_DB_INFO:
        if JSON_USER == CLIENTE_DB_INFO[0] and check_password_hash(CLIENTE_DB_INFO[1],JSON_PASS):
            TOKEN = token_hex(16)
            try:
                db_connection.login_cliente(TOKEN,JSON_USER)
                return {'token' : TOKEN}, 200
            except Exception as e:
                return ({'error' : 'Error del servidor',
                            'message' : 
                                'Error al insertar la información del usuario en la BD',
                            'details' :
                                str(e)},
                            500)
    return {'error' : 'Unauthorized', 'message' : 'Not valid credentials',
            'details' : 'Not valid user or password'}, 401

@app.route('/app/clientes/registrar-cliente', methods=['POST'])
def app_clientes_registrar_cliente():
    JSON = dict(request.get_json())

    CURP_JSON = JSON.get('curp')
    NOMBRE_JSON = JSON.get('nombre')
    APELLIDOP_JSON = JSON.get('apellidop')
    APELLIDOM_JSON = JSON.get('apellidom')
    ANIO_NACIMIENTO = JSON.get('añoNacimiento')
    CONDICION_JSON = JSON.get('condicion')
    CONTRASENA_JSON = JSON.get('contraseña')

    if not (CURP_JSON and NOMBRE_JSON and
        APELLIDOP_JSON and APELLIDOM_JSON and
        ANIO_NACIMIENTO and
        CONDICION_JSON and CONTRASENA_JSON):
        return {'error' : 'Bad request',
                'message' : 'Missing requiered parameter(s)',
                'details' : '''Missing requiered parameter(s) \'curp\'
                    or \'nombre\' or \'apellidop\' 
                    or \'apellidom\' or \'condicion\'
                    or \'contraseña\''''}, 400

    SEXO_JSON = CURP_JSON[10]
    FECHA_NACIMIENTO_JSON = ANIO_NACIMIENTO + '-' + CURP_JSON[6:8] + '-' + CURP_JSON[8:10]

    try:
        db_connection.registrar_cliente(CURP_JSON,NOMBRE_JSON,APELLIDOP_JSON,
                                        APELLIDOM_JSON,SEXO_JSON,FECHA_NACIMIENTO_JSON,
                                        CONDICION_JSON,generate_password_hash(CONTRASENA_JSON))
        db_connection.registrar_dependientes(CURP_JSON,CURP_JSON)
    except Exception as e:
        return ({'error' : 'Error del servidor',
                 'message' : 
                    'Error al insertar la información del usuario en la BD',
                 'details' : str(e)}), 500
    
    return {'message' : 'Usuario registrado',
            'details' : f'Se ha registrado correctamente al usuario {CURP_JSON}'}, 200

@app.route('/app/clientes/<token>/get-menu-comedor')
def get_menu_comedor(token):
    try:
        CLIENTE_INFO = db_connection.get_token_cliente(token)
    except Exception as e:
        return ({'error' : 'Error del servidor',
                 'message' : 
                    'Error al recuperar token de la BD',
                 'details' : str(e)}), 500
    
    if not CLIENTE_INFO:
        return {'error' : 'Unauthorized',
                'message' : 'token no válido',
                'details' : f'No existe un token autorizado {token}'}, 401
    
    IDCOMEDOR = request.args.get('idComedor')

    if not IDCOMEDOR:
        return {'error' : 'Bad request',
                'message' : 'Missing requiered query parameter',
                'details' : 'Missing requiered query parameter \'idComedor\''}, 400
    
    try:
        MENU = db_connection.get_menu(int(IDCOMEDOR))
    except Exception as e:
        return ({'error' : 'Error del servidor',
                 'message' : 
                    'Error al insertar la información del usuario en la BD',
                 'details' : str(e)}), 500
    
    try:
        return {'entrada' : MENU[0], 'plato' : MENU[1], 'postre' : MENU[2]}
    except (IndexError, TypeError):
        return {'error' : 'Not found',
                'message' : 'Not found menu for today',
                'details' : f'No existe un menu para el comedor {IDCOMEDOR} para el día de hoy'}, 404

@app.route('/app/clientes/<token>/get-comedores')
def get_comedores(token):
    '''Returns name and id of all community kitchens'''

    try:
        CLIENTE_INFO = db_connection.get_token_cliente(token)
    except Exception as e:
        return ({'error' : 'Error del servidor',
                 'message' : 
                    'Error al recuperar token de la BD',
                 'details' : str(e)}), 500

    if not CLIENTE_INFO:
        return {'error' : 'Unauthorized',
                'message' : 'token no valido',
                'details' : f'No existe un token autorizado {token}'}, 401
    
    try:
        lista_comedores = db_connection.get_comedores()
    except Exception as e:
        return ({'error' : 'Error del servidor',
                 'message' : 
                    'Error al obtener la información de la BD',
                 'details' : str(e)}), 500
    dict_comedores = {}

    for register in lista_comedores:
        dict_comedores[register[1]] = register[0]

    return dict_comedores

@app.route('/app/clientes/<token>/get-pedidos')
def app_clientes_get_pedidos(token):
    try:
        CLIENTE_INFO = db_connection.get_token_cliente(token)
    except Exception as e:
        return ({'error' : 'Error del servidor',
                 'message' : 
                    'Error al recuperar token de la BD',
                 'details' : str(e)}), 500

    if not CLIENTE_INFO:
        return {'error' : 'Unauthorized',
                'message' : 'token no valido',
                'details' : f'No existe un token autorizado {token}'}, 401
    
    CURP_CLIENTE = CLIENTE_INFO[1]

    try:
        PEDIDOS = db_connection.get_pedidos_cliente(CURP_CLIENTE)
    except Exception as e:
        return ({'error' : 'Error del servidor',
                 'message' : 
                    'Error al obtener la información de la BD',
                 'details' : str(e)}), 500
    
    dict_pedidos = {}
    for register in PEDIDOS:
        dict_pedidos[register[0]] = {'fechaHora' : register[1].strftime('%Y-%m-%d %H:%M:%S'),
                                     'nombreComedor' : register[2]}
        
    return dict_pedidos

@app.route('/app/clientes/publicar-evaluacion', methods=['POST'])
def publicar_evaluacion():
    JSON = dict(request.get_json())

    TOKEN_JSON = JSON.get('token')

    if not TOKEN_JSON:
        return {'error' : 'Bad request',
                'message' : 'Missing requiered parameter',
                'details' : 'Missing requiered parameter \'token\''}, 400
    try:
        CLIENTE_INFO = db_connection.get_token_cliente(TOKEN_JSON)
    except Exception as e:
        return ({'error' : 'Error del servidor',
                 'message' : 
                    'Error al recuperar token de la BD',
                 'details' : str(e)}), 500

    if not CLIENTE_INFO:
        return {'error' : 'Unauthorized',
                'message' : 'token no valido',
                'details' : f'No existe un token autorizado {TOKEN_JSON}'}, 401
    
    IDPEDIDO_JSON = JSON.get('idPedido')
    SERVICIO_JSON = JSON.get('servicio')
    HIGIENE_JSON = JSON.get('higiene')
    CALIDAD_JSON = JSON.get('calidad')

    if not (IDPEDIDO_JSON and SERVICIO_JSON and HIGIENE_JSON and CALIDAD_JSON):
        return {'error' : 'Bad request',
                'message' : 'Missing requiered parameter(s)',
                'details' : 'Missing requiered parameter(s) \'idPedido\' or \'servicio\' or \'higiene\' or \'calidad\''}, 400
    
    try:
        db_connection.publicar_evaluacion(IDPEDIDO_JSON,SERVICIO_JSON,HIGIENE_JSON,CALIDAD_JSON)
    except Exception as e:
        return ({'error' : 'Error del servidor',
                 'message' : 
                    'Error al insertar la información del usuario en la BD',
                 'details' : str(e)}), 500
    
    return {'message' : 'Evaluación publicada',
            'details' : 'Se ha publicado correctamente la evaluación'}, 200


if __name__ == '__main__':
    app.run(debug=True,host='0.0.0.0')
from flask import Flask, render_template, url_for, request, redirect
from flask_login import LoginManager, login_user, login_required
import connection
from secrets import token_hex
import User
from werkzeug.security import check_password_hash
from datetime import date, timedelta

app = Flask(__name__)
app.secret_key = token_hex()
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

        USER_DB_INFO = db_connection.get_admin(FORM_USER)

        if FORM_USER and FORM_PASS:
            if USER_DB_INFO:
                if USER_DB_INFO[0] == FORM_USER and check_password_hash(USER_DB_INFO[1], FORM_PASS):
                    login_user(load_user(FORM_USER))
                    return redirect('/dashboard')
            return 'Not valid user or password, try again.', 401
        return 'Bad request: Missing requiered parameter(s) \'usuario\' or \'contraseña\'', 400

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
    lista_comedores = db_connection.get_comedores()
    dict_comedores = {}

    for register in lista_comedores:
        dict_comedores[register[1]] = register[0]

    return dict_comedores


@app.route('/queries/get-top-ventas')
@login_required
def get_top_ventas():
    '''Top 10 sales number per community kitchen'''
    result = db_connection.get_top_ventas()
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
        return 'Bad request: Missing requiered parameter \'idComedor\'', 400

    resultado = db_connection.get_ventasDia_comedor(int(id_comedor))
    
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
        return 'Bad request: Missing requiered parameter \'idComedor\'', 400

    resultado = db_connection.get_ventasHora_comedor(int(id_comedor))
    dict_ventas_hora = {t : 0 for t in range(24)}

    for register in resultado:
        dict_ventas_hora[register[0]] = register[1]

    return dict_ventas_hora

@app.route('/queries/get-num-dependencias')
@login_required
def get_dependencias():
    '''Returns the number of dependants'''
    dependencias = db_connection.get_num_dependencia()
    dict_num_dependencias = {'Dependiente' : 0, 'Independiente' : 0}

    for register in dependencias:
        dict_num_dependencias[register[0]] = register[1]

    return dict_num_dependencias

@app.route('/queries/get-cant-sexos')
@login_required
def get_tipoPoblacion():
    '''Returns the sex of the clients of all kitchens'''
    resultado = db_connection.get_sexo_clientes()
    dict_sexos = {'F' : 0, 'H' : 0}

    for register in resultado:
        dict_sexos[register[0]] = register[1]

    return dict_sexos

@app.route('/queries/get-donaciones')
@login_required
def get_donaciones():
    '''Returns the number of donations of a community kitchen'''
    id_comedor = request.args.get('idComedor')

    if not id_comedor:
        return 'Bad request: Missing requiered parameter \'idComedor\'', 400
    
    resultado = db_connection.get_cantidad_donaciones_comedor(int(id_comedor))

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
    resultado = db_connection.get_rangos_edades_comedor()
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
        return 'Bad request: Missing requiered parameter \'idComedor\'', 400
    
    resultado = db_connection.get_metas_comedor(int(id_comedor))
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
    resultado = db_connection.get_cierres()
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
        return 'Bad request: Missing requiered parameter \'idComedor\'', 400
    
    try:
        resultado = db_connection.get_calificaciones(int(id_comedor))
        print(resultado)
    except Exception as e:
        return ({'error' : 'Error del servidor',
                'message' : 'Error al obtener la información de la BD',
                'details' :
                    str(e)},
                500)
    
    dict_calificaciones = {'Servicio' : round(resultado[1], 2), 
                            'Higiene' : round(resultado[2], 2), 
                            'Calidad' : round(resultado[3], 2)}    
    return dict_calificaciones

# --------- App "Comedor" endpoints --------------

@app.route('/app/comedor/login', methods = ['POST'])
def app_comedor_login():
    JSON = dict(request.get_json())

    JSON_USER = JSON.get('usuario')
    JSON_PASSW = JSON.get('contraseña')

    if JSON_USER and JSON_PASSW:
        COMEDOR_DB_INFO = db_connection.get_comedor(JSON_USER)

        for register in COMEDOR_DB_INFO:
            if JSON_USER == register[1] and check_password_hash(register[2],JSON_PASSW):
                TOKEN = token_hex(16)
                try:
                    db_connection.login_comedor(TOKEN,register[0])
                    return TOKEN, 200
                except Exception as e:
                    return ({'error' : 'Error del servidor',
                            'message' : 
                                'Error al insertar la información del usuario en la BD',
                            'details' :
                                str(e)},
                            500)
        return 'Not valid user or password, try again.', 401
    
    return 'Bad request: Missing requiered parameter(s) \'usuario\' or \'contraseña\'', 400

@app.route('/app/comedor/generar-pedido', methods=['POST'])
def generar_pedido():

    JSON = dict(request.get_json())

    TOKEN = JSON.get('token')
    COMEDOR_INFO = db_connection.get_token_comedor(TOKEN)

    if COMEDOR_INFO:
        DONACION  = JSON.get('donacion')
        RESPONSABLE = JSON.get('responsable')
        DEPENDIENTE = JSON.get('dependiente')
        IDCOMIDA = JSON.get('idComida')

        if (RESPONSABLE and
            DEPENDIENTE and IDCOMIDA and
            DONACION is not None):
            try:
                db_connection.generar_pedido(DONACION,
                                             RESPONSABLE,
                                             DEPENDIENTE,
                                             COMEDOR_INFO[1],
                                             IDCOMIDA)
                return 'Pedido creado con éxito', 200
            
            except Exception as e:
                return ({'error' : 'Error del servidor',
                            'message' : 
                                'Error al insertar la información del pedido en la BD',
                            'details' :
                                str(e)},
                            500)

        return '''Bad request: 
            Missing requiered parameter(s)
              \'donacion\' or \'responsable\' or
              \'dependiente\' or \'idComida\'''', 400

    return 'Not valid token, try again', 401

# --------- App "Clientes" endpoints --------------

@app.route('/app/clientes/login', methods = ['POST'])
def app_clientes_login():
    JSON = dict(request.get_json())

    JSON_USER = JSON.get('usuario')
    JSON_PASS = JSON.get('contraseña')

    if JSON_USER and JSON_PASS:
        CLIENTE_DB_INFO = db_connection.get_cliente(JSON_USER)
        if CLIENTE_DB_INFO:
            if JSON_USER == CLIENTE_DB_INFO[0] and check_password_hash(CLIENTE_DB_INFO[1],JSON_PASS):
                TOKEN = token_hex(16)
                try:
                    db_connection.login_cliente(TOKEN,JSON_USER)
                    return {'token':TOKEN},200
                except Exception as e:
                    return ({'error' : 'Error del servidor',
                                'message' : 
                                    'Error al insertar la información del usuario en la BD',
                                'details' :
                                    str(e)},
                                500)
        return 'Not valid user or password, try again.', 401
    return 'Bad request: Missing requiered parameter(s) \'usuario\' or \'contraseña\'', 400

if __name__ == '__main__':
    app.run(debug=True,host='0.0.0.0')
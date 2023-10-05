from flask import Flask, render_template, url_for, request, redirect
from flask_login import LoginManager, login_user, login_required
import connection
from secrets import token_hex
import User
from werkzeug.security import check_password_hash
import secrets

app = Flask(__name__)
app.secret_key = token_hex()
login_manager = LoginManager()
login_manager.init_app(app)

# Connection with database
db_connection = connection.connection()
sqlite_admin_connection = connection.Admin_connection()


@login_manager.user_loader
def load_user(user_id):
    '''Returns object user given the user_id in the DB'''
    admin_info = sqlite_admin_connection.get_admin(user_id)
    user = User.User(admin_info[0], admin_info[1])
    return user


@app.route('/', methods=['GET', 'POST'])
def login_page():
    '''Login admin page and login method'''
    if request.method == 'POST':
        FORM_USER = request.form.get('usuario')
        FORM_PASS = request.form.get('contraseña')

        USER_DB_INFO = sqlite_admin_connection.get_admin(FORM_USER)

        if USER_DB_INFO:
            if USER_DB_INFO[0] == FORM_USER and check_password_hash(USER_DB_INFO[1], FORM_PASS):
                login_user(load_user(FORM_USER))
                return redirect('/dashboard')

        return 'Not valid user or password, try again.', 401

    return render_template('login.html', stylesheet=url_for('static', filename='css/login.css'))


@app.route('/app/comedor/login', methods = ['POST'])
def app_user_login():
    JSON = request.get_json()

    if 'usuario' not in JSON or 'contraseña' not in JSON:
        return 'Not valid user or password, try again.', 401
    
    JSON_USER = JSON['usuario']
    JSON_PASSW = JSON['contraseña']
    


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
    id_comedor = request.args.get('idComedor')
    resultado = db_connection.get_ventasDia_comedor(int(id_comedor))
    '''Returns the sales per day given a specific "Comedor"'''
    dict_ventas_dia = {}

    for register in resultado:
        dict_ventas_dia[register[0]] = register[1]

    return dict_ventas_dia

@app.route('/queries/get-ventas-hora')
@login_required
def get_ventasHora():
    '''Returns the number of sales by hour of a community kitchen'''
    id_comedor = request.args.get('idComedor')
    resultado = db_connection.get_ventasHora_comedor(id_comedor)
    dict_ventas_hora = {}

    for register in resultado:
        dict_ventas_hora[register[0]] = register[1]

    return dict_ventas_hora

@app.route('/queries/get-num-dependencias')
@login_required
def get_dependencias():
    '''Returns the number of dependants'''
    dependencias = db_connection.get_num_dependencia()
    dict_num_dependencias = {}

    for register in dependencias:
        dict_num_dependencias[register[0]] = register[1]

    return dict_num_dependencias

@app.route('/queries/get-cant-sexos')
@login_required
def get_tipoPoblacion():
    '''Returns the sex of the clients of a "Comedor"'''
    resultado = db_connection.get_sexo_clientes()
    dict_sexos = {}

    for register in resultado:
        dict_sexos[register[0]] = register[1]

    return dict_sexos

@app.route('/queries/get-donaciones')
@login_required
def get_donaciones():
    '''Returns the number of donations of a community kitchen'''
    id_comedor = request.args.get('idComedor')
    resultado = db_connection.get_cantidad_donaciones_comedor(id_comedor)

    return {"No donaciones": resultado[0][0], "Donaciones": resultado[1][0]}

@app.route('/queries/get-edades')
@login_required
def get_rangosEdades():
    '''Returns the ranges and the quantity of clients per age range'''
    resultado = db_connection.get_rangos_edades_comedor()
    dict_edades = {}

    for register in resultado:
        dict_edades[register[0]] = register[1]

    return dict_edades

@app.route('/queries/get-metas')
@login_required
def get_metas():
    '''Returns the number of sales in the last 30 days of a community kitchen'''
    id_comedor = request.args.get('idComedor')
    resultado = db_connection.get_metas_comedor(id_comedor)
    dict_metas = {}

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

if __name__ == '__main__':
    app.run(debug=True)
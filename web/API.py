from flask import Flask, render_template, url_for, request
import mysql.connector
from os import environ

DB_USER = environ.get('DB_DIF_USER')
DB_PASS = environ.get('DB_DIF_PASS')

connection = mysql.connector.connect(host='localhost',user=DB_USER,password=DB_PASS,database="APPDIF")
cursor = connection.cursor()

if connection.is_connected():
    print('Base de datos conectada', connection.get_server_info())


app = Flask(__name__)

# Login admin page


@app.route('/')
def login_page():
    return render_template('login.html', stylesheet=url_for('static', filename='css/login.css'))

# @app.route('/login/admin')
# def login_admin

# @app.route('/dashboard/<user>/<hash_pass>')
# def dashboard():


# @app.route('/clientes/<nombre>')
# def get_list_clientes():
    


if __name__ == '__main__':
    app.run(debug=True)

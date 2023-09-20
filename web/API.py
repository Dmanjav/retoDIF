from flask import Flask, render_template, url_for

app = Flask(__name__)

# Login admin page


@app.route('/')
def login_page():
    return render_template('login.html', stylesheet=url_for('static', filename='css/login.css'))

# @app.route('/login/admin')
# def login_admin


if __name__ == '__main__':

    app.run(debug=True)

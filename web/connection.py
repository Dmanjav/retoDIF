import mysql.connector
from os import environ

DB_USER = environ.get('DB_DIF_USER')
DB_PASS = environ.get('DB_DIF_PASS')


class connection():

    def __init__(self) -> None:
        self.connect = mysql.connector.connect(
            host='localhost', user=DB_USER, password=DB_PASS, database="APPDIF")
        self.cursor = self.connect.cursor()

    def get_admin(self, user):
        query = 'SELECT * FROM Admins where usuario = %s'
        self.cursor.execute(query, [user])
        return self.cursor.fetchone()

    def get_comedores(self):
        query = 'SELECT idComedor,nombre FROM Comedor'
        self.cursor.execute(query)
        return self.cursor.fetchall()

    def get_top_ventas(self):
        query = '''SELECT Pedido.idComedor,Comedor.nombre,COUNT(Pedido.idPedido)
            AS \'numeroVentas\'
            FROM Pedido,Comedor WHERE Pedido.idComedor = Comedor.idComedor 
            GROUP BY Comedor.nombre ORDER BY \'numeroVentas\' 
            DESC LIMIT 10;'''
        self.cursor.execute(query)
        return self.cursor.fetchall()

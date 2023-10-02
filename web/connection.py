import mysql.connector
from os import environ

# Environment variables for DB connection
DB_USER = environ.get('DB_DIF_USER')
DB_PASS = environ.get('DB_DIF_PASS')


class connection():

    def __init__(self) -> None:
        self.connect = mysql.connector.connect(
            host='localhost', user=DB_USER, password=DB_PASS, database="APPDIF")
        self.cursor = self.connect.cursor()

    def get_admin(self, user):
        '''Returns a user from the DB'''
        query = 'SELECT * FROM Admins where usuario = %s'
        self.cursor.execute(query, [user])
        return self.cursor.fetchone()

    def get_comedores(self):
        '''Returns id and name of all community kitchens in DB'''
        query = 'SELECT idComedor,nombre FROM Comedor'
        self.cursor.execute(query)
        return self.cursor.fetchall()

    def get_top_ventas(self):
        '''Top 10 number of sales per kitchen'''
        query = '''SELECT Pedido.idComedor,Comedor.nombre,COUNT(Pedido.idPedido)
            AS \'numeroVentas\'
            FROM Pedido,Comedor WHERE Pedido.idComedor = Comedor.idComedor 
            GROUP BY Comedor.nombre ORDER BY \'numeroVentas\' 
            DESC LIMIT 10;'''
        self.cursor.execute(query)
        return self.cursor.fetchall()

    def get_ventasDia_comedor(self, idComedor):
        '''
        Returns number of sales of one kitchen by day of the week
        '''
        query = '''SELECT DAYOFWEEK(fechaHora) AS dia_de_la_semana,
            COUNT(*) AS ventas 
            FROM Pedido WHERE idComedor = %s 
            GROUP BY DAYOFWEEK(fechaHora) 
            ORDER BY dia_de_la_semana;'''
        self.cursor.execute(query, [idComedor])
        return self.cursor.fetchall()

    def get_ventasHora_comedor(self, idComedor):
        '''
        Returns number of sales of one kitchen by hour of the day
        '''
        query = '''SELECT HOUR(fechaHora) AS hora_del_dia, 
            COUNT(*) AS ventas FROM Pedido 
            WHERE idComedor = %s GROUP BY HOUR(fechaHora)
            ORDER BY hora_del_dia;'''
        self.cursor.execute(query, [idComedor])
        return self.cursor.fetchall()

    def get_num_dependencia(self):
        '''Returns the number of people that depends or not on other'''
        query = '''SELECT ( CASE WHEN idResponsable = idDependiente 
            THEN 'Independiente' ELSE 'Dependiente' END ) 
            AS tipo_de_usuario, COUNT(*) AS cantidad FROM Dependencia 
            GROUP BY tipo_de_usuario ORDER BY tipo_de_usuario;'''
        self.cursor.execute(query)
        return self.cursor.fetchall()

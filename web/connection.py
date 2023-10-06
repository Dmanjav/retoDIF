import mysql.connector
from os import environ
from sqlite3 import connect

# Environment variables for DB connection
DB_USER = environ.get('DB_DIF_USER')
DB_PASS = environ.get('DB_DIF_PASS')

class Admin_connection():
    def __init__(self) -> None:
        self.connection = connect('./admin.db', check_same_thread=False)
        self.cursor = self.connection.cursor()

    def get_admin(self, user):
        query = '''SELECT * FROM Admins WHERE usuario = ?;'''
        self.cursor.execute(query,[user])
        result = self.cursor.fetchone()
        return result


class App_user_connection():
    def __init__(self) -> None:
        pass


class connection():

    def __init__(self) -> None:
        self.connect = mysql.connector.connect(
            host='localhost', user=DB_USER, password=DB_PASS, database="APPDIF")
        self.cursor = self.connect.cursor()

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

    def get_ventasDia_comedor(self, id_comedor):
        '''
        Returns number of sales of one kitchen by day of the week
        '''
        query = '''SELECT DAYNAME(fechaHora) AS dia_de_la_semana,
            COUNT(*) AS ventas FROM Pedido WHERE idComedor = %s 
            GROUP BY dia_de_la_semana ORDER BY dia_de_la_semana;'''
        self.cursor.execute(query, [id_comedor])
        return self.cursor.fetchall()

    def get_ventasHora_comedor(self, id_comedor):
        '''
        Returns number of sales of one kitchen by hour of the day
        '''
        query = '''SELECT HOUR(fechaHora) AS hora_del_dia, 
            COUNT(*) AS ventas FROM Pedido 
            WHERE idComedor = %s GROUP BY HOUR(fechaHora)
            ORDER BY hora_del_dia;'''
        self.cursor.execute(query, [id_comedor])
        return self.cursor.fetchall()

    def get_num_dependencia(self):
        '''Returns the number of people that depends or not on other'''
        query = '''SELECT ( CASE WHEN idResponsable = idDependiente 
            THEN 'Independiente' ELSE 'Dependiente' END ) 
            AS tipo_de_usuario, COUNT(*) AS cantidad FROM Dependencia 
            GROUP BY tipo_de_usuario ORDER BY tipo_de_usuario;'''
        self.cursor.execute(query)
        return self.cursor.fetchall()
    
    def get_sexo_clientes(self):
        '''Returns the number of male and females'''
        query = '''SELECT sexo, COUNT(*) FROM Cliente GROUP BY sexo;'''
        self.cursor.execute(query)
        return self.cursor.fetchall()
    
    def get_cantidad_donaciones_comedor(self,id_comedor):
        '''Returns the number of orders that are donations of one kitchen'''
        query = '''SELECT COUNT(*) FROM Pedido 
            WHERE Pedido.idComedor = %s GROUP BY Pedido.donacion;'''
        self.cursor.execute(query,[id_comedor])
        return self.cursor.fetchall()
    
    def get_rangos_edades_comedor(self):
        '''Returns the number of people grouped by a range of ages'''
        query = '''SELECT CASE WHEN TIMESTAMPDIFF(YEAR,fechaNacimiento,CURDATE()) <= 11
            THEN 'Niños' WHEN TIMESTAMPDIFF(YEAR, fechaNacimiento,CURDATE()) 
            BETWEEN 12 AND 19 THEN 'Estudiantes adolescentes (12 - 19)' 
            WHEN TIMESTAMPDIFF(YEAR, fechaNacimiento,CURDATE()) 
            BETWEEN 20 AND 65 THEN 'Adultos (20 - 65)'
            ELSE 'Adultos Mayores (65+)' END AS rango_edad,
            COUNT(*) AS cantidad FROM Cliente GROUP BY rango_edad ORDER BY COUNT(*) DESC LIMIT 25;'''
        
        self.cursor.execute(query)
        return self.cursor.fetchall()
    
    def get_metas_comedor(self, id_comedor):
        '''Returns the number of sales in the las 30 days of a kitchen'''
        query = '''SELECT DATE(fechaHora) AS fecha, COUNT(*) AS ventas 
            FROM Pedido WHERE idComedor = %s AND 
            fechaHora >= DATE_SUB(CURDATE(), INTERVAL 30 DAY) 
            GROUP BY fecha ORDER BY fecha DESC;'''
        
        self.cursor.execute(query,[id_comedor])
        return self.cursor.fetchall()
    
    def get_cierres(self):
        '''Returns the times a kitchen closed'''
        query = '''SELECT Comedor.nombre, COUNT(*) 
            FROM Comedor ,Anuncios 
            WHERE Anuncios.cierre = 1 AND Anuncios.idComedor = Comedor.idComedor 
            GROUP BY Comedor.nombre;'''
        
        self.cursor.execute(query)
        return self.cursor.fetchall()
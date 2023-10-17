import mysql.connector
from os import environ

# Environment variables for DB connection
DB_USER = environ.get('DB_DIF_USER')
DB_PASS = environ.get('DB_DIF_PASS')


class connection():

    def __init__(self) -> None:
        return

    # ------------ Dashboard queries -----------------

    def get_admin(self, user):
        connection = mysql.connector.connect(
            host='localhost', user=DB_USER, password=DB_PASS, database="APPDIF")
        cursor = connection.cursor()
        query = '''SELECT * FROM Admins WHERE usuario = %s;'''
        cursor.execute(query, [user])
        result = cursor.fetchone()
        cursor.close()
        connection.close()
        return result

    def get_comedores(self):
        '''Returns id and name of all community kitchens in DB'''
        connection = mysql.connector.connect(
            host='localhost', user=DB_USER, password=DB_PASS, database="APPDIF")
        cursor = connection.cursor()
        query = 'SELECT idComedor,nombre FROM Comedor'
        cursor.execute(query)
        result = cursor.fetchall()
        cursor.close()
        connection.close()
        return result

    def get_top_ventas(self):
        '''Top 10 number of sales per kitchen'''
        connection = mysql.connector.connect(
            host='localhost', user=DB_USER, password=DB_PASS, database="APPDIF")
        cursor = connection.cursor()
        query = '''SELECT Pedido.idComedor,Comedor.nombre,COUNT(Pedido.idPedido)
            AS \'numeroVentas\'
            FROM Pedido,Comedor WHERE Pedido.idComedor = Comedor.idComedor 
            GROUP BY Comedor.nombre ORDER BY \'numeroVentas\' 
            DESC LIMIT 10;'''
        cursor.execute(query)
        result = cursor.fetchall()
        cursor.close()
        connection.close()
        return result

    def get_ventasDia_comedor(self, id_comedor):
        '''
        Returns number of sales of one kitchen by day of the week
        '''
        connection = mysql.connector.connect(
            host='localhost', user=DB_USER, password=DB_PASS, database="APPDIF")
        cursor = connection.cursor()
        query = '''SELECT DAYNAME(fechaHora) AS dia_de_la_semana,
            COUNT(*) AS ventas FROM Pedido WHERE idComedor = %s 
            GROUP BY dia_de_la_semana ORDER BY dia_de_la_semana;'''
        cursor.execute(query, [id_comedor])
        result = cursor.fetchall()
        cursor.close()
        connection.close()
        return result

    def get_ventasHora_comedor(self, id_comedor):
        '''
        Returns number of sales of one kitchen by hour of the day
        '''
        connection = mysql.connector.connect(
            host='localhost', user=DB_USER, password=DB_PASS, database="APPDIF")
        cursor = connection.cursor()
        query = '''SELECT HOUR(fechaHora) AS hora_del_dia, 
            COUNT(*) AS ventas FROM Pedido 
            WHERE idComedor = %s GROUP BY HOUR(fechaHora)
            ORDER BY hora_del_dia;'''
        cursor.execute(query, [id_comedor])
        result = cursor.fetchall()
        cursor.close()
        connection.close()
        return result

    def get_num_dependencia(self):
        '''Returns the number of people that depends or not on other'''
        connection = mysql.connector.connect(
            host='localhost', user=DB_USER, password=DB_PASS, database="APPDIF")
        cursor = connection.cursor()
        query = '''SELECT ( CASE WHEN idResponsable = idDependiente 
            THEN 'Independiente' ELSE 'Dependiente' END ) 
            AS tipo_de_usuario, COUNT(*) AS cantidad FROM Dependencia 
            GROUP BY tipo_de_usuario ORDER BY tipo_de_usuario;'''
        cursor.execute(query)
        result = cursor.fetchall()
        cursor.close()
        connection.close()
        return result

    def get_sexo_clientes(self):
        '''Returns the number of male and females'''
        connection = mysql.connector.connect(
            host='localhost', user=DB_USER, password=DB_PASS, database="APPDIF")
        cursor = connection.cursor()
        query = '''SELECT sexo, COUNT(*) FROM Cliente GROUP BY sexo;'''
        cursor.execute(query)
        result = cursor.fetchall()
        cursor.close()
        connection.close()
        return result

    def get_cantidad_donaciones_comedor(self, id_comedor):
        '''Returns the number of orders that are donations of one kitchen'''
        connection = mysql.connector.connect(
            host='localhost', user=DB_USER, password=DB_PASS, database="APPDIF")
        cursor = connection.cursor()
        query = '''SELECT COUNT(*) FROM Pedido 
            WHERE Pedido.idComedor = %s GROUP BY Pedido.donacion;'''
        cursor.execute(query, [id_comedor])
        result = cursor.fetchall()
        cursor.close()
        connection.close()
        return result

    def get_rangos_edades_comedor(self):
        '''Returns the number of people grouped by a range of ages'''
        connection = mysql.connector.connect(
            host='localhost', user=DB_USER, password=DB_PASS, database="APPDIF")
        cursor = connection.cursor()
        query = '''SELECT CASE WHEN TIMESTAMPDIFF(YEAR,fechaNacimiento,CURDATE()) <= 11
            THEN 'Niños' WHEN TIMESTAMPDIFF(YEAR, fechaNacimiento,CURDATE()) 
            BETWEEN 12 AND 19 THEN 'Estudiantes adolescentes (12 - 19)' 
            WHEN TIMESTAMPDIFF(YEAR, fechaNacimiento,CURDATE()) 
            BETWEEN 20 AND 65 THEN 'Adultos (20 - 65)'
            ELSE 'Adultos Mayores (65+)' END AS rango_edad,
            COUNT(*) AS cantidad FROM Cliente GROUP BY rango_edad ORDER BY COUNT(*) DESC LIMIT 25;'''

        cursor.execute(query)
        result = cursor.fetchall()
        cursor.close()
        connection.close()
        return result

    def get_metas_comedor(self, id_comedor):
        '''Returns the number of sales in the las 30 days of a kitchen'''
        connection = mysql.connector.connect(
            host='localhost', user=DB_USER, password=DB_PASS, database="APPDIF")
        cursor = connection.cursor()
        query = '''SELECT DATE(fechaHora) AS fecha, COUNT(*) AS ventas 
            FROM Pedido WHERE idComedor = %s AND 
            fechaHora >= DATE_SUB(CURDATE(), INTERVAL 30 DAY) 
            GROUP BY fecha ORDER BY fecha DESC;'''

        cursor.execute(query, [id_comedor])
        result = cursor.fetchall()
        cursor.close()
        connection.close()
        return result

    def get_cierres(self):
        '''Returns the times a kitchen closed'''
        connection = mysql.connector.connect(
            host='localhost', user=DB_USER, password=DB_PASS, database="APPDIF")
        cursor = connection.cursor()
        query = '''SELECT Comedor.nombre, COUNT(*) 
            FROM Comedor ,Anuncios 
            WHERE Anuncios.cierre = 1 AND Anuncios.idComedor = Comedor.idComedor 
            GROUP BY Comedor.nombre;'''

        cursor.execute(query)
        result = cursor.fetchall()
        cursor.close()
        connection.close()
        return result

    def get_calificaciones(self, idComedor):
        connection = mysql.connector.connect(
            host='localhost', user=DB_USER, password=DB_PASS, database="APPDIF")
        cursor = connection.cursor()
        query = '''SELECT Comedor.nombre, AVG(Encuesta.servicio), AVG(Encuesta.higiene), AVG(Encuesta.calidad) 
        FROM Encuesta, Pedido, Comedor 
        WHERE Pedido.idPedido = Encuesta.idPedido AND Comedor.idComedor = %s AND Pedido.idComedor = %s;'''
        cursor.execute(query, [idComedor, idComedor])
        result = cursor.fetchone()
        cursor.close()
        connection.close()
        return result

    # ------------ App comedor queries -----------------

    def get_comedor(self, nombre_comedor):
        '''Returns the name and password of a kitchen'''
        connection = mysql.connector.connect(
            host='localhost', user=DB_USER, password=DB_PASS, database="APPDIF")
        cursor = connection.cursor()
        query = '''SELECT idComedor,nombre,contrasena FROM Comedor where nombre = %s;'''
        cursor.execute(query, [nombre_comedor])
        result = cursor.fetchall()
        cursor.close()
        connection.close()
        return result

    def login_comedor(self, token, idComedor):
        '''Creates the log on DB table of a kitchen'''
        connection = mysql.connector.connect(
            host='localhost', user=DB_USER, password=DB_PASS, database="APPDIF")
        cursor = connection.cursor()
        query = '''INSERT INTO LoginComedores (token,idComedor,fechaHora) VALUES (%s,%s,NOW());'''
        cursor.execute(query, [token, idComedor])
        connection.commit()
        cursor.close()
        connection.close()

    def generar_pedido(self, donacion, responsable, dependiente, idComedor, idComida):
        connection = mysql.connector.connect(
            host='localhost', user=DB_USER, password=DB_PASS, database="APPDIF")
        cursor = connection.cursor()
        query = '''INSERT INTO Pedido (fechaHora,donacion,responsable,dependiente,idComedor,idComida)
            VALUES (NOW(),%s,%s,%s,%s,%s);'''
        cursor.execute(
            query, [donacion, responsable, dependiente, idComedor, idComida])
        connection.commit()
        result = cursor.lastrowid
        cursor.close()
        connection.close()
        return result

    def get_token_comedor(self, token):
        connection = mysql.connector.connect(
            host='localhost', user=DB_USER, password=DB_PASS, database="APPDIF")
        cursor = connection.cursor()
        query = '''SELECT token,idComedor FROM LoginComedores where token = %s'''
        cursor.execute(query,[token])
        result = cursor.fetchone()
        cursor.close()
        connection.close()
        return result
    
    def get_dependencias_cliente(self,curp):
        connection = mysql.connector.connect(
            host='localhost', user=DB_USER, password=DB_PASS, database="APPDIF")
        cursor = connection.cursor()
        query = '''SELECT idDependiente,nombre from Dependencia,Cliente where idDependiente = curp
            and idResponsable = %s;'''
        cursor.execute(query,[curp])
        result = cursor.fetchall()
        cursor.close()
        connection.close()
        return result
    
    def publicar_menu(self,token,entrada,plato,postre):
        connection = mysql.connector.connect(
            host='localhost', user=DB_USER, password=DB_PASS, database="APPDIF")
        cursor = connection.cursor()
        try:
            INFO_COMEDOR = self.get_token_comedor(token)
        except Exception as e:
            return Exception('Token no valido al procesar en BD')
        
        if self.comprobar_existencia_menu_dia(INFO_COMEDOR[1]):
            return Exception('Ya hay un menú registrado el día de hoy')

        query = '''INSERT INTO Comida (idComedor,fechaRegistro,entrada,plato,postre)
            VALUES (%s,CURDATE(),%s,%s,%s);'''
        cursor.execute(query,[INFO_COMEDOR[1],entrada,plato,postre])
        connection.commit()
        result = cursor.lastrowid
        cursor.close()
        connection.close()
        return result
    
    def get_clientes(self):
        connection = mysql.connector.connect(
            host='localhost', user=DB_USER, password=DB_PASS, database="APPDIF")
        cursor = connection.cursor()
        query = '''SELECT nombre,apellidoP,apellidoM FROM Cliente'''
        cursor.execute(query)
        result = cursor.fetchall()
        cursor.close()
        connection.close()
        return result
    
    def get_donaciones_comedor_dia(self, id_comedor):
        '''Returns the number of orders that are donations of one kitchen'''
        connection = mysql.connector.connect(
            host='localhost', user=DB_USER, password=DB_PASS, database="APPDIF")
        cursor = connection.cursor()
        query = '''SELECT COUNT(*) FROM Pedido 
            WHERE Pedido.idComedor = %s AND DATE(Pedido.fechaHora) = CURDATE() GROUP BY Pedido.donacion;'''
        cursor.execute(query, [id_comedor])
        result = cursor.fetchall()
        cursor.close()
        connection.close()
        return result
    
    def publicar_anuncio(self,token,contenido,cierre):
        connection = mysql.connector.connect(
            host='localhost', user=DB_USER, password=DB_PASS, database="APPDIF")
        cursor = connection.cursor()
        try:
            INFO_COMEDOR = self.get_token_comedor(token)
        except Exception as e:
            return Exception('Token no valido al procesar en BD')
        
        query = '''INSERT INTO Anuncios (idComedor,fechaHora,contenido,cierre)
            VALUES (%s,NOW(),%s,%s);'''
        cursor.execute(query,[INFO_COMEDOR[1],contenido,cierre])
        connection.commit()
        result = cursor.lastrowid
        cursor.close()
        connection.close()
        return result
    
    def comprobar_existencia_menu_dia(self,idComedor):
        connection = mysql.connector.connect(
            host='localhost', user=DB_USER, password=DB_PASS, database="APPDIF")
        cursor = connection.cursor()
        comprobar_existencia = '''SELECT * FROM Pedido where idComedor = %s and fechaRegistro = CURDATE();'''
        cursor.execute(comprobar_existencia,[idComedor])
        existencia_menu_dia = cursor.fetchall()
        cursor.close()
        connection.close()
        return existencia_menu_dia

    # ------------ App clientes queries -----------------

    def get_cliente(self,curp):
        '''Returns the curp and password of a client'''
        connection = mysql.connector.connect(
            host='localhost', user=DB_USER, password=DB_PASS, database="APPDIF")
        cursor = connection.cursor()
        query = '''SELECT curp,contrasena FROM Cliente where curp = %s'''
        cursor.execute(query,[curp])
        result = cursor.fetchone()
        cursor.close()
        connection.close()
        return result
    
    def login_cliente(self, token, curp):
        '''Creates the log on DB table of a client'''
        connection = mysql.connector.connect(
            host='localhost', user=DB_USER, password=DB_PASS, database="APPDIF")
        cursor = connection.cursor()
        query = '''INSERT INTO LoginClientes (token,curpCliente,fechaHora) VALUES (%s,%s,NOW());'''
        cursor.execute(query,[token,curp])
        connection.commit()
        cursor.close()
        connection.close()

    def get_token_cliente(self, token):
        connection = mysql.connector.connect(
            host='localhost', user=DB_USER, password=DB_PASS, database="APPDIF")
        cursor = connection.cursor()
        query = '''SELECT token,curpCliente FROM LoginClientes where token = %s'''
        cursor.execute(query,[token])
        result = cursor.fetchone()
        cursor.close()
        connection.close()
        return result
    
    def registrar_cliente(self,curp,nombre,apellidop,apellidom,sexo,fecha_nacimiento,condicion,contrasena):
        connection = mysql.connector.connect(
            host='localhost', user=DB_USER, password=DB_PASS, database="APPDIF")
        cursor = connection.cursor()
        query = '''INSERT INTO Cliente
            (curp,nombre,apellidoP,apellidoM,sexo,
                fechaNacimiento,condicion,contrasena)
            VALUES (%s,%s,%s,%s,%s,%s,%s,%s)'''
        cursor.execute(query,[curp,nombre,apellidop,
                                   apellidom,sexo,fecha_nacimiento,
                                   condicion,contrasena])
        connection.commit()
        cursor.close()
        connection.close()

    def get_menu(self,idComedor):
        connection = mysql.connector.connect(
            host='localhost', user=DB_USER, password=DB_PASS, database="APPDIF")
        cursor = connection.cursor()
        existencia_menu_dia = self.comprobar_existencia_menu_dia(idComedor)
        if not existencia_menu_dia:
            query = '''SELECT entrada,plato,postre FROM Comida 
                where fechaRegistro = CURDATE() and idComedor = %s;'''
            cursor.execute(query,[idComedor])
            result = cursor.fetchone()
            cursor.close()
            connection.close()
            return result
        cursor.close()
        connection.close()
        return existencia_menu_dia[0]
    
    def get_pedidos_cliente(self, curp):
        connection = mysql.connector.connect(
            host='localhost', user=DB_USER, password=DB_PASS, database="APPDIF")
        cursor = connection.cursor()
        query = '''SELECT Pedido.idPedido, Pedido.fechaHora, Comedor.nombre
            FROM Pedido,Comedor WHERE Pedido.idComedor = Comedor.idComedor
            and Pedido.dependiente = %s and DATE(Pedido.fechaHora)
            BETWEEN DATE_SUB(CURDATE(), INTERVAL 1 DAY) AND CURDATE();'''
        cursor.execute(query, [curp])
        result = cursor.fetchall()
        cursor.close()
        connection.close()
        return result
    
    def publicar_evaluacion(self,idPedido,servicio,higiene,calidad):
        connection = mysql.connector.connect(
            host='localhost', user=DB_USER, password=DB_PASS, database="APPDIF")
        cursor = connection.cursor()
        query = '''INSERT INTO Encuesta (idPedido,servicio,higiene,calidad)
            VALUES (%s,%s,%s,%s);'''
        cursor.execute(query,[idPedido,servicio,higiene,calidad])
        connection.commit()
        result = cursor.lastrowid
        cursor.close()
        connection.close()
        return result
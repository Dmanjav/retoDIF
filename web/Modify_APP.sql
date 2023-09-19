USE APP;
GO

Insert into Comedor
Values 
('Cinco de Mayo', 'Porfirio Díaz', 27, '5 de Mayo', '230822'),
('Monte María', 'Monte Real', 11, 'Lomas de Monte María', '230822'),
('Cerro Grande', 'Teotihuacán', 15, 'Cerro Grande', '300123'),
('Hogares', 'Retorno de la tranquilidad', 8, 'Hogares de Atizapán', '091222');


Insert Into 
Comida
Values
('Ensalada', 'Bistec a la mexicana', 'Duraznos en almíbar'),
('Sopa de fideo', 'Tacos dorados de pollo', 'Gelatina'),
('Arroz', 'Pozole', 'Plátanos con crema');

Insert Into
Cliente
Values
('AAAA030125HDFLVLA2', 'Alan', 'Alcántara', 'Ávila', 'H', '2003-01-25', 'Sano', '1234'),
('MAVD030411HDFNVGA7', 'Diego', 'Manjarrez', 'Viveros', 'H', '2003-04-11', 'Sano', '5435'),
('SACC030606HMCNLRA2', 'Carlos', 'Sánchez', 'Calderon', 'H', '2003-06-06', 'Cuatro Ojos', '0654');

Insert Into
Dependencia
Values
('AAAA030125HDFLVLA2', 'MAVD030411HDFNVGA7'),
('SACC030606HMCNLRA2', 'SACC030606HMCNLRA2');

Insert Into
Pedido
Values
(GETDATE(), 0,'AAAA030125HDFLVLA2', 'MAVD030411HDFNVGA7', 3, 2),
(GETDATE(), 1, 'SACC030606HMCNLRA2', 'SACC030606HMCNLRA2', 1, 1);

Select * from Dependencia;
Select * from Pedido;
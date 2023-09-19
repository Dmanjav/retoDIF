USE APP;
GO

Insert into Comedor
Values 
('Cinco de Mayo', 'Porfirio D�az', 27, '5 de Mayo', '230822'),
('Monte Mar�a', 'Monte Real', 11, 'Lomas de Monte Mar�a', '230822'),
('Cerro Grande', 'Teotihuac�n', 15, 'Cerro Grande', '300123'),
('Hogares', 'Retorno de la tranquilidad', 8, 'Hogares de Atizap�n', '091222');


Insert Into 
Comida
Values
('Ensalada', 'Bistec a la mexicana', 'Duraznos en alm�bar'),
('Sopa de fideo', 'Tacos dorados de pollo', 'Gelatina'),
('Arroz', 'Pozole', 'Pl�tanos con crema');

Insert Into
Cliente
Values
('AAAA030125HDFLVLA2', 'Alan', 'Alc�ntara', '�vila', 'H', '2003-01-25', 'Sano'),
('MAVD030411HDFNVGA7', 'Diego', 'Manjarrez', 'Viveros', 'H', '2003-04-11', 'Sano'),
('SACC030606HMCNLRA2', 'Carlos', 'S�nchez', 'Calderon', 'H', '2003-06-06', 'Cuatro Ojos');

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
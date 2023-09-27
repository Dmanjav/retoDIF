USE APPDIF;

Insert into Admins (`usuario`, `contrasena`)
Values
('Aldehil', 'pbkdf2:sha256:600000$FAhTzalCnmY15ljn$ba493709f7fce005ec3f1334003e3dc072f5d061026d4709b87dbae5aeaaa4df'), -- 12345
('Manja', 'pbkdf2:sha256:600000$qMhpBtIjN4BsozZt$030807f82615243981fed0e4da4d6cd035fa1f6d522839bd082c652017f099f7'); -- 54321

Insert into Comedor (`nombre`, `calle`, `numero`, `colonia`, `contrasena`)
Values 
('Cinco de Mayo', 'Porfirio Díaz', '27', '5 de Mayo', 'pbkdf2:sha256:600000$PRap2ooVKCqf0Qbu$4434aea98b45e2df2c7d4a947f44f4c63f5e695f93f961368e7be08f358fd38b'), -- 230822
('Monte María', 'Monte Real', '11', 'Lomas de Monte María', 'pbkdf2:sha256:600000$JbVGT08onUblXTzB$af121d1cfa2aed2ecee1f2165eb83a71fa482bd51268d9a53cba300a9c9d142e'), -- 230822
('Cerro Grande', 'Teotihuacán', '15', 'Cerro Grande', 'pbkdf2:sha256:600000$uycMlFrCgeweTaYQ$424303a1a01e2a74ce3a719593459dc3e8ea27ec328978615628a1c1024c71ba'), -- 300123
('Hogares', 'Retorno de la tranquilidad', '8', 'Hogares de Atizapán', 'pbkdf2:sha256:600000$ICVMgfsSIMOCX5A1$26f30c4d681abd06a8386f7d231e745054ca2431febe61c79f59174dff7b3c2f'); -- 091222


Insert Into Comida (`entrada`, `plato`, `postre`)
Values
('Ensalada', 'Bistec a la mexicana', 'Duraznos en almíbar'),
('Sopa de fideo', 'Tacos dorados de pollo', 'Gelatina'),
('Arroz', 'Pozole', 'Plátanos con crema');

Insert Into Cliente (`curp`, `nombre`, `apellidoP`, `apellidoM`, `sexo`, `fechaNacimiento`, `condicion`, `contrasena`)
Values
('AAAA030125HDFLVLA2', 'Alan', 'Alcántara', 'Ávila', 'H', '2003-01-25', 'Sano', 'pbkdf2:sha256:600000$i5qVgZPSoL293JLe$4a376c123c0f367450d75f23c134bcf72f2094b5ab408abb6984db18f172f11f'), -- 1234
('MAVD030411HDFNVGA7', 'Diego', 'Manjarrez', 'Viveros', 'H', '2003-04-11', 'Sano', 'pbkdf2:sha256:600000$ONOocJRfINGSEPz0$6138532be9c4c17ee944708175873dccd8cc3caed384a65f2c214503b5a7f8ff'), -- 5435
('SACC030606HMCNLRA2', 'Carlos', 'Sánchez', 'Calderon', 'H', '2003-06-06', 'Cuatro Ojos', 'pbkdf2:sha256:600000$LqBV7P8cylf6YXyb$4bb0cbff5ac485a97d714a2c3c413103910e7640f945b042d17e6752bfdb80b4'); -- 0654

Insert Into Dependencia (`idResponsable`, `idDependiente`)
Values
('AAAA030125HDFLVLA2', 'MAVD030411HDFNVGA7'),
('SACC030606HMCNLRA2', 'SACC030606HMCNLRA2');

Insert Into Pedido (`fechaHora`, `donacion`, `responsable`, `dependiente`, `idComedor`, `idComida`)
Values
(NOW(), 0,'AAAA030125HDFLVLA2', 'MAVD030411HDFNVGA7', 3, 2),
(NOW(), 1, 'SACC030606HMCNLRA2', 'SACC030606HMCNLRA2', 1, 1);
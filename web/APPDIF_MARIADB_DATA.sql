USE APPDIF;

INSERT INTO Admins (`usuario`, `contrasena`) VALUES
('Aldehil', 'pbkdf2:sha256:600000$FAhTzalCnmY15ljn$ba493709f7fce005ec3f1334003e3dc072f5d061026d4709b87dbae5aeaaa4df'),
('Manja', 'pbkdf2:sha256:600000$qMhpBtIjN4BsozZt$030807f82615243981fed0e4da4d6cd035fa1f6d522839bd082c652017f099f7');

--
-- Volcado de datos para la tabla `anuncios`
--

INSERT INTO Anuncios (`idAnuncio`, `idComedor`, `fechaHora`, `contenido`) VALUES
(1, 4, '2023-09-29 23:55:59', 'Cierre de Sucursal el próximo lunes, no venir por favor'),
(2, 3, '2023-09-29 23:59:08', 'Cierre de sucursal, no vengan'),
(3, 6, '2023-09-29 23:59:51', 'Cierre de sucursal el martes'),
(4, 3, '2023-09-30 00:01:59', 'Cierre de nuevo');

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO Cliente (`curp`, `nombre`, `apellidoP`, `apellidoM`, `sexo`, `fechaNacimiento`, `condicion`, `contrasena`) VALUES
('AAAA030125HDFLVLA2', 'Alan', 'Alcántara', 'Ávila', 'H', '2003-01-25', 'Sano', 'pbkdf2:sha256:600000$i5qVgZPSoL293JLe$4a376c123c0f367450d75f23c134bcf72f2094b5ab408abb6984db18f172f11f'),
('GAHI020228MMCRRNA7', 'Ingrid', 'García', 'Hernández', 'F', '2002-02-28', '', 'pbkdf2:sha256:600000$b8xYYER1mdI0Vnhr$44cb8a8021f8ad5bfcdbf489ee7e281017a62267410e01e0e49bbe2de97efad3'),
('MAVD030411HDFNVGA7', 'Diego', 'Manjarrez', 'Viveros', 'H', '2003-04-11', 'Sano', 'pbkdf2:sha256:600000$ONOocJRfINGSEPz0$6138532be9c4c17ee944708175873dccd8cc3caed384a65f2c214503b5a7f8ff'),
('SACC030606HMCNLRA2', 'Carlos', 'Sánchez', 'Calderon', 'H', '2003-06-06', 'Cuatro Ojos', 'pbkdf2:sha256:600000$LqBV7P8cylf6YXyb$4bb0cbff5ac485a97d714a2c3c413103910e7640f945b042d17e6752bfdb80b4');

--
-- Volcado de datos para la tabla `comedor`
--

INSERT INTO Comedor (`idComedor`, `nombre`, `calle`, `numero`, `colonia`, `contrasena`) VALUES
(1, 'Cinco de Mayo', 'Porfirio Díaz', '27', '5 de Mayo', 'pbkdf2:sha256:600000$PRap2ooVKCqf0Qbu$4434aea98b45e2df2c7d4a947f44f4c63f5e695f93f961368e7be08f358fd38b'),
(2, 'Monte María', 'Monte Real', '11', 'Lomas de Monte María', 'pbkdf2:sha256:600000$JbVGT08onUblXTzB$af121d1cfa2aed2ecee1f2165eb83a71fa482bd51268d9a53cba300a9c9d142e'),
(3, 'Cerro Grande', 'Teotihuacán', '15', 'Cerro Grande', 'pbkdf2:sha256:600000$uycMlFrCgeweTaYQ$424303a1a01e2a74ce3a719593459dc3e8ea27ec328978615628a1c1024c71ba'),
(4, 'Hogares', 'Retorno de la tranquilidad', '8', 'Hogares de Atizapán', 'pbkdf2:sha256:600000$ICVMgfsSIMOCX5A1$26f30c4d681abd06a8386f7d231e745054ca2431febe61c79f59174dff7b3c2f'),
(5, 'Margarita Maza', 'Francisco Javier Mina', '12', 'Margarita Maza de Juárez', 'pbkdf2:sha256:600000$MI81Eje2l2AJuuaD$159c7d9d41c4004720b1530074ca3b9bdcd13e2a79b4da2833b74ff53f11a3c8'),
(6, 'Cerro Grande', 'Teotihuacan', '15', 'Cerro Grande', 'pbkdf2:sha256:600000$CKgYmrNeOIw7Mfic$fb2da4a27152e06b12f3beafadec96be682883b1ba175cced4539a393a82196d'),
(7, 'Amp. Peñitas', 'Cerrada Gardenias', '3', 'Ampliación Peñitas', 'pbkdf2:sha256:600000$cFeg206nLQdHTLZU$bc0d1d237e06c0964ec9b1ec5bdfd978da547e4341dc3b41052a95ec3be5f780'),
(8, 'San Jose Jaral 2', 'Jazmín', '22', 'San José el Jaral 2', 'pbkdf2:sha256:600000$OQaxiH1X8iCuUnWS$164a72d33fc9a705416768d818ed49576ee092ea564070fd65d6bab3cfb2b5b0'),
(9, 'Amp. Emiliano Zapata', 'Ejército Mexicano', 's/n', 'Ampliación Emiliano Zapata', 'pbkdf2:sha256:600000$waTdmz86qHpE6sET$e16b85ee788b5e4501f29e3068c27e082aec4ff4026a6908019c8b7dec2aa21a'),
(10, 'DIF Central', 'Ruiz Cortines esq. Acambay ', 's/n', 'Lomas de Atizapán', 'pbkdf2:sha256:600000$V4DrSxfHeCZJjlUw$629090baa528f14473eda37b941d8d09bde95e7f85c8fc42578edc08acee5872');

--
-- Volcado de datos para la tabla `comida`
--

INSERT INTO Comida (`idComida`, `entrada`, `plato`, `postre`) VALUES
(1, 'Ensalada', 'Bistec a la mexicana', 'Duraznos en almíbar'),
(2, 'Sopa de fideo', 'Tacos dorados de pollo', 'Gelatina'),
(3, 'Arroz', 'Pozole', 'Plátanos con crema'),
(4, 'Arroz Blanco', 'Tacos Dorados', 'Durazno'),
(5, 'Arroz Rojo', 'Pieza de pollo', 'Durazno'),
(6, 'Sopa de Verduras', 'Filete de pescado', 'Tuna'),
(7, 'Sopa de habas', 'Tostadas de Tinga', 'Gelatina'),
(8, 'Caldo de pollo', 'Enchiladas', 'Flan'),
(9, 'Espagueti', 'Birria', 'Fresas con crema');

--
-- Volcado de datos para la tabla `dependencia`
--

INSERT INTO Dependencia (`idResponsable`, `idDependiente`) VALUES
('AAAA030125HDFLVLA2', 'GAHI020228MMCRRNA7'),
('AAAA030125HDFLVLA2', 'MAVD030411HDFNVGA7'),
('MAVD030411HDFNVGA7', 'MAVD030411HDFNVGA7'),
('SACC030606HMCNLRA2', 'GAHI020228MMCRRNA7'),
('SACC030606HMCNLRA2', 'SACC030606HMCNLRA2');

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO Pedido (`idPedido`, `fechaHora`, `donacion`, `responsable`, `dependiente`, `idComedor`, `idComida`) VALUES
(1, '2023-09-27 12:25:48', 0, 'AAAA030125HDFLVLA2', 'MAVD030411HDFNVGA7', 3, 2),
(2, '2023-09-27 12:25:48', 1, 'SACC030606HMCNLRA2', 'SACC030606HMCNLRA2', 1, 1),
(3, '2023-09-30 16:09:30', 0, 'MAVD030411HDFNVGA7', 'AAAA030125HDFLVLA2', 6, 8),
(4, '2023-09-30 00:09:29', 1, 'GAHI020228MMCRRNA7', 'GAHI020228MMCRRNA7', 1, 8);
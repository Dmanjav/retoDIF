USE APPDIF;

--
-- Volcado de datos para la tabla `Admins`
--

INSERT INTO Admins VALUES
('Aldehil', 'pbkdf2:sha256:600000$FAhTzalCnmY15ljn$ba493709f7fce005ec3f1334003e3dc072f5d061026d4709b87dbae5aeaaa4df'), -- 12345
('Manja', 'pbkdf2:sha256:600000$qMhpBtIjN4BsozZt$030807f82615243981fed0e4da4d6cd035fa1f6d522839bd082c652017f099f7'); -- 54321

--
-- Volcado de datos para la tabla `Cliente`
--

INSERT INTO Cliente (`curp`, `nombre`, `apellidoP`, `apellidoM`, `sexo`, `fechaNacimiento`, `condicion`, `contrasena`) VALUES
('AAAA030125HDFLVLA2', 'Alan', 'Alcántara', 'Ávila', 'H', '2003-01-25', 'Sano', 'pbkdf2:sha256:600000$i5qVgZPSoL293JLe$4a376c123c0f367450d75f23c134bcf72f2094b5ab408abb6984db18f172f11f'),
('GAHI020228MMCRRNA7', 'Ingrid', 'García', 'Hernández', 'M', '2002-02-28', '', 'pbkdf2:sha256:600000$b8xYYER1mdI0Vnhr$44cb8a8021f8ad5bfcdbf489ee7e281017a62267410e01e0e49bbe2de97efad3'), -- Ingrid
('MAVD030411HDFNVGA7', 'Diego', 'Manjarrez', 'Viveros', 'H', '2003-04-11', 'Sano', 'pbkdf2:sha256:600000$ONOocJRfINGSEPz0$6138532be9c4c17ee944708175873dccd8cc3caed384a65f2c214503b5a7f8ff'),
('SACC030606HMCNLRA2', 'Carlos', 'Sánchez', 'Calderon', 'H', '2003-06-06', 'Cuatro Ojos', 'pbkdf2:sha256:600000$LqBV7P8cylf6YXyb$4bb0cbff5ac485a97d714a2c3c413103910e7640f945b042d17e6752bfdb80b4'),
('SILP030314HDFPPBA3', 'Pablo', 'Spínola', 'López', 'H', '2003-04-14', 'Cuatro Ojos', 'pbkdf2:sha256:600000$AilSViF3yYUSxAyz$21bacc4088c0a781a6af788ba1b7daf2d5084c14059080301d2d42558c18c1b0');

--
-- Volcado de datos para la tabla `Comedor`
--

INSERT INTO Comedor (`idComedor`, `nombre`, `calle`, `numero`, `colonia`, `contrasena`) VALUES
(1, 'Cinco de Mayo', 'Porfirio Díaz', '27', '5 de Mayo', 'pbkdf2:sha256:600000$pjFtYJQiczvR8Nwl$3c0e6bc3ec3c095e45d06ad2f74b6e7c9e37729179e392ce0baa800f432e09cc'), -- Cinco de Mayo
(2, 'Monte María', 'Monte Real', '11', 'Lomas de Monte María', 'pbkdf2:sha256:600000$yrelDabj5lu8FiGc$a232b99f71df1044745e58508bbd98188155f76ce5b9f424193d9a02bb81c7cf'), -- Monte María
(3, 'Cerro Grande', 'Teotihuacán', '15', 'Cerro Grande', 'pbkdf2:sha256:600000$8ftIAPVbF2HPMMtt$4e67dae27a6620b8e1b6df85030fc710ef4f3c2f918acb88de9a697e86e5a032'), -- Cerro Grande
(4, 'Hogares', 'Retorno de la tranquilidad', '8', 'Hogares de Atizapán', 'pbkdf2:sha256:600000$mHmdj8Wde5zsBhHD$64bd255138035e6fe8fca0f01c5d34266c63da65f64646566a46ec685bc10f41'), -- Hogares
(5, 'Margarita Maza', 'Francisco Javier Mina', '12', 'Margarita Maza de Juárez', 'pbkdf2:sha256:600000$FEZxxhkQmABW1Nwz$668377284ed1627ca92b490abbac5a35b0254784a3a6a1e6461f07357e475c14'), -- Margarita Maza
(6, 'Amp. Peñitas', 'Cerrada Gardenias', '3', 'Ampliación Peñitas', 'pbkdf2:sha256:600000$AH6wfF9s2JO5Qodh$d9426b9efb5204f64951bcb7f4f039ada314e0903919f51b2826e9d9c74e1fa1'), -- Amp. Peñitas
(7, 'San Jose Jaral 2', 'Jazmín', '22', 'San José el Jaral 2', 'pbkdf2:sha256:600000$BdugPaLSwE3XDjLq$0a121892aa53da7e8204de8bf1aaba87301272c47d49ea8157c41de3c599a337'), -- San Jose Jaral 2
(8, 'Amp. Emiliano Zapata', 'Avenida Ejército Mexicano', 's/n', 'Ampliación Emiliano Zapata', 'pbkdf2:sha256:600000$ATNpxCHgpWc2OixT$194ada05792f9e2c83502d82869f1d6ab3a6dd83aaf27eb79c47486591e5575a'), -- Amp. Emiliano Zapata
(9, 'DIF Central', 'Avenida Ruiz Cortines esq. Acambay ', 's/n', 'Lomas de Atizapán', 'pbkdf2:sha256:600000$VjI3WjkzTNPT87QB$5e29c5a9fdaee3ea89f13a06978589df8b526edf08cc4cc1057f1bc5462cc408'), -- DIF Central
(10, 'Adolfo López Mateos', 'Avenida Adolfo López Mateos', '6', 'Privada Zacatecas', 'pbkdf2:sha256:600000$emSkITzTCZzJursr$35906242380ce08228b16165b939cbae32c1549b1ad90b2615e23518bbd38014'), -- Adolfo López Mateos
(11, 'Mexico 86', 'Italia', '53', 'México 86', 'pbkdf2:sha256:600000$txT6IwqXwwJrA4gP$79cb74711732c3edcba04f32ab6d0e9ec71fa1c0ab7532932ba49b69e2995229'), -- Mexico 86
(12, 'Rinconada Bonfil', 'Rosas Mz 4', 'Lt 15', 'Rinconada Bonfil', 'pbkdf2:sha256:600000$WiNyea3ngANlT1iA$05f18b9b776a7148422558352d754d9d52ae718dc99021bd8d0c0e930d2eb62d'), -- Rinconada Bonfil
(13, 'San Juan Bosco', 'Profesor ROberto Barrio', '2', 'San Juan Bosco', 'pbkdf2:sha256:600000$hbFrOs6FCbc5JQM6$ce07ff8326c8d51dfea61fccf19ac6dd2f9bee1379153c76f348e66aec27f906'), -- San Juan Bosco
(14, 'Las Peñitas', 'Mirador', '100', 'Las Peñitas', 'pbkdf2:sha256:600000$8smvIfNGq6xU3qYr$2b55ef5e756dd3fdb56970a6dbdfbd75cda5781066eb88270f89fa96c47464fb'), -- Las Peñitas
(15, 'Rancho Castro', 'Del Puerto', 's/n', 'Rancho Castro', 'pbkdf2:sha256:600000$05xC0X675PmNTohU$57d527ad87ccfac7cb4a0fe2455f26180a3ce8db343fd40b929ac9ee6a02d461'), -- Rancho Castro
(16, 'Villas de las Palmas', 'Avena Mz 5', 'Lt 12', 'Ampliación Villa de las Palas', 'pbkdf2:sha256:600000$8VmtPHZymmRFzOJx$14a88347f9ca38e15c25d8dcda686e32b2c79f3d0d1c0c379c8c3916e0c583c2'), -- Villas de las Palmas
(17, 'UAM', 'Ingenieria Industrial Mz 24', 'Lt 45', 'UAM', 'pbkdf2:sha256:600000$ieyzXm5xn8ePnblG$ba8575756436c9b42dd53c4a1f4dfeb62e57d0c7b31292264af509773f6a93c5'), -- UAM
(18, 'Tierra de en Medio', 'Hacienda de la Flor', '14', 'Tierra de en medio', 'pbkdf2:sha256:600000$ZNVJ5tvmU0P3iQ55$9d48dfeed0cbbffad40af744226184f9359c3770477fb2023dda686ef7342382'),
(19, 'Bosques de Ixtacala', 'Cerrada Sauces Mz 12' ,'Lt 13-C 6', 'Bosques de Ixtacala', 'pbkdf2:sha256:600000$xlKkbZTUYfZXkp9Z$bca64977384ebcdaab333a461d466269ce15e2fdd6ad9373e01b1d80587140e2'), -- Bosques de Ixtacala
(20, 'Lomas de Tepalcapa', 'Seis', '14', 'Lomas de Tepalcapa', 'pbkdf2:sha256:600000$pXpdP0e5K4BNuHN6$ea1690f1d1e513bf9b2c6d14c3d76b467774a878e15f63e88db164eaf83ae2c6'), -- Lomas de Tepalcapa
(21, 'Villa de las Torres', 'Villa Alba Mz 17', 'Lote 9', 'Villa de las Torres', 'pbkdf2:sha256:600000$c4kRnI8jvRykBG3F$fd92c084bce2455ae553c1c03e56f14e418ac6da4ee7ab5cd91e64bab788e462'), -- Villa de las Torres
(22, 'Cristobal Higuera', 'Sandía', '24', 'Prof. Cristobal Higuera', 'pbkdf2:sha256:600000$mfQmKqRXV1GWjdIA$053f8102d494e0ae3fb034e56fd6c5cb2dff35a2ff1bccf1b438c394af2797af'), -- Cristobal Higuera
(23, 'Lomas de Guadalupe', 'Vicente Guerrero', '2', 'Lomas de Guadalupe', 'pbkdf2:sha256:600000$I8X6hAzIKu4vNfxq$0e4ebf38f1fcbc5e776158a7ed7dbcbd8b47bff222fc5d2d4b15a5b54cac8936'), -- Lomas de Guadalupe
(24, 'Lázaro Cárdenas', 'Chihuahua', '151', 'Lázaro Cárdenas', 'pbkdf2:sha256:600000$oxaGMhV1VcsJuz5Y$2c82c6ee8b0e6b57a11ed7ab05360dc3d932c49d6e0db875347025dfe888bd0a'), -- Lázaro Cárdenas
(25, 'El Chaparral', 'Tucan', '48', 'El Chaparral', 'pbkdf2:sha256:600000$qXJ85HTJlhtoh3JK$2c422d0f678443c96721a0aef0f8b30b6f1587be379b398c438e187268f74ae1'), -- El Chaparral
(26, 'Primero de Septiembre', 'Belisario Domínguez', '44', 'Primero de Septiembre', 'pbkdf2:sha256:600000$Zwxuh0cpMIEK1aiP$a22683ca0edc02ce237ebbcafb4264de40311caa887c793f162faab258e67ccf'), -- Primero de Septiembre
(27, 'Las Águilas', 'Pavo Real', '18', 'Las Águilas', 'pbkdf2:sha256:600000$2T7kJkypak0TAkKq$17e7f9a13ced24fe49757cf0819036b8c8b95dd1863042302e8c34b776b199ba'), -- Las Águilas
(28, 'El Cerrito', 'Paseo Buenavista', '1', 'El Cerrito', 'pbkdf2:sha256:600000$M139tXpbQQt9h8dn$38291842598bccb36aabf7d28a3f2c8f9b9a9038acfee362e3e978ae47451500'), -- El Cerrito
(29, 'Villas de la Hacienda', 'De las Chaparreras', '5', 'Villas de la Hacienda', 'pbkdf2:sha256:600000$ESYXMgeBVDaGTebT$0c1d71e1f9bf592875a87f3f7a312f938f5ab43010cd5333f76978cf96a892fb'), -- Villas de la Hacienda
(30, 'San Juan Ixtacala Plano Norte 1', 'Loma San Juan', '194', 'San Juan Ixtacala Plano Norte', 'pbkdf2:sha256:600000$1JQ8xnGGtkAEvDhX$5091d67d421d9e0b60675e410da79daf468e804e4c39a2c23fc0791d85cb109f'), -- San Juan Ixtacala Plano Norte 1
(31, 'Prados de Ixtacala 2da. Secc.', 'Clavel Mz 13', 'lt 17 13','Prados Ixtacala 2da. secc.', 'pbkdf2:sha256:600000$YetdCLhwW6C2A3np$361e52ef69b12be34ab8752bbcb6e2865f36033b2d2374bf99362928bd64fc6d'), -- Prados de Ixtacala 2da. Secc.
(32, 'Villa Jardin', 'Cerrada Francisco Villa', 's/n.', 'Villa Jardin', 'pbkdf2:sha256:600000$K2M7QgixrHdM6KIf$7e3503726008dea5ebe64ee96c6894d74d43d8b6a4bfc9ff687cd9956ee8e42e'),
(33, 'Amp. Cristobal Higuera', 'Aldama', '#17', 'Amp. Cristobal Higuera', 'pbkdf2:sha256:600000$73VIUkhgc4C5SF5v$c88bfdf5aaff6db0cfd88820577f5ee4ffd32315e5832d39d82f2f0a4c0a2931'),
(34, 'Amp. Adolfo Lopez Mateos', 'Calle Leon', '#1', 'Amp.Adolfo López Mateos', 'pbkdf2:sha256:600000$eoYjoREkMHhD9uXX$d8afb12d341780f765cb81fa08e6f2d0d3f2e83240816616cb16a3fd9bd413ba'),
(35, 'Lomas de San Miguel', 'Jacarandas', '#5', 'Lomas de San Miguel', 'pbkdf2:sha256:600000$XlzLRUG1GGYE9yjN$2035950773bf94399c2fa8093ecc019ccd87a2bf0c4e1e18871849fdd1e0e507'),
(36, 'San Juan Ixtacala Plano Norte 2', 'Boulevar Ignacio Zaragoza', '82', 'San Juan Ixtacala Plano Norte', 'pbkdf2:sha256:600000$3d6TAYaGDNXuLv8N$976a25bba4f523516eff229cb62e54c22ae4086ae5a60b642fe3b7461ee7f888'),
(37, 'Los Olivos 2', 'Calle Mérida', '10', 'Los Olivos', 'pbkdf2:sha256:600000$Bp8pGi40ks7X0JhV$1357a8811c729066dda369132237b674f25b097e5c8c9f11cb2a11d8367a2815');

--
-- Volcado de datos para la tabla `Anuncios`
--

INSERT INTO Anuncios (`idAnuncio`, `idComedor`, `fechaHora`, `contenido`, `cierre`) VALUES
(1, 4, '2023-09-29 23:55:59', 'Cierre de Sucursal el próximo lunes, no venir por favor', 1),
(2, 3, '2023-09-29 23:59:08', 'Cierre de sucursal, no vengan', 1),
(3, 6, '2023-09-29 23:59:51', 'Cierre de sucursal el martes', 1),
(4, 3, '2023-09-30 00:01:59', 'Cambio de horario de apertura', 0),
(5, 23, '2023-09-10 08:23:23', 'No tenemos agua', 0),
(6, 16, '2023-09-09  00:03:59', 'La comida es deliciosa, vengan ya!', 0),
(7, 1, '2023-10-05 08:24:22', 'Falta personal, cerraremos', 1),
(8, 5, '2023-10-05 08:24:23', 'Tenemos nuevos postres esta semana', 0),
(9, 12, '2023-10-05 08:24:24', 'La sucursal se inundó, cerrada', 1),
(10, 20, '2023-10-05 08:24:25', 'Recuerden que la comida siempre cuesta 13 pesos', 0),
(11, 2, '2023-10-05 08:24:26', '¡Reapertura de sucursal! Ven a visitarnos', 0),
(12, 3, '2023-10-05 08:24:27', 'Nos falta personal, cerrada por lo mismo', 1),
(13, 1, '2023-10-05 09:24:22', '¡Nuevas bebidas! Prueba nuestro agua de horchata', 0),
(14, 5, '2023-10-05 09:24:23', 'Cerrado por cucas', 1),
(15, 12, '2023-10-05 09:24:24', '¡Tenemos servicio de valet parking!', 0),  
(16, 22, '2023-10-05 09:24:25', 'Cerrada por hoy', 1),
(17, 8, '2023-10-05 09:24:26', '¡Concierto de rock en vivo!', 0),
(18, 10, '2023-10-05 09:24:27', '¡Reapertura del área de juegos infantiles!', 0),
(19, 11, '2023-10-05 10:24:22', 'Cerrado por falta de ingredientes', 1),
(20, 7, '2023-10-05 10:24:23', 'Cerrado por falta de ingredientes', 1),
(21, 12, '2023-10-05 10:24:24', '¡Concierto de salsa gratis este sábado!', 0),
(22, 18, '2023-10-05 10:24:25', '¡Oferta de 30% de descuento en la comida para llevar!', 0),
(23, 32, '2023-10-05 10:24:26', '¡Reapertura de la sucursal!', 0),
(24, 18, '2023-10-05 10:24:27', 'Cerrado porque queremos', 1);

--
-- Volcado de datos para la tabla `Comida`
--

INSERT INTO Comida (`idComida`, `idComedor`, `fechaRegistro`,`entrada`, `plato`, `postre`) VALUES
(1, 1, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Ensalada', 'Bistec a la mexicana', 'Duraznos en almíbar'),
(2, 4, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Sopa de fideo', 'Tacos dorados de pollo', 'Gelatina'),
(3, 2, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Arroz', 'Pozole', 'Plátanos con crema'),
(4, 5, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Arroz Blanco', 'Tacos Dorados', 'Durazno'),
(5, 17, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Arroz Rojo', 'Pieza de pollo', 'Durazno'),
(6, 18, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Sopa de Verduras', 'Filete de pescado', 'Tuna'),
(7, 9, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Sopa de habas', 'Tostadas de Tinga', 'Gelatina'),
(8, 1, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Caldo de pollo', 'Enchiladas', 'Flan'),
(9, 5, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Espagueti', 'Birria', 'Fresas con crema'),
(10, 3, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Ensalada', 'Mole poblano', 'Pastel de chocolate'),
(11, 6, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Crema de champiñones', 'Chiles en nogada', 'Helado de vainilla'),
(12, 8, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Sopa de lentejas', 'Carnitas', 'Tres leches'),
(13, 10, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Sopa de tortilla', 'Cochinita pibil', 'Mousse de mango'),
(14, 12, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Tacos al pastor', 'Tamales', 'Gelatina de frutas'),
(15, 15, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Sopa de cebolla', 'Pescado a la veracruzana', 'Tarta de manzana'),
(16, 20, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Ensalada de aguacate', 'Costillas BBQ', 'Helado de fresa'),
(17, 22, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Sopa de garbanzos', 'Enchiladas verdes', 'Flan casero'),
(18, 25, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Tacos de carnitas', 'Chiles rellenos', 'Pudín de pan'),
(19, 27, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Crema de espárragos', 'Pollo asado', 'Pastel de queso'),
(20, 30, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Sopa de pollo', 'Tacos de pescado', 'Tiramisú'),
(21, 32, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Ensalada César', 'Ceviche de camarones', 'Tarta de chocolate'),
(22, 34, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Sopa de zanahoria', 'Chapulines', 'Gelatina de piña'),
(23, 7, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Sopa de fideos', 'Tacos al pastor', 'Tiramisú'),
(24, 14, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Arroz con leche', 'Barbacoa de res', 'Helado de vainilla'),
(25, 19, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Sopa de tomate', 'Chicharrón en salsa verde', 'Flan casero'),
(26, 23, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Tacos de carnitas', 'Mole negro', 'Pastel de chocolate'),
(27, 28, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Sopa de papa', 'Tacos de barbacoa', 'Tres leches'),
(28, 31, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Sopa de calabaza', 'Chiles en nogada', 'Mousse de mango'),
(29, 33, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Tacos de pollo', 'Tamales de elote', 'Gelatina de frutas'),
(30, 35, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Crema de champiñones', 'Pescado frito', 'Tarta de manzana'),
(31, 13, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Ensalada de aguacate', 'Carnitas', 'Helado de fresa'),
(32, 16, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Sopa de garbanzos', 'Enchiladas suizas', 'Flan casero'),
(33, 21, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Sopa de lentejas', 'Tacos de cabeza', 'Pudín de pan'),
(34, 24, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Crema de espárragos', 'Mole poblano', 'Pastel de queso'),
(35, 29, CURDATE() - INTERVAL FLOOR(1 + RAND() * 30) DAY,'Sopa de tortilla', 'Tacos de birria', 'Tiramisú');

--
-- Volcado de datos para la tabla `Dependencia`
--

INSERT INTO Dependencia (`idResponsable`, `idDependiente`) VALUES
('AAAA030125HDFLVLA2', 'GAHI020228MMCRRNA7'),
('AAAA030125HDFLVLA2', 'MAVD030411HDFNVGA7'),
('MAVD030411HDFNVGA7', 'MAVD030411HDFNVGA7'),
('SACC030606HMCNLRA2', 'GAHI020228MMCRRNA7'),
('SACC030606HMCNLRA2', 'SACC030606HMCNLRA2');

--
-- Volcado de datos para la tabla `Pedido`
--

INSERT INTO Pedido (`idPedido`, `fechaHora`, `donacion`, `responsable`, `dependiente`, `idComida`, `idComedor`) VALUES
(1, '2023-09-27 12:25:48', 0, 'AAAA030125HDFLVLA2', 'MAVD030411HDFNVGA7', 3, 2),
(2, '2023-09-27 12:25:48', 1, 'SACC030606HMCNLRA2', 'SACC030606HMCNLRA2', 1, 1),
(3, '2023-09-30 16:09:30', 0, 'MAVD030411HDFNVGA7', 'AAAA030125HDFLVLA2', 2, 4),
(4, '2023-09-30 00:09:29', 1, 'GAHI020228MMCRRNA7', 'GAHI020228MMCRRNA7', 1, 1),
(5, '2023-10-02 02:45:29', 0, 'MAVD030411HDFNVGA7', 'MAVD030411HDFNVGA7', 1, 1),
(6, '2023-10-02 17:45:29', 0, 'GAHI020228MMCRRNA7', 'GAHI020228MMCRRNA7', 23, 7),
(7, '2023-10-02 14:45:29', 1, 'MAVD030411HDFNVGA7', 'MAVD030411HDFNVGA7', 23, 7),
(8, '2023-07-24 01:07:00', 0, 'MAVD030411HDFNVGA7', 'SILP030314HDFPPBA3', 31, 13),
(9, '2023-07-26 09:09:03', 0, 'AAAA030125HDFLVLA2', 'GAHI020228MMCRRNA7', 3, 2),
(10, '2023-09-16 11:45:36', 1, 'SILP030314HDFPPBA3', 'MAVD030411HDFNVGA7', 28, 31),
(11, '2023-08-21 16:30:10', 0, 'GAHI020228MMCRRNA7', 'SACC030606HMCNLRA2', 10, 3),
(12, '2023-07-03 16:31:28', 1, 'MAVD030411HDFNVGA7', 'MAVD030411HDFNVGA7', 31, 13),
(13, '2023-07-16 08:32:18', 1, 'MAVD030411HDFNVGA7', 'MAVD030411HDFNVGA7', 31, 13),
(14, '2023-08-18 10:44:53', 0, 'GAHI020228MMCRRNA7', 'SILP030314HDFPPBA3', 28, 31),
(15, '2023-10-10 03:24:20', 0, 'MAVD030411HDFNVGA7', 'AAAA030125HDFLVLA2', 2, 4),
(16, '2023-08-21 19:56:08', 0, 'SILP030314HDFPPBA3', 'GAHI020228MMCRRNA7', 24, 14),
(17, '2023-10-13 16:11:43', 0, 'GAHI020228MMCRRNA7', 'GAHI020228MMCRRNA7', 1, 1),
(18, '2023-08-16 14:28:25', 1, 'MAVD030411HDFNVGA7', 'MAVD030411HDFNVGA7', 4, 5),
(19, '2023-10-19 09:16:50', 1, 'SILP030314HDFPPBA3', 'GAHI020228MMCRRNA7', 33, 21),
(20, '2023-09-12 15:58:30', 1, 'SACC030606HMCNLRA2', 'MAVD030411HDFNVGA7', 6, 18),
(21, '2023-07-27 19:28:22', 0, 'MAVD030411HDFNVGA7', 'AAAA030125HDFLVLA2', 26, 23),
(22, '2023-09-18 21:01:33', 1, 'GAHI020228MMCRRNA7', 'SILP030314HDFPPBA3', 17, 22),
(23, '2023-10-13 05:25:37', 1, 'SILP030314HDFPPBA3', 'SILP030314HDFPPBA3', 8, 1),
(24, '2023-09-15 11:27:30', 1, 'SILP030314HDFPPBA3', 'SILP030314HDFPPBA3', 15, 15),
(25, '2023-08-28 10:32:51', 0, 'AAAA030125HDFLVLA2', 'MAVD030411HDFNVGA7', 9, 5),
(26, '2023-10-17 18:48:55', 1, 'MAVD030411HDFNVGA7', 'SILP030314HDFPPBA3', 13, 10),
(27, '2023-07-11 06:27:57', 1, 'SACC030606HMCNLRA2', 'MAVD030411HDFNVGA7', 22, 34),
(28, '2023-09-04 22:33:46', 1, 'GAHI020228MMCRRNA7', 'AAAA030125HDFLVLA2', 32, 16),
(29, '2023-09-15 20:46:52', 1, 'SILP030314HDFPPBA3', 'SACC030606HMCNLRA2', 35, 29),
(30, '2023-10-03 22:22:42', 1, 'SACC030606HMCNLRA2', 'SILP030314HDFPPBA3', 35, 29),
(31, '2023-07-06 09:27:24', 1, 'GAHI020228MMCRRNA7', 'MAVD030411HDFNVGA7', 4, 5),
(32, '2023-10-15 21:48:41', 0, 'AAAA030125HDFLVLA2', 'AAAA030125HDFLVLA2', 19, 27),
(33, '2023-07-14 16:16:34', 1, 'MAVD030411HDFNVGA7', 'AAAA030125HDFLVLA2', 4, 5),
(34, '2023-07-28 11:28:14', 0, 'MAVD030411HDFNVGA7', 'MAVD030411HDFNVGA7', 6, 18),
(35, '2023-08-01 21:25:07', 1, 'SILP030314HDFPPBA3', 'MAVD030411HDFNVGA7', 3, 2),
(36, '2023-07-15 11:09:13', 1, 'AAAA030125HDFLVLA2', 'MAVD030411HDFNVGA7', 32, 16),
(37, '2023-10-14 06:11:44', 0, 'GAHI020228MMCRRNA7', 'AAAA030125HDFLVLA2', 23, 7),
(38, '2023-07-13 10:41:45', 1, 'AAAA030125HDFLVLA2', 'MAVD030411HDFNVGA7', 7, 9),
(39, '2023-10-03 02:33:55', 1, 'AAAA030125HDFLVLA2', 'AAAA030125HDFLVLA2', 3, 2),
(40, '2023-10-17 15:20:22', 0, 'SACC030606HMCNLRA2', 'SACC030606HMCNLRA2', 1, 1),
(41, '2023-08-07 14:01:55', 0, 'SILP030314HDFPPBA3', 'GAHI020228MMCRRNA7', 6, 18),
(42, '2023-07-23 09:51:51', 1, 'SACC030606HMCNLRA2', 'AAAA030125HDFLVLA2', 12, 8),
(43, '2023-09-03 19:57:23', 1, 'SACC030606HMCNLRA2', 'GAHI020228MMCRRNA7', 17, 22),
(44, '2023-07-12 05:12:18', 0, 'SACC030606HMCNLRA2', 'GAHI020228MMCRRNA7', 32, 16),
(45, '2023-09-17 05:55:45', 1, 'GAHI020228MMCRRNA7', 'GAHI020228MMCRRNA7', 24, 14),
(46, '2023-07-21 14:46:23', 1, 'AAAA030125HDFLVLA2', 'MAVD030411HDFNVGA7', 19, 27),
(47, '2023-07-25 04:40:33', 0, 'GAHI020228MMCRRNA7', 'SILP030314HDFPPBA3', 32, 16),
(48, '2023-08-04 05:23:20', 0, 'MAVD030411HDFNVGA7', 'AAAA030125HDFLVLA2', 15, 15),
(49, '2023-09-16 00:39:41', 1, 'SACC030606HMCNLRA2', 'MAVD030411HDFNVGA7', 23, 7),
(50, '2023-08-13 11:27:24', 0, 'GAHI020228MMCRRNA7', 'MAVD030411HDFNVGA7', 4, 5),
(51, '2023-10-21 00:20:30', 0, 'MAVD030411HDFNVGA7', 'AAAA030125HDFLVLA2', 14, 12),
(52, '2023-09-03 10:31:40', 1, 'AAAA030125HDFLVLA2', 'MAVD030411HDFNVGA7', 24, 14),
(53, '2023-09-14 02:38:24', 1, 'SILP030314HDFPPBA3', 'SILP030314HDFPPBA3', 14, 12),
(54, '2023-09-05 20:36:10', 1, 'SACC030606HMCNLRA2', 'SILP030314HDFPPBA3', 19, 27),
(55, '2023-07-27 00:56:25', 0, 'SACC030606HMCNLRA2', 'AAAA030125HDFLVLA2', 23, 7),
(56, '2023-08-17 21:24:03', 0, 'GAHI020228MMCRRNA7', 'MAVD030411HDFNVGA7', 25, 19),
(57, '2023-09-19 21:48:21', 0, 'AAAA030125HDFLVLA2', 'SILP030314HDFPPBA3', 23, 7),
(58, '2023-08-10 06:46:54', 1, 'MAVD030411HDFNVGA7', 'AAAA030125HDFLVLA2', 33, 21),
(59, '2023-10-11 09:06:12', 1, 'GAHI020228MMCRRNA7', 'GAHI020228MMCRRNA7', 28, 31),
(60, '2023-08-23 11:21:56', 1, 'SILP030314HDFPPBA3', 'SACC030606HMCNLRA2', 21, 32),
(61, '2023-08-25 03:47:21', 0, 'MAVD030411HDFNVGA7', 'SACC030606HMCNLRA2', 35, 29),
(62, '2023-07-20 20:14:33', 1, 'MAVD030411HDFNVGA7', 'SACC030606HMCNLRA2', 16, 20),
(63, '2023-08-22 15:03:08', 1, 'GAHI020228MMCRRNA7', 'GAHI020228MMCRRNA7', 35, 29),
(64, '2023-07-25 17:57:39', 0, 'SACC030606HMCNLRA2', 'MAVD030411HDFNVGA7', 22, 34),
(65, '2023-09-16 12:22:54', 0, 'MAVD030411HDFNVGA7', 'AAAA030125HDFLVLA2', 33, 21),
(66, '2023-09-17 03:30:00', 0, 'GAHI020228MMCRRNA7', 'MAVD030411HDFNVGA7', 19, 27),
(67, '2023-10-20 01:25:45', 0, 'MAVD030411HDFNVGA7', 'MAVD030411HDFNVGA7', 26, 23),
(68, '2023-07-22 09:59:36', 0, 'SACC030606HMCNLRA2', 'GAHI020228MMCRRNA7', 9, 5),
(69, '2023-07-19 22:04:50', 0, 'SILP030314HDFPPBA3', 'SACC030606HMCNLRA2', 20, 30),
(70, '2023-07-23 19:34:20', 1, 'SACC030606HMCNLRA2', 'MAVD030411HDFNVGA7', 5, 17),
(71, '2023-10-22 00:54:29', 0, 'AAAA030125HDFLVLA2', 'GAHI020228MMCRRNA7', 17, 22),
(72, '2023-09-01 17:07:42', 0, 'SACC030606HMCNLRA2', 'GAHI020228MMCRRNA7', 33, 21),
(73, '2023-08-13 16:54:27', 0, 'MAVD030411HDFNVGA7', 'GAHI020228MMCRRNA7', 13, 10),
(74, '2023-08-12 07:23:35', 1, 'AAAA030125HDFLVLA2', 'AAAA030125HDFLVLA2', 21, 32),
(75, '2023-08-15 04:25:39', 0, 'SILP030314HDFPPBA3', 'SACC030606HMCNLRA2', 17, 22),
(76, '2023-09-11 06:55:49', 0, 'SACC030606HMCNLRA2', 'SILP030314HDFPPBA3', 22, 34),
(77, '2023-10-15 20:40:42', 0, 'AAAA030125HDFLVLA2', 'GAHI020228MMCRRNA7', 31, 13),
(78, '2023-09-17 16:27:45', 1, 'AAAA030125HDFLVLA2', 'SACC030606HMCNLRA2', 8, 1),
(79, '2023-08-23 14:08:57', 0, 'AAAA030125HDFLVLA2', 'SACC030606HMCNLRA2', 3, 2),
(80, '2023-10-24 11:46:38', 1, 'MAVD030411HDFNVGA7', 'SACC030606HMCNLRA2', 31, 13),
(81, '2023-09-04 19:51:32', 0, 'SACC030606HMCNLRA2', 'MAVD030411HDFNVGA7', 9, 5),
(82, '2023-07-23 19:14:16', 0, 'SILP030314HDFPPBA3', 'MAVD030411HDFNVGA7', 11, 6),
(83, '2023-10-19 03:30:10', 1, 'MAVD030411HDFNVGA7', 'SILP030314HDFPPBA3', 3, 2),
(84, '2023-10-06 04:11:11', 1, 'GAHI020228MMCRRNA7', 'MAVD030411HDFNVGA7', 33, 21),
(85, '2023-08-08 02:30:53', 0, 'MAVD030411HDFNVGA7', 'GAHI020228MMCRRNA7', 3, 2),
(86, '2023-07-24 13:15:18', 1, 'SILP030314HDFPPBA3', 'SILP030314HDFPPBA3', 24, 14),
(87, '2023-08-09 00:39:58', 1, 'SACC030606HMCNLRA2', 'AAAA030125HDFLVLA2', 16, 20),
(88, '2023-10-23 07:09:31', 1, 'GAHI020228MMCRRNA7', 'GAHI020228MMCRRNA7', 16, 20),
(89, '2023-07-10 00:38:26', 0, 'SILP030314HDFPPBA3', 'AAAA030125HDFLVLA2', 2, 4),
(90, '2023-07-10 07:51:34', 1, 'AAAA030125HDFLVLA2', 'MAVD030411HDFNVGA7', 31, 13),
(91, '2023-10-07 04:09:44', 0, 'AAAA030125HDFLVLA2', 'MAVD030411HDFNVGA7', 9, 5),
(92, '2023-10-15 01:47:40', 1, 'GAHI020228MMCRRNA7', 'GAHI020228MMCRRNA7', 14, 12),
(93, '2023-07-05 20:18:58', 0, 'MAVD030411HDFNVGA7', 'AAAA030125HDFLVLA2', 35,29),
(94, '2023-10-26 00:40:30', 0, 'SILP030314HDFPPBA3', 'AAAA030125HDFLVLA2', 24, 14),
(95, '2023-09-14 12:06:00', 0, 'GAHI020228MMCRRNA7', 'GAHI020228MMCRRNA7', 35, 29),
(96, '2023-09-22 15:26:21', 0, 'GAHI020228MMCRRNA7', 'GAHI020228MMCRRNA7', 10, 3),
(97, '2023-10-12 10:43:34', 1, 'SILP030314HDFPPBA3', 'SILP030314HDFPPBA3', 35, 29),
(98, '2023-07-02 05:50:25', 0, 'SACC030606HMCNLRA2', 'MAVD030411HDFNVGA7', 19, 27),
(99, '2023-08-11 18:30:17', 0, 'SACC030606HMCNLRA2', 'AAAA030125HDFLVLA2', 35, 29),
(100, '2023-09-12 14:25:40', 1, 'AAAA030125HDFLVLA2', 'SILP030314HDFPPBA3', 13, 10),
(101, '2023-09-23 08:50:28', 0, 'MAVD030411HDFNVGA7', 'GAHI020228MMCRRNA7', 12, 8),
(102, '2023-10-18 22:27:39', 0, 'SILP030314HDFPPBA3', 'AAAA030125HDFLVLA2', 6, 18),
(103, '2023-07-16 16:56:52', 0, 'GAHI020228MMCRRNA7', 'MAVD030411HDFNVGA7', 34, 24),
(104, '2023-09-16 22:36:37', 0, 'SILP030314HDFPPBA3', 'MAVD030411HDFNVGA7', 27, 28),
(105, '2023-07-26 05:58:59', 0, 'AAAA030125HDFLVLA2', 'SACC030606HMCNLRA2', 29, 33),
(106, '2023-10-26 08:43:57', 0, 'MAVD030411HDFNVGA7', 'GAHI020228MMCRRNA7', 27, 28),
(107, '2023-09-19 14:59:12', 1, 'SACC030606HMCNLRA2', 'SILP030314HDFPPBA3', 29, 33);

INSERT INTO Encuesta (`idPedido`, `servicio`, `higiene`, `calidad`) VALUES
(1, 1, 1, 5),
(2, 4, 2, 3),
(3, 2, 5, 1),
(4, 2, 3, 4),
(5, 4, 5, 4),
(6, 1, 1, 4),
(7, 3, 4, 1),
(8, 4, 4, 3),
(9, 3, 3, 2),
(10, 2, 3, 5),
(11, 4, 5, 5),
(12, 3, 5, 5),
(13, 1, 5, 5),
(14, 4, 5, 1),
(15, 2, 3, 4),
(16, 3, 5, 3),
(17, 5, 4, 5),
(18, 4, 2, 2),
(19, 5, 2, 5),
(20, 5, 1, 2),
(21, 2, 1, 3),
(22, 5, 2, 2),
(23, 2, 1, 3),
(24, 2, 5, 3),
(25, 3, 5, 4),
(26, 3, 1, 3),
(27, 2, 4, 1),
(28, 5, 5, 5),
(29, 2, 2, 1),
(30, 1, 2, 5),
(31, 4, 2, 2),
(32, 4, 3, 5),
(33, 5, 5, 5),
(34, 4, 4, 1),
(35, 4, 4, 3),
(36, 1, 1, 5),
(37, 3, 1, 5),
(38, 5, 3, 1),
(39, 2, 2, 2),
(40, 1, 1, 5),
(41, 4, 3, 1),
(42, 1, 2, 4),
(43, 3, 1, 1),
(44, 4, 2, 1),
(45, 4, 1, 5),
(46, 2, 4, 4),
(47, 5, 1, 1),
(48, 1, 4, 4),
(49, 4, 1, 2),
(50, 5, 1, 3),
(51, 5, 5, 5),
(52, 2, 1, 4),
(53, 2, 1, 1),
(54, 1, 2, 3),
(55, 2, 1, 3),
(56, 1, 5, 5),
(57, 5, 4, 1),
(58, 5, 3, 1),
(59, 1, 1, 2),
(60, 1, 2, 5),
(61, 5, 2, 4),
(62, 3, 1, 2),
(63, 5, 3, 4),
(64, 2, 1, 2),
(65, 3, 5, 2),
(66, 3, 1, 3),
(67, 1, 3, 4),
(68, 2, 4, 3),
(69, 4, 2, 1),
(70, 5, 4, 2),
(71, 1, 1, 1),
(72, 1, 5, 3),
(73, 1, 3, 3),
(74, 4, 4, 4),
(75, 3, 5, 2),
(76, 3, 1, 5),
(77, 1, 1, 1),
(78, 3, 4, 1),
(79, 1, 3, 2),
(80, 2, 5, 2),
(81, 5, 5, 3),
(82, 3, 1, 1),
(83, 4, 2, 5),
(84, 5, 1, 4),
(85, 4, 3, 2),
(86, 1, 4, 2),
(87, 5, 1, 2),
(88, 4, 4, 1),
(89, 4, 2, 4),
(90, 1, 4, 2),
(91, 4, 4, 5),
(92, 2, 5, 3),
(93, 2, 4, 4),
(94, 4, 4, 2),
(95, 2, 5, 1),
(96, 3, 5, 2),
(97, 5, 2, 1),
(98, 2, 2, 4),
(99, 1, 1, 3),
(100, 1, 5, 4),
(101, 3, 3, 1),
(102, 5, 4, 5),
(103, 5, 4, 2),
(104, 3, 5, 2),
(105, 1, 2, 5),
(106, 2, 4, 1),
(107, 5, 2, 4);
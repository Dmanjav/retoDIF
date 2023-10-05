USE APPDIF;

INSERT INTO Admins (`usuario`, `contrasena`) VALUES
('Aldehil', 'pbkdf2:sha256:600000$FAhTzalCnmY15ljn$ba493709f7fce005ec3f1334003e3dc072f5d061026d4709b87dbae5aeaaa4df'),
('Manja', 'pbkdf2:sha256:600000$qMhpBtIjN4BsozZt$030807f82615243981fed0e4da4d6cd035fa1f6d522839bd082c652017f099f7');

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO Cliente (`curp`, `nombre`, `apellidoP`, `apellidoM`, `sexo`, `fechaNacimiento`, `condicion`, `contrasena`) VALUES
('AAAA030125HDFLVLA2', 'Alan', 'Alcántara', 'Ávila', 'H', '2003-01-25', 'Sano', 'pbkdf2:sha256:600000$i5qVgZPSoL293JLe$4a376c123c0f367450d75f23c134bcf72f2094b5ab408abb6984db18f172f11f'),
('GAHI020228MMCRRNA7', 'Ingrid', 'García', 'Hernández', 'F', '2002-02-28', '', 'pbkdf2:sha256:600000$b8xYYER1mdI0Vnhr$44cb8a8021f8ad5bfcdbf489ee7e281017a62267410e01e0e49bbe2de97efad3'),
('MAVD030411HDFNVGA7', 'Diego', 'Manjarrez', 'Viveros', 'H', '2003-04-11', 'Sano', 'pbkdf2:sha256:600000$ONOocJRfINGSEPz0$6138532be9c4c17ee944708175873dccd8cc3caed384a65f2c214503b5a7f8ff'),
('SACC030606HMCNLRA2', 'Carlos', 'Sánchez', 'Calderon', 'H', '2003-06-06', 'Cuatro Ojos', 'pbkdf2:sha256:600000$LqBV7P8cylf6YXyb$4bb0cbff5ac485a97d714a2c3c413103910e7640f945b042d17e6752bfdb80b4'),
('SILP030314HDFPPBA3', 'Pablo', 'Spínola', 'López', 'H', '2003-04-14', 'Cuatro Ojos', 'pbkdf2:sha256:600000$AilSViF3yYUSxAyz$21bacc4088c0a781a6af788ba1b7daf2d5084c14059080301d2d42558c18c1b0');

--
-- Volcado de datos para la tabla `comedor`
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
(37, 'Los Olivos 2', 'Calle Mérida', '10', 'Los Olivos', 'pbkdf2:sha256:600000$Bp8pGi40ks7X0JhV$1357a8811c729066dda369132237b674f25b097e5c8c9f11cb2a11d8367a2815'),
(38, 'Tierra de en Medio', 'Hacienda de la Flor', '14', 'Tierra de en medio', 'pbkdf2:sha256:600000$ZNVJ5tvmU0P3iQ55$9d48dfeed0cbbffad40af744226184f9359c3770477fb2023dda686ef7342382');

--
-- Volcado de datos para la tabla `anuncios`
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
(22, 38, '2023-10-05 10:24:25', '¡Oferta de 30% de descuento en la comida para llevar!', 0),
(23, 32, '2023-10-05 10:24:26', '¡Reapertura de la sucursal!', 0),
(24, 38, '2023-10-05 10:24:27', 'Cerrado porque queremos', 1);

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
(3, '2023-09-30 16:09:30', 0, 'MAVD030411HDFNVGA7', 'AAAA030125HDFLVLA2', 2, 8),
(4, '2023-09-30 00:09:29', 1, 'GAHI020228MMCRRNA7', 'GAHI020228MMCRRNA7', 1, 8),
(5, '2023-10-02 02:45:29', 0, 'MAVD030411HDFNVGA7', 'MAVD030411HDFNVGA7', 1, 6);
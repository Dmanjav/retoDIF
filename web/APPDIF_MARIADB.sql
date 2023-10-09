-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 26-09-2023 a las 01:18:48
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "-06:00";
-- Idiomas de la base de datos
SET lc_time_names = "es_MX";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `APPDIF`
--

DROP DATABASE IF EXISTS APPDIF;
CREATE DATABASE APPDIF;
USE APPDIF;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Admins`
--

CREATE TABLE `Admins` (
  `usuario` varchar(50) NOT NULL,
  `contrasena` varchar(102) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `LoginClientes`
--

CREATE TABLE `LoginClientes` (
  `token` varchar(32) NOT NULL,
  `curpCliente` varchar(18) NOT NULL,
  `fechaHora` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `LoginComedores`
--

CREATE TABLE `LoginComedores` (
  `token` varchar(32) NOT NULL,
  `idComedor` int(11) NOT NULL,
  `fechaHora` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Anuncios`
--

CREATE TABLE `Anuncios` (
  `idAnuncio` int(11) NOT NULL,
  `idComedor` int(11) NOT NULL,
  `fechaHora` datetime NOT NULL,
  `contenido` text NOT NULL,
  `cierre` BOOLEAN NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Cliente`
--

CREATE TABLE `Cliente` (
  `curp` varchar(18) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellidoP` varchar(50) NOT NULL,
  `apellidoM` varchar(50) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `condicion` varchar(50) NOT NULL,
  `contrasena` varchar(102) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Comedor`
--

CREATE TABLE `Comedor` (
  `idComedor` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `calle` varchar(64) NOT NULL,
  `numero` varchar(10) NOT NULL,
  `colonia` varchar(50) NOT NULL,
  `contrasena` varchar(102) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Comida`
--

CREATE TABLE `Comida` (
  `idComida` int(11) NOT NULL,
  `idComedor` int(11) NOT NULL,
  `fechaRegistro` date NOT NULL,
  `entrada` varchar(50) NOT NULL,
  `plato` varchar(50) NOT NULL,
  `postre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Dependencia`
--

CREATE TABLE `Dependencia` (
  `idResponsable` varchar(18) NOT NULL,
  `idDependiente` varchar(18) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Pedido`
--

CREATE TABLE `Pedido` (
  `idPedido` int(11) NOT NULL,
  `fechaHora` datetime NOT NULL,
  `donacion` BOOLEAN NOT NULL DEFAULT 0,
  `responsable` varchar(18) NOT NULL,
  `dependiente` varchar(18) NOT NULL,
  `idComedor` int(11) NOT NULL,
  `idComida` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Encuesta`
--

CREATE TABLE `Encuesta` (
  `idPedido` int(11) NOT NULL
  `servicio` int(11),
  `higiene` int(11),
  `calidad` int(11)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Admins`
--
ALTER TABLE  `Admins`
  ADD PRIMARY KEY (`usuario`);

--
-- Indices de la tabla `LoginClientes`
--

ALTER TABLE `LoginClientes`
  ADD PRIMARY KEY (`token`),
  ADD KEY `curpCliente` (`curpCliente`);

--
-- Indices de la tabla `LoginComedores`
--

ALTER TABLE `LoginComedores`
  ADD PRIMARY KEY (`token`),
  ADD KEY `idComedor` (`idComedor`);

--
-- Indices de la tabla `Anuncios`
--
ALTER TABLE `Anuncios`
  ADD PRIMARY KEY (`idAnuncio`),
  ADD KEY `idComedor` (`idComedor`);

--
-- Indices de la tabla `Cliente`
--
ALTER TABLE `Cliente`
  ADD PRIMARY KEY (`curp`);

--
-- Indices de la tabla `Comedor`
--
ALTER TABLE `Comedor`
  ADD PRIMARY KEY (`idComedor`);

--
-- Indices de la tabla `Comida`
--
ALTER TABLE `Comida`
  ADD PRIMARY KEY (`idComida`,`idComedor`),
  ADD KEY (`idComedor`);

--
-- Indices de la tabla `Dependencia`
--
ALTER TABLE `Dependencia`
  ADD PRIMARY KEY (`idResponsable`,`idDependiente`),
  ADD KEY `idResponsable` (`idResponsable`),
  ADD KEY `idDependiente` (`idDependiente`);

--
-- Indices de la tabla `Pedido`
--
ALTER TABLE `Pedido`
  ADD PRIMARY KEY (`idPedido`),
  ADD KEY `responsable` (`responsable`),
  ADD KEY `dependiente` (`dependiente`),
  ADD KEY `idComedor` (`idComedor`),
  ADD KEY `idComida` (`idComida`);

--
-- Indices de la tabla `Encuesta`
--
ALTER TABLE `Encuesta`
  ADD PRIMARY KEY (`idPedido`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Anuncios`
--
ALTER TABLE `Anuncios`
  MODIFY `idAnuncio` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Comedor`
--
ALTER TABLE `Comedor`
  MODIFY `idComedor` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Comida`
--
ALTER TABLE `Comida`
  MODIFY `idComida` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `Pedido`
--
ALTER TABLE `Pedido`
  MODIFY `idPedido` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `LoginClientes`
--

ALTER TABLE `LoginClientes`
  ADD CONSTRAINT `LoginClientes_ibfk_1` FOREIGN KEY (`curpCliente`) REFERENCES `Cliente` (`curp`);

--
-- Filtros para la tabla `LoginComedores`
--

ALTER TABLE `LoginComedores`
  ADD CONSTRAINT `LoginComedores_ibfk_1` FOREIGN KEY (`idComedor`) REFERENCES `Comedor` (`idComedor`);

--
-- Filtros para la tabla `Anuncios`
--
ALTER TABLE `Anuncios`
  ADD CONSTRAINT `Anuncios_ibfk_1` FOREIGN KEY (`idComedor`) REFERENCES `Comedor` (`idComedor`);

--
-- Filtros para la tabla `Dependencia`
--
ALTER TABLE `Dependencia`
  ADD CONSTRAINT `Dependencia_ibfk_1` FOREIGN KEY (`idResponsable`) REFERENCES `Cliente` (`curp`),
  ADD CONSTRAINT `Dependencia_ibfk_2` FOREIGN KEY (`idDependiente`) REFERENCES `Cliente` (`curp`);

--
-- Filtros para la tabla `Pedido`
--
ALTER TABLE `Comida`
  ADD CONSTRAINT `Comida_ibfk_1` FOREIGN KEY (`idComedor`) REFERENCES `Comedor` (`idComedor`);

--
-- Filtros para la tabla `Pedido`
--
ALTER TABLE `Pedido`
  ADD CONSTRAINT `Pedido_ibfk_1` FOREIGN KEY (`responsable`) REFERENCES `Cliente` (`curp`),
  ADD CONSTRAINT `Pedido_ibfk_2` FOREIGN KEY (`dependiente`) REFERENCES `Cliente` (`curp`),
  ADD CONSTRAINT `Pedido_ibfk_3` FOREIGN KEY (`idComedor`) REFERENCES `Comida` (`idComedor`),
  ADD CONSTRAINT `Pedido_ibfk_4` FOREIGN KEY (`idComida`) REFERENCES `Comida` (`idComida`);
COMMIT;

--
-- Filtros para la tabla `Encuesta`
--
ALTER TABLE `Encuesta`
  ADD CONSTRAINT `Encuesta_ibfk_1` FOREIGN KEY (`idPedido`) REFERENCES `Pedido` (`idPedido`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

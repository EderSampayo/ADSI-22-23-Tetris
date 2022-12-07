-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-12-2022 a las 00:04:39
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tetris`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partida`
--

CREATE TABLE `partida` (
  `id` int(11) NOT NULL,
  `estadoPartida` varchar(10000) NOT NULL,
  `puntos` int(11) DEFAULT NULL,
  `nivel` varchar(20) DEFAULT NULL,
  `usuario` varchar(40) NOT NULL,
  `fecha` date DEFAULT NULL,
  `hora` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `partida`
--

INSERT INTO `partida` (`id`, `estadoPartida`, `puntos`, `nivel`, `usuario`, `fecha`, `hora`) VALUES
(13, 'NoShape NoShape ZShape NoShape SquareShape SquareShape NoShape NoShape LineShape NoShape NoShape NoShape ZShape ZShape SquareShape SquareShape NoShape NoShape LineShape NoShape NoShape NoShape NoShape ZShape TShape NoShape NoShape NoShape LineShape NoShape NoShape NoShape NoShape TShape TShape TShape NoShape NoShape LineShape NoShape NoShape NoShape NoShape NoShape SquareShape SquareShape NoShape NoShape LineShape NoShape NoShape NoShape NoShape NoShape SquareShape SquareShape NoShape NoShape LineShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape LineShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape LineShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape', NULL, NULL, 'eder', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `usuario` varchar(40) NOT NULL,
  `pwd` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `apellidos` varchar(40) NOT NULL,
  `DNI` varchar(9) NOT NULL,
  `fNac` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`usuario`, `pwd`, `email`, `nombre`, `apellidos`, `DNI`, `fNac`) VALUES
('eder', 'eder', 'eder@eder.com', 'Eder', 'Sampayo', '55555555K', '2002-03-12');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `partida`
--
ALTER TABLE `partida`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Test` (`usuario`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `partida`
--
ALTER TABLE `partida`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `partida`
--
ALTER TABLE `partida`
  ADD CONSTRAINT `partida_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

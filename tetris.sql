--
-- Base de datos: 'tetris'
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla 'partida'
--

CREATE TABLE IF NOT EXISTS PARTIDA(
  id  int(11) NOT NULL AUTO_INCREMENT,
  estadoPartida varchar(10000) DEFAULT NULL,
  puntos int(11) DEFAULT NULL,
  nivel int DEFAULT NULL,
  usuario varchar(40) NOT NULL,
  fecha date DEFAULT NULL,
  hora time DEFAULT NULL,
  PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla PARTIDA
--

INSERT INTO PARTIDA(id, estadoPartida, puntos, nivel, usuario, fecha, hora) VALUES
(13, 'NoShape NoShape ZShape NoShape SquareShape SquareShape NoShape NoShape LineShape NoShape NoShape NoShape ZShape ZShape SquareShape SquareShape NoShape NoShape LineShape NoShape NoShape NoShape NoShape ZShape TShape NoShape NoShape NoShape LineShape NoShape NoShape NoShape NoShape TShape TShape TShape NoShape NoShape LineShape NoShape NoShape NoShape NoShape NoShape SquareShape SquareShape NoShape NoShape LineShape NoShape NoShape NoShape NoShape NoShape SquareShape SquareShape NoShape NoShape LineShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape LineShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape LineShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape NoShape', NULL, NULL, 'eder', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla USUARIO
--

CREATE TABLE IF NOT EXISTS USUARIO(
  usuario varchar(40) NOT NULL PRIMARY KEY,
  pwd varchar(40) NOT NULL,
  email varchar(40) NOT NULL,
  nombre varchar(40) NOT NULL,
  apellidos varchar(40) NOT NULL,
  DNI varchar(9) NOT NULL,
  fNac varchar(40) NOT NULL,
  idPersonalizacion int NOT NULL AUTO_INCREMENT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla PERSONALIZACION
--

CREATE TABLE IF NOT EXISTS PERSONALIZACION(
  id int NOT NULL PRIMARY KEY,
  colorFondo int NOT NULL DEFAULT 0,
  ladrillo1 int NOT NULL DEFAULT 0,
  ladrillo2 int NOT NULL DEFAULT 0,
  ladrillo3 int NOT NULL DEFAULT 0,
  ladrillo4 int NOT NULL DEFAULT 0,
  ladrillo5 int NOT NULL DEFAULT 0,
  ladrillo6 int NOT NULL DEFAULT 0,
  ladrillo7 int NOT NULL DEFAULT 0,
  sonido int NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla PERSONALIZACION
--

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

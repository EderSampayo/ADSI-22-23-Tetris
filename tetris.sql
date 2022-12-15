--
-- Base de datos: 'tetris'
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla 'partida'
--

CREATE TABLE PARTIDA IF NOT EXISTS(
  id  int(11) NOT NULL,
  estadoPartida varchar(10000) NOT NULL,
  puntos int(11) DEFAULT NULL,
  nivel varchar(20) DEFAULT NULL,
  usuario varchar(40) NOT NULL,
  fecha date DEFAULT NULL,
  hora time DEFAULT NULL
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

CREATE TABLE USUARIO IF NOT EXISTS(
  usuario varchar(40) NOT NULL,
  pwd varchar(40) NOT NULL,
  email varchar(40) NOT NULL,
  nombre varchar(40) NOT NULL,
  apellidos varchar(40) NOT NULL,
  DNI varchar(9) NOT NULL,
  fNac date NOT NULL,
  idPersonalizacion int AUTO_INCREMENT 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla USUARIO
--

INSERT INTO USUARIO(usuario, pwd, email, nombre, apellidos, DNI, fNac,idPersonalizacion) VALUES
('eder', 'eder', 'eder@eder.com', 'Eder', 'Sampayo', '55555555K', '2002-03-12',1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla PERSONALIZACION
--

CREATE TABLE PERSONALIZACION IF NOT EXISTS(
  id int NOT NULL,
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

INSERT INTO PERSONALIZACION(id,colorFondo,ladrillo1,ladrillo2,ladrillo3,ladrillo4,ladrillo5,ladrillo6,ladrillo7,sonido) VALUES
(1,0,0,0,0,0,0,0,0,0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla PARTIDA
--
ALTER TABLE PARTIDA
  ADD PRIMARY KEY (id),
  ADD KEY Test (USUARIO);

--
-- Indices de la tabla USUARIO
--
ALTER TABLE USUARIO
  ADD PRIMARY KEY(USUARIO);
  ADD FOREIGN KEY(idPersonalizacion) REFERENCES PERSONALIZACION(id);


--
-- Indices de la tabla PERSONALIZACION
--
ALTER TABLE PERSONALIZACION
  ADD PRIMARY KEY (id);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla partida
--
ALTER TABLE partida
  MODIFY id int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla partida
--
ALTER TABLE partida
  ADD CONSTRAINT partida_ibfk_1 FOREIGN KEY (usuario) REFERENCES usuario (usuario);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-04-2020 a las 18:53:25
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `multienvios`
--
CREATE DATABASE IF NOT EXISTS `multienvios` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `multienvios`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `envio`
--

CREATE TABLE `envio` (
  `Tipo` varchar(20) NOT NULL,
  `Nº Envio` varchar(30) NOT NULL,
  `Origen` varchar(50) NOT NULL,
  `Destino` varchar(50) NOT NULL,
  `Destinatario` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `envio`
--

INSERT INTO `envio` (`Tipo`, `Nº Envio`, `Origen`, `Destino`, `Destinatario`) VALUES
('Aereo', '10111101', 'Toronto', 'New York', 'Jhon Wiliam'),
('Terrestre', '101111011', 'Toronto', 'Siatle', 'Bob Stiven'),
('Terrestre', '101111101', 'Bogota', 'Medellin', 'Cesar Castillo'),
('Aereo', '21232', 'Bogota', 'Cali', 'Alfredo'),
('Aereo', '10111011', 'Bogota', 'San Frasisco', 'Darma Sinatra'),
('Aereo', '001', 'Bogota', 'Cali', 'Pepe Sanchez');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mercancia`
--

CREATE TABLE `mercancia` (
  `Serial` varchar(20) NOT NULL,
  `Descripcion` varchar(100) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Peso` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `mercancia`
--

INSERT INTO `mercancia` (`Serial`, `Descripcion`, `Cantidad`, `Peso`) VALUES
('2rtr33422', 'Iphone X', 1, 2),
('4tt443rr3', 'Televiso LG', 2, 50),
('34233331', 'Uniformes Verdes', 12, 30),
('342334', 'Zapatos blancos', 24, 23),
('2332uu22', 'Computador Personal', 1, 23),
('2323i22', 'Cuaderno', 5, 2),
('721', 'Zapatos', 5, 5),
('0012', 'Cinturones', 20, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `Nombre` varchar(50) NOT NULL,
  `Identificación` varchar(20) NOT NULL,
  `Teléfono` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`Nombre`, `Identificación`, `Teléfono`) VALUES
('Alfred', '2567666', '2344333'),
('Victor', '101234445', '321944333'),
('Pablo Alfredo', '122232', '2223223'),
('Maria Gutierrez', '232312', '223312'),
('Maria Martinez', '2321223122', '23233222'),
('Carlos Banegas', '7777777', '3157777');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

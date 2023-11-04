-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-11-2023 a las 23:52:44
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `eldar`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `credit_card`
--

CREATE TABLE `credit_card` (
  `expiration_date` datetime(6) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `number_card` bigint(20) DEFAULT NULL,
  `card_holder_name` varchar(255) DEFAULT NULL,
  `card_type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `credit_card`
--

INSERT INTO `credit_card` (`expiration_date`, `id`, `number_card`, `card_holder_name`, `card_type`) VALUES
('2024-02-09 21:00:00.000000', 1, 123456789, 'Ain Ponce', 'AMEX'),
('2024-02-01 21:00:00.000000', 2, 123456777, 'Fernando Mazzini', 'VISA');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `credit_card`
--
ALTER TABLE `credit_card`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `credit_card`
--
ALTER TABLE `credit_card`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

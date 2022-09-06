-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- 主機： localhost
-- 產生時間： 2020-04-16 07:47:49
-- 伺服器版本： 8.0.17
-- PHP 版本： 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫： `cmdev`
--

-- --------------------------------------------------------

--
-- 資料表結構 `pet`
--

CREATE TABLE `pet` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(30) NOT NULL,
  `owner` varchar(30) DEFAULT NULL,
  `species` varchar(30) DEFAULT NULL,
  `gender` enum('m','f','','') DEFAULT NULL,
  `birth` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=big5;

--
-- 傾印資料表的資料 `pet`
--

INSERT INTO `pet` (`id`, `name`, `owner`, `species`, `gender`, `birth`) VALUES
(0, 'Fluffy', 'Harold', 'cat', 'f', '1993-02-04'),
(1, 'Claws', 'Gwen', 'cat', 'm', '1994-03-17'),
(2, 'Buffy', 'Harold', 'dog', 'f', '1989-05-13'),
(3, 'Fang', 'Benny', 'dog', 'm', '1990-08-27'),
(4, 'Chirpy', 'Gwen', 'bird', 'f', '1998-09-11'),
(5, 'Whistler', 'Gwen', 'bird', NULL, '1997-12-09'),
(6, 'Slim', 'Benny', 'snake', 'm', '1996-04-29');

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `pet`
--
ALTER TABLE `pet`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `pet`
--
ALTER TABLE `pet`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

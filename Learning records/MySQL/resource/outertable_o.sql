-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- 主機： localhost
-- 產生時間： 2020-04-16 07:47:57
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
-- 資料表結構 `outertable`
--

CREATE TABLE `outertable` (
  `id` bigint(20) NOT NULL,
  `edate` date NOT NULL,
  `etype` varchar(15) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `n`int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=big5;

--
-- 傾印資料表的資料 `outertable`
--

INSERT INTO `outertable` (`id`, `edate`, `etype`, `remark`,`n`) VALUES
(1, '1995-05-15', 'litter', '4 kittens, 3 female, 1 male',1),
(3, '1993-06-23', 'litter', '5 puppies, 2 female, 3 male',2),
(3, '1994-06-19', 'litter', '3 puppies, 3 female',3),
(5, '1999-03-21', 'vet', 'needed beak straightened',4),
(7, '1997-08-03', 'vet', 'broken rib',5),
(1, '1995-05-15', 'aaaaa', '4 kittens, 3 female, 1 male',6),
(3, '1993-06-23', 'bbbbb', '5 puppies, 2 female, 3 male',7),
(3, '1994-06-19', 'cat', '3 puppies, 3 female',8),
(5, '1999-03-21', 'dog', 'needed beak straightened',9),
(7, '1997-08-03', 'www', 'broken rib',10);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

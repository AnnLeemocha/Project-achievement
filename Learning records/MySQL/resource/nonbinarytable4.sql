-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- 主機： localhost
-- 產生時間： 
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
-- 資料表結構 `nonbinarytable4`
--

CREATE TABLE `nonbinarytable4` (
  `id` int(10) NOT NULL,
  `s` varchar(10) NOT NULL,
  `s1` varchar(10) NOT NULL,
  `s2` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=big5;

--
-- 傾印資料表的資料 `nonbinarytable4`
--

INSERT INTO `nonbinarytable4` (`id`, `s`, `s1`, `s2`) VALUES
(1, 'a', 'A', '我'),
(2, 'bbb', 'ccc', '你我他');

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `nonbinarytable4`
--
ALTER TABLE `nonbinarytable4`
  ADD PRIMARY KEY (`id`);

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `nonbinarytable4`
--
ALTER TABLE `nonbinarytable4`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

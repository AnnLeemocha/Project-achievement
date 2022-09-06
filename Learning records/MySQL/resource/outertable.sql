-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- 主機： localhost:3310
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
-- 資料庫： `world`
--

-- --------------------------------------------------------

--
-- 資料表結構 `outertable`
--

CREATE TABLE `outertable` (
  `id` int(11) NOT NULL,
  `n` varchar(10) CHARACTER SET big5 COLLATE big5_chinese_ci NOT NULL,
  `age` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=big5;

--
-- 傾印資料表的資料 `outertable`
--

INSERT INTO `outertable` (`id`, `n`, `age`) VALUES
(1, 'TAIPEI', 15),
(2, 'HUALINE', 12),
(3, 'Taichung', 20),
(4, 'TAIPEI', 5),
(5, 'Tainan', 8),
(6, 'Tainan', 10),
(7, 'Changhua', 15),
(8, 'Changhua', 10);

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `outertable`
--
ALTER TABLE `outertable`
  ADD PRIMARY KEY (`id`);

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `outertable`
--
ALTER TABLE `outertable`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

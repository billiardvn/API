-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 19, 2024 at 12:55 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 7.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `a3`
--

-- --------------------------------------------------------

--
-- Table structure for table `SanPham`
--

CREATE TABLE `SanPham` (
  `MaSP` varchar(100) NOT NULL,
  `TenSP` varchar(100) NOT NULL,
  `MoTa` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `SanPham`
--

INSERT INTO `SanPham` (`MaSP`, `TenSP`, `MoTa`) VALUES
('Name', 'Name', 'Name'),
('name01', 'NameAndroid01', 'name01'),
('PH01', 'san pham 1', 'mo ta 1'),
('SP2', 'san pham 2', 'SP2'),
('SP3', 'san pham 333', 'SP3'),
('user123', 'password', 'user123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `SanPham`
--
ALTER TABLE `SanPham`
  ADD PRIMARY KEY (`MaSP`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

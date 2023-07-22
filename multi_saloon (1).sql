-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 22, 2023 at 05:24 AM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `multi_saloon`
--

-- --------------------------------------------------------

--
-- Table structure for table `appoinment`
--

CREATE TABLE IF NOT EXISTS `appoinment` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `service` varchar(70) NOT NULL,
  `amount` varchar(80) NOT NULL,
  `time` varchar(70) NOT NULL,
  `date` varchar(100) NOT NULL,
  `shop_id` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=25 ;

--
-- Dumping data for table `appoinment`
--

INSERT INTO `appoinment` (`id`, `service`, `amount`, `time`, `date`, `shop_id`) VALUES
(12, 'Facial', '400', '12.30pm', '18-5-2023', 0),
(13, 'Hair Cut', '200', '7.00pm', '19-5-2023', 0),
(14, 'Hair Cut', '200', '12.00', '26-5-2023', 1),
(16, 'Hair Cut', '200', '3.30pm', '22-5-2023', 1),
(17, 'Hair spa', '250', '5.30', '19-5-2023', 3),
(18, 'Hair Cut', '200', '6.00', '26-5-2023', 1),
(19, 'Hair Cut', '200', '12.00', '15-6-2023', 1),
(20, 'Hair spa', '250', '2.00', '30-6-2023', 3),
(21, 'Hair spa', '250', '9.00 am', '29-6-2023', 3),
(22, 'Hair spa', '250', '8.00pm', '28-7-2023', 3),
(23, 'Hair spa', '250', '2.00pm', '2-6-2023', 0),
(24, 'Hair spa', '250', '8.30pm', '8-6-2023', 2);

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE IF NOT EXISTS `feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(50) NOT NULL,
  `feedback` varchar(100) NOT NULL,
  `shop_name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`id`, `user_id`, `feedback`, `shop_name`) VALUES
(3, '3', 'good service', ''),
(4, '3', 'good', 'Cut pro');

-- --------------------------------------------------------

--
-- Table structure for table `package_tbl`
--

CREATE TABLE IF NOT EXISTS `package_tbl` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `image` tinytext NOT NULL,
  `package_name` varchar(80) NOT NULL,
  `rate` varchar(50) NOT NULL,
  `places` varchar(70) NOT NULL,
  `offer` varchar(60) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `package_tbl`
--

INSERT INTO `package_tbl` (`id`, `image`, `package_name`, `rate`, `places`, `offer`, `description`) VALUES
(1, '2023-05-10-03-39-22hairdresser-protective-mask-cutting-hair-curly-african-american-client-beauty-salon-free-space-195792989.jpg', 'Cutting + Hair color + facial', '1399', 'Edapally', '999', 'Good looks makes Better Confidence'),
(2, '2023-05-10-05-02-24photo-1516975080664-ed2fc6a32937.jpg', 'Hair color + golden facial', '1999', 'Kaloor', '1499', 'Good looks makes Better Confidence'),
(3, '2023-05-10-05-09-20shutterstock-1158042907-cropped-1557306156.jpg', 'Cutting + Threading', '499', 'Panampally nagar', '299', 'Good looks makes Better Confidence'),
(4, '2023-05-17-02-36-06photo-1516975080664-ed2fc6a32937.jpg', 'Cutting + Threading', '1399', 'Kaloor', '999', 'Good looks makes Better Confidence'),
(5, '2023-05-23-03-46-4911903742116_e4661baee7_b.jpg', 'Hair color + golden facial', 'â‚¹1999', 'Panampally nagar', 'â‚¹1499', 'Good looks makes Better Confidence');

-- --------------------------------------------------------

--
-- Table structure for table `rating_tbl`
--

CREATE TABLE IF NOT EXISTS `rating_tbl` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `shop_id` int(11) NOT NULL,
  `rating` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=73 ;

--
-- Dumping data for table `rating_tbl`
--

INSERT INTO `rating_tbl` (`id`, `uid`, `shop_id`, `rating`) VALUES
(3, 1, 0, '4'),
(4, 1, 1, '5'),
(5, 1, 2, '5'),
(6, 1, 3, '4'),
(7, 2, 4, '3'),
(8, 2, 1, '4'),
(9, 2, 2, '4'),
(10, 3, 5, '4'),
(11, 3, 6, '4'),
(12, 3, 4, '4.5'),
(13, 3, 7, '4'),
(14, 4, 8, '5'),
(15, 4, 9, '4'),
(16, 5, 2, '4'),
(17, 5, 1, '5'),
(18, 5, 0, '4'),
(19, 5, 4, '5'),
(20, 6, 10, '3'),
(21, 6, 11, '4'),
(22, 6, 12, '4'),
(23, 6, 2, '5'),
(24, 7, 2, '3'),
(25, 7, 0, '4'),
(26, 7, 3, '5'),
(27, 7, 13, '5'),
(28, 7, 14, '3.5'),
(29, 8, 2, '5'),
(30, 8, 0, '4'),
(31, 8, 3, '4'),
(32, 8, 4, '4'),
(33, 8, 1, '5'),
(34, 8, 15, '3'),
(35, 9, 16, '5'),
(36, 9, 17, '5'),
(37, 9, 18, '4'),
(38, 10, 19, '4'),
(39, 11, 20, '3.5'),
(40, 11, 14, '4'),
(41, 11, 2, '5'),
(42, 11, 13, '4'),
(43, 11, 5, '4'),
(44, 12, 21, '4'),
(45, 12, 2, '4'),
(46, 12, 0, '5'),
(47, 12, 1, '4'),
(48, 12, 4, '3.5'),
(49, 12, 22, '5'),
(50, 12, 23, '5'),
(51, 12, 24, '4.5'),
(52, 13, 25, '4.5'),
(53, 13, 26, '4'),
(54, 13, 27, '4'),
(55, 14, 24, '4'),
(56, 14, 23, '5'),
(57, 14, 28, '4'),
(58, 15, 25, '4'),
(59, 15, 29, '5'),
(60, 15, 23, '4'),
(61, 15, 24, '5'),
(62, 16, 30, '4.5'),
(63, 16, 31, '5'),
(64, 16, 23, '4'),
(65, 17, 25, '5'),
(66, 17, 32, '3'),
(67, 17, 29, '4.5'),
(68, 17, 23, '5'),
(69, 18, 23, '4.5'),
(70, 18, 25, '5'),
(71, 18, 29, '4.5'),
(72, 3, 1, '3.0');

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE IF NOT EXISTS `register` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(70) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(40) NOT NULL,
  `phone` varchar(60) NOT NULL,
  `gender` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`id`, `name`, `email`, `password`, `phone`, `gender`) VALUES
(1, 'Fayiz', 'fz@gmail.com', '555', '5555555', 'male'),
(2, 'Fayiz', 'fz@gmail.com', '555', '5555555', 'male'),
(3, 'fayiz', 'fz@gmail.com', '777', '2580963', 'male');

-- --------------------------------------------------------

--
-- Table structure for table `saloon_tbl`
--

CREATE TABLE IF NOT EXISTS `saloon_tbl` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(70) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(70) NOT NULL,
  `place` varchar(80) NOT NULL,
  `phone` varchar(60) NOT NULL,
  `image` tinytext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=32 ;

--
-- Dumping data for table `saloon_tbl`
--

INSERT INTO `saloon_tbl` (`id`, `shop_name`, `email`, `password`, `place`, `phone`, `image`) VALUES
(1, 'Black & White', 'fz@gmail.com', '777', 'Palarivattom', '9874563210', 'images.jpg'),
(2, 'Cut Pro', 'cp@gmail.com', '123456', 'kochi', '1234567890', '2023-05-13-01-52-38hairdresser-protective-mask-cutting-hair-curly-african-american-client-beauty-salon-free-space-195792989.jpg'),
(3, 'Beyond Beauty', 'bb@gmail.com', 'bb123', 'Vazhakulam', '1239872089', '2023-05-17-04-46-05salon1.jpg'),
(4, 'Lavender ', 'lavender@gmail.com', 'lav123', 'Vazhakulam', '3456789289', '2023-05-17-04-48-04salon2.jfif'),
(5, 'Cucumbo', 'cucumbo@gmail.com', 'cucu@123', 'Vazhakulam', '8889756123', '2023-05-17-04-50-21beauty-salon-barber-shop-interior-260nw-1408306397.webp'),
(6, 'Wondergirls', 'wg@gmail.com', 'wg123', 'Muvatupuzha', '1234567894', '2023-05-17-04-52-54hair-and-face-salon-logo-vector-templates.jpg'),
(7, 'Choice', 'choice@gmail.com', 'ch123', 'Muvatupuzha', '8590866317', '2023-05-17-04-54-26hairdresser-logo-beauty-salon-logo-with-man-and-woman-silhouettes-vector-illustration-2G6MBM5.jpg'),
(8, 'Haritha ', 'haritha@gamil.com', 'h123', 'Muvatupuzha', '8590866317', '2023-05-17-04-55-29salon1.jpg'),
(9, 'Stylette', 'st@gmail.com', 'st123', 'Muvatupuzha', '123457800', '2023-05-17-04-58-27pngtree-salon-logo-png-image_4024992.png'),
(10, 'Supercuts', 'supercuts@gmail.com', 'sp123', 'Muvatupuzha', '1234567891', '2023-05-17-04-59-35salon1.jpg'),
(11, 'Glamour Emporium', 'ge@gmail.com', '12365', 'Thodupuzha', '1234567896', '2023-05-17-05-01-03hair-and-face-salon-logo-vector-templates.jpg'),
(12, 'Beauty Lounge', 'bl@gmail.com', 'bl123', 'Thodupuzha', '8590866317', '2023-05-17-05-02-06pngtree-salon-logo-png-image_4024992.png'),
(13, 'Beautello', 'beautello@gmail.com', 'bb12', 'Thodupuzha', '1534597861', '2023-05-17-05-04-59pngtree-salon-logo-png-image_4024992.png'),
(14, 'Alpha', 'alpha@gmail.com', 'al123', 'Thodupuzha', '1234567800', '2023-05-17-05-07-08hair-and-face-salon-logo-vector-templates.jpg'),
(15, 'Beta', 'beta@gmail.com', 'bt145', 'Thodupuzha', '1423398724', '2023-05-17-05-07-59hair-and-face-salon-logo-vector-templates.jpg'),
(16, 'Colour & Curls', 'cc@gmail.com', 'cc123', 'Muvatupuzha', '1234567898', '2023-05-17-05-09-21pngtree-salon-logo-png-image_4024992.png'),
(17, 'Lagom Hair Lounge', 'll@gmail.com', 'hjj123', 'Vazhakulam', '1234567833', '2023-05-17-05-10-40hairdresser-logo-beauty-salon-logo-with-man-and-woman-silhouettes-vector-illustration-2G6MBM5.jpg'),
(18, 'Mirage', 'mirage@gmail.com', 'mm145', 'Vazhakulam', '3456723099', '2023-05-17-05-11-39hair-and-face-salon-logo-vector-templates.jpg'),
(19, 'Creato', 'creato@gmail.com', 'cc456', 'Muvatupuzha', '1234567877', '2023-05-17-05-13-24images.png'),
(20, 'Cool Cutz', 'cc@gmail.com', 'ccc12', 'Muvatupuzha', '1234567893', '2023-05-17-05-14-46download.png'),
(21, 'Dandalions', 'dd@gmail.com', 'dd123', 'Vazhakulam', '4567891230', '2023-05-17-05-16-46WhatsApp Image 2023-05-17 at 5.01.20 PM.jpeg'),
(22, 'Omega', 'omega@gmail.com', 'om123', 'Palarivattom', '1234561230', '2023-05-17-05-17-57WhatsApp Image 2023-05-17 at 5.01.19 PM.jpeg'),
(23, 'Nova Unisex Salon', 'nova@gmail.com', 'nova123', 'Palarivattom', '4564561230', '2023-05-17-05-19-11WhatsApp Image 2023-05-17 at 5.01.21 PM.jpeg'),
(24, 'Belles & Beaus', 'bbbb@gmail.com', 'kkl', 'Palarivattom', '7897897890', '2023-05-17-05-20-13images.png'),
(25, 'Mystique Salon', 'ms@gmail.com', 'ms123', 'Palarivattom', '4564564569', '2023-05-17-05-26-08222.jfif'),
(26, 'Belle Curls', 'bc@gmail.com', 'ed123', 'Edapally', '1231231239', '2023-05-17-05-27-20hairdresser-logo-beauty-salon-logo-with-man-and-woman-silhouettes-vector-illustration-2G6MBM5.jpg'),
(27, 'Just For You', 'justforyou@gmail.com', 'jj456', 'Edapally', '9638527410', '2023-05-17-05-29-00download.png'),
(28, 'Mirror', 'mirror@gmail.com', 'mm90', 'Edapally', '1472589638', '2023-05-17-05-29-54hair-and-face-salon-logo-vector-templates.jpg'),
(29, 'Beauty Garden', 'bg123@gmail.com', 'gh123', 'Kaloor', '1234567899', '2023-05-17-05-30-54pngtree-salon-logo-png-image_4024992.png'),
(30, 'Halo', 'halo@gmail.com', 'halo123', 'Kaloor', '8965327458', '2023-05-17-05-32-31download.png'),
(31, 'asdfghjk', 'davood@gmail.com', '123456', 'Ernakulam', '1234567822', '2023-05-20-02-53-246de74bd5812a30ed7d9212ab93cb721c13fe69ee.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `service_tbl`
--

CREATE TABLE IF NOT EXISTS `service_tbl` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `shop_id` int(11) NOT NULL,
  `service_type` varchar(80) NOT NULL,
  `time` varchar(100) NOT NULL,
  `price` varchar(100) NOT NULL,
  `gender` varchar(80) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `service_tbl`
--

INSERT INTO `service_tbl` (`id`, `shop_id`, `service_type`, `time`, `price`, `gender`) VALUES
(1, 1, 'Hair Cut', '40min', '250', 'men'),
(2, 1, 'Facial', '1hr', '400', 'women'),
(3, 2, 'Hair spa', '2hour', '250', 'women & men'),
(4, 1, 'Hair color', '40min', '399', 'women'),
(5, 1, 'Hair color', '40min', '200', 'men'),
(6, 1, 'Hair color', '40min', '200', 'men'),
(7, 0, 'Hair color', '40min', '200', 'men'),
(8, 4, 'Hair color', '40min', '399', 'women'),
(9, 4, 'Hair color', '40min', '399', 'women'),
(10, 1, 'cutting', '30min', '199', 'men'),
(11, 1, 'Shaving', '20min', '150', 'men');

-- --------------------------------------------------------

--
-- Table structure for table `stylists`
--

CREATE TABLE IF NOT EXISTS `stylists` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `shop_id` int(11) NOT NULL,
  `name` varchar(70) NOT NULL,
  `specialization` varchar(80) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `stylists`
--

INSERT INTO `stylists` (`id`, `shop_id`, `name`, `specialization`) VALUES
(1, 1, 'Amaya', 'Facial & Hair spa'),
(2, 2, 'Christy', 'Hair Cut'),
(3, 1, 'Gokul', 'Hair Spa');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

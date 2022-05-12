-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 16, 2019 at 04:19 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shopbandienthoai`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitietdonhang`
--

CREATE TABLE `chitietdonhang` (
  `idCTHD` int(11) NOT NULL,
  `idHD` int(11) NOT NULL,
  `idSP` int(11) NOT NULL,
  `Soluong` int(11) NOT NULL,
  `Dongia` float NOT NULL,
  `Thanhtien` float NOT NULL,
  `khuyenmai` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `chitietdonhang`
--

INSERT INTO `chitietdonhang` (`idCTHD`, `idHD`, `idSP`, `Soluong`, `Dongia`, `Thanhtien`, `khuyenmai`) VALUES
(1, 16, 43, 1, 990000, 990000, 0),
(2, 17, 39, 1, 17990000, 17990000, 0),
(3, 17, 52, 1, 5490000, 5490000, 0),
(4, 18, 47, 1, 22990000, 22990000, 0),
(5, 19, 53, 1, 2390000, 2390000, 0),
(6, 19, 35, 1, 10590000, 10590000, 0),
(7, 20, 44, 1, 440000, 440000, 0),
(8, 20, 41, 1, 6990000, 6990000, 0),
(9, 21, 33, 1, 11390000, 11390000, 0),
(10, 21, 32, 1, 3990000, 3990000, 0),
(11, 22, 55, 1, 5990000, 5990000, 0),
(12, 22, 11, 1, 6400000, 6400000, 0);

-- --------------------------------------------------------

--
-- Table structure for table `donhang`
--

CREATE TABLE `donhang` (
  `idHD` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `hoten_user` varchar(255) NOT NULL,
  `Gmail_user` varchar(255) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `Diachi` varchar(255) NOT NULL,
  `Tongtien` float NOT NULL,
  `payment` varchar(255) NOT NULL,
  `Ngaytao` varchar(11) NOT NULL,
  `trangthai` tinyint(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `donhang`
--

INSERT INTO `donhang` (`idHD`, `idUser`, `hoten_user`, `Gmail_user`, `phone`, `Diachi`, `Tongtien`, `payment`, `Ngaytao`, `trangthai`) VALUES
(16, 5, 'Nguyen Văn A', 'nguyenvansy@gmail.com', '0968798351', 'Quận 5 - TP.Hồ chí minh', 990000, 'Tiền mặt', '15-05-2019', 1),
(17, 5, 'Nguyễn Huy B', 'nguyenvansy@gmail.com', '0968798351', 'Quận 6 - TP.Hồ chí minh', 23480000, 'Qua thẻ', '15-05-2019', 1);

-- --------------------------------------------------------

--
-- Table structure for table `lienhe`
--

CREATE TABLE `lienhe` (
  `idLH` int(11) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `user_gmail` varchar(100) NOT NULL,
  `Noidung` text NOT NULL,
  `Create` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `idLSP` int(3) NOT NULL,
  `tenloai` varchar(50) NOT NULL,
  `maloai` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `loaisanpham`
--

INSERT INTO `loaisanpham` (`idLSP`, `tenloai`, `maloai`) VALUES
(1, 'Váy đen', 'vd'),
(2, 'Váy xanh', 'vx'),
(3, 'Váy vàng', 'vv'),
(4, 'Váy đỏ', 'vr'),
(5, 'Váy trắng ', 'vt1'),
(6, 'Váy hồng', 'vh');

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `STT` int(11) NOT NULL,
  `MaNV` varchar(10) NOT NULL,
  `Ten` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `SDT` varchar(12) NOT NULL,
  `DiaChi` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `NgaySinh` date NOT NULL,
  `GioiTinh` varchar(4) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Luong` int(11) NOT NULL,
  `Pass` varchar(20) NOT NULL,
  `Trangthai` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `PhanQuyen` varchar(10) CHARACTER SET utf8 COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`STT`, `MaNV`, `Ten`, `SDT`, `DiaChi`, `NgaySinh`, `GioiTinh`, `Luong`, `Pass`, `Trangthai`, `PhanQuyen`) VALUES
(1, 'Admin', 'Nguyễn Văn sỹ', '0911887319', '12, P7, Quận 1,TPHCM', '1999-09-09', 'Nam', 500, '0911887319', 'Mở khóa', 'Admin'),
(2, 'Manager01', 'Nguyễn Văn D', '0911887311', '20, NH,P.10,Gò Vấp,HCM', '1999-04-26', 'Nam', 350, '098877319', 'Mở khóa', 'Manager'),
(3, 'Manager02', 'Nguyễn Văn E', '0111887312', '18,P3,Tân Bình,HCM', '1999-01-12', 'Nam', 350, '0123456789', 'Mở khóa', 'Manager');

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `idSP` int(11) NOT NULL,
  `idLSP` int(11) NOT NULL,
  `tensp` varchar(100) NOT NULL,
  `gia` float NOT NULL,
  `mota` varchar(200) NOT NULL,
  `hinhanh` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`idSP`, `idLSP`, `tensp`, `gia`, `mota`, `hinhanh`) VALUES
(1, 1, 'Váy đen vd1', 3400000, 'váy đen vd1', 'vd1.jpg'),
(2, 1, 'Váy đen vd2', 19500000, 'Váy đen vd2 mang trong mình hàng hoạt các thay đổi đột phá với điểm nhấn đặc biệt đến từ chiếc bút S-Pen thần thánh cùng một viên pin dung lượng khổng lồ tới 4.000 mAh.', 'vd21.jpg'),
(3, 1, 'Váy đen vd3', 8000000, '', 'vd3.jpg'),
(4, 1, 'Váy đen vd4', 4400000, 'Váy đen vd4 là một chiếc váy giá rẻ hiếm hoi trên thị trường sở hữu những tính năng khá hấp dẫn trong năm 2018 đó là camera kép ở mặt lưng và màn hình tai thỏ ở mặt trước.', 'vd5.jpg'),
(5, 1, 'Váy đen vd 6', 4400000, 'Váy đen vd6 luôn mang có sự thay đổi trong thiết kế mới và chiếc .......', 'vd6.jpg'),
(6, 1, 'Váy đen vd9', 5400000, 'Váy đen vd9 là sản phẩm', 'vd9.jpg'),
(7, 1, 'Váy đen vd 10', 4400000, ' với các góc cạnh thể hiện rõ ràng, hơn nữa thân máy được làm bằng hợp kim Magie giúp máy có trọng lượng nhẹ và đạt tính thẩm mỹ cao. Cạnh dưới cùng của máy ta có ', 'vd10.jpg'),
(8, 2, 'Váy đen vd 11', 10500000, 'Tự động lấy nét, Quay video Full HD, Chế độ làm đẹp, Selfie ngược sáng HDR, Nhận diện khuôn mặt, Chụp bằng giọng nói, Selfie bằng cử chỉ.', 'vd11.jpg'),
(9, 1, 'Váy đen vd12', 4400000, 'vd12', 'vd12.jpg'),
(10, 1, 'Váy đen vd13', 8400000, 'vd13', 'vd13.jpg'),
(11, 1, 'Váy đen vd16', 6400000, 'váy đủ phụ kiện hướng dẫn sử dụng, hộp tùng , bảo hành 12 tháng.', 'vd16.jpg'),
(12, 6, 'Váy hồng', 12500000, 'Coppy đoạn văn something', 'vh1.jpg'),
(13, 6, 'Váy hồng vh2', 9300000, 'Something', 'vh2.jpg'),
(14, 6, 'Váy hồng vh3', 2300000, 'VH3', 'vh3.jpg'),
(15, 6, 'Váy hồng vh7', 1200000, 'vh7', 'vh7.jpg'),
(16, 6, 'Váy hồng vh8', 3400000, 'VH8', 'vh8.jpg'),
(17, 6, 'Vay Hong vh9', 5400000, 'vh9', 'vh9.jpg'),
(18, 6, 'Váy hồng vh10', 11500000, 'vh10', 'vh10.jpg'),
(19, 4, 'Váy đỏ vr1', 8600000, 'VR1', 'vr1.jpg'),
(20, 4, 'Váy đỏ vr2', 10900000, 'Váy đỏ vr2', 'vr2.jpg'),
(21, 4, 'Váy đỏ vr3', 7400000, 'Váy đỏ vr3', 'vr3.jpg'),
(22, 4, 'Váy đỏ vr4', 3500000, 'Váy đỏ vr4', 'vr4.jpg'),
(23, 4, 'Váy đỏ vr5', 8400000, 'Váy đỏ vr5', 'vr5.jpg'),
(24, 4, 'Váy đỏ vr6', 4900000, 'Váy đỏ vr6', 'vr6.jpg'),
(25, 4, 'Váy đỏ vr7', 3550000, 'Váy đỏ vr7', 'vr7.jpg'),
(26, 4, 'Váy đỏ vr8', 3550000, 'Váy đỏ vr8', 'vr8.jpg'),
(27, 4, 'Váy đỏ vr9', 3550000, 'Váy đỏ vr9', 'vr9.jpg'),
(28, 5, 'Váy trắng vt1', 3550000, 'Váy trắng vt1', 'vt1.jpg'),
(29, 5, 'Váy trắng vt2', 3550000, 'Váy trắng vt2', 'vt2.jpg'),
(30, 5, 'Váy trắng vt3', 3550000, 'Váy trắng vt3', 'vt3.jpg'),
(31, 5, 'Váy trắng vt4', 3550000, 'Váy trắng vt4', 'vt4.jpg'),
(32, 5, 'Váy trắng vt5', 3550000, 'Váy trắng vt5', 'vt5.jpg'),

(33, 5, 'Váy trắng vt6', 3550000, 'Váy trắng vt6', 'vt6.jpg'),

(34, 5, 'Váy trắng vt7', 3550000, 'Váy trắng vt7', 'vt7.jpg'),
(35, 5, 'Váy trắng vt8', 3550000, 'Váy trắng vt8', 'vt8.jpg'),
(36, 5, 'Váy trắng vt9', 3550000, 'Váy trắng vt9', 'vt9.jpg'),
(37, 5, 'Váy trắng vt10', 3550000, 'Váy trắng vt10', 'vt10.jpg'),
(38, 5, 'Váy trắng vt11', 3550000, 'Váy trắng vt11', 'vt11.jpg'),
(39, 5, 'Váy trắng vt12', 3550000, 'Váy trắng vt12', 'vt12.jpg'),
(40, 5, 'Váy trắng vt13', 3550000, 'Váy trắng vt13', 'vt13.jpg'),
(41, 5, 'Váy trắng vt14', 3550000, 'Váy trắng vt14', 'vt14.jpg'),
(42, 2, 'Váy xanh vx5', 3550000, 'Váy xanh vx5', 'vx6.jpg'),
(43, 2, 'Váy xanh vx6', 3550000, 'Váy xanh vx6', 'vx7.jpg'),
(44, 2, 'Váy xanh vx7', 3550000, 'Váy xanh vx7', 'vx8.jpg'),
(45, 2, 'Váy xanh vx8', 3550000, 'Váy xanh vx8', 'vx9.jpg'),
(46, 3, 'Váy vàng vv1', 3550000, 'Váy vàng vv', 'vv1.jpg'),
(47, 3, 'Váy vàng vv2', 3550000, 'Váy vàng vv', 'vv2.jpg'),
(48, 3, 'Váy vàng vv3', 3550000, 'Váy vàng vv', 'vv3.jpg'),
(49, 3, 'Váy vàng vv4', 3550000, 'Váy vàng vv', 'vv4.jpg'),
(50, 3, 'Váy vàng vv5', 3550000, 'Váy vàng vv', 'vv5.jpg'),
(51, 3, 'Váy vàng vv6', 3550000, 'Váy vàng vv', 'vv6.jpg'),
(52, 3, 'Váy vàng vv7', 3550000, 'Váy vàng vv', 'vv7.jpg');


-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `idUser` int(10) NOT NULL,
  `tendangnhap` varchar(50) NOT NULL,
  `matkhau` varchar(50) NOT NULL,
  `hoten` varchar(255) NOT NULL,
  `Gmail` varchar(100) NOT NULL,
  `SDT` varchar(11) NOT NULL,
  `Diachi` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`idUser`, `tendangnhap`, `matkhau`, `hoten`, `Gmail`, `SDT`, `Diachi`) VALUES
(1, 'Vansy', 'a67b61c217d3c6f92ceca1827583436a', 'slkadgaklsj', 'vansy@gmail.com', '02147483647', 'Hồ chí minh'),
(2, 'thang', 'e10adc3949ba59abbe56e057f20f883e', 'huythng', 'huythag', '0', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  ADD PRIMARY KEY (`idCTHD`),
  ADD KEY `idHD` (`idHD`),
  ADD KEY `idSP` (`idSP`);

--
-- Indexes for table `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`idHD`),
  ADD KEY `idUser` (`idUser`);

--
-- Indexes for table `lienhe`
--
ALTER TABLE `lienhe`
  ADD PRIMARY KEY (`idLH`);

--
-- Indexes for table `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD PRIMARY KEY (`idLSP`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`STT`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`idSP`),
  ADD KEY `idLSP` (`idLSP`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idUser`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  MODIFY `idCTHD` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `donhang`
--
ALTER TABLE `donhang`
  MODIFY `idHD` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `lienhe`
--
ALTER TABLE `lienhe`
  MODIFY `idLH` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `loaisanpham`
--
ALTER TABLE `loaisanpham`
  MODIFY `idLSP` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `STT` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `idSP` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `idUser` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  ADD CONSTRAINT `chitietdonhang_ibfk_1` FOREIGN KEY (`idSP`) REFERENCES `sanpham` (`idSP`),
  ADD CONSTRAINT `chitietdonhang_ibfk_2` FOREIGN KEY (`idHD`) REFERENCES `donhang` (`idHD`);

--
-- Constraints for table `donhang`
--
ALTER TABLE `donhang`
  ADD CONSTRAINT `donhang_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`);

--
-- Constraints for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `sanpham_ibfk_1` FOREIGN KEY (`idLSP`) REFERENCES `loaisanpham` (`idLSP`) ON DELETE NO ACTION ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

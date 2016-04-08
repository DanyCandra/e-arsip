-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 27, 2016 at 07:07 AM
-- Server version: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `arsip_catur`
--

-- --------------------------------------------------------

--
-- Table structure for table `cis`
--

CREATE TABLE IF NOT EXISTS `cis` (
  `id_cis` varchar(20) NOT NULL,
  `cif` varchar(20) DEFAULT NULL,
  `cif_cis` varchar(20) DEFAULT NULL,
  `no_pinjaman` varchar(20) DEFAULT NULL,
  `tanggal_realisasi` date DEFAULT NULL,
  `tanggal_mulai` date DEFAULT NULL,
  `tanggal_selesai` date DEFAULT NULL,
  `jumlah_pertanggungan` double(15,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cis`
--

INSERT INTO `cis` (`id_cis`, `cif`, `cif_cis`, `no_pinjaman`, `tanggal_realisasi`, `tanggal_mulai`, `tanggal_selesai`, `jumlah_pertanggungan`) VALUES
('01', '00000001', '00000001PLO1', '30303030', '2016-03-23', '2016-03-23', '2020-03-23', 1000000.00),
('02', '00000001', '00000001KWU1', '30303031', '2016-03-24', '2016-03-24', '2020-03-24', 1000000.00);

-- --------------------------------------------------------

--
-- Table structure for table `debitur`
--

CREATE TABLE IF NOT EXISTS `debitur` (
  `cif` varchar(20) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `tempat_lahir` varchar(20) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `nik` varchar(30) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `rt_rw` varchar(20) NOT NULL,
  `kelurahan` varchar(30) NOT NULL,
  `kecamatan` varchar(30) NOT NULL,
  `telepon` varchar(12) NOT NULL,
  `sk_cpns` varchar(50) DEFAULT NULL,
  `sk_pengangkatan` varchar(50) DEFAULT NULL,
  `sk_terakhir` varchar(50) DEFAULT NULL,
  `taspen` int(50) DEFAULT NULL,
  `sk_pensiun` varchar(50) DEFAULT NULL,
  `karip` int(50) DEFAULT NULL,
  `shm` varchar(50) DEFAULT NULL,
  `sht` varchar(50) DEFAULT NULL,
  `ijazah` varchar(50) DEFAULT NULL,
  `lainnya` varchar(20) DEFAULT NULL,
  `id_instansi` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `debitur`
--

INSERT INTO `debitur` (`cif`, `nama`, `tempat_lahir`, `tanggal_lahir`, `nik`, `alamat`, `rt_rw`, `kelurahan`, `kecamatan`, `telepon`, `sk_cpns`, `sk_pengangkatan`, `sk_terakhir`, `taspen`, `sk_pensiun`, `karip`, `shm`, `sht`, `ijazah`, `lainnya`, `id_instansi`) VALUES
('00000001', 'Dany Candra', 'Banyumas', '1992-02-20', '3302242002920001', 'Jl Sarwodadi V No 6', 'RT 2 RW 8', 'Purwokerto Kidul', 'Purwokerto Selatan', '089667194026', '001 /821/ Tahun 2016', NULL, '001 /821/ Tahun 2016', NULL, NULL, NULL, NULL, NULL, NULL, '001/UMP/IV/2013', NULL),
('00000002', 'Catur Yandi', 'Banyumas', '1984-03-21', '3302242103840002', 'Jl Jatwin GG Pergiwa', 'RT 3 RW 8', 'Jatiwinangun', 'Purwokerto Timu', '081227452300', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `dus`
--

CREATE TABLE IF NOT EXISTS `dus` (
  `id_dus` varchar(20) NOT NULL,
  `nama_dus` varchar(20) DEFAULT NULL,
  `id_lantai` varchar(20) DEFAULT NULL,
  `id_rak` varchar(20) DEFAULT NULL,
  `quota` int(2) DEFAULT '10'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dus`
--

INSERT INTO `dus` (`id_dus`, `nama_dus`, `id_lantai`, `id_rak`, `quota`) VALUES
('1', '03.01.1', '3', '1', 10),
('2', '03.01.2', '3', '1', 10);

-- --------------------------------------------------------

--
-- Table structure for table `instansi`
--

CREATE TABLE IF NOT EXISTS `instansi` (
  `id_instansi` varchar(20) NOT NULL,
  `nama_instansi` varchar(20) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `telepon` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `instansi`
--

INSERT INTO `instansi` (`id_instansi`, `nama_instansi`, `alamat`, `telepon`) VALUES
('1', 'Bapeluh KP', 'Jl Gatot Subroto 111', '0281 631444');

-- --------------------------------------------------------

--
-- Table structure for table `lantai`
--

CREATE TABLE IF NOT EXISTS `lantai` (
  `id_lantai` varchar(20) NOT NULL,
  `nama_lantai` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lantai`
--

INSERT INTO `lantai` (`id_lantai`, `nama_lantai`) VALUES
('1', '1'),
('1459053664145', '3'),
('2', '2'),
('3', '3');

-- --------------------------------------------------------

--
-- Table structure for table `pejabat`
--

CREATE TABLE IF NOT EXISTS `pejabat` (
  `id_pejabat` varchar(20) NOT NULL,
  `nama_pejabat` varchar(20) DEFAULT NULL,
  `jabatan` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pengarsipan`
--

CREATE TABLE IF NOT EXISTS `pengarsipan` (
  `id_arsip` varchar(20) NOT NULL,
  `cif` varchar(20) DEFAULT NULL,
  `tanggal_terima` date DEFAULT NULL,
  `id_user_penerima` varchar(20) DEFAULT NULL,
  `id_dus` varchar(20) DEFAULT NULL,
  `tanggal_kembali` date DEFAULT NULL,
  `id_user_pengembali` varchar(20) DEFAULT NULL,
  `status_arsip` varchar(20) DEFAULT 'ADA' COMMENT 'ADA, TIDAK ADA',
  `status_kembali` varchar(20) DEFAULT NULL COMMENT 'PELUNASAN, PENGAMBILAN'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pengarsipan`
--

INSERT INTO `pengarsipan` (`id_arsip`, `cif`, `tanggal_terima`, `id_user_penerima`, `id_dus`, `tanggal_kembali`, `id_user_pengembali`, `status_arsip`, `status_kembali`) VALUES
('1', '00000001', '2016-03-20', '1', '1', NULL, NULL, 'ADA', NULL),
('2', '00000002', '2010-04-03', '1', '1', '2016-03-23', '1', 'TIDAK ADA', 'PELUNASAN'),
('3', '00000002', '2016-03-24', '1', '2', NULL, NULL, 'ADA', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `rak`
--

CREATE TABLE IF NOT EXISTS `rak` (
  `id_rak` varchar(20) NOT NULL,
  `nama_rak` varchar(2) DEFAULT NULL,
  `quota` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rak`
--

INSERT INTO `rak` (`id_rak`, `nama_rak`, `quota`) VALUES
('1', '1', NULL),
('1459053938451', '3', 20),
('2', '2', NULL);

-- --------------------------------------------------------

--
-- Stand-in structure for view `select arsip berdasarkan dus`
--
CREATE TABLE IF NOT EXISTS `select arsip berdasarkan dus` (
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `select arsip kembali`
--
CREATE TABLE IF NOT EXISTS `select arsip kembali` (
);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id_user` varchar(20) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `nama` varchar(20) DEFAULT NULL,
  `status` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`, `nama`, `status`) VALUES
('1', 'NK.0134', 'caca', 'Catur Yandi', NULL);

-- --------------------------------------------------------

--
-- Structure for view `select arsip berdasarkan dus`
--
DROP TABLE IF EXISTS `select arsip berdasarkan dus`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `select arsip berdasarkan dus` AS select `tt_pengarsipan`.`id_arsip` AS `id_arsip`,`tt_pengarsipan`.`cif` AS `cif`,`tt_pengarsipan`.`tanggal_terima` AS `tanggal_terima`,`tm_debitur`.`nama` AS `nama`,`tm_dus`.`nama_dus` AS `nama_dus`,`tm_user`.`username` AS `username`,`tt_pengarsipan`.`status_arsip` AS `status_arsip` from (((`tt_pengarsipan` join `tm_debitur` on((`tt_pengarsipan`.`cif` = `tm_debitur`.`cif`))) join `tm_dus` on((`tt_pengarsipan`.`id_dus` = `tm_dus`.`id_dus`))) join `tm_user` on((`tt_pengarsipan`.`id_user_penerima` = `tm_user`.`id_user`))) where ((`tm_dus`.`id_dus` = 2) and (`tt_pengarsipan`.`status_arsip` = 'ADA'));

-- --------------------------------------------------------

--
-- Structure for view `select arsip kembali`
--
DROP TABLE IF EXISTS `select arsip kembali`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `select arsip kembali` AS select `tt_pengarsipan`.`id_arsip` AS `id_arsip`,`tt_pengarsipan`.`cif` AS `cif`,`tt_pengarsipan`.`tanggal_terima` AS `tanggal_terima`,`tm_debitur`.`nama` AS `nama`,`tm_dus`.`nama_dus` AS `nama_dus`,`tm_user`.`username` AS `username`,`tt_pengarsipan`.`status_arsip` AS `status_arsip`,`tt_pengarsipan`.`tanggal_kembali` AS `tanggal_kembali`,`tt_pengarsipan`.`status_kembali` AS `status_kembali` from (((`tt_pengarsipan` join `tm_debitur` on((`tt_pengarsipan`.`cif` = `tm_debitur`.`cif`))) join `tm_dus` on((`tt_pengarsipan`.`id_dus` = `tm_dus`.`id_dus`))) join `tm_user` on((`tt_pengarsipan`.`id_user_penerima` = `tm_user`.`id_user`))) where (`tt_pengarsipan`.`status_arsip` = 'TIDAK ADA');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cis`
--
ALTER TABLE `cis`
  ADD PRIMARY KEY (`id_cis`), ADD KEY `cif` (`cif`);

--
-- Indexes for table `debitur`
--
ALTER TABLE `debitur`
  ADD PRIMARY KEY (`cif`), ADD KEY `id_instansi` (`id_instansi`);

--
-- Indexes for table `dus`
--
ALTER TABLE `dus`
  ADD PRIMARY KEY (`id_dus`), ADD KEY `id_lantai` (`id_lantai`), ADD KEY `id_rak` (`id_rak`);

--
-- Indexes for table `instansi`
--
ALTER TABLE `instansi`
  ADD PRIMARY KEY (`id_instansi`);

--
-- Indexes for table `lantai`
--
ALTER TABLE `lantai`
  ADD PRIMARY KEY (`id_lantai`);

--
-- Indexes for table `pejabat`
--
ALTER TABLE `pejabat`
  ADD PRIMARY KEY (`id_pejabat`);

--
-- Indexes for table `pengarsipan`
--
ALTER TABLE `pengarsipan`
  ADD PRIMARY KEY (`id_arsip`), ADD KEY `cif` (`cif`), ADD KEY `id_user_penerima` (`id_user_penerima`), ADD KEY `id_user_pengembali` (`id_user_pengembali`), ADD KEY `id_dus` (`id_dus`);

--
-- Indexes for table `rak`
--
ALTER TABLE `rak`
  ADD PRIMARY KEY (`id_rak`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cis`
--
ALTER TABLE `cis`
ADD CONSTRAINT `cis_fk` FOREIGN KEY (`cif`) REFERENCES `debitur` (`cif`);

--
-- Constraints for table `debitur`
--
ALTER TABLE `debitur`
ADD CONSTRAINT `tm_debitur_fk` FOREIGN KEY (`id_instansi`) REFERENCES `instansi` (`id_instansi`);

--
-- Constraints for table `dus`
--
ALTER TABLE `dus`
ADD CONSTRAINT `tm_lokasi_fk` FOREIGN KEY (`id_lantai`) REFERENCES `lantai` (`id_lantai`),
ADD CONSTRAINT `tm_lokasi_fk1` FOREIGN KEY (`id_rak`) REFERENCES `rak` (`id_rak`);

--
-- Constraints for table `pengarsipan`
--
ALTER TABLE `pengarsipan`
ADD CONSTRAINT `pengarsipan_fk` FOREIGN KEY (`cif`) REFERENCES `debitur` (`cif`),
ADD CONSTRAINT `pengarsipan_fk1` FOREIGN KEY (`id_user_penerima`) REFERENCES `user` (`id_user`),
ADD CONSTRAINT `pengarsipan_fk2` FOREIGN KEY (`id_user_pengembali`) REFERENCES `user` (`id_user`),
ADD CONSTRAINT `tt_pengarsipan_fk` FOREIGN KEY (`id_dus`) REFERENCES `dus` (`id_dus`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

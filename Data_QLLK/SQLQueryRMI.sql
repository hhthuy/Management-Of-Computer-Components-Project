/*Tạo Mã Sản Phẩm Tự Động*/
create database QLLK_RMI
use QLLK_RMI
CREATE FUNCTION AUTO_IDLK()
RETURNS VARCHAR(5)
AS
BEGIN
	DECLARE @ID VARCHAR(5)
	IF (SELECT COUNT([MaLK]) FROM [dbo].[LinhKien]) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT([MaLK], 3)) FROM [dbo].[LinhKien]
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'LK00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'LK0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
--DROP FUNCTION SanPham.AUTO_IDSP
--DROP FUNCTION IF EXISTS AUTO_IDSP;

ALTER TABLE  [dbo].[LinhKien]
add CONSTRAINT IDLK DEFAULT DBO.AUTO_IDLK() for [MaLK]


/*Tạo Mã Khách Hàng Tự Động*/
CREATE FUNCTION AUTO_IDKH()
RETURNS VARCHAR(5)
AS
BEGIN
	DECLARE @ID VARCHAR(5)
	IF (SELECT COUNT([MaKH]) FROM [dbo].[KhachHang]) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT([MaKH], 3)) FROM [dbo].[KhachHang]
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'KH00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'KH0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
--DROP FUNCTION IF EXISTS AUTO_IDKH;
/*Khách hàng*/
ALTER TABLE [dbo].[KhachHang]
add CONSTRAINT IDKH DEFAULT DBO.AUTO_IDKH() for [MaKH] 

/*Tạo Mã Nhân Viên Tự Động*/
CREATE FUNCTION AUTO_IDNV()
RETURNS VARCHAR(5)
AS
BEGIN
	DECLARE @ID VARCHAR(5)
	IF (SELECT COUNT([MaNV]) FROM [dbo].[NhanVien]) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT([MaNV], 3)) FROM [dbo].[NhanVien]
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'NV00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'NV0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
--DROP FUNCTION IF EXISTS AUTO_IDNV;
/*Nhân Viên*/
ALTER TABLE [dbo].[NhanVien]
add CONSTRAINT IDNV DEFAULT DBO.AUTO_IDNV() for [MaNV] 

/*Tạo Mã Hóa Đơn Bán Hàng Tự Động*/
CREATE FUNCTION AUTO_IDHDBH()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID VARCHAR(7)
	IF (SELECT COUNT([maHD]) FROM [dbo].[HoaDon]) = 0
		SET @ID = '0'
	ELSE
		SELECT @ID = MAX(RIGHT([maHD], 3)) FROM [dbo].[HoaDon]
		SELECT @ID = CASE
			WHEN @ID >= 0 and @ID < 9 THEN 'HDBH00' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
			WHEN @ID >= 9 THEN 'HDBH0' + CONVERT(CHAR, CONVERT(INT, @ID) + 1)
		END
	RETURN @ID
END
---DROP FUNCTION IF EXISTS AUTO_IDHDBH;
/*Hóa Đơn Bán Hàng*/
ALTER TABLE [dbo].[HoaDon]
add CONSTRAINT IDHDBH DEFAULT DBO.AUTO_IDHDBH() for [maHD]


--data loai linh kien
INSERT [dbo].[LoaiLinhKien] ([MaLoaiLK], [TenLoaiLK]) VALUES (N'LLK01', N'CPU')
INSERT [dbo].[LoaiLinhKien] ([MaLoaiLK], [TenLoaiLK]) VALUES (N'LLK02', N'MAIN')
INSERT [dbo].[LoaiLinhKien] ([MaLoaiLK], [TenLoaiLK]) VALUES (N'LLK03', N'RAM')
INSERT [dbo].[LoaiLinhKien] ([MaLoaiLK], [TenLoaiLK]) VALUES (N'LLK04', N'VGA')
INSERT [dbo].[LoaiLinhKien] ([MaLoaiLK], [TenLoaiLK]) VALUES (N'LLK05', N'SSD')
INSERT [dbo].[LoaiLinhKien] ([MaLoaiLK], [TenLoaiLK]) VALUES (N'LLK06', N'CASE')
select * from LoaiLinhKien where TenLoaiLK ='CPU'

--data linh kien
INSERT [dbo].[LinhKien] ([MaLK], [MaLoaiLK], [TenLK], [SoLuongTon], [GiaLK], [NhaSX], [TinhTrang], [BaoHanh]) VALUES (N'LK001', N'LLK01', N'Intel Core i3 10105F', 99, 3190000.0000, N'Intel', N'New', N'24 Thang')
INSERT [dbo].[LinhKien] ([MaLK], [MaLoaiLK], [TenLK], [SoLuongTon], [GiaLK], [NhaSX], [TinhTrang], [BaoHanh]) VALUES (N'LK002', N'LLK01', N'Intel Core i3 10100 ', 89, 3990000.0000, N'Intel', N'New', N'12 Thang')
INSERT [dbo].[LinhKien] ([MaLK], [MaLoaiLK], [TenLK], [SoLuongTon], [GiaLK], [NhaSX], [TinhTrang], [BaoHanh]) VALUES (N'LK003', N'LLK01', N'Intel Core i5 10400', 99, 5390000.0000, N'Intel', N'New', N'24 Thang')
INSERT [dbo].[LinhKien] ([MaLK], [MaLoaiLK], [TenLK], [SoLuongTon], [GiaLK], [NhaSX], [TinhTrang], [BaoHanh]) VALUES (N'LK004', N'LLK01', N'Intel Core i5 11400', 77, 5890000.0000, N'Intel', N'New', N'24 Thang')
INSERT [dbo].[LinhKien] ([MaLK], [MaLoaiLK], [TenLK], [SoLuongTon], [GiaLK], [NhaSX], [TinhTrang], [BaoHanh]) VALUES (N'LK005', N'LLK01', N'Intel Core i5 11500', 99, 6190000.0000, N'Intel', N'New', N'24 Thang')
INSERT [dbo].[LinhKien] ([MaLK], [MaLoaiLK], [TenLK], [SoLuongTon], [GiaLK], [NhaSX], [TinhTrang], [BaoHanh]) VALUES (N'LK006', N'LLK01', N'Intel Core i5 11600K', 89, 7490000.0000, N'Intel', N'New', N'24 Thang')
INSERT [dbo].[LinhKien] ([MaLK], [MaLoaiLK], [TenLK], [SoLuongTon], [GiaLK], [NhaSX], [TinhTrang], [BaoHanh]) VALUES (N'LK007', N'LLK01', N'Intel Core i7 10700', 99, 8790000.0000, N'Intel', N'New', N'36 Thang')
INSERT [dbo].[LinhKien] ( [MaLoaiLK], [TenLK], [SoLuongTon], [GiaLK], [NhaSX], [TinhTrang], [BaoHanh]) VALUES ( N'LLK01', N'Intel Core i7 10700K', 0, 9690000.0000, N'Intel', N'New', N'36 Thang')
select * from [dbo].[LinhKien]  
delete LinhKien where MaLK ='02'
select * from LinhKien where TenLK = 'Intel Core i7 10700K' or MaLK='Intel Core i7 10700K' and  SoLuongTon >1  
update LinhKien set soLuongTon = 50  where [MaLK] ='LK001'
select * from LinhKien where SoLuongTon =0


--so san pham het hang
select COUNT(MaLK) from LinhKien where SoLuongTon =0
--so khach hang mua
SELECT count (sokh.kh) from
				(SELECT hdb.MaKH kh , COUNT(hdb.MaHD) sc, kh.TenKH ten 
                					FROM [dbo].[HoaDon] hdb, [dbo].[KhachHang] kh
                					WHERE hdb.MaKH = kh.MaKH and hdb.NgayLapHD = '2021-11-23'
               					 GROUP BY hdb.MaKH , kh.TenKH ) sokh
--so hoa don 
select COUNT(hd.maHD) as'so hd' from [dbo].[HoaDon] hd where ngaylapHD ='2021-11-23'
--so san pham ban trong ngay
SELECT COUNT (sosp.sp) AS 'Masp' from
				(SELECT cthd.MaLk sp ,SUM (cthd.SoLuong)  sl, sp.TenLK ten ,sp.GiaLK dongia 
                					FROM [dbo].[CTHoaDon] cthd, [dbo].[LinhKien] sp , [dbo].[HoaDon] hdb
                					WHERE  cthd.MaLk = sp.MaLK and cthd.MaHD =hdb.MaHD  and hdb.ngaylapHD ='2021-11-23'---and day( hdb.NgayLapHD) ='2021'
          					 GROUP BY cthd.MaLk , sp.TenLK,sp.GiaLK ) sosp
								
SELECT DATEPART(WEEK, '2021-11-23');


SELECT sosp.sp AS 'Masp', sosp.ten AS 'Tensp',sosp.sl as'SoLuongBang' , sosp.dongia as'Gia Ban' , GETDATE() as'ngaytao' from
				(SELECT cthd.MaLk sp ,SUM (cthd.SoLuong)  sl, sp.TenLK ten ,sp.GiaLK dongia 
                					FROM [dbo].[CTHoaDon] cthd, [dbo].[LinhKien] sp , [dbo].[HoaDon] hdb
                					WHERE  cthd.MaLk = sp.MaLK and cthd.MaHD =hdb.MaHD  ---and year( hdb.NgayLapHD) ='2021'
               					 GROUP BY cthd.MaLk , sp.TenLK,sp.GiaLK ) sosp
								 order by sosp.sl desc

--data nhan vien
INSERT INTO NhanVien([TenNV],[ChucVu],[GioiTinh],[Luong],[NgaySinh])
VALUES (N'Trung Tin', N'Nhan Vien', 'Nam', '100000', '2021-10-01' );
select * from NhanVien

--data khach hang
INSERT [dbo].[KhachHang] ( [TenKH], [SDT], [DiaChi]) VALUES ( N'Nguyễn Tiến Đạt', N'0998765456', N'127 Man Thiện Thủ Đức')
INSERT [dbo].[KhachHang] ( [TenKH], [SDT], [DiaChi]) VALUES ( N'Tấn Đăng', N'0397578976', N'127 Man Thiện Thủ Đức')
INSERT [dbo].[KhachHang] ( [TenKH], [SDT], [DiaChi]) VALUES ( N'Hoàng Anh', N'012454515', N'Phường An Phú Đông, Quận 12, TP Hồ Chí Minh')
INSERT [dbo].[KhachHang] ( [TenKH], [SDT], [DiaChi]) VALUES ( N'Tèo', N'0125485657', N'813 Cách Mạng Tháng Tám')
INSERT [dbo].[KhachHang] ( [TenKH], [SDT], [DiaChi]) VALUES ( N'Vân Ly', N'0124545145', N'813 Cách Mạng Tháng Tám')
INSERT [dbo].[KhachHang] ( [TenKH], [SDT], [DiaChi]) VALUES ( N'Trần Tấn Phát', N'012454785', N'813 Cách Mạng Tháng Tám')
INSERT [dbo].[KhachHang] ( [TenKH], [SDT], [DiaChi]) VALUES ( N'Bùi Văn Vui', N'0312454547', N'Phường An Phú Đông, Quận 12, TP Hồ Chí Minh')
select * from KhachHang
select top 1 * from KhachHang order by MaKH DESC


--data tai khoan
INSERT [dbo].[TaiKhoan] ([TenDN], [MatKhau],[TenQuyen], [MaNV]) VALUES (N'dang', N'12345678', N'QuanLy', N'NV004')
select * from TaiKhoan where [MaNV]='NV002'
select * from TaiKhoan where [TenDN]='19526881' and [MatKhau] ='12345678'
delete TaiKhoan

--data hoa don
INSERT [dbo].[HoaDon]([ngaylapHD] , [MaNV], [MaKH]) VALUES ( '2021-10-05', N'NV001', N'KH006')
select * from HoaDon
select top 1 * from HoaDon order by MaHD DESC
select * from HoaDon where ngaylapHD ='2021-11-23'

SELECT CTHoaDon.maHD, HoaDon.ngaylapHD, (CTHoaDon.giaban* CTHoaDon.soluong)
FROM     CTHoaDon INNER JOIN
                  HoaDon ON CTHoaDon.MaHD = HoaDon.maHD
				  where ngaylapHD ='2021-11-24'

SELECT CTHoaDon.maHD m, sum(CTHoaDon.giaban* CTHoaDon.soluong) a
FROM     CTHoaDon INNER JOIN
                  HoaDon ON CTHoaDon.MaHD = HoaDon.maHD
				  where ngaylapHD ='2021-11-24'
group by CTHoaDon.maHD 
---tong so tien hd ban dc trong ngay
select sum(a.a)as tong from 
(SELECT CTHoaDon.maHD m, sum(CTHoaDon.giaban* CTHoaDon.soluong) a
FROM     CTHoaDon INNER JOIN 
                  HoaDon ON CTHoaDon.MaHD = HoaDon.maHD
				  where ngaylapHD ='2021-11-24'
				  group by CTHoaDon.maHD
				  )a

select sum(tong.tongTien), tong.ngaylap tongDoanhThu from 
(SELECT HoaDon.ngaylapHD ngaylap, sum(CTHoaDon.giaban* CTHoaDon.soluong) tongTien
FROM     CTHoaDon INNER JOIN
                  HoaDon ON CTHoaDon.MaHD = HoaDon.maHD
				  where   day(ngaylapHD) <=25 and day(ngaylapHD) >=25-7 and YEAR(ngaylapHD)='2021'
				  group by  HoaDon.ngaylapHD
				  )tong
				  group by ngaylap order by tong.ngaylap DESC
 
				  select sum(tong.tongTien), tong.ngaylap tongDoanhThu from 
(SELECT HoaDon.ngaylapHD ngaylap, sum(CTHoaDon.giaban* CTHoaDon.soluong) tongTien
FROM     CTHoaDon INNER JOIN
                  HoaDon ON CTHoaDon.MaHD = HoaDon.maHD
				  --where   day(ngaylapHD) <=24 and day(ngaylapHD) >=24-7 and YEAR(ngaylapHD)='2021'
				  group by  HoaDon.ngaylapHD
				  )tong
				  group by ngaylap


SELECT CTHoaDon.maHD, HoaDon.ngaylapHD, CTHoaDon.giaban, CTHoaDon.soluong
FROM     CTHoaDon INNER JOIN
                  HoaDon ON CTHoaDon.MaHD = HoaDon.maHD
				  where ngaylapHD ='2021-11-24'
--date ct hdon
INSERT [dbo].[CTHoaDon] ([MaHD],[MaLk], [giaban],[soluong]) VALUES ( 'HDBH004', N'LK001',300000.0,10)
select * from [dbo].[CTHoaDon]
select * from CTHoaDon where MaHD = 'HDBH022'


select a.MaHD, a.NgayLapHD,b.SoLuong, b.MaLk, c.TenLK, d.TenKH, e.TenNV, c.GiaLK from HoaDon a

inner join CTHoaDon b on a.MaHD = b.MaHD
inner join [dbo].[LinhKien] c on b.MaLK = c.MaLK
inner join KhachHang d on a.MaKH = d.MaKH
inner join NhanVien e on a.MaNV = e.MaNV
where a.MaHD = 'HDBH022'



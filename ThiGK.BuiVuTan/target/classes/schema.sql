-- Tao database
CREATE DATABASE ThiGK2DB;
GO

USE ThiGK2DB;
GO

-- Bang THE_LOAI_TIN
CREATE TABLE the_loai_tin (
    ma_the_loai INT PRIMARY KEY IDENTITY(1,1),
    ten_the_loai NVARCHAR(100) NOT NULL
);

-- Bang TIN
CREATE TABLE tin (
    ma_tin      INT PRIMARY KEY IDENTITY(1,1),
    tieu_de     NVARCHAR(255) NOT NULL,
    noi_dung    NVARCHAR(MAX),
    hinh_anh    NVARCHAR(255),
    ngay_dang   DATETIME,
    ma_the_loai INT,
    FOREIGN KEY (ma_the_loai) REFERENCES the_loai_tin(ma_the_loai)
);

-- Bang NGUOI_DUNG
CREATE TABLE nguoi_dung (
    ma_nguoi_dung INT PRIMARY KEY IDENTITY(1,1),
    ten_dang_nhap NVARCHAR(50)  NOT NULL UNIQUE,
    mat_khau      NVARCHAR(255) NOT NULL,
    ho_ten        NVARCHAR(100),
    email         NVARCHAR(100),
    vai_tro       NVARCHAR(20) DEFAULT 'USER'
);

-- Du lieu mau: The loai
INSERT INTO the_loai_tin (ten_the_loai) VALUES
    (N'Thể thao'),
    (N'Công nghệ'),
    (N'Giải trí'),
    (N'Kinh tế');

-- Du lieu mau: Tin tuc
INSERT INTO tin (tieu_de, noi_dung, hinh_anh, ngay_dang, ma_the_loai) VALUES
    (N'Tin thể thao 1', N'Nội dung tin thể thao 1', NULL, GETDATE(), 1),
    (N'Tin thể thao 2', N'Nội dung tin thể thao 2', NULL, GETDATE(), 1),
    (N'Tin công nghệ 1', N'Nội dung tin công nghệ 1', NULL, GETDATE(), 2),
    (N'Tin giải trí 1', N'Nội dung tin giải trí 1', NULL, GETDATE(), 3);

-- Du lieu mau: Nguoi dung (mat khau: 123456)
INSERT INTO nguoi_dung (ten_dang_nhap, mat_khau, ho_ten, email, vai_tro) VALUES
    ('admin', '123456', N'Quản trị viên', 'admin@example.com', 'ADMIN'),
    ('buivutan', '123456', N'Bùi Vũ Tân', 'buivutan@example.com', 'USER');

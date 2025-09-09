create database thi_modeule3;
use thi_modeule3;
create table mat_bang(
	ma_mat_bang varchar(50) primary key,
    dien_tich int,
    trang_thai int,
    loai int,
    so_tang int,
    gia decimal(10,0),
    ngay_bat_dau varchar(50),
    ngay_ket_thuc varchar(50),
    mo_ta VARCHAR(255)
);

INSERT INTO mat_bang (ma_mat_bang, dien_tich, trang_thai, loai, gia, ngay_bat_dau, ngay_ket_thuc, so_tang) VALUES
('MB001', 50, 1, 1, 8000000, '2025-01-01', '2025-06-30', 3),
('MB002', 70, 0, 2, 12000000, '2025-02-15', '2025-08-15', 5),
('MB003', 100, 1, 1, 15000000, '2025-03-01', '2025-09-01', 7),
('MB004', 40, 1, 2, 6000000, '2025-04-10', '2025-10-10', 2),
('MB005', 85, 0, 1, 11000000, '2025-05-20', '2025-11-20', 4);

select * from mat_bang order by dien_tich asc;
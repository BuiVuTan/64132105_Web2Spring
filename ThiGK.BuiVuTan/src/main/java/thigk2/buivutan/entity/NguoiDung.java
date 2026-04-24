package thigk2.buivutan.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "nguoi_dung")
public class NguoiDung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_nguoi_dung")
    private Integer maNguoiDung;

    @Column(name = "ten_dang_nhap", nullable = false, unique = true, length = 50)
    private String tenDangNhap;

    @Column(name = "mat_khau", nullable = false, length = 255)
    private String matKhau;

    @Column(name = "ho_ten", length = 100)
    private String hoTen;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "vai_tro", length = 20)
    private String vaiTro; // ADMIN, USER
}

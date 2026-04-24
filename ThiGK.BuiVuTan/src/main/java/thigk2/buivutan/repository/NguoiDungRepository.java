package thigk2.buivutan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thigk2.buivutan.entity.NguoiDung;
import java.util.Optional;

@Repository
public interface NguoiDungRepository extends JpaRepository<NguoiDung, Integer> {

    // Tìm người dùng theo tên đăng nhập (dùng cho đăng nhập)
    Optional<NguoiDung> findByTenDangNhap(String tenDangNhap);

    // Kiểm tra đăng nhập với cả username và password
    Optional<NguoiDung> findByTenDangNhapAndMatKhau(String tenDangNhap, String matKhau);
}

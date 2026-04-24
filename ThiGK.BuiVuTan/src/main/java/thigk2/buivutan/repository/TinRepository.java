package thigk2.buivutan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thigk2.buivutan.entity.Tin;
import thigk2.buivutan.entity.TheLoaiTin;
import java.util.List;

@Repository
public interface TinRepository extends JpaRepository<Tin, Integer> {

    // Tìm danh sách tin theo thể loại
    List<Tin> findByTheLoaiTin(TheLoaiTin theLoaiTin);

    // Tìm danh sách tin theo mã thể loại
    List<Tin> findByTheLoaiTin_MaTheLoai(Integer maTheLoai);
}

package thigk2.buivutan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import thigk2.buivutan.entity.TheLoaiTin;

@Repository
public interface TheLoaiTinRepository extends JpaRepository<TheLoaiTin, Integer> {
}

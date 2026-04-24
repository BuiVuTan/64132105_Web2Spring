package thigk2.buivutan.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "the_loai_tin")
public class TheLoaiTin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_the_loai")
    private Integer maTheLoai;

    @Column(name = "ten_the_loai", nullable = false, length = 100)
    private String tenTheLoai;

    // Một thể loại có nhiều tin
    @JsonIgnore
    @OneToMany(mappedBy = "theLoaiTin", fetch = FetchType.LAZY)
    private List<Tin> danhSachTin;
}

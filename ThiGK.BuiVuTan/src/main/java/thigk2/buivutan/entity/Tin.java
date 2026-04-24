package thigk2.buivutan.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tin")
public class Tin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_tin")
    private Integer maTin;

    @Column(name = "tieu_de", nullable = false, length = 255)
    private String tieuDe;

    @Column(name = "noi_dung", columnDefinition = "NVARCHAR(MAX)")
    private String noiDung;

    @Column(name = "hinh_anh", length = 255)
    private String hinhAnh;

    @Column(name = "ngay_dang")
    private LocalDateTime ngayDang;

    // Nhiều tin thuộc một thể loại
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ma_the_loai")
    private TheLoaiTin theLoaiTin;
}

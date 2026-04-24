package thigk2.buivutan.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thigk2.buivutan.entity.TheLoaiTin;
import thigk2.buivutan.entity.Tin;
import thigk2.buivutan.service.TheLoaiTinService;
import thigk2.buivutan.service.TinService;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TinApiController {

    private final TheLoaiTinService theLoaiTinService;
    private final TinService tinService;

    public TinApiController(TheLoaiTinService theLoaiTinService, TinService tinService) {
        this.theLoaiTinService = theLoaiTinService;
        this.tinService = tinService;
    }

    // API 1: Lấy danh sách tất cả thể loại tin
    // GET http://localhost:8080/api/the-loai
    @GetMapping("/the-loai")
    public ResponseEntity<List<TheLoaiTin>> getDanhSachTheLoai() {
        List<TheLoaiTin> danhSach = theLoaiTinService.layTatCa();
        return ResponseEntity.ok(danhSach);
    }

    // API 2: Lấy danh sách tin theo thể loại
    // GET http://localhost:8080/api/tin/the-loai/1
    @GetMapping("/tin/the-loai/{maTheLoai}")
    public ResponseEntity<List<Tin>> getTinTheoTheLoai(@PathVariable Integer maTheLoai) {
        List<Tin> danhSach = tinService.layTheoTheLoai(maTheLoai);
        return ResponseEntity.ok(danhSach);
    }
}

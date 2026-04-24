package thigk2.buivutan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import thigk2.buivutan.service.TheLoaiTinService;
import thigk2.buivutan.service.TinService;

@Controller
public class TinController {

    private final TinService tinService;
    private final TheLoaiTinService theLoaiTinService;

    public TinController(TinService tinService, TheLoaiTinService theLoaiTinService) {
        this.tinService = tinService;
        this.theLoaiTinService = theLoaiTinService;
    }

    // 1. Danh sách tất cả tin
    @GetMapping("/tin")
    public String danhSachTatCaTin(Model model) {
        model.addAttribute("danhSachTin", tinService.layTatCa());
        model.addAttribute("danhSachTheLoai", theLoaiTinService.layTatCa());
        model.addAttribute("tieuDeTrang", "Tất cả tin tức");
        return "tin/danh-sach";
    }

    // 2. Danh sách tin theo thể loại
    @GetMapping("/tin/the-loai/{maTheLoai}")
    public String tinTheoTheLoai(@PathVariable Integer maTheLoai, Model model) {
        model.addAttribute("danhSachTin", tinService.layTheoTheLoai(maTheLoai));
        model.addAttribute("danhSachTheLoai", theLoaiTinService.layTatCa());
        model.addAttribute("maTheLoaiHienTai", maTheLoai);
        model.addAttribute("tieuDeTrang", "Tin theo thể loại");
        return "tin/danh-sach";
    }

    // 3. Chi tiết tin theo mã
    @GetMapping("/tin/{maTin}")
    public String chiTietTin(@PathVariable int maTin, Model model) {
        return tinService.layTheoMa(maTin)
            .map(tin -> {
                model.addAttribute("tin", tin);
                model.addAttribute("danhSachTheLoai", theLoaiTinService.layTatCa());
                return "tin/chi-tiet";
            })
            .orElse("redirect:/tin");
    }
}

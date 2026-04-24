package thigk2.buivutan.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import thigk2.buivutan.entity.NguoiDung;
import thigk2.buivutan.service.NguoiDungService;
import java.util.Optional;

@Controller
public class AuthController {

    private final NguoiDungService nguoiDungService;

    public AuthController(NguoiDungService nguoiDungService) {
        this.nguoiDungService = nguoiDungService;
    }

    // Hiển thị form đăng nhập
    @GetMapping("/dang-nhap")
    public String showDangNhap(HttpSession session) {
        // Nếu đã đăng nhập rồi thì chuyển về trang chủ
        if (session.getAttribute("nguoiDungDangNhap") != null) {
            return "redirect:/";
        }
        return "auth/dang-nhap";
    }

    // Xử lý đăng nhập
    @PostMapping("/dang-nhap")
    public String xuLyDangNhap(@RequestParam String tenDangNhap,
                                @RequestParam String matKhau,
                                HttpSession session,
                                Model model) {
        Optional<NguoiDung> nguoiDung = nguoiDungService.dangNhap(tenDangNhap, matKhau);

        if (nguoiDung.isPresent()) {
            session.setAttribute("nguoiDungDangNhap", nguoiDung.get());
            return "redirect:/";
        } else {
            model.addAttribute("loi", "Tên đăng nhập hoặc mật khẩu không đúng!");
            return "auth/dang-nhap";
        }
    }

    // Đăng xuất
    @GetMapping("/dang-xuat")
    public String dangXuat(HttpSession session) {
        session.invalidate();
        return "redirect:/dang-nhap";
    }
}

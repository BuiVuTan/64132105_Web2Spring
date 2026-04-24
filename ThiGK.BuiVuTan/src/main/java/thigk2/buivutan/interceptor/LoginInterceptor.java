package thigk2.buivutan.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request,
                             @NonNull HttpServletResponse response,
                             @NonNull Object handler) throws Exception {

        Object nguoiDung = request.getSession().getAttribute("nguoiDungDangNhap");

        if (nguoiDung == null) {
            // Chưa đăng nhập → chuyển sang trang đăng nhập
            response.sendRedirect(request.getContextPath() + "/dang-nhap");
            return false; // Dừng, không cho vào controller
        }

        return true; // Đã đăng nhập → cho đi tiếp
    }
}

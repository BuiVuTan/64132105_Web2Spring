package thigk2.buivutan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import thigk2.buivutan.interceptor.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @NonNull
    private final LoginInterceptor loginInterceptor;

    public WebConfig(LoginInterceptor loginInterceptor) {
        this.loginInterceptor = loginInterceptor;
    }

    @Override
    public void addInterceptors(@NonNull InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")          // Chặn tất cả URL
                .excludePathPatterns(
                    "/dang-nhap",                // Cho phép truy cập trang đăng nhập
                    "/dang-xuat",                // Cho phép đăng xuất
                    "/css/**",                   // Tài nguyên tĩnh
                    "/js/**",
                    "/images/**"
                );
    }
}

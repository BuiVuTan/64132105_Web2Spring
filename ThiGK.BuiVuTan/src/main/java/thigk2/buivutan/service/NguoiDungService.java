package thigk2.buivutan.service;

import org.springframework.stereotype.Service;
import thigk2.buivutan.entity.NguoiDung;
import thigk2.buivutan.repository.NguoiDungRepository;
import java.util.Optional;

@Service
public class NguoiDungService {

    private final NguoiDungRepository nguoiDungRepository;

    public NguoiDungService(NguoiDungRepository nguoiDungRepository) {
        this.nguoiDungRepository = nguoiDungRepository;
    }

    public Optional<NguoiDung> dangNhap(String tenDangNhap, String matKhau) {
        return nguoiDungRepository.findByTenDangNhapAndMatKhau(tenDangNhap, matKhau);
    }
}

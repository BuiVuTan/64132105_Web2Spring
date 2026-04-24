package thigk2.buivutan.service;

import org.springframework.stereotype.Service;
import thigk2.buivutan.entity.TheLoaiTin;
import thigk2.buivutan.repository.TheLoaiTinRepository;
import java.util.List;

@Service
public class TheLoaiTinService {

    private final TheLoaiTinRepository theLoaiTinRepository;

    public TheLoaiTinService(TheLoaiTinRepository theLoaiTinRepository) {
        this.theLoaiTinRepository = theLoaiTinRepository;
    }

    public List<TheLoaiTin> layTatCa() {
        return theLoaiTinRepository.findAll();
    }
}

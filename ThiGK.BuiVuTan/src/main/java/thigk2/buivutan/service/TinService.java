package thigk2.buivutan.service;

import org.springframework.stereotype.Service;
import thigk2.buivutan.entity.Tin;
import thigk2.buivutan.repository.TinRepository;
import java.util.List;
import java.util.Optional;

@Service
public class TinService {

    private final TinRepository tinRepository;

    public TinService(TinRepository tinRepository) {
        this.tinRepository = tinRepository;
    }

    public List<Tin> layTatCa() {
        return tinRepository.findAll();
    }

    public List<Tin> layTheoTheLoai(Integer maTheLoai) {
        return tinRepository.findByTheLoaiTin_MaTheLoai(maTheLoai);
    }

    public Optional<Tin> layTheoMa(int maTin) {
        return tinRepository.findById(maTin);
    }
}

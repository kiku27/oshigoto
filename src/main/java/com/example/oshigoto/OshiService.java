package com.example.oshigoto;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OshiService {

    private final OshiRepository oshiRepository;

    public OshiService(OshiRepository oshiRepository) {
        this.oshiRepository = oshiRepository;
    }

    public List<Oshi> getAllOshis() {
        return oshiRepository.findAll();
    }

    public Oshi createOshi(Oshi oshi) {
        return oshiRepository.save(oshi);
    }

    public void deleteOshi(Long id) {
        oshiRepository.deleteById(id);
    }
}
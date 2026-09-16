package com.example.oshigoto;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/oshis")
@CrossOrigin(origins = "http://localhost:5173") // Reactからの接続を許可
public class OshiController {

    private final OshiRepository oshiRepository;

    public OshiController(OshiRepository oshiRepository) {
        this.oshiRepository = oshiRepository;
    }

    // 推し一覧を取得するAPI
    @GetMapping
    public List<Oshi> getAllOshis() {
        return oshiRepository.findAll();
    }

    // 新しい推しを登録するAPI
    @PostMapping
    public Oshi createOshi(@RequestBody Oshi oshi) {
        return oshiRepository.save(oshi);
    }
}
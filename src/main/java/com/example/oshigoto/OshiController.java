package com.example.oshigoto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/oshis")
@CrossOrigin(origins = "http://localhost:5173")
public class OshiController {

    private final OshiService oshiService;

    // Serviceを注入する
    public OshiController(OshiService oshiService) {
        this.oshiService = oshiService;
    }

    // 全件取得API
    @GetMapping
    public List<Oshi> getAllOshis() {
        return oshiService.getAllOshis();
    }

    // 新規登録API
    @PostMapping
    public Oshi createOshi(@RequestBody Oshi oshi) {
        return oshiService.createOshi(oshi);
    }

    // 削除API
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOshi(@PathVariable Long id) {
        oshiService.deleteOshi(id);
        return ResponseEntity.ok().build();
    }
}
package com.example.oshigoto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class LoginController {

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> request) {
        String loginId = request.get("login_id");
        String password = request.get("password");

        Map<String, String> response = new HashMap<>();

        // 動作確認用の固定IDとパスワード
        String validLoginId = "admin";
        String validPassword = "password123";

        // IDとパスワードの照合チェック
        if (validLoginId.equals(loginId) && validPassword.equals(password)) {
            response.put("message", "ログイン成功");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "ログインIDまたはパスワードが正しくありません。");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}

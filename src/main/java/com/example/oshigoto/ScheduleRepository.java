package com.example.oshigoto;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    // 推しIDとカテゴリでスケジュールを絞り込むメソッド
    List<Schedule> findByOshiIdAndCategory(Long oshiId, String category);
}

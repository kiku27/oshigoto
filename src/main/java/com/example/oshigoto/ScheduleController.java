package com.example.oshigoto;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/schedules")
@CrossOrigin(origins = "http://localhost:5173")
public class ScheduleController {

    private final ScheduleRepository scheduleRepository;

    public ScheduleController(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    // スケジュール一覧取得 API
    @GetMapping
    public List<Schedule> getSchedules(@RequestParam(required = false) Long oshiId,
                                       @RequestParam(required = false) String category) {
        if (oshiId != null && category != null) {
            return scheduleRepository.findByOshiIdAndCategory(oshiId, category);
        }
        return scheduleRepository.findAll();
    }

    // 新規スケジュール登録 API
    @PostMapping
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    // スケジュール削除 API
    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Long id) {
        scheduleRepository.deleteById(id);
    }

    // ★追加: スケジュール更新 API
    @PutMapping("/{id}")
    public Schedule updateSchedule(@PathVariable Long id, @RequestBody Schedule updatedSchedule) {
        return scheduleRepository.findById(id)
                .map(schedule -> {
                    schedule.setTitle(updatedSchedule.getTitle());
                    schedule.setEventDate(updatedSchedule.getEventDate());
                    schedule.setEventLocation(updatedSchedule.getEventLocation());
                    schedule.setMemo(updatedSchedule.getMemo());
                    return scheduleRepository.save(schedule);
                })
                .orElseGet(() -> {
                    updatedSchedule.setId(id);
                    return scheduleRepository.save(updatedSchedule);
                });
    }
}
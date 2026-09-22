package com.example.oshigoto;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "schedules")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long oshiId;
    private String category;
    private String title;
    private LocalDate eventDate;
    private String eventLocation;

    @Column(columnDefinition = "TEXT")
    private String memo;

    public Schedule() {}

    public Schedule(Long oshiId, String category, String title, LocalDate eventDate, String eventLocation, String memo) {
        this.oshiId = oshiId;
        this.category = category;
        this.title = title;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
        this.memo = memo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getOshiId() { return oshiId; }
    public void setOshiId(Long oshiId) { this.oshiId = oshiId; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public LocalDate getEventDate() { return eventDate; }
    public void setEventDate(LocalDate eventDate) { this.eventDate = eventDate; }

    public String getEventLocation() { return eventLocation; }
    public void setEventLocation(String eventLocation) { this.eventLocation = eventLocation; }

    public String getMemo() { return memo; }
    public void setMemo(String memo) { this.memo = memo; }
}

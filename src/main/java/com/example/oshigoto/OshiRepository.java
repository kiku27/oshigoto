package com.example.oshigoto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OshiRepository extends JpaRepository<Oshi, Long> {
}

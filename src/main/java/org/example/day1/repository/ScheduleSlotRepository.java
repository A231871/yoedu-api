package org.example.day1.repository;

import org.example.day1.domain.entity.ScheduleSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleSlotRepository  extends JpaRepository<ScheduleSlot, Long> {
}

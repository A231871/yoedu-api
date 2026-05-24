package org.example.day1.repository;

import org.example.day1.domain.entity.Promotion;
import org.example.day1.domain.entity.TuitionInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion,Long> {
}

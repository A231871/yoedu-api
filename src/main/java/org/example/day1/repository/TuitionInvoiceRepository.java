package org.example.day1.repository;

import org.example.day1.domain.entity.TuitionInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TuitionInvoiceRepository extends JpaRepository<TuitionInvoice,Long> {
    java.util.List<TuitionInvoice> findByStudentId(Long studentId);

    java.util.List<TuitionInvoice> findByStudentParentId(Long parentId);
}

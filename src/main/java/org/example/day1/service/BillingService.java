package org.example.day1.service;

import org.example.day1.common.exception.BadRequestException;
import org.example.day1.common.exception.NotFoundException;
import org.example.day1.dto.billing.InvoiceCreateRequest;
import org.example.day1.dto.billing.InvoiceResponse;

import java.util.List;

public interface BillingService {
    InvoiceResponse createInvoice(InvoiceCreateRequest request) throws NotFoundException;

    List<InvoiceResponse> findInvoicesByStudent(Long studentId, String username)
            throws BadRequestException, NotFoundException;
}

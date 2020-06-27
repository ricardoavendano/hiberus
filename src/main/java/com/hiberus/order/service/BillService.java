package com.hiberus.order.service;

import org.springframework.stereotype.Service;

import com.hiberus.order.request.mapping.InvoiceRequestMapping;

import fj.data.Either;

@Service
public interface BillService {

	public Either<Exception, String> saveOrder(InvoiceRequestMapping invoiceRequestMapping);
}

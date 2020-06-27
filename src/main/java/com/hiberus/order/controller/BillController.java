package com.hiberus.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiberus.order.datatransfer.Error;
import com.hiberus.order.request.mapping.InvoiceRequestMapping;
import com.hiberus.order.service.BillService;
import com.hiberus.order.service.ErrorService;

import fj.data.Either;

@EnableAutoConfiguration
@CrossOrigin(origins = "*")
@RequestMapping
@RestController
@Controller
public class BillController {
	
	@Autowired
	private ErrorService errorService;
	
	@Autowired
	private BillService billService;
	
	@PostMapping(value = "/recibe/order")
	public ResponseEntity<?> invoiceProduct(@RequestBody InvoiceRequestMapping invoiceRequestMapping) {

		Either<Exception, String> resultEither = billService.saveOrder(invoiceRequestMapping);

		if (resultEither.isRight()) {
			return new ResponseEntity<>(resultEither.right().value(), HttpStatus.OK);
		}

		Error error = errorService.getError(resultEither.left().value());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

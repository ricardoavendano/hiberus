package com.hiberus.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiberus.order.datatransfer.ClientDTO;
import com.hiberus.order.datatransfer.Error;
import com.hiberus.order.service.ErrorService;
import com.hiberus.order.service.LogisticService;

import fj.data.Either;

@EnableAutoConfiguration
@CrossOrigin(origins = "*")
@RequestMapping
@RestController
@Controller
public class LogisticController {
	
	@Autowired
	private ErrorService errorService;
	
	@Autowired
	private LogisticService logisticService; 
	
	@GetMapping(value = "/create/sent-order/client/{clientId}")
	public ResponseEntity<?> getClientOrder(@PathVariable Long clientId) {

		Either<Exception, ClientDTO> resultEither = logisticService.getOrder(clientId);

		if (resultEither.isRight()) {
			return new ResponseEntity<>(resultEither.right().value(), HttpStatus.OK);
		}

		Error error = errorService.getError(resultEither.left().value());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

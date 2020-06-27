package com.hiberus.order.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hiberus.order.datatransfer.Error;
import com.hiberus.order.exception.CouldNotSaveProductException;
import com.hiberus.order.exception.FailedOrderException;
@Service
public class ErrorService {

	public Error getError(Exception e) {

		if (e instanceof FailedOrderException) {

			return new Error("FailedOrderException001", "There are no purchases registered with the id: "+ ((FailedOrderException) e).getId());

		}
		
		if (e instanceof CouldNotSaveProductException) {

			return new Error("CouldNotSaveProductException001", "Could not save produc");

		}
									
		Map<String, String> params = new HashMap<>();
		params.put("Exception", e.getClass() + "-" + e.getMessage());
		params.put("Time", LocalDateTime.now().toString());

		return new Error("Bill001", "Unknown Error");
	}
}

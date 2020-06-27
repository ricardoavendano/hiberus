package com.hiberus.order.service.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.hiberus.order.datatransfer.Error;
import com.hiberus.order.exception.CouldNotSaveProductException;
import com.hiberus.order.exception.FailedOrderException;
import com.hiberus.order.service.ErrorService;

@RunWith(MockitoJUnitRunner.class)
public class ErrorServiceTest {

	@InjectMocks
	private ErrorService errorService;
	
	@Test
	public void failedOrderException() {
		Error error = errorService.getError(new FailedOrderException(Long.valueOf(1)));
		assertTrue(error.getCode().equals("FailedOrderException001"));
	}
	
	@Test
	public void couldNotSaveProductException() {
		Error error = errorService.getError(new CouldNotSaveProductException());
		assertTrue(error.getCode().equals("CouldNotSaveProductException001"));
	}
		
	
	@Test
	public void unknownError() {
		Error error = errorService.getError(new Exception());
		
		assertTrue(error.getCode().equals("Bill001"));
		assertTrue(error.getDescription().equals("Unknown Error"));
	}
	
	
}

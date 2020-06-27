package com.hiberus.order.controller.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.hiberus.order.controller.BillController;
import com.hiberus.order.datatransfer.Error;
import com.hiberus.order.exception.CouldNotSaveProductException;
import com.hiberus.order.service.BillService;
import com.hiberus.order.service.ErrorService;

import fj.data.Either;

@RunWith(MockitoJUnitRunner.Silent.class)
public class BillControllerTest {

	@InjectMocks
	private BillController billController;
	
	@Mock
	private BillService billService;
	
	@Mock
	private ErrorService errorService;
	
	@Test
	public void invoiceProductOK() {
		
		Either<Exception, String> resultEither = Either.right("");
		
		Mockito.when(billService.saveOrder(Mockito.any())).thenReturn(resultEither);
				
		ResponseEntity<?> res = billController.invoiceProduct(Mockito.any());
		
		assertEquals(200, res.getStatusCodeValue());
	}
	
	@Test
	public void invoiceProductERROR() throws Exception{
		
		Exception e = new CouldNotSaveProductException();
		Error error = errorService.getError(e);
		
		Either<Exception, String> resultEither = Either.left(new CouldNotSaveProductException());
		
		Mockito.when(billService.saveOrder(Mockito.any())).thenReturn(resultEither);
		Mockito.when(errorService.getError(e)).thenReturn(error);
				
		ResponseEntity<?> res = billController.invoiceProduct(Mockito.any());
		
		assertEquals(500, res.getStatusCodeValue());
	}
}

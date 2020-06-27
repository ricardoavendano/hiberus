package com.hiberus.order.controller.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.hiberus.order.controller.LogisticController;
import com.hiberus.order.datatransfer.ClientDTO;
import com.hiberus.order.datatransfer.Error;
import com.hiberus.order.exception.FailedOrderException;
import com.hiberus.order.service.ErrorService;
import com.hiberus.order.service.LogisticService;

import fj.data.Either;

@RunWith(MockitoJUnitRunner.Silent.class)
public class LogisticControllerTest {

	@InjectMocks
	private LogisticController ogisticController;

	@Mock
	private LogisticService logisticService;

	@Mock
	private ErrorService errorService;

	@Test
	public void getClientOrderOK() {

		ClientDTO clientDTO = new ClientDTO();
		Either<Exception, ClientDTO> resultEither = Either.right(clientDTO);

		Mockito.when(logisticService.getOrder(Mockito.anyLong())).thenReturn(resultEither);

		ResponseEntity<?> res = ogisticController.getClientOrder(Mockito.anyLong());

		assertEquals(200, res.getStatusCodeValue());
	}
	
	@Test
	public void getClientOrderERROR() {
		
		Exception e = new FailedOrderException(Mockito.anyLong());
		Error error = errorService.getError(e);
		
		Either<Exception, ClientDTO> resultEither = Either.left(new FailedOrderException(Long.valueOf(1)));
		
		Mockito.when(logisticService.getOrder(Mockito.anyLong())).thenReturn(resultEither);
		Mockito.when(errorService.getError(e)).thenReturn(error);
				
		ResponseEntity<?> res = ogisticController.getClientOrder(Mockito.anyLong());
		
		assertEquals(500, res.getStatusCodeValue());
		
	}

}

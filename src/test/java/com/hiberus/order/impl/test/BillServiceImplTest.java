package com.hiberus.order.impl.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hiberus.order.impl.BillServiceImpl;
import com.hiberus.order.repository.ClientRepository;
import com.hiberus.order.request.mapping.InvoiceRequestMapping;
import com.hiberus.order.request.mapping.ProductRequestMapping;

@RunWith(MockitoJUnitRunner.class)
public class BillServiceImplTest {
	
	@InjectMocks
	private BillServiceImpl billServiceImpl;
	
	@Mock
	private ClientRepository clientRepository;
	
	@Test
	public void saveOrderOK() {
		
		InvoiceRequestMapping invoiceRequestMapping = new InvoiceRequestMapping();
		List<ProductRequestMapping> productRequestMappingList = new ArrayList<>();
		ProductRequestMapping productRequestMapping = new ProductRequestMapping();
		
		invoiceRequestMapping.setClientId(Long.valueOf(1));
		invoiceRequestMapping.setDateTime(new Date(System.currentTimeMillis()));
		invoiceRequestMapping.setDirection("direction");
		
		productRequestMapping.setCost(Long.valueOf(1));
		productRequestMapping.setId(Long.valueOf(1));
		productRequestMapping.setQuantity(Long.valueOf(1));
		productRequestMappingList.add(productRequestMapping);
		invoiceRequestMapping.setProductRequestMapping(productRequestMappingList);
		
		Mockito.when(clientRepository.save(Mockito.any())).thenReturn(null);
		billServiceImpl.saveOrder(invoiceRequestMapping);
		
	}
	
	@Test
	public void saveOrderERROR() {
		
		billServiceImpl.saveOrder(null);
		
	}

}

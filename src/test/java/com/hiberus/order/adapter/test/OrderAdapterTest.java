package com.hiberus.order.adapter.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.hiberus.order.adapter.OrderAdapter;
import com.hiberus.order.datatransfer.ClientDTO;
import com.hiberus.order.domain.Client;
import com.hiberus.order.domain.Product;

@RunWith(MockitoJUnitRunner.class)
public class OrderAdapterTest {

	@InjectMocks
	private OrderAdapter orderAdapter;
	
	@Test
	public void clientAdapterTest() {
		
		Client client = new Client();
		Product product = new Product();
		List<Product> productList = new ArrayList<>();
		
		client.setClientId(Long.valueOf(1));
		client.setDataTime(new Date(System.currentTimeMillis()));
		client.setDirection("direction");
				
		product.setCost(Long.valueOf(1));
		product.setId(Long.valueOf(1));
		product.setIdIncrement(Long.valueOf(1));
		product.setQuantity(Long.valueOf(1));
		product.setClientIdPK(client);
		productList.add(product);
		
		client.setProductList(productList);
		
		ClientDTO clientDTO = orderAdapter.clientAdapter(client, productList);
		
		assertEquals(clientDTO.getClientId(), client.getClientId());
	}
}

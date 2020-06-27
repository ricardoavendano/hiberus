package com.hiberus.order.impl.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hiberus.order.adapter.OrderAdapter;
import com.hiberus.order.domain.Client;
import com.hiberus.order.domain.Product;
import com.hiberus.order.impl.LogisticServiceImpl;
import com.hiberus.order.repository.ClientRepository;
import com.hiberus.order.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class LogisticServiceImplTest {

	@InjectMocks
	private LogisticServiceImpl logisticServiceImpl;

	@Mock
	private ClientRepository clientRepository;

	@Mock
	private ProductRepository productRepository;

	@Mock
	private OrderAdapter orderAdapter;

	@Test
	public void getOrderOK() {

		Client client = new Client();
		List<Product> productList = new ArrayList<>();
		Product product = new Product();

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
		Mockito.when(clientRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(client));
		Mockito.when(productRepository.productList(Mockito.anyLong())).thenReturn(productList);

		logisticServiceImpl.getOrder(Mockito.anyLong());

	}

	@Test
	public void getOrderClientEmpty() {

		Optional<Client> client = Optional.empty();

		Mockito.when(clientRepository.findById(Mockito.anyLong())).thenReturn(client);

		logisticServiceImpl.getOrder(Mockito.anyLong());

	}

}

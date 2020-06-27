package com.hiberus.order.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiberus.order.domain.Client;
import com.hiberus.order.domain.Product;
import com.hiberus.order.exception.CouldNotSaveProductException;
import com.hiberus.order.repository.ClientRepository;
import com.hiberus.order.request.mapping.InvoiceRequestMapping;
import com.hiberus.order.request.mapping.ProductRequestMapping;
import com.hiberus.order.service.BillService;

import fj.data.Either;

@Service
public class BillServiceImpl implements BillService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BillServiceImpl.class);

	@Autowired
	private ClientRepository clientRepository;

	public Either<Exception, String> saveOrder(InvoiceRequestMapping invoiceRequestMapping) {
		try {

			Client client = new Client();
			client.setClientId(invoiceRequestMapping.getClientId());
			client.setDataTime(invoiceRequestMapping.getDateTime());
			client.setDirection(invoiceRequestMapping.getDirection());

			List<Product> productList = new ArrayList<>();

			for (ProductRequestMapping productRequestMapping : invoiceRequestMapping.getProductRequestMapping()) {

				Product product = new Product();
				product.setClientIdPK(client);
				product.setCost(productRequestMapping.getCost());
				product.setId(productRequestMapping.getId());
				product.setQuantity(productRequestMapping.getQuantity());
				productList.add(product);

			}
			client.setProductList(productList);
			clientRepository.save(client);
			return Either.right("{\"code\":\"Save all products\"}");

		} catch (Exception e) {

			LOGGER.error("BillServiceImpl:ClientRepository", e);
			return Either.left(new CouldNotSaveProductException());
		}
	}
}

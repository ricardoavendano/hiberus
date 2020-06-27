package com.hiberus.order.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiberus.order.adapter.OrderAdapter;
import com.hiberus.order.datatransfer.ClientDTO;
import com.hiberus.order.domain.Client;
import com.hiberus.order.domain.Product;
import com.hiberus.order.exception.FailedOrderException;
import com.hiberus.order.repository.ClientRepository;
import com.hiberus.order.repository.ProductRepository;
import com.hiberus.order.service.LogisticService;

import fj.data.Either;

@Service
public class LogisticServiceImpl implements LogisticService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LogisticServiceImpl.class);

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderAdapter orderAdapter;

	@Transactional
	public Either<Exception, ClientDTO> getOrder(Long id) {
		try {
			Optional<Client> clientList = clientRepository.findById(id);
			if (!clientList.isPresent()) {
				throw new FailedOrderException(id);
			} else {

				List<Product> productList = productRepository.productList(id);

				ClientDTO clientDTO = orderAdapter.clientAdapter(clientList.get(), productList);
				return Either.right(clientDTO);
			}

		} catch (FailedOrderException e) {
			LOGGER.error("LogisticServiceImpl:getOrder", e);
			return Either.left(e);
		}

	}

}

package com.hiberus.order.service;

import org.springframework.stereotype.Service;

import com.hiberus.order.datatransfer.ClientDTO;

import fj.data.Either;

@Service
public interface LogisticService {

	public Either<Exception, ClientDTO> getOrder(Long id);
}

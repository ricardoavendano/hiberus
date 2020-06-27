package com.hiberus.order.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.hiberus.order.domain.Client;

@Component
public interface ClientRepository extends CrudRepository<Client, Long>{
}

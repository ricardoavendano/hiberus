package com.hiberus.order.adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hiberus.order.datatransfer.ClientDTO;
import com.hiberus.order.datatransfer.ProductDTO;
import com.hiberus.order.domain.Client;
import com.hiberus.order.domain.Product;

@Component
public class OrderAdapter {
	
	public ClientDTO clientAdapter(Client client, List<Product> productList) {
		
		ClientDTO clientDTO = new ClientDTO();
		List<ProductDTO> productDTOList = new ArrayList<>();
		Long sum = Long.valueOf(0);
		
		clientDTO.setClientId(client.getClientId());
		clientDTO.setDateTime(client.getDataTime());
		clientDTO.setDirection(client.getDirection());
		
		for(Product product: productList) {
			sum += (product.getCost() * product.getQuantity());
			
			ProductDTO productDTO = new ProductDTO();
			productDTO.setCost(product.getCost());
			productDTO.setId(product.getId());
			productDTO.setQuantity(product.getQuantity());
			productDTOList.add(productDTO);
		}
		
		clientDTO.setTotalPrice(sum);
		clientDTO.setProductDTO(productDTOList);
		return clientDTO;
	}

}

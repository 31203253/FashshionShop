package com.myclass.fashionshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.myclass.fashionshop.dto.CheckoutDto;
import com.myclass.fashionshop.entity.Invoice;
import com.myclass.fashionshop.entity.Product;
import com.myclass.fashionshop.repository.ProductRepository;

@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	ProductRepository productRepository;

	public void checkout(List<CheckoutDto> checkoutList) {
		for (CheckoutDto item : checkoutList) {
			Product entity = productRepository.findById(item.getId()).get();
			entity.setSales(entity.getSales() + item.getQuantity());
			productRepository.save(entity);
		}
	}

	public List<CheckoutDto> getSessionObjects(String session) {
		Gson gson = new Gson();
		String[] jsonArray = gson.fromJson(session, String[].class);
		List<CheckoutDto> checkoutList = new ArrayList<CheckoutDto>();
		for (String item : jsonArray) {
			checkoutList.add(gson.fromJson(item, CheckoutDto.class));
		}
		return checkoutList;

	}

	public void performaInvoice(Invoice invoice) {
		List<CheckoutDto> checkoutList = getSessionObjects(invoice.getSession());
		checkout(checkoutList);
	}
}

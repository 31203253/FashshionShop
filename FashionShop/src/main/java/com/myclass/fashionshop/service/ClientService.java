package com.myclass.fashionshop.service;

import java.util.List;
import com.myclass.fashionshop.dto.CheckoutDto;
import com.myclass.fashionshop.entity.Invoice;


public interface ClientService {
	void checkout(List<CheckoutDto> checkoutList);
	void performaInvoice(Invoice invoice);
	List<CheckoutDto> getSessionObjects(String session);
}

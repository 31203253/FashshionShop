package com.myclass.fashionshop.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.fashionshop.dto.CheckoutDto;
import com.myclass.fashionshop.entity.Invoice;
import com.myclass.fashionshop.repository.InvoiceRepository;
import com.myclass.fashionshop.service.ClientServiceImpl;

@RestController
@RequestMapping("api/invoice")
@CrossOrigin("*")
public class InvoiceRestController {
	@Autowired
	InvoiceRepository invoiceRepository;
	@Autowired
	ClientServiceImpl transactionServiceImpl;
	
	@PostMapping("/addInvoice")
	public Object add(@RequestBody Invoice invoice) {
		Invoice entity = invoiceRepository.save(invoice);
		return new ResponseEntity<Invoice>(entity, HttpStatus.CREATED);
	}
	@PutMapping("/checkout")
	public Object checkout(@RequestBody List<CheckoutDto> checkoutList) {
		transactionServiceImpl.checkout(checkoutList);
		return new ResponseEntity<String>("Successfully Transaction!", HttpStatus.OK);
	}
}

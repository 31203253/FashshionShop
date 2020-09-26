package com.myclass.fashionshop.restcontroller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.myclass.fashionshop.entity.Product;
import com.myclass.fashionshop.repository.ProductRepository;
import com.myclass.fashionshop.service.ClientServiceImpl;
import com.myclass.fashionshop.service.UserServiceImpl;

@RestController
@RequestMapping("api/product")
@CrossOrigin("*")
public class ProductRestController {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ClientServiceImpl clientServiceImpl;
	@Autowired
	UserServiceImpl userServiceImpl;
	@GetMapping("/count")
	public Object countProduct() {
		Long count = productRepository.count();
		return new ResponseEntity<Long>(count, HttpStatus.OK);
	}

	@GetMapping("/getAllProducts/{pageIndex}/{pageSize}")
	public Object getAllProducts(@PathVariable int pageIndex, @PathVariable int pageSize) {
		if (pageSize > 0) {
			Pageable pageable = PageRequest.of(pageIndex - 1, pageSize);
			List<Product> products = productRepository.getAllProducts(pageable).getContent();
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/descPrice/{pageIndex}/{pageSize}")
	public Object descPrice(@PathVariable int pageIndex, @PathVariable int pageSize) {
		if (pageSize > 0) {
			Pageable pageable = PageRequest.of(pageIndex - 1, pageSize);
			List<Product> products = productRepository.descPrice(pageable).getContent();
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/ascPrice/{pageIndex}/{pageSize}")
	public Object ascPrice(@PathVariable int pageIndex, @PathVariable int pageSize) {
		if (pageSize > 0) {
			Pageable pageable = PageRequest.of(pageIndex - 1, pageSize);
			List<Product> products = productRepository.ascPrice(pageable).getContent();
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/getBestSelling/{pageIndex}/{pageSize}")
	public Object getBestSelling(@PathVariable int pageIndex, @PathVariable int pageSize) {
		if (pageSize > 0) {
			Pageable pageable = PageRequest.of(pageIndex - 1, pageSize);
			List<Product> products = productRepository.bestSelling(pageable).getContent();
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/getById/{id}")
	public Object getById(@PathVariable Long id) {
		Product product = productRepository.findById(id).get();
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@GetMapping("/getByStatus/{status}")
	public Object getByStatus(@PathVariable String status) {
		List<Product> products = productRepository.findByStatus(status);
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@PostMapping("/addProduct")
	public Object add(@RequestBody Product product) {
		Product entity = productRepository.save(product);
		return new ResponseEntity<Product>(entity, HttpStatus.CREATED);
	}

	@PutMapping("/updateProduct/{id}")
	public Object update(@PathVariable Long id, @RequestBody Product product) {
		if (productRepository.existsById(id)) {
			product.setId(id);
			Product entity = productRepository.save(product);
			return new ResponseEntity<Product>(entity, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Invalid Product ID!", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/deleteProduct/{id}")
	public Object delete(@PathVariable Long id) {
		if (productRepository.existsById(id)) {
			productRepository.deleteById(id);
			return new ResponseEntity<String>("Successfully Deleted!", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>("Invalid Product ID!", HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/uploadImage/{productId}/{slot}")
	public Object uploadImage(@PathVariable Long productId, @PathVariable String slot, @RequestBody MultipartFile file)
			throws IOException {
		String result = userServiceImpl.uploadImage(productId, slot, file);
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

}

package com.myclass.fashionshop.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface UserService {

	String uploadImage(Long productId, String slot, MultipartFile file) throws IOException;

}

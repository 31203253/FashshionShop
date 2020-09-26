package com.myclass.fashionshop.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.myclass.fashionshop.config.Constants;

@Service
public class UserServiceImpl implements UserService {
	private final String fileLocation = Constants.productImagesDir;

	public String uploadImage(Long productId, String slot, MultipartFile file) throws IOException {
		String uploadFolder = productId.toString();
		String path = fileLocation + uploadFolder + "\\";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();
		}
		String fileExtension = "jpg";
		String fullPath = path + slot + "." + fileExtension;
		File pathFile = new File(fullPath);
		String result = pathFile.delete() ? "Updated" : "Uploaded";
		pathFile.createNewFile();
		FileOutputStream fileOutputStream = new FileOutputStream(pathFile);
		fileOutputStream.write(file.getBytes());
		fileOutputStream.close();
		return result;

	}
}

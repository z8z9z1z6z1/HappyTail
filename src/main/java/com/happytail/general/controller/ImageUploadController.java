package com.happytail.general.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.happytail.general.model.service.ImageUploadService;

@RestController
public class ImageUploadController {

	@Autowired
	private ImageUploadService imageUploadService;

	@PostMapping("/uploadTopicImg")
	public Map<String, String> uploadTopicImg(@RequestPart(name="upload") MultipartFile image, ModelMap model) throws IOException {

		Map<String, String> map = new HashMap<>();
		String imageUrl = imageUploadService.uploadSingleImage(image);

		if (imageUrl != null) {
			map.put("uploaded", "true");
			map.put("url", imageUrl);
			System.out.println("imageUrl=" + imageUrl);
		} else {
			map.put("uploaded", "false");
			map.put("url", null);
			System.out.println("imageUrl: not exsit");
		}

		return map;
	}

}

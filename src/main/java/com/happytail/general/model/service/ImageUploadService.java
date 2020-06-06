package com.happytail.general.model.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.happytail.general.util.MultipartInputStreamFileResource;

@Service
@Transactional
public class ImageUploadService {

	private final String IMGUR_UPLOAD_URL = "https://api.imgur.com/3/upload";
	private final String IMGUR_CLIENT_ID = "2cd5c2a77436892";

	public String uploadSingleImage(MultipartFile image) throws IOException {

		URI url = URI.create(IMGUR_UPLOAD_URL);
		RestTemplate restTemplate = new RestTemplate();
		//RestTemplate => Synchronous client to perform HTTP requests.
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.MULTIPART_FORM_DATA);

		// body
		MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("image", new MultipartInputStreamFileResource(image.getInputStream(),image.getOriginalFilename()));
		// MultipartInputStreamFileResource needs InputStream inputStream, String filename

		// get request & response entity
		// MyRequest body = ...
		//				 RequestEntity<MyRequest> request = RequestEntity
		//				     .post(new URI("https://example.com/bar"))
		//				     .accept(MediaType.APPLICATION_JSON)
		//				     .body(body);
		// ResponseEntity<MyResponse> response = template.exchange(request, MyResponse.class);
		
		RequestEntity<MultiValueMap<String, Object>> request = 
				RequestEntity.post(url) //Create an HTTP POST builder with the given url.
				.header("Authorization", "Client-ID " + IMGUR_CLIENT_ID) //Authorization: Client-ID <YOUR_CLIENT_ID>
				.contentType(MediaType.MULTIPART_FORM_DATA) //Set the media type of the body, as specified by the Content-Type header.
				.body(body);
		ResponseEntity<Map> response = restTemplate.exchange(request, Map.class);//T - the body type
		//exchange=>Execute the request specified in the given RequestEntity and return the response as ResponseEntity.
		
		if(response.getStatusCodeValue() == 200) {
			String imgUrl = ((Map)response.getBody().get("data")).get("link").toString();
			return imgUrl;
		}
		System.out.println("upload fail");
		return "";
	}

}

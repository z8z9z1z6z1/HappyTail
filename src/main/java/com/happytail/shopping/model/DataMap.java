package com.happytail.shopping.model;

import java.util.Map;

public class DataMap {
	ProductBean bean;
	String imageData;
	Map<String, Integer> map;

	public DataMap() {
		
	}

	public DataMap(ProductBean bean, String imageData, Map<String, Integer> map) {
		this.bean = bean;
		this.imageData = imageData;
		this.map = map;
	}

	public ProductBean getBean() {
		return bean;
	}

	public void setBean(ProductBean bean) {
		this.bean = bean;
	}

	public String getImageData() {
		return imageData;
	}

	public void setImageData(String imageData) {
		this.imageData = imageData;
	}

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductBeanImageData [bean=");
		builder.append(bean);
		builder.append(", imageData=");
		builder.append(imageData);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}

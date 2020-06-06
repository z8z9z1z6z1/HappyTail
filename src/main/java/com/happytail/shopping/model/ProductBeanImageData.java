package com.happytail.shopping.model;



public class ProductBeanImageData {
	
	ProductBean bean;
	
	String imageData;
	
	

	public ProductBeanImageData() {
	
	}

	public ProductBeanImageData(ProductBean bean, String imageData) {
		this.bean = bean;
		this.imageData = imageData;
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

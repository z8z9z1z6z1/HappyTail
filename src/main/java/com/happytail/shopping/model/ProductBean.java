package com.happytail.shopping.model;



import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Component
@Table(name = "Product")

public class ProductBean {

	private Integer productId;
	private String name;
	private Double price;
	private Double discount;
	private Blob coverImage;
	private String fileName;
	private String descriptrion;
	private String categoryId;
	private Double amount;
	private Integer sales;
	private Integer status;
	private  String biPhoto;
	private String  priceStr = null;
	private MultipartFile productImage;
	private Timestamp admissionTime;
	

	//放入商品的資料裡面 不要放置
	public ProductBean(Integer productId, String name, Double price, Double discount, Blob coverImage, String fileName,
			String descriptrion, String categoryId, Double amount) {		
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.discount = discount;
		this.coverImage = coverImage;
		this.fileName = fileName;
		this.descriptrion = descriptrion;
		this.categoryId = categoryId;
		this.amount = amount;

	
		
	}
//	public ProductBean(Integer productId, String name, Double price, Double discount, String fileName,
//			String descriptrion, String categoryId, Double amount, Integer sales, Integer status) {
//		super();
//		this.productId = productId;
//		this.name = name;
//		this.price = price;
//		this.discount = discount;
//		this.fileName = fileName;
//		this.descriptrion = descriptrion;
//		this.categoryId = categoryId;
//		this.amount = amount;
//		this.sales = sales;
//		this.status = status;
//	}
//	
	public ProductBean() {
		
	}
	

	@Id @Column(name="productId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name="price")
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name="discount")
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	@JsonIgnore

	@Column(name="coverImage")
	public Blob getCoverImage() {
		return coverImage;
	}
	public void setCoverImage(Blob coverImage) {
		this.coverImage = coverImage;
	}

	@Column(name="fileName")
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name="description")
	public String getDescriptrion() {
		return descriptrion;
	}
	public void setDescriptrion(String descriptrion) {
		this.descriptrion = descriptrion;
	}

	@Column(name="categoryId")
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name="amount")
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Column(name="sales")
	public Integer getSales() {
		return sales;
	}
	public void setSales(Integer sales) {
		this.sales = sales;
	}

	@Column(name="status")
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	@Transient
	public String getBiPhoto() {
		int Length = 0;
		byte[] Bytes = null;
		try {
			Length = (int) this.coverImage.length();
			Bytes = this.coverImage.getBytes(1, Length);
//			System.out.println("傳換陣列");
		} catch (SQLException e1) {
			e1.printStackTrace();
//			System.out.println("無法轉換成陣列");
		}
		String biPhoto =Base64.getEncoder().encodeToString(Bytes);
		return biPhoto;
	}
	public void setBiPhoto(String biPhoto) {
		this.biPhoto = biPhoto;
	}
	@JsonIgnore

	@Transient
	public String getPriceStr() {
		return priceStr;
	}
	public void setPriceStr(String priceStr) {
		this.priceStr = priceStr;
	}
	@Transient
	public MultipartFile getProductImage() {
		return productImage;
	}
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

	@Column(name="admissionTime")
	public Timestamp getAdmissionTime() {
		return admissionTime;
	}
	public void setAdmissionTime(Timestamp admissionTime) {
		this.admissionTime = admissionTime;
	}
	
	
	
	
	
}

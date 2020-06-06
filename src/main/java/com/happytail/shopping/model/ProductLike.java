package com.happytail.shopping.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import net.bytebuddy.asm.Advice.This;
@Component
@Entity
@Table(name = "ProductLike")
public class ProductLike {
	@Id
	@Column(name="productLikeId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productLikeId;

	@Column(name="petMemberId")
	private Integer petMemberId;
	@Column(name="updatetime")
	private java.sql.Timestamp updatetime;
	@OneToOne
	@JoinColumn(name="productId")
	private ProductBean bean;
	
	
	
	public ProductLike(int productLikeId, Integer petMemberId, Timestamp updatetime) {
		super();
		this.productLikeId = productLikeId;
//		this.productId = productId;
		this.petMemberId = petMemberId;
		this.updatetime = updatetime;
	}
	public ProductLike() {
		
	}
	

	public void setProductLikeId(int productLikeId) {
		this.productLikeId = productLikeId;
	}
//	public Integer getProductId() {
//		return productId;
//	}
//	public void setProductId(Integer productId) {
//		this.productId = productId;
//	}
	public Integer getPetMemberId() {
		return petMemberId;
	}
	public void setPetMemberId(Integer petMemberId) {
		this.petMemberId = petMemberId;
	}
	public java.sql.Timestamp getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(java.sql.Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	public ProductBean getBean() {
		return bean;
	}
	public void setBean(ProductBean bean) {
		this.bean = bean;
	}
	public int getProductLikeId() {
		return productLikeId;
	}
	
	
	
}

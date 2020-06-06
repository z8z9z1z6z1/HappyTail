package com.happytail.forum.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
@Entity
@Table(name = "Favorate")
public class Favorate {
	
	private Integer id;
	private Integer userId;
	private Integer categoryId;
	private Timestamp createDate = new Timestamp(System.currentTimeMillis());
	private Timestamp updateDate = new Timestamp(System.currentTimeMillis());
	
	public Favorate(Integer userId, Integer categoryId, Timestamp createDate
	,Timestamp updateDate) {
		this.userId = userId;
		this.categoryId = categoryId;
		this.createDate = createDate;
		this.updateDate = updateDate;
		}
	public Favorate() {
		
	}
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "userId")
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@Column(name = "categoryId")
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	@Column(name = "createDate")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm")
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	
	@Column(name = "updateDate")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm")
	public Timestamp getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
	@Override
	public String toString() {
		return "Favorate [id=" + id + ", userId=" + userId + ", categoryId=" + categoryId + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + "]";
	}
	
	
}

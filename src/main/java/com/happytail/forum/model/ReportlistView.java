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
@Table(name = "ReportlistView")
public class ReportlistView {
	
	private Integer id;
	private Integer topicId;
	private String title;
	private Integer userId;
	private String username;
	private String email;	
	private String isDone;
	private String message;
	private Integer categoryId;
	private String category;
	private Timestamp createDate;
	
	public ReportlistView(Integer topicId, String title, Integer userId, String username
			, String email, String isDone, String message,Integer categoryId 
			, String category, Timestamp createDate) {
		this.topicId = topicId;
		this.title = title;
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.isDone = isDone;
		this.message = message;
		this.categoryId = categoryId;
		this.category = category;
		this.createDate =createDate;
	}
	
	public ReportlistView() {
		
	}

	@Id
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "topicId")
	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "userId")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "isDone")
	public String getIsDone() {
		return isDone;
	}

	public void setIsDone(String isDone) {
		this.isDone = isDone;
	}

	@Column(name = "message")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "categoryId")
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "category")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name = "createDate")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm")
	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "ReportlistView [id=" + id + ", topicId=" + topicId + ", title=" + title + ", userId=" + userId
				+ ", username=" + username + ", email=" + email + ", isDone=" + isDone + ", message=" + message
				+ ", categoryId=" + categoryId + ", category=" + category + ", createDate=" + createDate + "]";
	}

	
}

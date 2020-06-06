package com.happytail.forum.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
@Entity
@Table(name = "Topic")
public class Topic {
	
	private Integer id;
	private Integer categoryId;
	private String title;
	private String content;
	private Integer userId;
	private String username;
	private Timestamp createDate = new Timestamp(System.currentTimeMillis());
	private Timestamp updateDate = new Timestamp(System.currentTimeMillis());
	private Boolean isThumbsUp;
	private Boolean isFollowed;
	private Boolean isReported;
	private String category;
	
	public Topic(Integer categoryId, String title, String content, Integer userId,
	String username, Timestamp createDate,Timestamp updateDate,String category) {
		this.categoryId = categoryId;
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.username = username;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.category = category;
	}
	
	public Topic() {
		
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

	@Column(name = "categoryId")
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
	
	@Transient
	public Boolean getIsThumbsUp() {
		return isThumbsUp;
	}
	
	public void setIsThumbsUp(Boolean isThumbsUp) {
		this.isThumbsUp = isThumbsUp;
	}
	@Transient
	public Boolean getIsFollowed() {
		return isFollowed;
	}

	public void setIsFollowed(Boolean isFollowed) {
		this.isFollowed = isFollowed;
	}
	@Transient
	public Boolean getIsReported() {
		return isReported;
	}

	public void setIsReported(Boolean isReported) {
		this.isReported = isReported;
	}
	
	
	@Transient
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Topic [id=" + id + ", categoryId=" + categoryId + ", title=" + title + ", content=" + content
				+ ", userId=" + userId + ", username=" + username + ", createDate=" + createDate + ", updateDate="
				+ updateDate + ", isThumbsUp=" + isThumbsUp + ", isFollowed=" + isFollowed + ", isReported="
				+ isReported + ", category=" + category + "]";
	}

}

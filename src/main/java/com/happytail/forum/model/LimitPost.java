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
@Table(name = "LimitPost")
public class LimitPost {
	
	private Integer id;
	private Integer userId;
	private String username;
	private String imageUrl;
	private Timestamp expireTime = new Timestamp(System.currentTimeMillis()); 
	
	public LimitPost(Integer userId, String username, String imageUrl
	,Timestamp expireTime) {
		this.userId = userId;
		this.username = username;
		this.imageUrl = imageUrl;
		this.expireTime = expireTime;
	}
	
	public LimitPost() {
		
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

	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "imageUrl")
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	@Column(name = "expireTime")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm")
	public Timestamp getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Timestamp expireTime) {
		this.expireTime = expireTime;
	}

	@Override
	public String toString() {
		return "LimitPost [id=" + id + ", userId=" + userId + ", username=" + username + ", imageUrl=" + imageUrl
				+ ", expireTime=" + expireTime + "]";
	}

	
}

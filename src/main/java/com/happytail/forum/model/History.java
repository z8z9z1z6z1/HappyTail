package com.happytail.forum.model;

import java.sql.Date;
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
@Table(name = "History")
public class History {
	
	private Integer id;
	private Integer topicId;
	private Integer userId;
	private String username;
	private Date readDate  = new Date(System.currentTimeMillis());
	
	public History(Integer topicId, Integer userId, String username
	,Date readDate) {
		this.topicId = topicId;
		this.userId = userId;
		this.username = username;
		this.readDate = readDate;		
	}
	
	public History() {
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

	@Column(name = "topicId")
	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
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

	@Column(name = "readDate")
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getReadDate() {
		return readDate;
	}

	public void setReadDate(Date readDate) {
		this.readDate = readDate;
	}

	@Override
	public String toString() {
		return "History [id=" + id + ", topicId=" + topicId + ", userId=" + userId + ", username=" + username
				+ ", readDate=" + readDate + "]";
	}

	
}

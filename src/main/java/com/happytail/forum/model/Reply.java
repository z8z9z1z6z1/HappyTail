package com.happytail.forum.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
@Table(name = "Reply")
public class Reply {
	
	private Integer id;
	private Integer userId;
	private String username;
	private Integer topicId;
	private String replyContent;
	private Timestamp createDate = new Timestamp(System.currentTimeMillis());
	private Timestamp updateDate = new Timestamp(System.currentTimeMillis());
	private List<Integer> atUserIdList = new ArrayList<Integer>();
	private Boolean isThumbsUp;

	
	public Reply(Integer userId, String username, Integer topicId
			, String replyContent, Timestamp createDate, Timestamp updateDate) {
		this.userId = userId;
		this.username = username;
		this.topicId = topicId;
		this.replyContent = replyContent;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
	

	public Reply() {
		
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


	@Column(name = "topicId")
	public Integer getTopicId() {
		return topicId;
	}


	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}


	@Column(name = "replyContent")
	public String getReplyContent() {
		return replyContent;
	}


	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
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
	public List<Integer> getAtUserIdList() {
		return atUserIdList;
	}


	public void setAtUserIdList(List<Integer> atUserIdList) {
		this.atUserIdList = atUserIdList;
	}
	
	@Transient
	public Boolean getIsThumbsUp() {
		return isThumbsUp;
	}


	public void setIsThumbsUp(Boolean isThumbsUp) {
		this.isThumbsUp = isThumbsUp;
	}


	@Override
	public String toString() {
		return "Reply [id=" + id + ", userId=" + userId + ", username=" + username + ", topicId=" + topicId
				+ ", replyContent=" + replyContent + ", createDate=" + createDate + ", updateDate=" + updateDate
				+ ", atUserIdList=" + atUserIdList + "]";
	}
	
}

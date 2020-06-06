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
@Table(name = "TopiclistView")
public class TopiclistView {
	
	private Integer userId;
	private String username;
	private Integer categoryId;
	private Integer topicId;
	private String title;
	private Timestamp createDate;
	private String imageUrl;
	private Integer replyNum;
	private Integer count;
	private Integer likeNum;
	private String category;
	private Boolean isThumbsUp;
	private Boolean isFollowed;
	private Boolean isReported;	
	
	public TopiclistView(Integer userId, String username, Integer categoryId
	, Integer topicId, String title, Timestamp createDate, String imageUrl
	, Integer replyNum, Integer count, Integer likeNum, String category) {
		this.userId = userId;
		this.username = username;
		this.categoryId = categoryId;
		this.topicId = topicId;
		this.title = title;
		this.createDate = createDate;
		this.imageUrl = imageUrl;
		this.replyNum = replyNum;
		this.count = count;
		this.likeNum = likeNum;
		this.category = category;		
		}
	
	public TopiclistView() {
		
	}
	@Id
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

	@Column(name = "createDate")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm")
	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Column(name = "imageUrl")
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Column(name = "replyNum")
	public Integer getReplyNum() {
		return replyNum;
	}

	public void setReplyNum(Integer replyNum) {
		this.replyNum = replyNum;
	}

	@Column(name = "count")
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Column(name = "likeNum")
	public Integer getLikeNum() {
		return likeNum;
	}

	public void setLikeNum(Integer likeNum) {
		this.likeNum = likeNum;
	}

	@Column(name = "category")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	@Override
	public String toString() {
		return "TopiclistView [userId=" + userId + ", username=" + username + ", categoryId=" + categoryId
				+ ", topicId=" + topicId + ", title=" + title + ", createDate=" + createDate + ", imageUrl=" + imageUrl
				+ ", replyNum=" + replyNum + ", count=" + count + ", likeNum=" + likeNum + ", category=" + category
				+ ", isThumbsUp=" + isThumbsUp + ", isFollowed=" + isFollowed + ", isReported=" + isReported + "]";
	}


}

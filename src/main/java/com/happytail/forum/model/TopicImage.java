package com.happytail.forum.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
@Entity
@Table(name = "TopicImage")
public class TopicImage {
	 
	private Integer id;
	private Integer topidId;
	private String imageUrl;
	private Boolean isCover = false;
	private Timestamp createDate = new Timestamp(System.currentTimeMillis());
	private Timestamp updateDate = new Timestamp(System.currentTimeMillis());

	public TopicImage(Integer topidId, String imageUrl,
			Boolean isCover, Timestamp createDate, Timestamp updateDate) {
		this.topidId = topidId;
		this.imageUrl = imageUrl;
		this.isCover = isCover;
		this.createDate = createDate;
		this.updateDate =updateDate;		
	}
	
	public TopicImage() {
		
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
	public Integer getTopidId() {
		return topidId;
	}

	public void setTopidId(Integer topidId) {
		this.topidId = topidId;
	}

	@Column(name = "imageUrl")
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Type(type="yes_no")
	@Column(name = "isCover")
	public Boolean getIsCover() {
		return isCover;
	}

	public void setIsCover(Boolean isCover) {
		this.isCover = isCover;
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
		return "TopicImage [id=" + id + ", topidId=" + topidId + ", imageUrl=" + imageUrl + ", isCover=" + isCover
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}

	

}

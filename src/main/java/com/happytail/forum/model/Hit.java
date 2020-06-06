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
@Table(name = "Hit")
public class Hit {
	
	private Integer id;
	private Integer topicId;
	private Integer count;
	private Date recordDate = new Date(System.currentTimeMillis());
	private Timestamp createDate = new Timestamp(System.currentTimeMillis());
	private Timestamp updateDate = new Timestamp(System.currentTimeMillis());
	
	public Hit(Integer topicId, Integer count
	,Date recordDate, Timestamp createDate, Timestamp updateDate) {
		this.topicId = topicId;
		this.count = count;
		this.recordDate = recordDate;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
	
	public Hit() {
		
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

	@Column(name = "[count]")
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Column(name = "recordDate")
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
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
		return "Hit [id=" + id + ", topicId=" + topicId + ", count=" + count + ", recordDate=" + recordDate
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
	
	

}

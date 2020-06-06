package com.happytail.general.model;

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
@Table(name = "CodeMap")
public class CodeMap {
	
	private Integer id;
	private String module;
	private String type;
	private String key;
	private String value;
	private Timestamp createDate = new Timestamp(System.currentTimeMillis());
	private Timestamp updateDate = new Timestamp(System.currentTimeMillis());
	
	public CodeMap(String module, String type, String key, String value
	,Timestamp createDate, Timestamp updateDate) {
		this.module = module;
		this.type = type;
		this.key = key;
		this.value = value;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
	
	public CodeMap() {
		
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

	@Column(name = "module")
	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	@Column(name = "type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "[key]")
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Column(name = "value")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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
		return "codeMap [id=" + id + ", module=" + module + ", type=" + type + ", key=" + key + ", value=" + value
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
	
}

package com.happytail.member.model;

import java.sql.Blob;
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
@Table(name = "PetMembers")
public class PetMembers {
	private Integer id;
	private String account;
	private String email;
	private String password;
	private String startCode;
	private String temporaryPassword;
	private String username;
	private String gender;
	private Integer age;
	private Date bday ;
	private String address;
	private String phone;
	private Blob memberImage;
	private String fileName;
	private Timestamp registerTime = new Timestamp(System.currentTimeMillis());
	private Timestamp updateDate;
//	private Timestamp updateDate = new Timestamp(System.currentTimeMillis());
	private Integer status = 0;

	public PetMembers(String account, 
			String email, String password, String username, 
			String gender, Integer age, Date bday, String address,
			String phone, Blob memberImage, Timestamp createDate,Timestamp updateDate) {
		this.account = account;
		this.email = email;
		this.password = password;
		this.username = username;
		this.gender = gender;
		this.age = age;
		this.bday = bday;
		this.address = address;
		this.phone = phone;
		this.memberImage = memberImage;
		this.registerTime = createDate;
		this.updateDate = updateDate;
	}

	public PetMembers() {
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer memberId) {
		this.id = memberId;
	}
	
	@Column(name = "account")
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "gender")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "age")
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Column(name = "bday")
	@JsonFormat(pattern="yyyy-MM-dd")
	public Date getBday() {
		return bday;
	}

	public void setBday(Date bday) {
		this.bday = bday;
	}
	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "memberImage")
	public Blob getMemberImage() {
		return memberImage;
	}

	public void setMemberImage(Blob memberImage) {
		this.memberImage = memberImage;
	}
	
	@Column(name = "createDate")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm")
	public Timestamp getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}
	
	@Column(name = "startCode")
	public String getStartCode() {
		return startCode;
	}

	public void setStartCode(String startCode) {
		this.startCode = startCode;
	}

	@Column(name = "temporaryPassword")
	public String getTemporaryPassword() {
		return temporaryPassword;
	}

	public void setTemporaryPassword(String temporaryPassword) {
		this.temporaryPassword = temporaryPassword;
	}
	
	@Column(name = "memberFileName")
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "updateDate")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm")
	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PetMembers [id=" + id + ", account=" + account + ", email=" + email + ", password=" + password
				+ ", username=" + username + ", gender=" + gender + ", age=" + age + ", bday=" + bday + ", address="
				+ address + ", phone=" + phone + ", memberImage=" + memberImage + ", createDate=" + registerTime
				+ ", updateDate=" + updateDate + ", status=" + status + "]";
	}

	
}

package com.practice.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "key_otp")
public class Otp implements Serializable{
	private static final long serialVersionUID = -7592533236162015146L;

	@Id
	@Column(name = "_key")
	private String key;
	
	@Column(name = "otp")
	private  Integer otp;
	
	@Column(name = "create_date")
	@DateTimeFormat(iso= DateTimeFormat.ISO.TIME)
	@JsonFormat(pattern = "dd-mm-yyyy HH:mm")
	private LocalDateTime createDate;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer getOtp() {
		return otp;
	}

	public void setOtp(Integer otp) {
		this.otp = otp;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	
	
}

package com.practice.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "salutation")
public class Salutation implements Serializable {
	private static final long serialVersionUID = 8963376107131855792L;

	@Id
	@GeneratedValue
	@Column(name = "salutation_id")
	private Integer salutationId;

	@Column(name = "salutation_value")
	private String salutationValue;

	@Column(name = "create_id")
	private Integer createId;

	@Column(name = "create_date")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm")
	private LocalDateTime createDate;

	@Column(name = "update_id")
	private Integer updateId;

	@Column(name = "update_date")
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm")
	private LocalDateTime updateDate;

	@Column(name = "is_active")
	private Integer isActive;

	@Transient
	private List<Userdetails> users;

	public Integer getSalutationId() {
		return salutationId;
	}

	public void setSalutationId(Integer salutationId) {
		this.salutationId = salutationId;
	}

	public String getSalutationValue() {
		return salutationValue;
	}

	public void setSalutationValue(String salutationValue) {
		this.salutationValue = salutationValue;
	}

	public List<Userdetails> getUsers() {
		return users;
	}

	public void setUsers(List<Userdetails> users) {
		this.users = users;
	}

	public Integer getCreateId() {
		return createId;
	}

	public void setCreateId(Integer createId) {
		this.createId = createId;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public Integer getUpdateId() {
		return updateId;
	}

	public void setUpdateId(Integer updateId) {
		this.updateId = updateId;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
}
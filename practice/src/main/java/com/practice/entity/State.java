package com.practice.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "state")
public class State implements Serializable {
	private static final long serialVersionUID = 6134455472163733172L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "state_id")
	private Integer stateId;

	@Column(name = "state_name")
	private String stateName;

	@Column(name = "country_id")
	private Integer countryId;

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
	private List<City> cities;

	@Transient
	private List<Address> addresses;

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
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
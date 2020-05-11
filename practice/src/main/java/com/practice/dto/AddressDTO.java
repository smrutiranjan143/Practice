package com.practice.dto;

import java.io.Serializable;

public class AddressDTO implements Serializable{
	private static final long serialVersionUID = -842564523191123791L;
	
	private String addressLine1;
	private String addressLine2;
	private Integer countryId;
	private Integer stateId;
	private Integer cityId;
	private Integer zip;
	private Integer userId;
	
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getZip() {
		return zip;
	}
	public void setZip(Integer zip) {
		this.zip = zip;
	}
	
}

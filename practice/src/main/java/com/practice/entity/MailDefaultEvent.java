package com.practice.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "mail_default_event")
public class MailDefaultEvent implements Serializable {
	private static final long serialVersionUID = -1406894686119284475L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "maildefaultevent_id")
	private Integer mailDefaultEventId;

	@Column(name = "event_desc")
	private String eventDescription;

	@Column(name = "event_body")
	private String eventBody;

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
	
	@OneToMany
	private List<MailDefaultParameter> defaultParameters;

	@OneToMany
	private List<MailDetails> mailDetails;

	public Integer getMailDefaultEventId() {
		return mailDefaultEventId;
	}

	public void setMailDefaultEventId(Integer mailDefaultEventId) {
		this.mailDefaultEventId = mailDefaultEventId;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getEventBody() {
		return eventBody;
	}

	public void setEventBody(String eventBody) {
		this.eventBody = eventBody;
	}

	public List<MailDefaultParameter> getDefaultParameters() {
		return defaultParameters;
	}

	public void setDefaultParameters(List<MailDefaultParameter> defaultParameters) {
		this.defaultParameters = defaultParameters;
	}

	public List<MailDetails> getMailDetails() {
		return mailDetails;
	}

	public void setMailDetails(List<MailDetails> mailDetails) {
		this.mailDetails = mailDetails;
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
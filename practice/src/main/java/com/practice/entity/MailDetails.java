package com.practice.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "mail_details")
public class MailDetails implements Serializable {
	private static final long serialVersionUID = 3664404090385946811L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mail_id")
	private Integer mailId;

	@Column(name = "maildefaultevent_id")
	private Integer mailDefaultEventId;

	@Column(name = "event_desc")
	private String eventDescription;

	@Column(name = "mail_body")
	private String mailBody;

	@Column(name = "mail_to")
	private String mailTo;

	@Column(name = "mail_cc")
	private String[] mailCC;

	@Column(name = "mail_bcc")
	private String[] mailBCC;

	@Column(name = "user_id")
	private Integer userId;

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

	public Integer getMailId() {
		return mailId;
	}

	public void setMailId(Integer mailId) {
		this.mailId = mailId;
	}

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

	public String getMailBody() {
		return mailBody;
	}

	public void setMailBody(String mailBody) {
		this.mailBody = mailBody;
	}

	public String getMailTo() {
		return mailTo;
	}

	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}

	public String[] getMailCC() {
		return mailCC;
	}

	public void setMailCC(String[] mailCC) {
		this.mailCC = mailCC;
	}

	public String[] getMailBCC() {
		return mailBCC;
	}

	public void setMailBCC(String[] mailBCC) {
		this.mailBCC = mailBCC;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
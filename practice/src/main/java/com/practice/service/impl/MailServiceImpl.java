package com.practice.service.impl;

import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.entity.MailDefaultEvent;
import com.practice.entity.MailDetails;
import com.practice.exception.ServiceException;
import com.practice.repository.MailDefaultEventRepo;
import com.practice.repository.MailDetailsRepo;
import com.practice.service.MailService;
import com.practice.util.PracticeConstants;
import com.practice.util.PracticeUtil;

@Service
public class MailServiceImpl implements MailService {
	Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);

	@Autowired
	private MailDefaultEventRepo mailDefaultEventRepo;
	
	@Autowired
	private MailDetailsRepo mailDetailsRepo;

	@Override
	public void sendMail(Map<String, Object> mapMailInfo, Map<String, Object> mapMailParameterInfo) {

		MailDefaultEvent mailDefaultEvent = null;
		Integer eventId = null;
		String mailTo = null;
		MailDetails mailDetails = new MailDetails();
		String mailBody = null;
		try {
			mailTo = (String) mapMailInfo.get(PracticeConstants.MAIL_TO);
			eventId = (Integer) mapMailInfo.get(PracticeConstants.MAIL_EVENT_ID);
			if (eventId != null && eventId != 0 && mailTo != null && !mailTo.isEmpty()) {
				mailDefaultEvent = mailDefaultEventRepo
						.findById((Integer) mapMailInfo.get(PracticeConstants.MAIL_EVENT_ID))
						.orElse(new MailDefaultEvent());
				mailBody = mailDefaultEvent.getEventBody();
				if (mailDefaultEvent != null) {
					if (mailBody != null && !mailBody.isEmpty()) {
						mailDetails.setMailDefaultEventId(eventId);
						mailDetails.setEventDescription(mailDefaultEvent.getEventDescription());
						mailDetails.setMailSubject(mailDefaultEvent.getEventSubject());
						mailDetails.setMailBody(mailBody);
						mailDetails.setMailTo(mailTo);
						if (mapMailInfo.get(PracticeConstants.MAIL_CC) != null) {
							mailDetails.setMailBCC((String[]) mapMailInfo.get(PracticeConstants.MAIL_CC));
						}
						if (mapMailInfo.get(PracticeConstants.MAIL_BCC) != null) {
							mailDetails.setMailBCC((String[]) mapMailInfo.get(PracticeConstants.MAIL_BCC));
						}
						mailDetails.setUserId((Integer) mapMailInfo.get(PracticeConstants.MAIL_USER_ID));
						mailDetails.setCreateId(PracticeConstants.DEFAULT_CREATE_ID);
						mailDetails.setCreateDate(PracticeUtil.getCurrentDateTime());
						mailDetails.setUpdateId(PracticeConstants.DEFAULT_CREATE_ID);
						mailDetails.setUpdateDate(PracticeUtil.getCurrentDateTime());
						mailDetails.setIsActive(PracticeConstants.ACTIVE_ROW);
					}
				}
				mailSend(PracticeConstants.MAIL_SENDING_USERNAME, PracticeConstants.MAIL_SENDING_PASSWORD, mailTo,
						mailDetails);
				mailDetailsRepo.save(mailDetails);
			} else {
				System.out.println("Please give event id and mail to");
			}
		} catch (ServiceException se) {
			logger.error("mail service impl", se);
		}
	}

	private static void mailSend(String username, String password, String mailTo, MailDetails mailDetails) {

		Properties props = new Properties();
		props.put(PracticeConstants.MAIL_SMTP_AUTH, PracticeConstants.TRUE);
		props.put(PracticeConstants.MAIL_SMTP_STARTTLS_ENABLE, PracticeConstants.TRUE);
		props.put(PracticeConstants.MAIL_SMTP_HOST, PracticeConstants.SMTP_GMAIL);
		props.put(PracticeConstants.MAIL_SMTP_PORT, PracticeConstants.GMAIL_PORT);

		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailTo));
			message.setSubject(mailDetails.getMailSubject());
			message.setText(mailDetails.getMailBody());

			Transport.send(message);
			System.out.println("message sent successfully");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
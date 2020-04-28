package com.practice.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface MailService {
	public void tryToSendMail(Map<String, Object> mapMailInfo,Map<String, Object> mapMailParameterInfo);
}
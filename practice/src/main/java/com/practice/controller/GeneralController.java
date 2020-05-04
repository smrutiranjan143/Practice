package com.practice.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/general")
public class GeneralController {

	@Autowired

	@GetMapping(value = "/getAuthorization")
	@ResponseBody
	public String getAuthorization(HttpServletRequest request, HttpServletResponse response) {
		StringBuffer sb = new StringBuffer();
		String str1 = null;
		String str2 = null;
		try {
			str1 = UUID.randomUUID().toString();
			str2 = UUID.randomUUID().toString();

			String[] strings = str1.split("-");
			String[] strings2 = str2.split("-");
			for (String str : strings) {
				sb.append(str);
			}
			for (String str : strings2) {
				sb.append(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

}
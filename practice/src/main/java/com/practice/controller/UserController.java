package com.practice.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.practice.dto.UserDTO;
import com.practice.exception.ServiceException;
import com.practice.service.GeneralService;
import com.practice.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private GeneralService generalService;

	@GetMapping(value = "/register")
	public String register(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("user", new UserDTO());
		return "register";
	}

	@PostMapping(value = "/register")
	@ResponseBody
	public ModelAndView insertUser(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute UserDTO userDTO) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("email", userDTO.getEmail());
		userService.insertUser(userDTO);
		mav.setViewName("validate-otp");
		return mav;
	}

	@PostMapping(value = "/validate-otp")
	public String validateOtp(@RequestParam("email") String email, @RequestParam("otp") Integer otp) {
		generalService.validateOtp(email, otp);
		return "success-registration";
	}

	@GetMapping(value = "/getAllUserCode")
	@ResponseBody
	public Map<String, Object> getAllUserCode(@ModelAttribute UserDTO userDTO) {
		Map<String, Object> userCodeMap = new HashMap<>();
		try {
			userCodeMap = userService.getAllUserCode();
		} catch (ServiceException e) {
			logger.error("error in " + logger.getName(), e);
		}
		return userCodeMap;
	}

	@PostMapping(value = "/isUserCodePresent")
	@ResponseBody
	public Boolean isUserCodePresent(@RequestParam("userCode") String usercode) {
		Boolean flag = false;
		try {
			Map<String, Object> userCodeMap = userService.getAllUserCode();
			if (userCodeMap != null && userCodeMap.size() > 0) {
				for (Map.Entry<String, Object> entry : userCodeMap.entrySet()) {
					if (entry.getKey().equals(usercode)) {
						flag = true;
					}
				}
			}
		} catch (ServiceException ex) {
			logger.error("error in", ex);
		}
		return flag;
	}

}
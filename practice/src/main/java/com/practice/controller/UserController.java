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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.practice.dto.UserDTO;
import com.practice.entity.Userdetails;
import com.practice.exception.ServiceException;
import com.practice.service.GeneralService;
import com.practice.service.MasterService;
import com.practice.service.UserService;
import com.practice.util.PracticeConstants;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private GeneralService generalService;
	
	@Autowired
	private MasterService masterService;

	@GetMapping(value = "/home")
	public String home() {
		return "home";
	}
	
	@GetMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@PostMapping(value="/login")
	public ModelAndView login(@RequestParam("userCode") String userCode, @RequestParam("password") String password) {
		Userdetails userdetails = null;
		ModelAndView mav = new ModelAndView();
		userdetails = userService.loggedInUser(userCode, password);
		if(userdetails != null) {
			mav.addObject("usercode", userdetails.getUserCode());
			mav.setViewName("profile");
		}
		else {
			mav.addObject("error", "Bad_Credentials");
			mav.setViewName("login");
		}
		return mav;
	}
	
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
	public ModelAndView validateOtp(@RequestParam("email") String email, @RequestParam("otp") Integer otp) {
		boolean flag = false;
		ModelAndView mav = new ModelAndView();
		flag = generalService.validateOtp(email, otp);
		if(flag) {
			mav.setViewName("success-registration");
		}
		else {
			mav.addObject("error", "Your_otp_is_incorrect");
			mav.addObject("email", email);
			mav.setViewName("validate-otp");
		}
		return mav;
	}
	
	@GetMapping(value = "/forgot-password")
	public String forgotPassword() {
		return"forgot-password";
	}
	
	@PostMapping(value = "/forgot-password")
	public ModelAndView forgotPasssword(@RequestParam("email") String email) {
		ModelAndView mav = new ModelAndView();
		Userdetails userdetails = null;
		userdetails = userService.getUserAndPasswordByEmail(email);
		if(userdetails != null) {
			mav.setViewName("login");
		}
		else {
			mav.addObject("error", "User Not Found");
			mav.setViewName("forgot-password");
		}
		return mav;
	}
	
	@GetMapping(value = "/logout")
	public String logout() {
		return "login";
	}
	
	@GetMapping(value = "/reset-password")
	public String resetPassword() {
		return "reset-password";
	}
	
	@PostMapping(value = "/reset-password")
	public ModelAndView resetPassword(@RequestParam("password")String password, @RequestParam("new_password")String newPassword) {
		ModelAndView mav = new ModelAndView();
		Integer updatedPassword = 0;
		updatedPassword = userService.resetPassword(password, newPassword);
		if(updatedPassword != 0) {
			mav.setViewName("login");
		}
		else {
			mav.addObject("error", "Invalid Password");
			mav.setViewName("reset-password");
		}
		return mav;
	}
	
	@GetMapping(value = "/address")
	public String address(ModelMap modelMap) {
		Integer isActive = PracticeConstants.ACTIVE_ROW;
		modelMap.put("countries",masterService.getCountries(isActive));
		return "address";
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
package com.training.FundTransferSystem.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.training.FundTransferSystem.dto.UserDTO;
import com.training.FundTransferSystem.entity.Login;
import com.training.FundTransferSystem.service.UserService;

@Controller
public class HomeController {

	@Autowired
	UserService userService;
	static Logger logger = Logger.getLogger(HomeController.class);

	private int userId;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String test(Model model) throws IOException {

		return "redirect:/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		logger.info("User about to login");
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());

		return mav;
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(@Valid @ModelAttribute("login") Login login, BindingResult theBindingResult) {
		ModelAndView mav = null;
		if (theBindingResult.hasErrors()) {
			return new ModelAndView("login");
		}
		UserDTO dto = userService.validateUser(login);

		if (dto != null) {
			userId = dto.getUserId();
			logger.info("logged in by user");
			mav = new ModelAndView("redirect:ListById/{userId}");
			mav.addObject("userId", dto.getUserId());
		} else {
			logger.info("Entered worng credential, login failed !!!");
			mav = new ModelAndView("login");
			mav.addObject("message", "Username or Password is wrong!!");
		}
		return mav;

	}
}

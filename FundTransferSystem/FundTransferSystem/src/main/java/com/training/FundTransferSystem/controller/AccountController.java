package com.training.FundTransferSystem.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.training.FundTransferSystem.dto.AccountDTO;
import com.training.FundTransferSystem.service.AccountService;
import com.training.FundTransferSystem.service.UserService;

@Controller
public class AccountController {
	@Autowired
	AccountService accountService;
	@Autowired
	UserService userService;
	private int userId;
	static Logger logger = Logger.getLogger(AccountController.class);

	@RequestMapping(value = "/ListById/{userId}", method = RequestMethod.GET)
	public String listAccountByID(@PathVariable("userId") int userId, Model model) {
		System.out.println("In account controller");
		AccountDTO accountDTO = accountService.getAccountDetails(userId);
		logger.info("showing account details of particular user");
		model.addAttribute("userId", userId);
		model.addAttribute("account", accountDTO);
		System.out.println("Got account Number =  " + accountDTO.getAccountNumber());
		return "account";
	}
}

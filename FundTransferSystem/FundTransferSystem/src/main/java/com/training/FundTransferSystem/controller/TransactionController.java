package com.training.FundTransferSystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.training.FundTransferSystem.dto.TransactionDTO;
import com.training.FundTransferSystem.entity.Transaction;
import com.training.FundTransferSystem.exception.BalanceException;
import com.training.FundTransferSystem.service.AccountService;
import com.training.FundTransferSystem.service.TransactionService;

@Controller
public class TransactionController {
	private Logger logger = Logger.getLogger(TransactionController.class);

	@Autowired
	TransactionService transactionService;

	@Autowired
	AccountService accountService;

	@RequestMapping(value = "ListById/openFundTransferPage", method = RequestMethod.GET)
	public ModelAndView listTransaction(@RequestParam int userId, Model model) {
		logger.info("About to transfer the funds");
		model.addAttribute("userId", userId);
		return new ModelAndView("transaction");
	}

	@RequestMapping(value = "ListById/saveTransaction", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@Valid @ModelAttribute TransactionDTO transaction, Model model,
			BindingResult result) throws BalanceException {
		ModelAndView mav = null;
		if (result.hasErrors()) {
			return new ModelAndView("transaction");
		}
		transaction.setTransactionStatus("debit");
		Transaction tr = transactionService.saveTransaction(transaction);
		if (tr != null) {
			logger.info("Funds transfered successfully");
			int userId = transaction.getUserId();
			model.addAttribute("userId", userId);
			System.out.println("User id in tran " + userId);
			mav = new ModelAndView("redirect:/ListById/{userId}");
		} else {
			mav = new ModelAndView("transaction");
			mav.addObject("message", "Please enter the required values");
		}
		return mav;
	}

	@RequestMapping(value = "ListById/transactionHistory/{userId}", method = RequestMethod.GET)
	public ModelAndView getTransactionHistory(@PathVariable("userId") int userId) {
		ModelAndView modelAndView = new ModelAndView("transactionHistory");
		List<TransactionDTO> transaction = transactionService.getStatement(userId);
		modelAndView.addObject("transaction", transaction);
		logger.info("Uploaded tranaction details of particular user");
		return modelAndView;
	}

}

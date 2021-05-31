package com.training.FundTransferSystem.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.FundTransferSystem.converter.AccountEntityToDTOConvertor;
import com.training.FundTransferSystem.dao.AccountDao;
import com.training.FundTransferSystem.dto.AccountDTO;
import com.training.FundTransferSystem.entity.Account;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDao accountDao;
	@Autowired
	private AccountEntityToDTOConvertor converter;

	@Override
	public AccountDTO getAccountDetails(int userId) {
		Account account = accountDao.getAccountDetails(userId);
		AccountDTO accountDTO = converter.convertAccountToDTO(account);
		return accountDTO;
	}

	@Override
	public void updateAccountDetailsl(Account account) {
		accountDao.updateAccountDetailsl(account);
	}

	@Override
	public Account getAccountDetailsByAccountNumber(String accountNumber) {
		return accountDao.getAccountDetailsByAccountNumber(accountNumber);
	}

}

package com.training.FundTransferSystem.service;

import com.training.FundTransferSystem.dto.AccountDTO;
import com.training.FundTransferSystem.entity.Account;

public interface AccountService {
	AccountDTO getAccountDetails(int userId);

	void updateAccountDetailsl(Account account);

	public Account getAccountDetailsByAccountNumber(String accountNumber);
}

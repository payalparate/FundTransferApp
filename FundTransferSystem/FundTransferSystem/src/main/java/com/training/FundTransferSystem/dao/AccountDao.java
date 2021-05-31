package com.training.FundTransferSystem.dao;

import com.training.FundTransferSystem.entity.Account;

public interface AccountDao {
	Account getAccountDetails(int userId);

	void updateAccountDetailsl(Account account);

	public Account getAccountDetailsByAccountNumber(String accountNumber);
}

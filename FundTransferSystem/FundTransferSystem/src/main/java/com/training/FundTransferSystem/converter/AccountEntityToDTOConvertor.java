package com.training.FundTransferSystem.converter;

import org.springframework.stereotype.Component;

import com.training.FundTransferSystem.dto.AccountDTO;
import com.training.FundTransferSystem.entity.Account;

@Component
public class AccountEntityToDTOConvertor {
	public AccountDTO convertAccountToDTO(Account account){
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setAccountId(account.getAccountId());
		accountDTO.setAccountNumber(account.getAccountNumber());
		accountDTO.setUserId(account.getUserId());
		accountDTO.setBalance(account.getBalance());
		return accountDTO;
	}
}

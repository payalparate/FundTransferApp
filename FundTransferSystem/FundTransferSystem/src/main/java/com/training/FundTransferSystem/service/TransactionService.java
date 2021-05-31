package com.training.FundTransferSystem.service;

import java.util.List;

import com.training.FundTransferSystem.dto.TransactionDTO;
import com.training.FundTransferSystem.entity.Transaction;
import com.training.FundTransferSystem.exception.BalanceException;

public interface TransactionService {
	Transaction saveTransaction(TransactionDTO transactionDTO) throws BalanceException;
	List<TransactionDTO> getStatement(int userId);

}

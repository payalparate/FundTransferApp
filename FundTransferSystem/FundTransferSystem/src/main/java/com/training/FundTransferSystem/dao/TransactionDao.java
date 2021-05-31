package com.training.FundTransferSystem.dao;

import java.util.List;

import com.training.FundTransferSystem.entity.Transaction;
import com.training.FundTransferSystem.exception.BalanceException;

public interface TransactionDao {
	Transaction saveTransaction(Transaction transaction) throws BalanceException;

	List<Transaction> getStatement(int userId);

}

package com.training.FundTransferSystem.converter;

import org.springframework.stereotype.Component;

import com.training.FundTransferSystem.dto.TransactionDTO;
import com.training.FundTransferSystem.entity.Transaction;

@Component
public class TransactionDTOToEntityConvertor {

	public Transaction convertDTOToEntity(TransactionDTO transactionDTO) {
		Transaction transaction = new Transaction();
		transaction.setTransactionId(transactionDTO.getTransactionId());
		transaction.setAccountNumber(transactionDTO.getAccountNumber());
		transaction.setDate(transactionDTO.getDate());
		transaction.setAmount(transactionDTO.getAmount());
		transaction.setTransactionStatus(transactionDTO.getTransactionStatus());
		transaction.setDescription(transactionDTO.getDescription());
		return transaction;

	}
}

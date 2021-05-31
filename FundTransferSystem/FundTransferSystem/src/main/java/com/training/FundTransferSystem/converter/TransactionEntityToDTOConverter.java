package com.training.FundTransferSystem.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.training.FundTransferSystem.dto.TransactionDTO;
import com.training.FundTransferSystem.entity.Transaction;

@Component
public class TransactionEntityToDTOConverter {
	 
		public List<TransactionDTO> convertEntityToDTO(List<Transaction> transactions) {
			List<TransactionDTO> dto = new ArrayList<TransactionDTO>();
			TransactionDTO transactionDTO = new TransactionDTO();
			for (Transaction transaction : transactions) {
				transactionDTO.setTransactionId(transaction.getTransactionId());
				transactionDTO.setAccountNumber(transaction.getAccountNumber());
				transactionDTO.setDate(transaction.getDate());
				transactionDTO.setAmount(transaction.getAmount());
				transactionDTO.setTransactionStatus(transaction.getTransactionStatus());
				transactionDTO.setDescription(transaction.getDescription());
				dto.add(transactionDTO);
			}
			return dto;
}
}

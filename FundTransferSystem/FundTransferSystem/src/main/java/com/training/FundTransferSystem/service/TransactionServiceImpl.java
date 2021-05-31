package com.training.FundTransferSystem.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.FundTransferSystem.converter.TransactionDTOToEntityConvertor;
import com.training.FundTransferSystem.converter.TransactionEntityToDTOConverter;
import com.training.FundTransferSystem.dao.TransactionDao;
import com.training.FundTransferSystem.dto.TransactionDTO;
import com.training.FundTransferSystem.entity.Transaction;
import com.training.FundTransferSystem.exception.BalanceException;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	TransactionDao transactionDao;
	@Autowired
	TransactionDTOToEntityConvertor converter1;
	@Autowired
	TransactionEntityToDTOConverter converter2;

	@Override
	public Transaction saveTransaction(TransactionDTO transactionDTO) throws BalanceException {
		Date utildate = new Date();
		java.sql.Date sqlDate = new java.sql.Date(utildate.getTime());
		transactionDTO.setDate(sqlDate);
		Transaction transaction = converter1.convertDTOToEntity(transactionDTO);
		return transactionDao.saveTransaction(transaction);

	}

	@Override
	public List<TransactionDTO> getStatement(int userId) {
		List<Transaction> transaction = transactionDao.getStatement(userId);
		List<TransactionDTO> dto = converter2.convertEntityToDTO(transaction);
		return dto;
	}

}

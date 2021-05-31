package com.training.FundTransferSystem.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.FundTransferSystem.entity.Account;
import com.training.FundTransferSystem.entity.Transaction;
import com.training.FundTransferSystem.exception.BalanceException;

@Repository
public class TransactionDaoImpl implements TransactionDao {

	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	private AccountDao accountDao;

	private Logger logger = Logger.getLogger(TransactionDaoImpl.class);

	@Override
	public Transaction saveTransaction(Transaction transaction) throws BalanceException {
		Session session = sessionFactory.openSession();
		org.hibernate.Transaction tran = session.beginTransaction();
		Account account = accountDao.getAccountDetails(transaction.getUserId());
		if (account.getBalance() < transaction.getAmount()) {
			throw new BalanceException("Insufficient Balance");
		}
		double newBalance = account.getBalance() - transaction.getAmount();
		account.setBalance(newBalance);
		accountDao.updateAccountDetailsl(account);

		Account benAccount = accountDao.getAccountDetailsByAccountNumber(transaction.getAccountNumber());
		if (benAccount == null) {
			logger.info("the benficiary account can't be null : " + transaction.getAccountNumber());
		} else {
			double newBalanceBen = benAccount.getBalance() + transaction.getAmount();
			benAccount.setBalance(newBalanceBen);
			logger.info("the benficiary account : " + benAccount.getAccountNumber());
			accountDao.updateAccountDetailsl(benAccount);

		}
		Transaction tr = new Transaction();
		tr.setAccountNumber(transaction.getAccountNumber());
		tr.setUserId(benAccount.getUserId());
		tr.setAmount(transaction.getAmount());
		tr.setDate(transaction.getDate());
		tr.setDescription(transaction.getDescription());
		tr.setTransactionStatus("credit");
		session.saveOrUpdate(tr);
		session.save(transaction);
		tran.commit();
		return transaction;

	}

	public List<Transaction> getStatement(int userId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Transaction t where t.userId = :userId");
		query.setInteger("userId", userId);
		System.out.println("did it");
		List<Transaction> transactions = query.list();
		return transactions;
	}

}

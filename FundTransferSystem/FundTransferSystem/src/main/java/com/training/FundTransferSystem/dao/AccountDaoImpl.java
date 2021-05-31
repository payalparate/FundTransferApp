package com.training.FundTransferSystem.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.training.FundTransferSystem.entity.Account;

@Repository
@EnableTransactionManagement
public class AccountDaoImpl implements AccountDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Account getAccountDetails(int userId) {
		Session session = sessionFactory.openSession();
		Account account = null;
		account = session.get(Account.class, userId);
		return account;
	}

	public Account getAccountDetailsByAccountNumber(String accountNumber) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("In getAccountDetailsByAccountNumber() method");
		SQLQuery query = session.createSQLQuery("select * from Account where accountNumber='" + accountNumber + "'");
		System.out.println("Query successfull");
		query.addEntity(Account.class);
		List<Account> accounts = query.list();
		if (accounts.isEmpty()) {
			return null;
		}
		Account account = accounts.get(0);
		return account;
	}

	@Override
	public void updateAccountDetailsl(Account account) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(account);
		transaction.commit();
		session.close();

	}

}

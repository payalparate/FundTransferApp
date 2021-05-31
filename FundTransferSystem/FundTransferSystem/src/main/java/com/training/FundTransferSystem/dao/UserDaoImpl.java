package com.training.FundTransferSystem.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.FundTransferSystem.entity.Login;
import com.training.FundTransferSystem.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public User validateUser(Login login) {
		Session session = sessionFactory.openSession();
		String sql = "select * from User where name='" + login.getName() + "' and password='" + login.getPassword()
				+ "'";

		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(User.class);
		List<User> list = query.list();

		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public User getUserByUserId(int userid) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		User user = (User) session.get(User.class, userid);
		return user;
	}

}

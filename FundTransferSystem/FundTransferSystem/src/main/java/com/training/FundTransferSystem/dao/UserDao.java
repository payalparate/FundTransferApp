package com.training.FundTransferSystem.dao;

import com.training.FundTransferSystem.entity.Login;
import com.training.FundTransferSystem.entity.User;

public interface UserDao {
	User validateUser(Login login);

	User getUserByUserId(int userid);

}

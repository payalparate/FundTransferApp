package com.training.FundTransferSystem.service;

import com.training.FundTransferSystem.dto.UserDTO;
import com.training.FundTransferSystem.entity.Login;
import com.training.FundTransferSystem.entity.User;

public interface UserService {
	UserDTO validateUser(Login login);
	UserDTO getUserByUserId(int userid);
}

package com.training.FundTransferSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.FundTransferSystem.converter.UserEntityToDTOConverter;
import com.training.FundTransferSystem.dao.UserDao;
import com.training.FundTransferSystem.dto.UserDTO;
import com.training.FundTransferSystem.entity.Login;
import com.training.FundTransferSystem.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	private UserEntityToDTOConverter converter;


	@Override
	public UserDTO validateUser(Login login) {
		User user = userDao.validateUser(login);
		if (user == null) {
			return null;
		}
		UserDTO userDTO = converter.convertUserTODTO(user);
		return userDTO;
	}

	@Override
	public UserDTO getUserByUserId(int userid) {
		User user = userDao.getUserByUserId(userid);
		UserDTO userDTO = converter.convertUserTODTO(user);
		return userDTO;
	}

}

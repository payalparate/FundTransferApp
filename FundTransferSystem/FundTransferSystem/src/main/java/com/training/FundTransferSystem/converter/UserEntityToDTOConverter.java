package com.training.FundTransferSystem.converter;

import org.springframework.stereotype.Component;

import com.training.FundTransferSystem.dto.UserDTO;
import com.training.FundTransferSystem.entity.User;

@Component
public class UserEntityToDTOConverter {
	public UserDTO convertUserTODTO(User user){
		if (user == null) {
			return null;
		}
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(user.getUserId());
		userDTO.setName(user.getName());
		userDTO.setPassword(user.getPassword());
		userDTO.setEmail(user.getEmail());
		return userDTO;
	}
}

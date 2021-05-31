package com.training.FundTransferSystem.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class UserDTO {

	private int userId;

	private String name;

	private String password;

	private String email;

}

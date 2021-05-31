package com.training.FundTransferSystem.entity;

import org.hibernate.validator.constraints.NotEmpty;

public class Login {
	@NotEmpty(message = "enter username")
	private String name;
	@NotEmpty(message = "enter password")
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

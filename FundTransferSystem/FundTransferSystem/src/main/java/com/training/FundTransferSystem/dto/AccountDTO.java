package com.training.FundTransferSystem.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AccountDTO {

	private int accountId;
	private String accountNumber;
	private int userId;
	private double balance;
}

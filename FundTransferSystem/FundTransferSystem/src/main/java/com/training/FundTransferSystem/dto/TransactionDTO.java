package com.training.FundTransferSystem.dto;

import java.util.Date;




import org.hibernate.validator.constraints.NotEmpty;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TransactionDTO {

	private int transactionId;
	@NotEmpty(message = "enter your account number")
	private String accountNumber;
	private Date date;
	private double amount;
	private String transactionStatus;
	private String description;
	private int userId;

}

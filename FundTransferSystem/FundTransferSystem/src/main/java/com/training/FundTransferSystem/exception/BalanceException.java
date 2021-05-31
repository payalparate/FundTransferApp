package com.training.FundTransferSystem.exception;

public class BalanceException extends Exception {
	
	String string;
	BalanceException()
	{
		System.out.println("Insufficient Balance");
	}

	public BalanceException(String string) {
		
		this.string = string;
	}

}

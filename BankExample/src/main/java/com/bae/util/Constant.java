package com.bae.util;

import com.bae.entity.Account;

public class Constant {
	
	public final static String PRODUCT_MESSAGE_QUEUE = "account-queue";

	public final static Account MOCK_ACCOUNT_1= new Account((long)1, "0123456789", "Bob", "Smith");
	public final static Account MOCK_ACCOUNT_2= new Account((long)2, "9876543210", "Jane", "Kiln");
}

package com.bae.service;

import java.util.Collection;

import com.bae.entity.Account;

public interface AccountService {

	Collection<Account> getAll();
	Account getAccount(Long id);
	String createAccount(Account account);
	String deleteAccount(Long id);
	String updateAccount(Account account);
	
}

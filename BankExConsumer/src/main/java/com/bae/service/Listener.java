package com.bae.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.bae.entity.Account;
import com.bae.repository.AccountRepository;

@Service
public class Listener {

	private AccountRepository mongoRepo;

	@Autowired
	public Listener(AccountRepository mongoRepo) {
		this.mongoRepo = mongoRepo;
	}

	@JmsListener(destination = "account-queue", containerFactory = "myFactory")
	public void receiveAccount(Account account) {
		System.out.println("Received Account:-  " + account.getAccountNumber());
		mongoRepo.insert(account);
	}
}

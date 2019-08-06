package com.bae.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bae.entity.Account;
import com.bae.service.AccountServiceImplementation;

@RestController
public class AccountController {

	private AccountServiceImplementation accountServ;
	@Autowired
	public AccountController(AccountServiceImplementation accountServ) {
		this.accountServ=accountServ;
	}

	@GetMapping(value="/getAll", produces="application/json")
	public Collection<Account> getAll() {
		return accountServ.getAll();
	}
	
	@GetMapping(value="/get/{id}", produces="application/json")
	public Account getAccount(@PathVariable("id") Long id) {
		return accountServ.getAccount(id);
	}
	
	@PostMapping(value="/createAccount", consumes="application/json")
	public String createAccount(@RequestBody Account account) {
		return accountServ.createAccount(account);
	}
	
	@DeleteMapping(value="/deleteAccount/{id}")
	public String deleteAccount(@PathVariable("id") Long id) {
		return accountServ.deleteAccount(id);
	}
	
	@PutMapping(value="/updateAccount", consumes="application/json")
	public String updateAccount(@RequestBody Account account) {
		return accountServ.updateAccount(account);
	}
	
}

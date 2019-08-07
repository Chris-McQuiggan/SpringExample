package com.bae.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bae.entity.Account;
import com.bae.repository.AccountRepository;
import com.bae.util.Constant;

@Service
public class AccountServiceImplementation implements AccountService {

	private AccountRepository accountRepo;
	private RestTemplate restTemplate;
    private JmsTemplate jmsTemplate;

	@Autowired
	public AccountServiceImplementation(AccountRepository accountRepo, RestTemplate restTemplate, JmsTemplate jmsTemplate) {
		this.accountRepo = accountRepo;
		this.restTemplate = restTemplate;
        this.jmsTemplate = jmsTemplate;
	}
	
	@Override
	public Collection<Account> getAll() {
		return accountRepo.findAll();
	}

	@Override
	public Account getAccount(Long id) {
		return accountRepo.findById(id).get();
	}

	@Override
	public String createAccount(Account account) {
		ResponseEntity<String> exchangeAccNum = restTemplate.exchange("http://localhost:8081/getAccountNumber/10",
				HttpMethod.GET, null, String.class);
		account.setAccountNumber(exchangeAccNum.getBody());
		accountRepo.save(account);
		ResponseEntity<String> exchangePrize = restTemplate.exchange(
				"http://localhost:8082/getPrize/" + exchangeAccNum.getBody(),
				HttpMethod.GET, null, String.class);
		
        jmsTemplate.convertAndSend(Constant.PRODUCT_MESSAGE_QUEUE, account);

		return exchangePrize.getBody();
	}

	@Override
	public String deleteAccount(Long id) {
		accountRepo.deleteById(id);
		return "Account Deleted";
	}

	@Override
	public String updateAccount(Account account) {
		if (accountRepo.existsById(account.getId())) {
			accountRepo.save(account);
			return ("Success");
		}
		return ("Failure");
	}
}
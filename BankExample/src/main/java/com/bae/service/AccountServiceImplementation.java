package com.bae.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bae.entity.Account;
import com.bae.repository.AccountRepository;

@Service
public class AccountServiceImplementation implements AccountService {

	private AccountRepository accountRepo;
	private RestTemplate restTemplate;

	@Autowired
	public AccountServiceImplementation(AccountRepository accountRepo, RestTemplate restTemplate) {
		this.accountRepo = accountRepo;
		this.restTemplate = restTemplate;
	}

	@Override
	public Collection<Account> getAll() {
		return accountRepo.findAll();
	}

	@Override
	public Account getAccount(Long id) {
		return accountRepo.findById(id).get();
	}

//	@Override
//	public String createAccount(Account account) {
//		char text = textGen();
//		String num = numGen(10);
//		String accountNumber = text + num;
//		account.setAccountNumber(accountNumber);
//		accountRepo.save(account);
//		return prizeGen(text, num);
//	}

	@Override
	public String createAccount(Account account) {
		ResponseEntity<String> exchangeAccNum = restTemplate.exchange("http://localhost:8081/getAccountNumber/10",
				HttpMethod.GET, null, String.class);
		account.setAccountNumber(exchangeAccNum.getBody());
		accountRepo.save(account);
		ResponseEntity<String> exchangePrize = restTemplate.exchange(
				"http://localhost:8082/getPrize/" + exchangeAccNum.getBody(),
				HttpMethod.GET, null, String.class);
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

//	public char textGen() {
//		Random r = new Random();
//		char randomChar = (char) (65 + r.nextInt(3));
//		return randomChar;
//	}
//
//	public String numGen(int digits) {
//		SecureRandom random = new SecureRandom();
//		int num = 0;
//		if (digits == 6) {
//			num = random.nextInt(1000000);
//		}
//		if (digits == 8) {
//			num = random.nextInt(100000000);
//		}
//		if (digits == 10) {
//			String num2 = String.format("%05d", random.nextInt(100000));
//			String num1 = String.format("%05d", random.nextInt(100000));
//			return num1 + num2;
//		}
//		String formatted = String.format("%0" + digits + "d", num);
//		return formatted;
//	}
//	
//	public String prizeGen(char text, String num) {
//		String prize="";
//		if(num.length()==6) {
//			if(text=='A') {
//				prize="Sorry, you didn't win anything";
//			}
//			if(text=='B') {
//				prize="$50";
//			}
//			if(text=='C') {
//				prize="$100";
//			}
//		}
//		if(num.length()==8) {
//			if(text=='A') {
//				prize="Sorry, you didn't win anything";
//			}
//			if(text=='B') {
//				prize="$500";
//			}
//			if(text=='C') {
//				prize="$750";
//			}
//		}
//		if(num.length()==10) {
//			if(text=='A') {
//				prize="Sorry, you didn't win anything";
//			}
//			if(text=='B') {
//				prize="$5000";
//			}
//			if(text=='C') {
//				prize="$10000";
//			}
//		}
//		return prize;
//	}

}

package com.bae;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.bae.entity.Account;
import com.bae.repository.AccountRepository;
import com.bae.service.AccountServiceImplementation;
import com.bae.util.Constant;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceImplementaionTests {

	@InjectMocks
	AccountServiceImplementation service;

	@Mock
	AccountRepository accountRepo;
	
	@Mock
	RestTemplate restTemplate;
	
	@Mock
	JmsTemplate jmsTemplate;

	@Test
	public void contextLoads() {
	}

	@Test
	public void getAllTest() {
		List<Account> MOCK_LIST = new ArrayList<>();
		MOCK_LIST.add(Constant.MOCK_ACCOUNT_1);
		MOCK_LIST.add(Constant.MOCK_ACCOUNT_2);
		Mockito.when(accountRepo.findAll()).thenReturn(MOCK_LIST);
		assertEquals(MOCK_LIST, service.getAll());
		Mockito.verify(accountRepo).findAll();
	}

	@Test
	public void getAccountTest() {
		Long id = (long) 1;
		Optional<Account> opt = Optional.of(Constant.MOCK_ACCOUNT_1);
		Mockito.when(accountRepo.findById(id)).thenReturn(opt);
		assertEquals(opt.get(), service.getAccount(id));
		Mockito.verify(accountRepo).findById(id);
	}
	
	@Ignore
	@Test
	public void createAccountTest() {
		Mockito.when(accountRepo.save(Constant.MOCK_ACCOUNT_1)).thenReturn(Constant.MOCK_ACCOUNT_1);
		assertNotNull(service.createAccount(Constant.MOCK_ACCOUNT_1));
		Mockito.verify(accountRepo).save(Constant.MOCK_ACCOUNT_1);
	}
	
	@Test
	public void createAccountRequestTest() {
		ResponseEntity<String> accNumber = new ResponseEntity<String>("B1234567890", HttpStatus.OK);
		
		Mockito.when(restTemplate.exchange("http://localhost:8081/getAccountNumber/10",
				HttpMethod.GET, null, String.class)).thenReturn(accNumber);
		
		ResponseEntity<String> prize = new ResponseEntity<String>("$5000", HttpStatus.OK);
		
		Mockito.when(restTemplate.exchange("http://localhost:8082/getPrize/B1234567890",
				HttpMethod.GET, null, String.class)).thenReturn(prize);
		assertEquals("$5000", service.createAccount(Constant.MOCK_ACCOUNT_1));
		Mockito.verify(accountRepo).save(Constant.MOCK_ACCOUNT_1);
	}
	
	@Test
	public void deleteAccountTest() {
		Long id = (long) 1;
		assertEquals("Account Deleted", service.deleteAccount(id));
		Mockito.verify(accountRepo).deleteById(id);
	}
	
	@Test
	public void updateAccountTestSuccess() {
		Long id = (long) 1;
		Mockito.when(accountRepo.existsById(id)).thenReturn(true);
		assertEquals("Success", service.updateAccount(Constant.MOCK_ACCOUNT_1));
		Mockito.verify(accountRepo).existsById(id);
		Mockito.verify(accountRepo).save(Constant.MOCK_ACCOUNT_1);
	}
	
	@Test
	public void updateAccountTestFailure() {
		Long id = (long) 1;
		Mockito.when(accountRepo.existsById(id)).thenReturn(false);
		assertEquals("Failure", service.updateAccount(Constant.MOCK_ACCOUNT_1));
		Mockito.verify(accountRepo).existsById(id);
	}

}

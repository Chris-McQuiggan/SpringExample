package com.bae;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.controller.AccountController;
import com.bae.entity.Account;
import com.bae.service.AccountServiceImplementation;
import com.bae.util.Constant;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountControllerTests {

	@InjectMocks
	AccountController controller;

	@Mock
	AccountServiceImplementation accountServ;

	@Test
	public void contextLoads() {
	}

	@Test
	public void getAllTest() {
		Collection<Account> MOCK_COLLECTION = new ArrayList<>();
		MOCK_COLLECTION.add(Constant.MOCK_ACCOUNT_1);
		MOCK_COLLECTION.add(Constant.MOCK_ACCOUNT_2);
		Mockito.when(accountServ.getAll()).thenReturn(MOCK_COLLECTION);
		assertEquals(MOCK_COLLECTION, controller.getAll());
		Mockito.verify(accountServ).getAll();
	}

	@Test
	public void getAccountTest() {
		Long id = (long) 1;
		Mockito.when(accountServ.getAccount(id)).thenReturn(Constant.MOCK_ACCOUNT_1);
		assertEquals(Constant.MOCK_ACCOUNT_1, controller.getAccount(id));
		Mockito.verify(accountServ).getAccount(id);
	}
	
	@Test
	public void createAccountTest() {
		Mockito.when(accountServ.createAccount(Constant.MOCK_ACCOUNT_1)).thenReturn("$10000");
		assertEquals("$10000", controller.createAccount(Constant.MOCK_ACCOUNT_1));
		Mockito.verify(accountServ).createAccount(Constant.MOCK_ACCOUNT_1);
	}
	
	@Test
	public void deleteAccountTest() {
		Long id = (long) 1;
		Mockito.when(accountServ.deleteAccount(id)).thenReturn("Account Deleted");
		assertEquals("Account Deleted", controller.deleteAccount(id));
		Mockito.verify(accountServ).deleteAccount(id);
	}
	
	@Test
	public void updateAccountTest() {
		Mockito.when(accountServ.updateAccount(Constant.MOCK_ACCOUNT_1)).thenReturn("Success");
		assertEquals("Success", controller.updateAccount(Constant.MOCK_ACCOUNT_1));
		Mockito.verify(accountServ).updateAccount(Constant.MOCK_ACCOUNT_1);
	}

}

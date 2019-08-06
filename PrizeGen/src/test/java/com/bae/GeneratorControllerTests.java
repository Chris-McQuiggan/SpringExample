package com.bae;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.controller.GeneratorController;
import com.bae.service.GeneratorServiceImplementation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneratorControllerTests {
	
	@InjectMocks
	GeneratorController controller;

	@Mock
	GeneratorServiceImplementation service;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void getAccountNumberTest() {
		String accNum = "B1234567890";
		Mockito.when(service.prizeGen(accNum)).thenReturn("$5000");
		assertEquals("$5000", controller.getAccountNumber(accNum));
		Mockito.verify(service).prizeGen(accNum);
	}
	

}

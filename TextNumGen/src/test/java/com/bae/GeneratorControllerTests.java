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
		int digit = 10;
		Mockito.when(service.textGen()).thenReturn('A');
		Mockito.when(service.numGen(digit)).thenReturn("1234567890");
//		Mockito.when(service.getAccountNumber(digit)).thenReturn("A1234567890");
		assertEquals("A1234567890", controller.getAccountNumber(digit));
		Mockito.verify(service).textGen();
		Mockito.verify(service).numGen(digit);
	}
	
}

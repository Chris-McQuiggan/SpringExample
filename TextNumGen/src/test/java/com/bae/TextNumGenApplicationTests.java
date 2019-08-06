package com.bae;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.service.GeneratorServiceImplementation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TextNumGenApplicationTests {

	@InjectMocks
	GeneratorServiceImplementation service;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void textGenTest() {
		assertThat(service.textGen(), anyOf(is('A'), is('B'), is('C')));
	}
	
	@Test
	public void prizeGen6Test() {
		assertEquals(6, service.numGen(6).length());
	}
	
	@Test
	public void prizeGen8Test() {
		assertEquals(8, service.numGen(8).length());
	}
	
	@Test
	public void prizeGen10Test() {
		assertEquals(10, service.numGen(10).length());
	}
	
	@Test
	public void prizeGen11Test() {
		assertEquals(11, service.numGen(11).length());
	}
	
//	@Test
//	public void getAccountNumberTest() {
//		assertEquals(11, service.getAccountNumber(10).length());
//		assertThat(service.getAccountNumber(10).charAt(0), anyOf(is('A'), is('B'), is('C')));
//	}

}

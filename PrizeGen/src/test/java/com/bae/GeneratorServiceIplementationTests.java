package com.bae;

import static org.junit.Assert.assertEquals;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.service.GeneratorServiceImplementation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneratorServiceIplementationTests {
	
	@InjectMocks
	GeneratorServiceImplementation service;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void prizeGen_A_Test() {
		String num = "A1234567890";
		assertEquals("Sorry, you didn't win anything", service.prizeGen(num));
	}
	
	@Test
	public void prizeGen_6B_Test() {
		String num = "B123456";
		assertEquals("$50", service.prizeGen(num));
	}
	
	@Test
	public void prizeGen_6C_Test() {
		String num = "C123456";
		assertEquals("$100", service.prizeGen(num));
	}
	
	@Test
	public void prizeGen_8B_Test() {
		String num = "B12345678";
		assertEquals("$500", service.prizeGen(num));
	}
	
	@Test
	public void prizeGen_8C_Test() {
		String num = "C12345678";
		assertEquals("$750", service.prizeGen(num));
	}
	
	@Test
	public void prizeGen_10B_Test() {
		String num = "B1234567890";
		assertEquals("$5000", service.prizeGen(num));
	}
	
	@Test
	public void prizeGen_10C_Test() {
		String num = "C1234567890";
		assertEquals("$10000", service.prizeGen(num));
	}

}

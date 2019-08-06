package com.bae.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bae.service.GeneratorServiceImplementation;

@RestController
public class GeneratorController {

	private GeneratorServiceImplementation service;
	@Autowired
	public GeneratorController(GeneratorServiceImplementation service) {
		this.service=service;
	}
	
	@GetMapping(value="/getAccountNumber/{digit}")
	public String getAccountNumber(@PathVariable("digit") int digit) {
		return service.textGen()+service.numGen(digit);
//		return service.getAccountNumber(digit);
	}
}

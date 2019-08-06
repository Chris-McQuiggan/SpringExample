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
	
	@GetMapping(value="/getPrize/{accNum}")
	public String getAccountNumber(@PathVariable("accNum") String accNum) {
		return service.prizeGen(accNum);
	}
}

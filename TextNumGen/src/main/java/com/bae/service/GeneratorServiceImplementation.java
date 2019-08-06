package com.bae.service;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class GeneratorServiceImplementation {

	public char textGen() {
		Random r = new Random();
		return (char) (65 + r.nextInt(3));
	}

	public String numGen(int digits) {
		SecureRandom random = new SecureRandom();
			if (digits % 2 != 0) {
				String num2 = String.format(
						"%0"+(int)Math.floor(0.5 * digits)+"d", 
						random.nextInt((int) Math.pow(10, Math.floor(0.5 * digits))));
				String num1 = String.format(
						"%0"+(int)(Math.floor(0.5 * digits)+1)+"d",
						random.nextInt((int) Math.pow(10, (Math.floor(0.5 * digits) + 1))));
				return num1 + num2;
			} else {
				String num2 = String.format(
						"%0"+(int)Math.floor(0.5 * digits)+"d", 
						random.nextInt((int) Math.pow(10, Math.floor(0.5 * digits))));
				String num1 = String.format(
						"%0"+(int)Math.floor(0.5 * digits)+"d", 
						random.nextInt((int) Math.pow(10, Math.floor(0.5 * digits))));
				return num1 + num2;
		}
	}
}

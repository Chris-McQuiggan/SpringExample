package com.bae.service;

import org.springframework.stereotype.Service;

@Service
public class GeneratorServiceImplementation {
	
	public String prizeGen(String num) {
		String prize="Sorry, you didn't win anything";
		if(num.length()==7) {
			if(num.charAt(0)=='B') {
				prize="$50";
			}
			if(num.charAt(0)=='C') {
				prize="$100";
			}
		}
		if(num.length()==9) {
			if(num.charAt(0)=='B') {
				prize="$500";
			}
			if(num.charAt(0)=='C') {
				prize="$750";
			}
		}
		if(num.length()==11) {
			if(num.charAt(0)=='B') {
				prize="$5000";
			}
			if(num.charAt(0)=='C') {
				prize="$10000";
			}
		}
		return prize;
	}
}

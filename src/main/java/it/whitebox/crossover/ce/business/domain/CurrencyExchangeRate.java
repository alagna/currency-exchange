package it.whitebox.crossover.ce.business.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor 
public class CurrencyExchangeRate {
	
	private String code;
	private String name;
	private double rate;
}

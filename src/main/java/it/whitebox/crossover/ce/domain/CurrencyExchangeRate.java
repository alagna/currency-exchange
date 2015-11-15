package it.whitebox.crossover.ce.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor 
public class CurrencyExchangeRate {
	
	private String code;
	private String name;
	private double value;
}

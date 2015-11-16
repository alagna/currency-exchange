package it.whitebox.crossover.ce.frontend.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Conversion {
	private String sourceCurrencyCode;
	private String targetCurrencyCode;
	double amount;
	double targetAmount;
}

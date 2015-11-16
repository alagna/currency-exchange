package it.whitebox.crossover.ce.integration;

import java.util.List;

import it.whitebox.crossover.ce.business.domain.CurrencyExchangeRate;

public interface ExchangeRateServiceItf {
	
	/**
	 * Get the latest exchange rates for all the supported currencies
	 * 
	 * @return
	 */
	public List<CurrencyExchangeRate> getLatestER();
	
	/**
	 * Get the code and description for all the supported currencies
	 * 
	 * @return
	 */
	public List<CurrencyExchangeRate> getAllCurrencies();

}

package it.whitebox.crossover.ce.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.whitebox.crossover.ce.business.domain.CurrencyExchangeRate;
import it.whitebox.crossover.ce.integration.ExchangeRateServiceItf;
import lombok.Setter;

/**
 * Business service containing the business logic of the Exchange server
 * 
 * @author alagna
 *
 */
@Service
public class CurrencyExchangeBusinessService {

	private static Logger log = Logger.getLogger(CurrencyExchangeBusinessService.class.getName());
	
	/**
	 * TODO choose which ExchangeRateService implementation to use
	 */
	@Autowired @Setter
	private ExchangeRateServiceItf exchangeRateService;
	
	/**
	 * Map containing all the currency codes and descriptions
	 */
	private Map<String, String> mapCurrencyCodeDescription = new HashMap<>();
	
	/**
	 * Search for the exchange rate for a specific currency
	 * 
	 * @param currencyCode
	 * @return
	 */
	public CurrencyExchangeRate getExchangeRate(String currencyCode){
		populateMap();
		
		if (!mapCurrencyCodeDescription.containsKey(currencyCode)){
			log.error("Currency code not found: " + currencyCode);
			return new CurrencyExchangeRate();
		}
		
		List<CurrencyExchangeRate> listCER = exchangeRateService.getLatestER();
		return getLastRate(currencyCode, listCER);
	}

	/**
	 * Completes the ExchangeRate with the value and the description
	 * 
	 * @param currencyCode
	 * @param listCER
	 * @return
	 */
	private CurrencyExchangeRate getLastRate(String currencyCode, List<CurrencyExchangeRate> listCER) {
		populateMap();
		for (CurrencyExchangeRate cer : listCER) {
			if (cer.getCode().equals(currencyCode)) {
				// it completes the CER with the name
				cer.setName(mapCurrencyCodeDescription.get(currencyCode));
				return cer;
			}
		}
		// this step will never been reached if the exchangeRateService provides always all the 
		// exchange rates
		return new CurrencyExchangeRate();
	}

	
	/**
	 * List of exchange rates for different currencies.
	 * 
	 * @param listCurrencyCodes
	 * @return
	 */
	public List<CurrencyExchangeRate> listExchangeRate(List<String> listCurrencyCodes){
		List<CurrencyExchangeRate> listCER = exchangeRateService.getLatestER();
		List<CurrencyExchangeRate> res = new ArrayList<>();
		for (String currencyCode : listCurrencyCodes) {
			CurrencyExchangeRate cer = getLastRate(currencyCode, listCER);
			if (cer.getName()!=null)
				res.add(cer);
		}
		return res;
	}
	

	
	/**
	 * Convert a specific amount of money from a currency to another
	 * 
	 * @param sourceCurrencyCode
	 * @param targetCurrencyCode
	 * @param amount
	 * @return
	 */
	public double convert(String sourceCurrencyCode, String targetCurrencyCode, double amount){
		CurrencyExchangeRate source = getExchangeRate(sourceCurrencyCode);
		if (source.getName()==null){
			log.error("Currency code " + sourceCurrencyCode + " not found");
			return -1;
		}
		CurrencyExchangeRate target = getExchangeRate(targetCurrencyCode);
		if (target.getName()==null){
			log.error("Currency code " + targetCurrencyCode + " not found");
			return -1;
		}

		double res = amount * target.getValue()/source.getValue();

		return res;
	}
	
	/**
	 * Populates the HashMap of the Currency code and descriptions
	 */
	private Map<String, String> populateMap(){
		if (mapCurrencyCodeDescription.size()==0) {
			List<CurrencyExchangeRate> listCE = exchangeRateService.getAllCurrencies();
			for (CurrencyExchangeRate currencyExchangeRate : listCE) {
				mapCurrencyCodeDescription.put(currencyExchangeRate.getCode(), 
					currencyExchangeRate.getName());
			}
		}
		return mapCurrencyCodeDescription;
	}
}

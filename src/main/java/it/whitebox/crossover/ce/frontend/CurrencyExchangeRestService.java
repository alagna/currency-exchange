package it.whitebox.crossover.ce.frontend;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.whitebox.crossover.ce.business.CurrencyExchangeBusinessService;
import it.whitebox.crossover.ce.business.domain.CurrencyExchangeRate;
import lombok.Setter;

/**
 * CurrencyExchange REST service.
 * 
 * It contains only the logic to convert the request parameters into Domain Objects and the response
 * Business Objects into the response.
 * The JSON magic happens here. 
 * 
 * @author alagna
 *
 */
@RestController
@RequestMapping(produces = "application/json")
public class CurrencyExchangeRestService {

	private static Logger log = Logger.getLogger(CurrencyExchangeRestService.class);
	
	@Autowired @Setter
	private CurrencyExchangeBusinessService buzService;

	/**
	 * Search for the exchange rate for a specific currency.
	 * 
	 * @param currency
	 * @return
	 */
	@RequestMapping(value="/api/getExchangeRate")
	public @ResponseBody CurrencyExchangeRate getExchangeRate(
		@RequestParam("currencyCode") String currencyCode){
		log.debug("getExchangeRate(" + currencyCode +")");
		
		CurrencyExchangeRate res = buzService.getExchangeRate(currencyCode);
		
		log.debug("  response: " + res);

		return res;
	}

	
	/**
	 * List of exchange rates for different currencies.
	 * 
	 * @param listCurrencyCodes
	 * @return
	 */
	@RequestMapping(value="/api/listExchangeRate")
	public @ResponseBody List<CurrencyExchangeRate> listExchangeRate(
			@RequestParam("currencyCodes") List<String> listCurrencyCodes){
		log.debug("listExchangeRate(" + listCurrencyCodes +")");
		
		List<CurrencyExchangeRate> listCER = buzService.listExchangeRate(listCurrencyCodes);
		
		log.debug("  response: " + listCER);

		return listCER;
	}
	

	
	/**
	 * Convert a specific amount of money from a currency to another
	 * 
	 * @param sourceCurrencyCode
	 * @param targetCurrencyCode
	 * @param amount
	 * @return
	 */
	@RequestMapping(value="/api/convert")
	public @ResponseBody double convert(
		@RequestParam("sourceCurrencyCode") String sourceCurrencyCode, 
		@RequestParam("targetCurrencyCode") String targetCurrencyCode, 
		@RequestParam("amount") double amount){
		log.debug("convert(" + sourceCurrencyCode +", " + targetCurrencyCode + ", " + amount+")");
		
		double res = buzService.convert(sourceCurrencyCode, targetCurrencyCode, amount);
		res = Math.floor(res * 100) / 100;
		log.debug(  "response: " + res);

		return res;
	}


}
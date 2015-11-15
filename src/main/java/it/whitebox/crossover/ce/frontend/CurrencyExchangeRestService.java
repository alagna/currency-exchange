package it.whitebox.crossover.ce.frontend;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import it.whitebox.crossover.ce.domain.CurrencyExchangeRate;

/**
 * CurrencyExchange REST service
 * 
 * @author alagna
 *
 */
@RestController
@RequestMapping(produces = "application/json")
public class CurrencyExchangeRestService {

	private static Logger log = Logger.getLogger(CurrencyExchangeRestService.class);
	
//	private ObjectMapper mapper = new ObjectMapper();
//	private	ObjectReader reader = mapper.reader(ConfigurazioneMissione.class);


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
		
		CurrencyExchangeRate res = new CurrencyExchangeRate("AAA", "name AAA", 12);
		
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
		
		CurrencyExchangeRate res = new CurrencyExchangeRate("AAA", "name AAA", 12);
		List<CurrencyExchangeRate> listCER = new ArrayList<>();
		listCER.add(res);
		listCER.add(res);

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

		return 23.27;
	}

//	@RequestMapping(method = RequestMethod.GET)
//	public @ResponseBody List<ConfigurazioneMissione> getConfigurazioneMissione(
//		@RequestParam("idMissione") String idMissione, 
//		@RequestParam("tipoOperazione") ConfigurazioneMissioneTipoOperazione tipoOperazione,
//		@RequestParam("idConfigurazione") String idConfigurazione
//	) {
//		log.start(logger, "getConfigurazioneMissione", true, "idMissione", idMissione, "tipoOperazione", 
//			tipoOperazione, "idConfigurazione", idConfigurazione);
//		
//		ConfigurazioneMissione cm = configManager.findConfigurazioneMissione(idMissione, tipoOperazione, idConfigurazione);
//		log.end(logger, "getConfigurazioneMissione", cm);
//		List<ConfigurazioneMissione> lRes = new ArrayList<ConfigurazioneMissione>();
//		lRes.add(cm);
//		return lRes;
//	}
	


}
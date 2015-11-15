package it.whitebox.crossover.ce.frontend;

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
//	public @ResponseBody List<ConfigurazioneMissione> getConfigurazioneMissione(
//		@RequestParam("idMissione") String idMissione, 
//		@RequestParam("tipoOperazione") ConfigurazioneMissioneTipoOperazione tipoOperazione,
//		@RequestParam("idConfigurazione") String idConfigurazione

	@RequestMapping(value="/api/getExchangeRate", method = RequestMethod.GET)
	public @ResponseBody String getExchangeRate(
		@RequestParam("currencyCode") String currencyCode){
		log.debug("getExchangeRate(" + currencyCode +")");
		return "aa";
	}

	
	/**
	 * List of exchange rates for different currencies.
	 * 
	 * @param listCurrencyCodes
	 * @return
	 */
	@RequestMapping(value="/api/listExchangeRate", method = RequestMethod.GET)
	public @ResponseBody List<CurrencyExchangeRate> listExchangeRate(
			@RequestParam("currencyCodes") List<String> listCurrencyCodes){
		return null;
	}
	

	
	/**
	 * Convert a specific amount of money from a currency to another
	 * 
	 * @param sourceCurrencyCode
	 * @param targetCurrencyCode
	 * @param amount
	 * @return
	 */
	@RequestMapping(value="/api/convert", method = RequestMethod.GET)
	public @ResponseBody double convert(
		@RequestParam("sourceCurrencyCode") String sourceCurrencyCode, 
		@RequestParam("targeteCurrencyCode") String targetCurrencyCode, 
		@RequestParam("amount") double amount){
		return 0;
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
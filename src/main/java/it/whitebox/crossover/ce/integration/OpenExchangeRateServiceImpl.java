package it.whitebox.crossover.ce.integration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.whitebox.crossover.ce.business.domain.CurrencyExchangeRate;

/**
 * The implementation of the ExchangeRateService based on the OpenExchangeRates provider,
 * which provides The Open Exchange Rates API provides hourly-updated exchange (forex) rates, 
 * relative to US Dollars (USD) in JSON format.
 * (see https://openexchangerates.org/)
 * 
 * @author alagna
 */
@Service
public class OpenExchangeRateServiceImpl implements ExchangeRateServiceItf {

	private static Logger log = Logger.getLogger(OpenExchangeRateServiceImpl.class);
	
	private static final String ENDPOINT = "https://openexchangerates.org/api/";
	private static final String LATEST_METHOD = "latest.json";
	private static final String CURRENCIES_METHOD = "currencies.json";
	private static final String APP_ID = "app_id=2b11faaa33f14c04afef1f031cf98520";

	
	/**
	 * Get the latest available exchange rates
	 * TODO put app_id into properties
	 * TODO manager null response
	 */
	@Override
	public List<CurrencyExchangeRate> getLatestER() {

		List<CurrencyExchangeRate> listCER = new ArrayList<>();
		
		try {
			String sRes = doGet(ENDPOINT + LATEST_METHOD + "?" + APP_ID);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode rootNode = mapper.readValue(sRes.getBytes(), JsonNode.class); 
			JsonNode rates = rootNode.get("rates");

			// converting the json result of openexchangerates.org
			for (Iterator<String> iCode = rates.fieldNames(); iCode.hasNext();){
				String code = iCode.next();
				double value = new Double(rates.findValue(code).asText());
				CurrencyExchangeRate rate = new CurrencyExchangeRate(
					code, null, new Double(value));
					listCER.add(rate);
			}
			
		} catch (Exception e){
			log.error("Error getting Exchange rates from openexchangerates.org: " + e.getMessage(), e);
		}
		return listCER;
	}

	/**
	 * Do a get request
	 * TODO manager not 200 response
	 * @return
	 */
	private String doGet(String targetUrl){
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(targetUrl);
		log.debug("GET " + targetUrl);
		
		try {
			CloseableHttpResponse response = httpclient.execute(httpGet);
		    int status = response.getStatusLine().getStatusCode();
		    HttpEntity entity = response.getEntity();
		    String sRes = EntityUtils.toString(entity);

		    EntityUtils.consume(entity);
		    response.close();
		    log.debug("  response: (" + status + ") " + sRes);
		    
		    return sRes;
		} catch (Exception e){
			log.error("Error connecting to the target exchange rate server: " + e.getMessage(), e);
			return null;
		}
	}

	/**
	 * Get all currencies (code and description)
	 */
	@Override
	public List<CurrencyExchangeRate> getAllCurrencies() {
		List<CurrencyExchangeRate> listCER = new ArrayList<>();
		
		try {
			String sRes = doGet(ENDPOINT + CURRENCIES_METHOD + "?" + APP_ID);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode rates = mapper.readValue(sRes.getBytes(), JsonNode.class); 

			// converting the json result of openexchangerates.org
			for (Iterator<String> iCode = rates.fieldNames(); iCode.hasNext();){
				String code = iCode.next();
				String description = rates.findValue(code).asText();
				CurrencyExchangeRate rate = new CurrencyExchangeRate(
					code, description, 0);
					listCER.add(rate);
			}
			
		} catch (Exception e){
			log.error("Error getting Exchange rates from openexchangerates.org: " + e.getMessage(), e);
		}
		return listCER;
	}
	
}

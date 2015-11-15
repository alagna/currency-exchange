package it.whitebox.crossover.ce.frontend;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * CurrencyExchange REST service
 * 
 * @author alagna
 *
 */
@RestController
@RequestMapping("/api/ce")
public class CurrencyExchangeRestService {

	private static Logger log = Logger.getLogger(CurrencyExchangeRestService.class);
	
//	private ObjectMapper mapper = new ObjectMapper();
//	private	ObjectReader reader = mapper.reader(ConfigurazioneMissione.class);


	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody String ping() {
		log.debug("Start");
		return "pong";
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
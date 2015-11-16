package it.whitebox.crossover.ce.frontend.response;

import it.whitebox.crossover.ce.business.domain.CurrencyExchangeRate;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Reasult of getExchangeRate
 * @author alagna
 *
 */
@Data @AllArgsConstructor
public class GetExchangeRateResponse {
	private CurrencyExchangeRate currencyExchange;
}

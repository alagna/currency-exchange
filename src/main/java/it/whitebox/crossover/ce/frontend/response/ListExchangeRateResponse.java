package it.whitebox.crossover.ce.frontend.response;

import java.util.ArrayList;
import java.util.List;

import it.whitebox.crossover.ce.business.domain.CurrencyExchangeRate;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Reasult of getExchangeRate
 * @author alagna
 *
 */
@Data @AllArgsConstructor
public class ListExchangeRateResponse {
	private List<CurrencyExchangeRate> currencyExchanges = new ArrayList<>();
}

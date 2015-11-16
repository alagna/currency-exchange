package it.whitebox.crossover.ce.integration;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test for the implementation of the ExchangeRateService based on the OpenExchangeRates provider
 * TODO write test instead of main
 * @author alagna
 *
 */
public class OpenExchangeRateServiceImplTest {

	public static void main(String[] args) {
		OpenExchangeRateServiceImpl client = new OpenExchangeRateServiceImpl();
		System.out.println("latest" + client.getLatestER());
		
		System.out.println("all" + client.getAllCurrencies());
	}
	
	@Test
	public void testGetLatest() {
		fail("Not yet implemented");
	}

}

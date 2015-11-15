package it.whitebox.crossover.ce.config;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Listener dello start del sistema: utilizzato per esempio per innescare il popolamento del db
 * @author alagna
 *
 */
@Component
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger log = Logger.getLogger(StartupListener.class);
		
	@Override
	public void onApplicationEvent(final ContextRefreshedEvent event) {		
		log.info("System startup finished.");
	}
}

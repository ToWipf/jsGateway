package org.wipf.jsGateway.logic.base;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import org.jboss.logging.Logger;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

/**
 * @author wipf
 *
 */
@ApplicationScoped
public class MainHome {

	private static final Logger LOGGER = Logger.getLogger("_MainHome_");
	public static final String VERSION = "0.0.1";

	/**
	 * Stop App
	 */
	public static void stopApp() {
		LOGGER.info("Stoppen...");
		Quarkus.asyncExit();
	}

	/**
	 * @param ev
	 */
	void onStart(@Observes StartupEvent ev) {
		LOGGER.info("Starte " + VERSION);
	}

	/**
	 * @param ev
	 */
	void onStop(@Observes ShutdownEvent ev) {
		LOGGER.info("Stoppe");
	}

}
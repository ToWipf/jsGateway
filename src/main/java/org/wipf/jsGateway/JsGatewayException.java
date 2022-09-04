package org.wipf.jsGateway;

import org.jboss.logging.Logger;

/**
 * @author wipf
 *
 */
public class JsGatewayException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger("Telegram Log");

	/**
	 * 
	 */
	JsGatewayException() {
		super("Wipf Exception");
	}

	/**
	 * @param s
	 */
	public JsGatewayException(String s) {
		LOGGER.error(s);
	}
}

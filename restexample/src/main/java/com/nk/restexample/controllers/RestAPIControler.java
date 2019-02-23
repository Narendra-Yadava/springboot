/**
 * 
 */
package com.nk.restexample.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Narendra.kumar
 *
 */
@RestController
public class RestAPIControler {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("hi")
	public String getName() {
		String res = "Hi Narendra Yadav";
		logger.debug("This is a debug message");
		logger.info("This is an info message");
		logger.warn("This is a warn message");
		logger.error("This is an error message");

		return res;
	}

}

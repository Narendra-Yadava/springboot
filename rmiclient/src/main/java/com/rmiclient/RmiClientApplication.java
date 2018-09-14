/***************************************************************************
 *  Copyright (C) Narendra-Yadava 2018
 *
 *  The reproduction, transmission or use of this document  or its contents
 *  is not  permitted without  prior express written consent of Narendra-Yadava.
 *  Offenders will be liable for damages. All rights, including  but not 
 *  limited to rights created by patent grant or registration of a utility
 *  model or design, are reserved.
 *
 *  Narendra-Yadava reserves the right to modify technical specifications and features.
 *
 *  Technical specifications and features are binding only in so far as they
 *  are specifically and expressly agreed upon in a written contract.
 *
 **************************************************************************/
package com.rmiclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import com.rmiserver.helloservice.IHelloWordService;

/**
 * RmiClientApplication.java
 *
 * @author Narendra.Kumar
 * @date Sep 13, 2018
 * @time 5:58:37 PM
 *
 */
@SpringBootApplication
public class RmiClientApplication {

	@Bean
	RmiProxyFactoryBean service() {
		RmiProxyFactoryBean rmiProxyFactory = new RmiProxyFactoryBean();
		rmiProxyFactory.setServiceUrl("rmi://localhost:1099/IHelloWordService");
		rmiProxyFactory.setServiceInterface(IHelloWordService.class);
		return rmiProxyFactory;
	}

	public static void main(String[] args) {
		IHelloWordService service = SpringApplication.run(RmiClientApplication.class, args)
				.getBean(IHelloWordService.class);
		String helloString = service.printHello();
		System.out.println("helloString : " + helloString);
	}

}

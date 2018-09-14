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
package com.rmiserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiServiceExporter;
	
import com.rmiserver.helloservice.HelloWordServiceImpl;
import com.rmiserver.helloservice.IHelloWordService;

/**
 * This class is used to initialized the spring boot and start the RMI server
 *
 * @author Narendra.Kumar
 * @date Sep 13, 2018
 * @time 5:49:01 PM
 *
 */
@SpringBootApplication
public class RMIServerApplication {
	@Bean
	public IHelloWordService bookingService() {
		return new HelloWordServiceImpl();
	}

	@Bean
	RmiServiceExporter exporter(IHelloWordService implementation) {

		// Expose a service via RMI. Remote obect URL is:
		// rmi://<HOST>:<PORT>/<SERVICE_NAME>
		// 1099 is the default port

		Class<IHelloWordService> serviceInterface = IHelloWordService.class;
		RmiServiceExporter exporter = new RmiServiceExporter();
		exporter.setServiceInterface(serviceInterface);
		exporter.setService(implementation);
		exporter.setServiceName(serviceInterface.getSimpleName());
		exporter.setRegistryPort(1099);
		return exporter;
	}

	public static void main(String[] args) {
		SpringApplication.run(RMIServerApplication.class, args);
	}
}

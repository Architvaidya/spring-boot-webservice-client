package com.webserviceclient.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CalculatorConfiguration {
    private static final Logger log = LoggerFactory.getLogger(CalculatorConfiguration.class);
    @Bean
    public Jaxb2Marshaller marshaller() {
        log.info("Inside marshaller");
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        log.info("Initialized Marshaller");
        marshaller.setContextPath("calculator.wsdl");
        log.info("Returning Marshaller, its hashvalue is: "+marshaller.hashCode());
        return marshaller;
    }

    @Bean
    public CalculatorClient calculatorClient(Jaxb2Marshaller marshaller) {

        log.info("Inside method calculatorClient, hashvalue of marshaller is: "+marshaller.hashCode());
        CalculatorClient client = new CalculatorClient();
        log.info("Created client");
        client.setDefaultUri("http://www.dneonline.com/calculator.asmx");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        log.info("Configured client, hashvalue of client is :  "+client.hashCode());
        return client;
    }

}

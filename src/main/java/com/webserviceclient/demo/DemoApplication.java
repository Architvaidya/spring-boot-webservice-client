package com.webserviceclient.demo;


import calculator.wsdl.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import calculator.wsdl.AddResponse;


@SpringBootApplication
@RestController
public class DemoApplication {

    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
	CalculatorClient client;

	public static void main(String[] args) {
	    log.info("DemoApplication started");
		SpringApplication.run(DemoApplication.class, args);
	}


    @Bean
    CommandLineRunner lookup(CalculatorClient calculatorClient) {
	    log.info("Inside lookup, hashvalue of calculatorClient is: "+calculatorClient.hashCode());
        return args -> {
            int a = 1;
            int b = 2;

            if (args.length > 0) {
                a = Integer.parseInt(args[0]);
                b = Integer.parseInt(args[1]);
            }
            this.client = calculatorClient;
            AddResponse response = calculatorClient.doAdd(a,b);
            System.err.println(response.getAddResult());
        };
    }



    @RequestMapping("/hello")
	public String sayHello(){
        int a,b;
        a = 3;
        b = 5;
		//client = new CalculatorClient();
		//client.AddResponse(a,b);

		return this.client.getTest(a,b);

	}
}

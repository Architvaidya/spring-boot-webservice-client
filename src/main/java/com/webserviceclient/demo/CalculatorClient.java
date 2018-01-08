package com.webserviceclient.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import calculator.wsdl.AddResponse;
import calculator.wsdl.Add;

public class CalculatorClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(CalculatorClient.class);

    public String getTest(int a, int b){
        doAdd(a,b);
        return "Reached client";
    }

    public AddResponse doAdd(int a, int b){
        Add addRequest = new Add();
        AddResponse addResponse;
        addRequest.setIntA(a);
        addRequest.setIntB(b);
        log.info("Value of A is set to "+addRequest.getIntA()+" value of B is set to "+addRequest.getIntB());
        addResponse = (AddResponse)getWebServiceTemplate().marshalSendAndReceive("http://www.dneonline.com/calculator.asmx?WSDL", addRequest, new SoapActionCallback("http://tempuri.org/Add"));
        log.info("Result is -> "+addResponse.getAddResult());
        return addResponse;

    }






}

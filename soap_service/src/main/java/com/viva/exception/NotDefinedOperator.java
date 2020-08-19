package com.viva.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM,customFaultCode = "{http://myexpr.com/expr}001_NOT_DEFINED_OPERATOR")
public class NotDefinedOperator extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotDefinedOperator(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}

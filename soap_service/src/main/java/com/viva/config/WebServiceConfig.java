package com.viva.config;

import java.util.Collections;
import java.util.List;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.security.xwss.XwsSecurityInterceptor;
import org.springframework.ws.soap.security.xwss.callback.SimplePasswordValidationCallbackHandler;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;


//Enable spring webservices
@EnableWs
//Spring Configuration
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter{
	@Bean
	public ServletRegistrationBean messageDispatcherServelet(ApplicationContext context) {
		MessageDispatcherServlet messageDispatcherServlet=new MessageDispatcherServlet();
		messageDispatcherServlet.setApplicationContext(context);
		messageDispatcherServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(messageDispatcherServlet,"/ws/*");
	}


	//  /ws/course.wsdl

	// course-details.xsd

	@Bean(name="expression")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema exprSchema) {
		DefaultWsdl11Definition defination=new DefaultWsdl11Definition();
		// PotType - coursePort
		defination.setPortTypeName("ExpressionPort");
		// Namespace - http://mysoapexample.com/course
		defination.setTargetNamespace("http://myexpr.com/expr");
		// /ws
		defination.setLocationUri("/ws");		
		//schema
		defination.setSchema(exprSchema);

		return defination;
	}


	@Bean
	public XsdSchema courseSchema() {
		return new SimpleXsdSchema(new ClassPathResource("expr-detail.xsd"));
	}


/*	  
	  <Header> 
	  <wsse:Security xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd" mustUnderstand="1"> 
	  <wsse:UsernameToken> 
	  <wsse:Username>vikrant.dhakde</wsse:Username>
	  <wsse:Password>1234</wsse:Password> 
	  </wsse:UsernameToken>
	  </wsse:Security> 
	  </Header>
	 
*/

	@Bean
	public XwsSecurityInterceptor securityInterceptor() {
		XwsSecurityInterceptor securityInterceptor=new XwsSecurityInterceptor();
		//callback Handler ->SimplePasswordValidationCallbackHandeler
		securityInterceptor.setCallbackHandler(callbackHandler());
		//Security policy ->securityPolicy.xml
		securityInterceptor.setPolicyConfiguration(new ClassPathResource("securityPolicy.xml"));
		return securityInterceptor;
	}


	private SimplePasswordValidationCallbackHandler callbackHandler() {
		SimplePasswordValidationCallbackHandler handler=new SimplePasswordValidationCallbackHandler();
		handler.setUsersMap(Collections.singletonMap("vikrant.dhakde","1234"));
		return handler;
	}


	//Interceptor.add -> XwsSecurityInteceptor
	@Override
	public void addInterceptors(List<EndpointInterceptor> interceptors) {
		// TODO Auto-generated method stub
		interceptors.add(securityInterceptor());
	}







}

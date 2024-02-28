package com.soap.webservice.soapcoursemanagement.soap;

import java.util.List;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

// Enable Spring Web Service
@EnableWs

// Spring Configuration
@Configuration
public class WebSpringConfig extends WsConfigurerAdapter {

	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
		MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
		messageDispatcherServlet.setApplicationContext(context);
		messageDispatcherServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<MessageDispatcherServlet>(messageDispatcherServlet, "/ws/*");
	}

	// create wsdl from schema xsd
	// /ws/courses.wsdl 1) PortType - CoursePort 2) namespace =
	// "https://course-details/course"
	// course-detials.xsd

	@Bean
	public XsdSchema courseSchema() {
		return new SimpleXsdSchema(new ClassPathResource("course-details.xsd"));
	}

	@Bean(name = "courses")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema courseSchema) {
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();

		definition.setPortTypeName("CoursePort");
		definition.setTargetNamespace("https://course-details/course");
		definition.setLocationUri("/ws");
		definition.setSchema(courseSchema);

		return definition;
	}

	@Bean
	public Wss4jSecurityInterceptor securityInterceptor() {
		Wss4jSecurityInterceptor wss4jSecurityInterceptor = new Wss4jSecurityInterceptor();
		wss4jSecurityInterceptor.setSecurementActions("UsernameToken");
		wss4jSecurityInterceptor.setSecurementUsername("username");
		wss4jSecurityInterceptor.setSecurementPassword("password");
		return wss4jSecurityInterceptor;
	}

	@Override
	public void addInterceptors(List<EndpointInterceptor> interceptors) {
		interceptors.add(securityInterceptor());
	}

}

package com.sudhanshu.rest.webservice.restfulwebservices.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	// give url as /demo-rest-api
	// show demo rest api

	// @RequestMapping(method = RequestMethod.GET, path = "/demo-rest-api")
	// better way to do is with @GetMapping

	@GetMapping(path = "/demo-rest-api")
	public String demoRest() {
		return "Demo of Rest API";
	}
	
	// above method return string back in http body
	// but most of Rest API returns JSON back
	
	@GetMapping(path = "/demo-rest-api-bean")
	public DemoRestBean demoRestBean() {
		return new DemoRestBean("Demo of Rest API");
	}
	
	// path parameter
	// /user/{id}/todo/{id}
	// /user/2/todo/200 or /demo-rest-api-bean/sudhanshu
	
	@GetMapping(path = "/demo-rest-api-bean/{name}")
	public DemoRestBean demoRestPathVariable(@PathVariable String name) {
		return new DemoRestBean("Demo of Rest API "+ name);
	}
	

}

package com.example.springboot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseConfigurationController {
	@Autowired
	private CourseServiceConfiguration csConfig;

	@RequestMapping("/course-service")
	public CourseServiceConfiguration retriveAllConfigs() {
		return this.csConfig;

	}
}

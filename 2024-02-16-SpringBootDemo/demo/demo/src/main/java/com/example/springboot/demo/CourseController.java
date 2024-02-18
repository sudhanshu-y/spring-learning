package com.example.springboot.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

	@RequestMapping("/courses")
	public List<Course> retriveAllCourses() {
		return Arrays.asList(
				new Course(1, "Spring Boot", "Udemy"), 
				new Course(2, "REST API", "Coursera"),
				new Course(3, "Big Data", "Udacity"),
				new Course(4, "GraphQL", "Udemy"),
				new Course(5, "API Trends", "Udemy")
				);
	}
}

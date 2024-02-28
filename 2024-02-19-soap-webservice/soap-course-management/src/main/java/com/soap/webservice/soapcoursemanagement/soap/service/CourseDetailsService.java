package com.soap.webservice.soapcoursemanagement.soap.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.soap.webservice.soapcoursemanagement.soap.bean.Courses;

@Component
public class CourseDetailsService {
	// find course by id
	// get all courses
	// delete course with id
	
	public enum Status{
		SUCCESS, FAILURE
	}

	private static List<Courses> courses = new ArrayList<>(Arrays.asList(new Courses(1, "SOAP API", "Udemy"),
			new Courses(2, "REST API", "Udacity"), new Courses(3, "Spring Boot", "Coursera"),
			new Courses(4, "Java", "Udemy"), new Courses(5, "DSA", "GFG")));

	public Courses getCourseById(int id) {
		for (Courses course : courses) {
			if (course.getId() == id) {
				return course;
			}
		}
		return null;
	}

	public List<Courses> getAllCourses() {
		return courses;
	}

	public Status deleteCourseById(int id) {
		Iterator<Courses> itr = courses.iterator();
		while (itr.hasNext()) {
			Courses c = itr.next();
			if (c.getId() == id) {
				itr.remove();
				return Status.SUCCESS;
			}
		}
		return Status.FAILURE;
	}

}

package com.soap.webservice.soapcoursemanagement.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.soap.webservice.soapcoursemanagement.soap.bean.Courses;
import com.soap.webservice.soapcoursemanagement.soap.exception.CourseNotFoundException;
import com.soap.webservice.soapcoursemanagement.soap.service.CourseDetailsService;
import com.soap.webservice.soapcoursemanagement.soap.service.CourseDetailsService.Status;

import https.course_details.course.CourseDetails;
import https.course_details.course.DeleteCourseDetailsRequest;
import https.course_details.course.DeleteCourseDetailsResponse;
import https.course_details.course.GetAllCourseDetailsRequest;
import https.course_details.course.GetAllCourseDetailsResponse;
import https.course_details.course.GetCourseDetailsRequest;
import https.course_details.course.GetCourseDetailsResponse;

@Endpoint
public class CourseDetailEndPoint {

	@Autowired
	CourseDetailsService service;

	// Write a method which takes
	// input as GetCourseDetailsRequest
	// output GetCourseDetailsResponse
	// namespace = https://course-details/course

	@PayloadRoot(namespace = "https://course-details/course", localPart = "GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {
		Courses course = service.getCourseById(request.getId());

		if (course == null) {
			throw new CourseNotFoundException("Invalid Id" + request.getId());
		}

		return mapCourseDetails(course);
	}

	private GetCourseDetailsResponse mapCourseDetails(Courses course) {
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();

		CourseDetails courseDetails = mapCourse(course);

		response.setCourseDetails(courseDetails);

		return response;
	}

	private CourseDetails mapCourse(Courses course) {
		CourseDetails courseDetails = new CourseDetails();

		courseDetails.setId(course.getId());
		courseDetails.setName(course.getName());
		courseDetails.setDescription(course.getDescription());
		
		return courseDetails;
	}

	@PayloadRoot(namespace = "https://course-details/course", localPart = "GetAllCourseDetailsRequest")
	@ResponsePayload
	public GetAllCourseDetailsResponse processAllCourseDetailsRequest(@RequestPayload GetAllCourseDetailsRequest request) {
		List<Courses> courses = service.getAllCourses();
		return mapAllCourses(courses);
	}

	private GetAllCourseDetailsResponse mapAllCourses(List<Courses> courses) {
		GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
		for (Courses c : courses) {
			CourseDetails mapCourses = mapCourse(c);
			response.getCourseDetails().add(mapCourses);
		}
		return response;
	}
	
	@PayloadRoot(namespace = "https://course-details/course", localPart = "DeleteCourseDetailsRequest")
	@ResponsePayload
	public DeleteCourseDetailsResponse deleteCourseDetailsRequest(@RequestPayload DeleteCourseDetailsRequest request) {
		Status status = service.deleteCourseById(request.getId());

		DeleteCourseDetailsResponse response = new DeleteCourseDetailsResponse();
		response.setStatus(mapStatus(status));
		return response;
	}

	private https.course_details.course.Status mapStatus(Status status) {
		if (status == Status.FAILURE) {
			return https.course_details.course.Status.FAILURE;
		}
		return https.course_details.course.Status.SUCCESS;
	}

}

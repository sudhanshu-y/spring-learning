# spring-learning
>**2024-02-16-SpringBootDemo**

1) Spring Boot - Rapid application development
2) Sample REST API using Spring Boot
3) Spring initializer: https://start.spring.io/
4) initializer: Maven Project & Dependency: Spring Web
5) Class: CourseController --> retrives all course information & Class: Course - contains getters & setters of course id, name and source.
6) @RestController Annotation --> CourseController

The @RestController annotation in Spring is a specialised version of the @Controller annotation, specifically designed for building RESTful web services. Combines @Controller and @ResponseBody: Data returned by any method is written directly to the HTTP response body in a format like JSON or XML, without the need for explicit annotation on each method. It enables the class to handle incoming HTTP requests (GET, POST, PUT, DELETE) and generate appropriate responses.
7) @RequestMapping Annotation --> CourseController method List<Course> retriveAllCourses()

It defines the URL path that triggers a particular method in your controller. It acts as a bridge between URLs and the code that handles those requests. It allows handling different request types (GET, POST, etc.) and URL patterns efficiently.

8) http://localhost:8080/courses
9) Spring Boot Auto configuration: 
It automatically configures various aspects of our application based on the libraries we include in our classpath. Reduces boilerplate code & Flexible and customizable.

Enable auto-configuration by adding the @SpringBootApplication or @EnableAutoConfiguration annotation to the main configuration class (**DemoApplication**).

Ex: 

i) Spring Boot Starter Web: automatically configure an embedded web server like Tomcat, Default Error page, Bean to JSON conversion.

ii) Messaging: By including a messaging library like RabbitMQ, Spring Boot will automatically configure a message broker.

10) Spring Logging:

application.properties --> By default info

logging.level.org.springframework=debug

11) Spring Boot DevTools 
Provides features like automatic restart, live reload, and remote debugging. Need to add the spring-boot-devtools dependency to the project.

Note: For code/configuration changes, Server restart is not required. But for pom.xml dependency changes, server restart is required. 

12) Spring Application Configuration using Profiles

Spring Profiles offer a powerful way to manage and customise your application's configuration for different environments (development, test, production, etc.). 
Profile-specific properties files:

Create files named application-{profile}.properties (e.g., application-dev.properties). Properties specific to a profile are defined in its corresponding file.
Common properties can be defined in application.properties.

Environment variables and system properties: Set **spring.profiles.active** variable with active profile(s).

Link: http://localhost:8080/course-service

13) Spring Boot Embedded Servers

Eliminates the need for standalone web servers like Tomcat/Jetty/Undertow. Embedded Server is already part of the jar generated. 

14) Spring Actuator 

It is a powerful tool that helps you monitor and manage Spring Boot applications. 

Provides number of endpoints:

beans - complete list of spring beans in application

health - application health information 

metrics - application metrics

mapping - details of request mapping

For Dev Env application.properties: management.endpoints.web.exposure.include=*

For Prod/Prod Like env application.properties: management.endpoints.web.exposure.include=health,info

Link: http://localhost:8080/actuator

15) Spring vs Spring MVC vs Spring Boot

Spring: The comprehensive foundation, offering modules for various functionalities like dependency injection, data access, web development, security, and more.

Spring MVC: A module within Spring, specifically designed for building web applications using the Model-View-Controller (MVC) pattern.

Spring Boot: An opinionated approach built on top of Spring, promoting rapid application development. Especially used for Rapid application development.





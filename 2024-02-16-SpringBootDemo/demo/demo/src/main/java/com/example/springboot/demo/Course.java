package com.example.springboot.demo;

public class Course {
	private int id;
	private String course;
	private String source;

	public Course(int id, String course, String source) {
		super();
		this.id = id;
		this.course = course;
		this.source = source;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", course=" + course + ", source=" + source + "]";
	}

}

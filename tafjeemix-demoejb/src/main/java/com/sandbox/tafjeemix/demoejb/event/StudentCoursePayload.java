package com.sandbox.tafjeemix.demoejb.event;

import com.sandbox.tafjeemix.demojar.Course;
import com.sandbox.tafjeemix.demojar.Student;

/**
 * This class is used to define the payload for a student/course based event.
 * This allows us to pass both a student and a course at the same time as one
 * object.
 * 
 * @author Andy Gibson
 * 
 */
public class StudentCoursePayload {

	private Student student;
	private Course course;

	public StudentCoursePayload() {

	}

	public StudentCoursePayload(Student student, Course course) {
		super();
		this.student = student;
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}

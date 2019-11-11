package com.course.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.courses.Course;
import com.course.courses.CourseRepositry;

@RestController
public class ApplicationController {
	
	@Autowired
	private CourseRepositry courseRepositry;
	
	public void initCourses() {
		List<Course> currCourses = new ArrayList<>(Arrays.asList( new Course("Java" , "Java course" , "Java description"),
				   									new Course("JavaScript", "JavaScript course", "JavaScript description"),
				   									new Course("Rust" , "Rust course" , "Rust description")));
		
		for(Course course : currCourses) {
			courseRepositry.save(course);
		}
	}
	
	@RequestMapping("/")
	public String getDefaultResponse() {
		initCourses();
		return "Hello World";
	}
	
	
}

package com.course.courses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
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
	
	@GetMapping("/courses")
	public List<Course> getCourses() {
		List<Course> courses = new ArrayList<>();
		courseRepositry.findAll().forEach(courses::add);
		
		return courses;
	}
	
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		if(courseId == null) return null;
		
		Optional<Course> course = courseRepositry.findById(courseId);
		if(course.isPresent()) return course.get();
		
		return null;
	}
	
	@PostMapping("/courses")
	public boolean addCourse(@RequestBody Course course) {
		if(course == null) return false;
		courseRepositry.save(course);
		
		return true;
	}
	
	@PutMapping("/courses")
	public boolean updateCourse(@RequestBody Course course) {
		if(course == null) return false;
		courseRepositry.save(course);
		
		return false;
	}
	
}

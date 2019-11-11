package com.course.application;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.course.courses.CourseController;

@SpringBootApplication
@ComponentScan(basePackages = { "com.course.application","com.course.courses"})
@EntityScan(basePackages = { "com.course.application","com.course.courses"})
@EnableJpaRepositories(basePackages = {"com.course.courses"})
public class CourseApiDataApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CourseApiDataApplication.class, args);
	}
	
}

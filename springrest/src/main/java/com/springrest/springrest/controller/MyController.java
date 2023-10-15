package com.springrest.springrest.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Courses;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {

	@Autowired
	private CourseService courseService;
	
	
	@GetMapping("/home")
	public String home() {
		
		
		return "hello my friends ! this is home page";
	}
	
	//get courses
	
	@GetMapping("/courses")
	public List<Courses> getCourses(){
		return courseService.getCourses();
		
	}
	
	// get course using id
	
	@GetMapping("/courses/{courseId}")
	public Courses getCourse(@PathVariable String courseId) {
		return courseService.getCourse(Long.parseLong(courseId));
		
	}
	
	//add course
	@PostMapping("/courses")
	public Courses addCourse(@RequestBody Courses course) {
		return this.courseService.addCourse(course);
		
		
	}
	
	// update course using id
	@PutMapping("courses")
	public Courses updateCourse(@RequestBody Courses course) {
		
		return this.courseService.updateCourse(course);
		
	}
	
	
	// delete course using id
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> delCourse(@PathVariable String courseId) {
		try {
	    this.courseService.delCourse(Long.parseLong(courseId));
		return new ResponseEntity<>(HttpStatus.OK);
		
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}

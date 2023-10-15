package com.springrest.springrest.services;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Courses;


@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;
	
	
	
	/*
	 * List<Courses> list;
	 * 
	 * public CourseServiceImpl() { list=new ArrayList<>(); list.add(new
	 * Courses(120,"hibernate","use instead of jdbc")); list.add(new
	 * Courses(123,"spring boot","for creating entreprise applications"));
	 * 
	 * }
	 */
	@Override
	public List<Courses> getCourses() {
		
		return courseDao.findAll();
	}

	
	// for get single course using courseId
	
	@Override
	public Courses getCourse(long courseId) {
		
		/*
		 * for(Courses c:list) {
		 * 
		 * if (c.getId()==courseId) { return c;
		 * 
		 * } }
		 */
      
       return courseDao.getOne(courseId);
       
	}

	// for add new course
	@Override
	public Courses addCourse(Courses course) {
		
		
		/*
		 * // list.add(course);
		 */		
		courseDao.save(course);	
		return course;
	}

	// for update course
	@Override
	public Courses updateCourse(Courses course) {
		/*
		 * for(Courses c:list) { if(c.getId()==course.getId()) {
		 * c.setTitle(course.getTitle()); c.setDescription(course.getDescription());
		 * 
		 * } }
		 */
		courseDao.save(course);
	    return course;
	}
	
	// for delete course 
	@Override
	public Courses delCourse(long courseId) {

		
		/*
		 * for(Courses c:list) {
		 * 
		 * if (c.getId()==courseId) { list.remove(c); return c;
		 * 
		 * } }
		 */
	   Courses entity=courseDao.getOne(courseId);
       courseDao.delete(entity);
       return entity;
       
	}
	
	
	

}









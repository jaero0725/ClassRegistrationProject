package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.CourseDao;
import kr.ac.hansung.model.Course;

@Service
public class CourseService {
	
	@Autowired
	private CourseDao courseDao;
	
	public List <Course> getCurrent(){
		return courseDao.getCourses();
	}

	//그룹별로 보는함수.
	public List<Course> getGroupCurrent() {
		return courseDao.getGroupCourses();
	}
	
	public List<Course> getSemesterCurrent(String year, String semester) {
		return courseDao.getSemesterCourses(year, semester);
	}
	
	public void insert(Course course) {
		courseDao.insert(course);
	}
}

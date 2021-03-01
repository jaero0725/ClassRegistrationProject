package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.Course;
import kr.ac.hansung.service.CourseService;

@Controller
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/courses/semester")
	public String showSemesterCourses(@RequestParam String year,
										@RequestParam String semester, Model model) {
		List <Course> courses = courseService.getSemesterCurrent(year, semester);
		model.addAttribute("courses", courses);
		
		return "semester"; //view를 만들어준다.
	}
	
	//첫화면, 그룹 단위로 볼수 있는 화면
	@RequestMapping("/courses")
	public String showSemesterCourses(Model model) {
		List <Course> courses = courseService.getGroupCurrent();
		model.addAttribute("courses", courses);
		return "courses"; //view를 만들어준다.
	}
	

	//2021학년도 1학기 수강 신청조회.
	@RequestMapping("/signLookup")
	public String showSign(@RequestParam String year,
			@RequestParam String semester, Model model) {
		List <Course> courses = courseService.getSemesterCurrent(year, semester);
		model.addAttribute("courses", courses);
		
		return "signLookup"; //view를 만들어준다.
	}

	
	//수강신청 웹페이지들어가기
	@RequestMapping("/sign")
	public String sign(Model model) {
		model.addAttribute("course", new Course()); //data buffering 
		return "sign"; //view를 만들어준다. 웹폼을 만든다. 
	}
	
	//수강신청  Db에 저장. data validation 필요
	@RequestMapping("/docreate")
	public String docreate(Model model, @Valid Course course, BindingResult result) { //DB에 저장해야함
		if(result.hasErrors()) {
			System.out.println("== Form data does not validated ==");
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error:errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "sign"; //다시 입력을 받게 보냄
		}
		
		courseService.insert(course); //수강신청하기.
		return "signSuccess"; //view를 만들어준다. 웹폼을 만든다. 
	}
}

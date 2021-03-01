package kr.ac.hansung.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	//private static final Logger logger = LoggerFactory.getLogger("kr.ac.hansung.controller.HomeController");

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		
		//trace -> debug -> info -> warn -> error
//		logger.trace("Trace Level");
//		logger.debug("debug Level");
//		logger.info("info Level");
//		logger.warn("warn Level");
//		logger.error("error Level");
		
		String url = request.getRequestURI().toString();
		String clientIPaddr = request.getRemoteAddr();
		
		logger.info("Request URL : {}, Client IP: {}", url, clientIPaddr);
		
		
		return "home";
	}
}

package com.co.kr.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.co.kr.vo.UserVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(UserVO userVO, HttpSession session) {
		
//		userVO userId = 서비스타서 정보가져오기
//		if(userId.isResult()) {
			session.setAttribute("svo", "userId");
			session.setAttribute("userNm", "userNm");
//		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/index");
		return mv;
	}
	
	@RequestMapping(value = "/board.do", method = RequestMethod.GET)
	public ModelAndView board(UserVO userVO, HttpSession session) {
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/board");
		return mv;
	}	
	
}

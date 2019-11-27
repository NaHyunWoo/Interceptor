package com.co.kr.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.co.kr.vo.UserVO;

public class Interceptor extends HandlerInterceptorAdapter {

	// 컨트롤러가 실행되기 전 호출됨: 세션 객체를 체크
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			HttpSession session = request.getSession();
			UserVO userId = (UserVO) session.getAttribute("svo");
			
			System.out.println("userId::::"+userId);
			
			// userId 없을때.. login.do로 이동
			if(userId == null) {
				response.sendRedirect("/login.do");
				return false;
			}
			
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}




	
	
}

# Interceptor

	Interceptor.class
	
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
	
	
	servlet-context.xml
	
	<!-- interceptor 생성 -->
	<beans:bean id="interceptor" class="com.co.kr.interceptor.Interceptor"/>
	
	<interceptors>
		<interceptor>
			<!-- /board.do를 요청하면  -->
			<mapping path="/board.do"/>
			<!-- 27줄에 선언한 인터셉터를 타라 -->
			<beans:ref bean="interceptor"/>
		</interceptor>
	</interceptors>
// 파일 삭제 (스프링꺼씀) 
/*
package com.ssamz.web.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 모든 .do 요청(버튼클릭)에 대해 실행되도록 web.xml 에 등록함, service() 무조건 실행  
public class DispatcherServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private HandlerMapping handlerMapping;    
	// .do 요청 받을때마다 HandlerMapping 객체 생성 (모든 컨트롤러 생성하여 Map에 등록) 하지 않고 딱 한번만 생성되도록 service() 안에 X
	
	// 서블릿 객체 생성된 직후 호출되는 메서드 
	public void init() throws ServletException {
		handlerMapping = new HandlerMapping();       // notNullPointException 
	}
	
	// .do 요청마다 실행되는 메서드 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));     // 사용자 요청 uri로부터 path(~.do 형태) 정보 추출  
		System.out.println("요청 path : " + path);
		
		// HandlerMapping handlerMapping = new HandlerMapping();      // 각 path와 Controller 객체가 매핑된 객체 
		Controller ctrl = handlerMapping.getController(path);      // path에 해당하는 Controller 객체 반환  
		
		String viewName = ctrl.handleRequest(request, response);    // 반환된 Controller 객체 실행 후 문자열 반환 (~.jsp 형태)   

		// 반환한 문자열을 브라우저에 출력 (화면이동 포워드 방식) 
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
		dispatcher.forward(request, response);
	}

}
*/












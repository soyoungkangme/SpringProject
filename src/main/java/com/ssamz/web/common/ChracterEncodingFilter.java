// 파일 삭제 

package com.ssamz.web.common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;

// 서블릿이 실행되기 전후처리 
public class ChracterEncodingFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L; // 노란줄 없애기
	private String encoding;

//    public ChracterEncodingFilter() {
//        super();
//    }

//	public void destroy() {
//	}

	
	// FilterConfig 객체로 로컬 파라미터 값 추출 = 멤버변수 encoding init()에서 초기화 
	public void init(FilterConfig fConfig) throws ServletException {
		encoding = fConfig.getInitParameter("encoding");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(encoding);      // 서블릿 실행되기 직전 인코딩 처리 
		chain.doFilter(request, response);
	}

}

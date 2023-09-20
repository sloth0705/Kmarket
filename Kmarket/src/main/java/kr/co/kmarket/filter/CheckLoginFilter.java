package kr.co.kmarket.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.kmarket.dto.MemberDTO;

// web.xml로 filter-mapping
public class CheckLoginFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = -4987767003943486524L;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpSession session = ((HttpServletRequest) request).getSession();
		MemberDTO sessMember = (MemberDTO) session.getAttribute("sessMember");
		
		if (sessMember != null) // 로그인 상태
			chain.doFilter(request, response);
		else
			((HttpServletResponse) response).sendRedirect("/Kmarket/member/login.do?success=101");
	}
}

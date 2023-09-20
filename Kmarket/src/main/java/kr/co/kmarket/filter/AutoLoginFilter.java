package kr.co.kmarket.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.co.kmarket.dto.MemberDTO;
import kr.co.kmarket.service.MemberService;

// web.xml로 filter-mapping
public class AutoLoginFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = -5860127056836840227L;
	private MemberService service = MemberService.INSTANCE;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpSession session = ((HttpServletRequest) request).getSession();
		MemberDTO sessMember = (MemberDTO) session.getAttribute("sessMember");
		
		// 쿠키 가져오기
		Cookie[] cookies = ((HttpServletRequest) request).getCookies();
		
		// 로그인 정보가 없는데 쿠키가 존재한다면 = 자동로그인처리
		if (cookies != null && sessMember == null)
		{
			for (Cookie tempCookie : cookies)
			{
				if (tempCookie.getName().equals("memberCookie"))
				{
					MemberDTO dto = service.selectCookie(tempCookie.getValue());
					
					session.setAttribute("sessMember", dto); // 자동로그인 정보 추가
				}
			}
		}
		
		chain.doFilter(request, response);
	}
}

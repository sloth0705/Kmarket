package kr.co.kmarket.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.kmarket.dto.MemberDTO;
import kr.co.kmarket.service.MemberService;

@WebServlet("/member/register.do")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = -8565694525391581478L;
	private MemberService service = MemberService.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String type = req.getParameter("type");
		if (type.equals("normal"))
		{
			RequestDispatcher dispatcher = req.getRequestDispatcher("/member/register.jsp");
			dispatcher.forward(req, resp);
		}
		else if (type.equals("seller"))
		{
			RequestDispatcher dispatcher = req.getRequestDispatcher("/member/registerSeller.jsp");
			dispatcher.forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uid       = req.getParameter("uid");
		String pass      = req.getParameter("pass1");
		String name      = req.getParameter("name");
		String gender    = req.getParameter("gender");
		String hp        = req.getParameter("hp");
		String email     = req.getParameter("email");
		String type      = req.getParameter("type");
		String level     = req.getParameter("level");
		String zip       = req.getParameter("zip");
		String addr1     = req.getParameter("addr1");
		String addr2     = req.getParameter("addr2");
		String company   = req.getParameter("company");
		String ceo       = req.getParameter("ceo");
		String bizRegNum = req.getParameter("bizRegNum");
		String comRegNum = req.getParameter("comRegNum");
		String tel       = req.getParameter("tel");
		String manager   = req.getParameter("manager");
		String managerHp = req.getParameter("managerHp");
		String fax       = req.getParameter("fax");
		String regip     = req.getRemoteAddr();
		
		MemberDTO dto = new MemberDTO();
		dto.setUid(uid);
		dto.setPass(pass);
		dto.setName(name);
		dto.setGender(gender);
		dto.setHp(hp);
		dto.setEmail(email);
		dto.setType(type);
		dto.setLevel(level);
		dto.setZip(zip);
		dto.setAddr1(addr1);
		dto.setAddr2(addr2);
		dto.setCompany(company);
		dto.setCeo(ceo);
		dto.setBizRegNum(bizRegNum);
		dto.setComRegNum(comRegNum);
		dto.setTel(tel);
		dto.setManager(manager);
		dto.setManagerHp(managerHp);
		dto.setFax(fax);
		dto.setRegip(regip);
		
		service.insertMember(dto);
		resp.sendRedirect("/Kmarket/member/login.do");
	}
}

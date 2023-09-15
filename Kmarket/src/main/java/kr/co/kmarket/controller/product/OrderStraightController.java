package kr.co.kmarket.controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dto.MemberPointDTO;
import kr.co.kmarket.dto.ProductDTO;
import kr.co.kmarket.dto.ProductOrderDTO;
import kr.co.kmarket.dto.ProductOrderItemDTO;
import kr.co.kmarket.service.ProductOrderService;
import kr.co.kmarket.service.MemberPointService;
import kr.co.kmarket.service.MemberService;
import kr.co.kmarket.service.ProductOrderItemService;
import kr.co.kmarket.service.ProductService;

@WebServlet("/product/orderStraight.do")
public class OrderStraightController extends HttpServlet {
	private static final long serialVersionUID = -757054072708392597L;
	private ProductService pService = ProductService.INSTANCE;
	private ProductOrderService poService = ProductOrderService.INSTANCE;
	private ProductOrderItemService piService = ProductOrderItemService.INSTANCE;
	private MemberService mService = MemberService.INSTANCE;
	private MemberPointService mpService = MemberPointService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prodNo = req.getParameter("prodNo");
		String count = req.getParameter("count");
		ProductDTO product = pService.selectProduct(prodNo);
		req.setAttribute("product", product);
		req.setAttribute("count", count);
		logger.info("orderStraight product : " + product);
		req.getRequestDispatcher("/product/orderStraight.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ordUid = req.getParameter("uid");
		String count = req.getParameter("count");
		String ordCount = req.getParameter("ordCount");
		String ordPrice = req.getParameter("ordPrice");
		String ordDiscount = req.getParameter("ordDiscount");
		String ordDelivery = req.getParameter("ordDelivery");
		String ordTotPrice = req.getParameter("ordTotPrice");
		String usedPoint = req.getParameter("usedPoint"); 
		String userPoint = req.getParameter("userPoint");
		String recipName = req.getParameter("recipName"); 
		String recipHp = req.getParameter("recipHp"); 
		String recipZip = req.getParameter("recipZip"); 
		String recipAddr1 = req.getParameter("recipAddr1"); 
		String recipAddr2 = req.getParameter("recipAddr2"); 
		String ordPayment = req.getParameter("ordPayment"); 
		String prodNo = req.getParameter("prodNo");
		
		ProductOrderDTO dto = new ProductOrderDTO();
		dto.setOrdUid(ordUid);
		dto.setOrdCount(ordCount);
		dto.setOrdPrice(ordPrice);
		dto.setOrdDiscount(ordDiscount);
		dto.setOrdDelivery(ordDelivery);
		dto.setOrdTotPrice(ordTotPrice);
		dto.setUsedPoint(usedPoint);
		dto.setRecipName(recipName);
		dto.setRecipHp(recipHp);
		dto.setRecipZip(recipZip);
		dto.setRecipAddr1(recipAddr1);
		dto.setRecipAddr2(recipAddr2);
		dto.setOrdPayment(ordPayment);
		
		int ordNo = poService.insertProductOrder(dto);
		ProductOrderItemDTO piDto = new ProductOrderItemDTO();
		piDto.setOrdNo(ordNo);
		piDto.setProdNo(prodNo);
		piDto.setCount(count);
		piService.insertProductOrderItem(piDto);
		if (Integer.parseInt(usedPoint) > 0) {
			MemberPointDTO mp = new MemberPointDTO();
			mp.setOrdNo(ordNo);
			mp.setUid(ordUid);
			mp.setPoint(Integer.parseInt(usedPoint) * - 1);
			mpService.insertMemberPoint(mp);
		}
		if (Integer.parseInt(userPoint) > 0) {
			MemberPointDTO mp = new MemberPointDTO();
			mp.setOrdNo(ordNo);
			mp.setUid(ordUid);
			mp.setPoint(Integer.parseInt(userPoint) * Integer.parseInt(count));
			mpService.insertMemberPoint(mp);
			mService.savePoint(ordUid, Integer.parseInt(userPoint) * Integer.parseInt(count));
		}
		mService.usePoint(ordUid, usedPoint);
		
		resp.sendRedirect("/Kmarket/product/complete.do?ordNo=" + ordNo);
	}
}
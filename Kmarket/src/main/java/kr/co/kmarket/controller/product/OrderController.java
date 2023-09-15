package kr.co.kmarket.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dto.MemberPointDTO;
import kr.co.kmarket.dto.ProductCartDTO;
import kr.co.kmarket.dto.ProductOrderDTO;
import kr.co.kmarket.dto.ProductOrderItemDTO;
import kr.co.kmarket.service.MemberPointService;
import kr.co.kmarket.service.MemberService;
import kr.co.kmarket.service.ProductCartService;
import kr.co.kmarket.service.ProductOrderItemService;
import kr.co.kmarket.service.ProductOrderService;

@WebServlet("/product/order.do")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = -8655047175919956311L;
	private ProductCartService cService = ProductCartService.INSTANCE;
	private ProductOrderService poService = ProductOrderService.INSTANCE;
	private ProductOrderItemService piService = ProductOrderItemService.INSTANCE;
	private MemberService mService = MemberService.INSTANCE;
	private MemberPointService mpService = MemberPointService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] cartNos = req.getParameterValues("chk");
		StringBuilder sb = new StringBuilder("(");

		for (int i = 0; i < cartNos.length; i++) {
			sb.append(cartNos[i]);
			if (i < cartNos.length - 1) {
				sb.append(", ");
			}
		}
		sb.append(")");
		String in = sb.toString();
		logger.info("order in : " + in);
		List<ProductCartDTO> carts = cService.selectCheckedProductCarts(in);
		req.setAttribute("carts", carts);
		logger.info("order carts : " + carts.size());
		req.getRequestDispatcher("/product/order.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ordUid = req.getParameter("uid");
		String ordCount = req.getParameter("ordCount");
		String ordPrice = req.getParameter("ordPrice");
		String ordDiscount = req.getParameter("ordDiscount");
		String ordDelivery = req.getParameter("ordDelivery");
		String ordTotPrice = req.getParameter("ordTotPrice");
		String usedPoint = req.getParameter("usedPoint");
		String recipName = req.getParameter("recipName");
		String recipHp = req.getParameter("recipHp");
		String recipZip = req.getParameter("recipZip");
		String recipAddr1 = req.getParameter("recipAddr1");
		String recipAddr2 = req.getParameter("recipAddr2");
		String ordPayment = req.getParameter("ordPayment");

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

		// 주문 생성 후 주문번호 반환
		int ordNo = poService.insertProductOrder(dto);

		String[] prodNos = req.getParameterValues("prodNo");
		String[] counts = req.getParameterValues("count");
		String[] cartNos = req.getParameterValues("cartNo");
		String[] userPoints = req.getParameterValues("userPoint");
		for (int i = 0; i < counts.length; i++) {
			ProductOrderItemDTO piDto = new ProductOrderItemDTO();
			piDto.setOrdNo(ordNo);
			piDto.setProdNo(prodNos[i]);
			piDto.setCount(counts[i]);
			
			// 주문 물품 생성
			piService.insertProductOrderItem(piDto);

			// 주문한 장바구니 삭제
			cService.deleteProductCart(Integer.parseInt(cartNos[i]));
			
			int userPoint = Integer.parseInt(userPoints[i]);
			// 해당 물품의 포인트가 0 초과일 때
			if (userPoint > 0) {
				MemberPointDTO mp = new MemberPointDTO();
				mp.setOrdNo(ordNo);
				mp.setUid(ordUid);
				mp.setPoint(userPoint * Integer.parseInt(counts[i]));
				// 포인트 이력에 추가
				mpService.insertMemberPoint(mp);
				// 해당 회원 포인트 추가
				mService.savePoint(ordUid, userPoint * Integer.parseInt(counts[i]));
			}
		}
		// 사용 포인트가 0 초과일 때
		if (Integer.parseInt(usedPoint) > 0) {
			MemberPointDTO mp = new MemberPointDTO();
			mp.setOrdNo(ordNo);
			mp.setUid(ordUid);
			mp.setPoint(Integer.parseInt(usedPoint) * - 1);
			
			// 해당 회원 포인트 이력에 감소 추가
			mpService.insertMemberPoint(mp);
		}
		// 해당 회원 포인트 감소
		mService.usePoint(ordUid, usedPoint);
		resp.sendRedirect("/Kmarket/product/complete.do?ordNo=" + ordNo);
	}
}
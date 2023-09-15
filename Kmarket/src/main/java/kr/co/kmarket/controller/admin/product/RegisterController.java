package kr.co.kmarket.controller.admin.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oreilly.servlet.MultipartRequest;

import kr.co.kmarket.dto.ProductDTO;
import kr.co.kmarket.service.ProductService;

@WebServlet("/admin/product/register.do")
public class RegisterController extends HttpServlet{
	private static final long serialVersionUID = -575977800525097241L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private ProductService service = ProductService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/product/register.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String prodCate1Value = req.getParameter("prodCate1");
		String prodCate2Value = req.getParameter("prodCate2");
		logger.info(prodCate1Value);
		logger.info(prodCate2Value);
		
		// 썸네일 업로드
		String path = service.getPath(req, "/thumb/"+prodCate1Value+"/"+prodCate2Value);
		MultipartRequest mr = service.uploadFile(req, path);
		
		String seller    = mr.getParameter("seller");
		String prodCate1 = mr.getParameter("prodCate1");
		String prodCate2 = mr.getParameter("prodCate2");
		String prodName  = mr.getParameter("prodName");
		String descript  = mr.getParameter("descript");
		String company   = mr.getParameter("company");
		String price     = mr.getParameter("price");
		String discount  = mr.getParameter("discount");
		String point     = mr.getParameter("point");
		String stock     = mr.getParameter("stock");
		String delivery  = mr.getParameter("delivery");
		String thumb1    = mr.getOriginalFileName("thumb1");
		String thumb2    = mr.getOriginalFileName("thumb2");
		String thumb3    = mr.getOriginalFileName("thumb3");
		String detail    = mr.getOriginalFileName("detail");
		String status    = mr.getParameter("status");
		String duty      = mr.getParameter("duty");
		String receipt   = mr.getParameter("receipt");
		String bizType   = mr.getParameter("bizType");
		String origin    = mr.getParameter("origin");
		String ip        = req.getRemoteAddr();
		
		ProductDTO dto = new ProductDTO(path);
		dto.setSeller(seller);
		dto.setProdCate1(prodCate1);
		dto.setProdCate2(prodCate2);
		dto.setProdName(prodName);
		dto.setDescript(descript);
		dto.setCompany(company);
		dto.setPrice(price);
		dto.setDiscount(discount);
		dto.setPoint(point);
		dto.setStock(stock);
		dto.setDelivery(delivery);
		dto.setThumb1ForRename(thumb1);
		dto.setThumb2ForRename(thumb2);
		dto.setThumb3ForRename(thumb3);
		dto.setDetailForRename(detail);
		dto.setStatus(status);
		dto.setDuty(duty);
		dto.setReceipt(receipt);
		dto.setBizType(bizType);
		dto.setOrigin(origin);
		dto.setIp(ip);
		
		logger.debug(dto.toString());
		service.insertProduct(dto);
		resp.sendRedirect("/Kmarket/admin/product/register.do");
	}
}

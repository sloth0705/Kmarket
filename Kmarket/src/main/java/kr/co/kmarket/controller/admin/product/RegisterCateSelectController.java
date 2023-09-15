package kr.co.kmarket.controller.admin.product;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dto.ProductCate2DTO;
import kr.co.kmarket.service.ProductCate2Service;
import net.sf.json.JSONObject;

// 관리자 - 상품 등록 시 카테고리 분류를 위한 컨트롤러
@WebServlet("/admin/product/registerCateSelect.do")
public class RegisterCateSelectController extends HttpServlet {
	private static final long serialVersionUID = 2958123619532609572L;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private ProductCate2Service service = ProductCate2Service.INSTANCE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cate1 = req.getParameter("cate1");
		logger.info("cate1 : " + cate1);
		
		JSONObject json = new JSONObject();
		
		List<ProductCate2DTO> list = service.selectProductCate2s(cate1);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cate2List", list);
		
		json.put("map", map);
		
		resp.setContentType("application/x-json; charset=utf-8");
		resp.getWriter().print(json); // 전송
	}
}

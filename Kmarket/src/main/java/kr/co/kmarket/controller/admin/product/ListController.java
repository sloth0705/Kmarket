package kr.co.kmarket.controller.admin.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dto.ProductDTO;
import kr.co.kmarket.dto.ProductSearchForm;
import kr.co.kmarket.service.ProductService;

@WebServlet("/admin/product/list.do")
public class ListController extends HttpServlet {

	private static final long serialVersionUID = 5993656574541195493L;
	/* private ProductService pService = ProductService.INSTANCE; */
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String thumb1   = req.getParameter("thumb1");
		String prodNo   = req.getParameter("prodNo");
		String prodName = req.getParameter("prodName");
		String price    = req.getParameter("price");
		String discount = req.getParameter("discount");
		String point	= req.getParameter("point");
		String stock 	= req.getParameter("stock");
		String seller 	= req.getParameter("seller");
		String hit 		= req.getParameter("hit");
		
		
		/* ProductSearchForm searchForm = new ProductSearchForm();
		searchForm.setCate1(cate1);
		
		List<ProductDTO> products = pService.selectProducts(searchForm, start);

		
		
		req.setAttribute("products", products); */
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/product/list.jsp");
		dispatcher.forward(req, resp);
	}
	

}

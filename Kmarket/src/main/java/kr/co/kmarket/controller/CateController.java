package kr.co.kmarket.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import kr.co.kmarket.dto.ProductCate1DTO;
import kr.co.kmarket.dto.ProductCate2DTO;
import kr.co.kmarket.service.ProductCate1Service;
import kr.co.kmarket.service.ProductCate2Service;

@WebServlet("/cate.do")
public class CateController extends HttpServlet{
	private static final long serialVersionUID = 8632769547315263827L;
	private ProductCate1Service cate1Service = ProductCate1Service.INSTANCE;
	private ProductCate2Service cate2Service = ProductCate2Service.INSTANCE;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuilder cate = new StringBuilder("");
		cate.append("<li><i class=\"fa fa-bars\" aria-hidden=\"true\"></i>카테고리</li>");
		List<ProductCate1DTO> cate1s =  cate1Service.selectProductCate1s();
		for (ProductCate1DTO cate1 : cate1s) {
			List<ProductCate2DTO> cate2s = cate2Service.selectProductCate2s();
			cate.append("<li>");
			cate.append("<a href=\"#\"><i class=\"fas " + cate1.getCss() + "\"></i>" + cate1.getC1Name() + "</a>");
			cate.append("<ol>");
			for (ProductCate2DTO cate2 : cate2s) {
				if (cate2.getCate1() == cate1.getCate1()) {
					cate.append("<li><a href=\"/Kmarket/product/list.do?pg=1&cate1="+cate1.getCate1()+"&cate2=" + cate2.getCate2() + "\">" + cate2.getC2Name() + "</a></li>");
				}
			}
			cate.append("</ol>");
			cate.append("</li>");
		}
		JsonObject jsonData = new JsonObject();
		jsonData.addProperty("cate", cate.toString());
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().write(jsonData.toString());
	}
}
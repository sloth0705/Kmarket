package kr.co.kmarket.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dao.ProductDAO;
import kr.co.kmarket.dto.ProductDTO;
import kr.co.kmarket.dto.ProductSearchForm;

public enum Admin_ProductService {

	INSTANCE;
	private ProductDAO dao = ProductDAO.getInstance();
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public void insertProduct(ProductDTO dto) {
		dao.insertProduct(dto);
	}
	
	public ProductDTO selectProduct(String prodNo) {
		return dao.selectProduct(prodNo);
	}
	
	public List<ProductDTO> selectProducts(ProductSearchForm searchForm, int start) {
		return dao.selectProducts(searchForm, start);
	}
	
	
	public void updateProduct(ProductDTO dto) {
		dao.updateProduct(dto);
	}

	public void deleteProduct(int prodNo) {
		dao.deleteProduct(prodNo);
	}
	
	
	

}

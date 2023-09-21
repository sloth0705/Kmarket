package kr.co.kmarket.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.dao.Admin_ProductListDAO;
import kr.co.kmarket.dto.ProductDTO;
import kr.co.kmarket.dto.ProductSearchForm;

public enum Admin_ProductService {

	INSTANCE;
	private Admin_ProductListDAO dao = Admin_ProductListDAO.getInstance();
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

	public void deleteProduct(String in) {
		dao.deleteProduct(in);
	}

	public int selectCountTotal(String uid, int level, ProductSearchForm searchForm) {
		return dao.selectCountTotal(uid, level, searchForm);
	}
}

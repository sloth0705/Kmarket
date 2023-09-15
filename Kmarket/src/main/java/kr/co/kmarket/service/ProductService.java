package kr.co.kmarket.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.kmarket.dao.ProductDAO;
import kr.co.kmarket.dto.FileDTO;
import kr.co.kmarket.dto.ProductDTO;
import kr.co.kmarket.dto.ProductSearchForm;

public enum ProductService {
	
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

	public int selectCountTotal(String cate1, String cate2) {
		return dao.selectCountTotal(cate1, cate2);
	}
	
	// 파일 업로드 경로 구하기
	public String getPath(HttpServletRequest req, String dir) {
		
		ServletContext ctx = req.getServletContext();
		String path = ctx.getRealPath(dir);
		return path;
	}
	
	// 파일명 수정
	public String renameToFile(HttpServletRequest req, String path, String oName) {
		
		int i = oName.lastIndexOf(".");
		String ext = oName.substring(i);
		
		String uuid  = UUID.randomUUID().toString();
		String sName = uuid + ext;
		
		File f1 = new File(path+"/"+oName);
		File f2 = new File(path+"/"+sName);
		
		// 파일명 수정
		f1.renameTo(f2);
		
		return sName;
	}
	
	// 파일 업로드
	public MultipartRequest uploadFile(HttpServletRequest req, String path) {
		
		int maxSize = 1024 * 1024 * 10; // 최대 업로드 파일 크기
		
		// 파일 업로드 및 Multipart 객체 생성
		MultipartRequest mr = null;
		
		try {
			// 업로드될 경로의 폴더가 존재하지 않을 경우 폴더생성
			File upDir = new File(path);
			if (!upDir.exists())
				upDir.mkdirs();
			
			// 파일 업로드
			mr = new MultipartRequest(req, 
									  path, 
									  maxSize, 
									  "UTF-8", 
									  new DefaultFileRenamePolicy());
		}catch(Exception e) {
			logger.error("uploadFile() error : " + e.getMessage());
		}
		return mr;
	}
}
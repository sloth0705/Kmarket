<!-- 
날짜: 2023/09/14
작업자: 조유빈
내용: 관리자 상품관리 - 상품목록 페이지 기능 구현
 -->

<%@page import="kr.co.kmarket.dao.ProductDAO"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.kmarket.dto.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<main>
<%@ include file="../inc/aside.jsp" %>
<script>
	$(function() {
		// 전체 체크박스
		$('input[name=all]').change(function(){
			const isChecked = $(this).is(':checked');
			if (isChecked) {
				$('input[name=chk]').prop('checked', true);
			} else {
				$('input[name=chk]').prop('checked', false);
			}
		});
	    
		$('input[name=chk]').change(function() {
			const chk = $('input[name=chk]');
			let cnt = 0;
			for (let i = 0; i < chk.length; i++) {
				if (chk[i].checked) {
					cnt++;
				}
			}
			if (!$(this).is(':checked')) {
				$('input[name=all]').prop('checked', false);
			} else if (cnt == chk.length) {
				$('input[name=all]').prop('checked', true);
			}
		});
	});
</script>
			<section id="admin-product-list">
			    <nav>
			        <h3>상품목록</h3>
			        <p>
			            HOME > 상품관리 > <strong>상품목록</strong>
			        </p>
			    </nav>
			    <section>
			        <div>
			            <form action="${path }/admin/product/list.do" method="get">
				<select name="searchType">
				    <option value="prodName" ${searchType eq 'prodName' ? 'selected' : '' }>상품명</option>
				<option value="prodNo" ${searchType eq 'prodNo' ? 'selected' : '' }>상품코드</option>
				<option value="company" ${searchType eq 'company' ? 'selected' : '' }>제조사</option>
				<option value="seller" ${searchType eq 'seller' ? 'selected' : '' }>판매자</option>                                    
				</select>
				<input type="text" name="search" value="${search }">
				     <input type="submit" value="검색" />
				    </form>               
				</div>
				<form action="${path }/admin/product/delete.do" method="get">
					<table>
					    <tr>
					        <th><input type="checkbox" name="all"/></th>
					        <th>이미지</th>
					        <th>상품코드</th>
					        <th>상품명</th>
					        <th>판매가격</th>
					        <th>할인율</th>
					        <th>포인트</th>
					        <th>재고</th>
					        <th>판매자</th>
					        <th>조회</th>
					        <th>관리</th>
					    </tr>
				    	<c:forEach var="product" items="${products}">
							<tr>
							    <td><input type="checkbox" name="chk" value="${product.prodNo }"/></td>
							    <td><img src="${path }/thumb/${product.prodCate1 }/${product.prodCate2 }/${product.thumb1}" class="thumb"></td>
								<td>${product.prodNo}</td>
								<td>${product.prodName}</td>
								<td>${product.getPriceWithComma()}</td>
								<td>${product.discount}</td>
								<td>${product.point}</td>
								<td>${product.stock}</td>
								<td>${product.name}</td>
								<td>${product.hit}</td>
							    <td>
							      <a href="${path }/admin/product/delete.do?prodNo=${product.prodNo}">[삭제]</a>
							      <a href="#">[수정]</a>
							  </td>
							</tr>
					  	</c:forEach>
					</table>
					<input type="submit" value="선택삭제" />
				</form>                          
				<!-- 상품목록 페이지번호 -->
				<div class="paging">
				<c:if test="${pageGroupStart gt 1 }">
					<span class="prev">
					  <a href="#"><&nbsp;이전</a>
					</span>
				</c:if>
				<c:forEach var="i" begin="${pageGroupStart }" end="${pageGroupEnd }">
				<span class="num">
				  <a href="${path }/admin/product/list.do?pg=${i}&searchType=${searchType}&search=${search}" class="${i eq pg ? 'on' : '' }">${i }</a>
				</span>
				</c:forEach>
				<c:if test="${pageGroupEnd lt lastPageNum }">
				<span class="next">
				  <a href="#">다음&nbsp;></a>
				</span>
				</c:if>
	  		</div>
	    </section>                
	    <p class="ico info">
	        <strong>Tip!</strong>
	        전자상거래 등에서의 상품 등의 정보제공에 관한 고시에 따라 총 35개 상품군에 대해 상품 특성 등을 양식에 따라 입력할 수 있습니다.
	    </p>
	</section>
</main>
<%@ include file="../inc/footer.jsp" %>
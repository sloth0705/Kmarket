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
    <section id="admin-product-list">
        <nav>
            <h3>상품목록</h3>
            <p>
                HOME > 상품관리 > <strong>상품목록</strong>
            </p>
        </nav>
        <section>
            <div>
                <select name="search">
                    <option value="prodName">상품명</option>
                    <option value="prodNo">상품코드</option>
                    <option value="company">제조사</option>
                    <option value="seller">판매자</option>                                    
                </select>
                <input type="text" name="search">
                <input type="button" value="검색" />               
            </div>
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
 				 
                <tr>
                    <td><img src="#" class="thumb" alt="상품 이미지"></td>
                    <td><input type="checkbox" name="상품코드"/></td>
                    <td>이름</td>
                    <td>가격</td>
                    <td>할인</td>
                    <td>포인트</td>
                    <td>재고</td>
                    <td>판매자</td>
                    <td>조회</td>
                    <td>관리</td>
                
            		<td>
                        <a href="#">[삭제]</a>
                        <a href="#">[수정]</a>
                    </td>
                </tr>
                
            </table>
            
            <input type="button" value="선택삭제" />                          


            <div class="paging">
                <span class="prev">
	            <a href="#" class="prev"><</a>
                </span>
                <span class="num">
	            <a href="#"class="on">[1]</a>
                </span>
                <span class="next">
	            <a href="#" class="next">></a>
                </span>
             </div>

        </section>                

        
        <p class="ico info">
            <strong>Tip!</strong>
            전자상거래 등에서의 상품 등의 정보제공에 관한 고시에 따라 총 35개 상품군에 대해 상품 특성 등을 양식에 따라 입력할 수 있습니다.
        </p>

    </section>
</main>
<%@ include file="../inc/footer.jsp" %>
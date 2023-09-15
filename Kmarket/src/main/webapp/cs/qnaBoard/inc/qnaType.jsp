<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tr>
    <td>문의유형</td>
    <td>
        <!-- cateName이랑 동일함 -->
        <select name="type1">
            <option value="0">회원</option>
            <option>쿠폰/이벤트</option>
            <option>주문/결제</option>
            <option>배송</option>
            <option>취소/반품/교환</option>
            <option>여행/숙박/항공</option>
            <option>안전거래</option>
        </select>

        <!-- cateName에 따라서 선택지가 달라짐 -->
        <!-- 회원 -->
	<c:choose>
		<c:when test="${cate eq 'member' }">
	        <select name="type2">
	            <option value="0">선택</option>
	            <option>가입</option>
	            <option>탈퇴</option>
	            <option>회원정보</option>
	            <option>로그인</option>
	        </select>
        </c:when>
        
        <!-- 쿠폰 -->
        <c:when test="${cate eq 'coupon' }">
	        <select name="type2">
	            <option value="0">선택</option>
	            <option>쿠폰/할인혜택</option>
	            <option>포인트</option>
	            <option>제휴</option>
	            <option>이벤트</option>
	        </select>
        </c:when>

        <!-- 주문 -->
        <c:when test="${cate eq 'order' }">
	        <select name="type2">
	            <option value="0">선택</option>
	            <option>상품</option>
	            <option>결제</option>
	            <option>구매내역</option>
	            <option>영수증/증빙</option>
	        </select>
        </c:when>

        <!-- 배송 -->
        <c:when test="${cate eq 'delivery' }">
	        <select name="type2">
	            <option value="0">선택</option>
	            <option>상태/기간</option>
	            <option>정보확인/변경</option>
	            <option>해외배송</option>
	            <option>당일배송</option>
	            <option>해외직구</option>
	        </select>
        </c:when>

        <!-- 취소/반품 -->
        <c:when test="${cate eq 'cancle' }">
	        <select name="type2">
	            <option value="0">선택</option>
	            <option>반품 신청/철회</option>
	            <option>교환 AS신청/철회</option>
	            <option>취소 신청/철회</option>
	        </select>
        </c:when>

        <!-- 여행/숙박/항공 -->
        <c:when test="${cate eq 'travel' }">
	       <select name="type2">
	           <option value="0">선택</option>
	           <option>여행</option>
	           <option>숙박</option>
	           <option>항공</option>
	       </select>
        </c:when>

        <!-- 안전거래 -->
        <c:when test="${cate eq 'safe' }">
	        <select name="type2">
	            <option value="0">선택</option>
	            <option>서비스 이용 규칙 위반</option>
	            <option>지식재산권침해</option>
	            <option>법령 및 정책 위반 상품</option>
	            <option>게시물 정책 위반</option>
	            <option>직거래 / 외부거래 유도</option>
	            <option>표시 광고</option>
	            <option>청소년 위해상품 / 이미지</option>
	        </select>
        </c:when>
	</c:choose>
    </td>
</tr>

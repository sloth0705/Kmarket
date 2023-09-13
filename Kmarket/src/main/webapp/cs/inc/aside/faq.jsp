<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:set var="path" value="${pageContext.request.contextPath}" />

<section id="cs">
	<div class="faq">
		<nav>
			<div>
				<p>
					<a href="${path }/cs/index.do">홈</a><span>&gt;</span>
					<a href="${path }/cs/board/list.do?group=faq&cate=member">자주묻는 질문</a>
				</p>
			</div>
		</nav>
		<section class="list">
			<aside>
				<h2>자주묻는 질문</h2>
				<ul>
					<li class="${cate eq 'member' ? 'on' : '' }">
					    <a href="${path }/cs/board/list.do?group=faq&cate=memeber">회원</a>
					</li>
					<li class="${cate eq 'coupon' ? 'on' : '' }">
					    <a href="${path }/cs/board/list.do?group=faq&cate=coupon">쿠폰/이벤트</a>
					</li>
					<li class="${cate eq 'order' ? 'on' : '' }">
					    <a href="${path }/cs/board/list.do?group=faq&cate=order">주문/결제</a>
					</li>
					<li class="${cate eq 'delivery' ? 'on' : '' }">
					    <a href="${path }/cs/board/list.do?group=faq&cate=delivery">배송</a>
					</li>
					<li class="${cate eq 'cancle' ? 'on' : '' }">
					    <a href="${path }/cs/board/list.do?group=faq&cate=cancle">취소/반품/교환</a>
					</li>
					<li class="${cate eq 'travel' ? 'on' : '' }">
					    <a href="${path }/cs/board/list.do?group=faq&cate=travel">여행/숙박/항공</a>
					</li>
				</ul>
			</aside>
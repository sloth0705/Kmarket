<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:set var="path" value="${pageContext.request.contextPath}" />
    
 <section id="cs">
        <div class="qna">
            <nav>
                <div>
                    <a href="${path }/cs/index.do">홈</a><span>&gt;</span>
                    <a href="${path }/cs/board/list.do?group=qna&cate=member">문의 하기</a>
                </div>
            </nav>
            <section class="list">
                <aside>
                    <h2>문의 하기</h2>
                    <ul>
					    <li class="${cate eq 'member' ? 'on' : '' }">
					        <a href="${path }/cs/board/list.do?group=qna&cate=member">회원</a>
					    </li>
					    <li class="${cate eq 'coupon' ? 'on' : '' }">
					        <a href="${path }/cs/board/list.do?group=qna&cate=coupon">쿠폰/이벤트</a>
					    </li>
					    <li class="${cate eq 'order' ? 'on' : '' }">
					        <a href="${path }/cs/board/list.do?group=qna&cate=order">주문/결제</a>
					    </li>
					    <li class="${cate eq 'delivery' ? 'on' : '' }">
					        <a href="${path }/cs/board/list.do?group=qna&cate=delivery">배송</a>
					    </li>
					    <li class="${cate eq 'cancle' ? 'on' : '' }">
					        <a href="${path }/cs/board/list.do?group=qna&cate=cancle">취소/반품/교환</a>
					    </li>
					    <li class="${cate eq 'travel' ? 'on' : '' }">
					        <a href="${path }/cs/board/list.do?group=qna&cate=travel">여행/숙박/항공</a>
					    </li>
					    <li class="${cate eq 'safe' ? 'on' : '' }">
					        <a href="${path }/cs/board/list.do?group=qna&cate=safe">안전거래</a>
					    </li>
					</ul>
                </aside>

                <article>
                    <nav>
                        <h1>${cateName }</h1>
                        <h2>[${cateName }]관련 문의 내용입니다.</h2>
                    </nav>
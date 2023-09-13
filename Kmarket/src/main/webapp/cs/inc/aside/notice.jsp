<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:set var="path" value="${pageContext.request.contextPath}" />
    
<section id="cs">
    <div class="notice">
        <nav>
            <div>
                <p>
                    <a href="${path }/cs/index.do">홈</a><span>&gt;</span>
                    <a href="${path }/cs/board/list.do?group=notice&cate=All">공지사항</a>
                </p>
            </div>
        </nav>
        <!-- class list or view 선택에 따라서 css 적용이 달라짐-->
        <section id="csPage" class="list">
            <aside>
                <h2>공지사항</h2>
                <ul>
                    <li class="${cate eq 'All' ? 'on' : '' }">
                        <a href="${path }/cs/board/list.do?group=notice&cate=All">전체</a>
                    </li>
                    <li class="${cate eq 'cs' ? 'on' : '' }">
                        <a href="${path }/cs/board/list.do?group=notice&cate=cs">고객서비스</a>
                    </li>
                    <li class="${cate eq 'safe' ? 'on' : '' }">
                        <a href="${path }/cs/board/list.do?group=notice&cate=safe">안전거래</a>
                    </li>
                    <li class="${cate eq 'dangerProd' ? 'on' : '' }">
                        <a href="${path }/cs/board/list.do?group=notice&cate=dangerProd">위해상품</a>
                    </li>
                    <li class="${cate eq 'event' ? 'on' : '' }">
                        <a href="${path }/cs/board/list.do?group=notice&cate=event">이벤트당첨</a>
                    </li>
                </ul>
            </aside>
            
            <article>
                    <nav>
                    	<c:choose>
							<c:when test="${cate eq 'All' }">
                        		<h1>전체</h1>
                        	</c:when>
							<c:when test="${cate eq 'cs' }">
                        		<h1>고객서비스</h1>
                        	</c:when>
							<c:when test="${cate eq 'safe' }">
                        		<h1>안전거래</h1>
                        	</c:when>
							<c:when test="${cate eq 'dangerProd' }">
                        		<h1>위해상품</h1>
                        	</c:when>
							<c:when test="${cate eq 'event' }">
                        		<h1>이벤트당첨</h1>
                        	</c:when>
                        	<c:otherwise>
							<em>...</em>
						</c:otherwise>
                        </c:choose>
                        <h2>공지사항 전체 내용입니다.</h2>
                    </nav>
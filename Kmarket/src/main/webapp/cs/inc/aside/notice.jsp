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
                    <a href="${path }/cs/noticeBoard/list.do?group=notice&cate=All">공지사항</a>
                </p>
            </div>
        </nav>
        <!-- class list or view 선택에 따라서 css 적용이 달라짐-->
        <section id="pageCss" class="list">
            <aside>
                <h2>공지사항</h2>
                <ul>
                    <li class="${cate eq 'All' ? 'on' : '' }">
                        <a href="${path }/cs/noticeBoard/list.do?group=notice&cate=All">전체</a>
                    </li>
                    <li class="${cate eq 'cs' ? 'on' : '' }">
                        <a href="${path }/cs/noticeBoard/list.do?group=notice&cate=cs">고객서비스</a>
                    </li>
                    <li class="${cate eq 'safe' ? 'on' : '' }">
                        <a href="${path }/cs/noticeBoard/list.do?group=notice&cate=safe">안전거래</a>
                    </li>
                    <li class="${cate eq 'dangerProd' ? 'on' : '' }">
                        <a href="${path }/cs/noticeBoard/list.do?group=notice&cate=dangerProd">위해상품</a>
                    </li>
                    <li class="${cate eq 'event' ? 'on' : '' }">
                        <a href="${path }/cs/noticeBoard/list.do?group=notice&cate=event">이벤트당첨</a>
                    </li>
                </ul>
            </aside>
            
<script src="/Kmarket/cs/js/pageCSS.js"></script>
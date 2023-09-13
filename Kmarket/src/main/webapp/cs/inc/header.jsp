<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<DOCTYPE html>
    <html lang="ko">
    <head>
        <meta charset="utf-8"/>
        <title>Kmarket</title>
        <link rel="shortcut icon" type="image/x-icon" href="${path}/cs/img/favicon.ico">
        <link rel="stylesheet" href="${path }/cs/css/cs.css">
        <style> 
    
        </style>
        <script src="https://code.jquery.com/jquery-latest.min.js" ></script>
    </head>
<body>
    <div id="wrapper">
        <header>
            <div class="top">
                <div>
                    <p>
                        <a href="${path}/cs/member/login.do">로그인</a>
                        <a href="#">회원가입</a>
                        <a href="#">마이페이지</a>
                        <a href="#">
                            <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                            &nbsp;장바구니
                        </a>
                    </p>
                </div>
            </div>
            <div class="logo">
                <div>
                    <a href="${path }/cs/index.do">
                        <img src="${path}/cs/img/logo.png" alt="로고">고객센터
                    </a>
                </div>
            </div>
        </header>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp" %>
<main>
<%@ include file="../../inc/aside.jsp" %>
<section id="admin-cs-notice-modify">
    <nav>
        <h3>공지사항 수정</h3>
        <p>
            HOME > 고객센터 > <strong>자주묻는질문</strong>
        </p>
    </nav>
    <section>
    	<form action="${path}/admin/cs/notice/modify.do" method="post">
    		<input type="hidden" name="bno" value="${bno}"/>
    		<input type="hidden" name="type" value="${type}"/>
            <table>
                <tr>
				    <th>유형</th>
				    <td>
				    	<select name="cate">
						    <!-- <option value="" selected disabled>유형선택</option> -->
						    <option value="All"        <c:if test="${cate eq 'All'}">selected</c:if>>전체</option>
						    <option value="cs"         <c:if test="${cate eq 'cs'}">selected</c:if>>고객서비스</option>
						    <option value="safe"       <c:if test="${cate eq 'safe'}">selected</c:if>>안전거래</option>
						    <option value="dangerProd" <c:if test="${cate eq 'dangerProd'}">selected</c:if>>위해상품</option>
						    <option value="event"      <c:if test="${cate eq 'event'}">selected</c:if>>이벤트 당첨</option>
						</select>
				    </td>
                </tr>
                <tr>
				    <th>제목</th>
				    <td><input type="text" value="${title}"></td>
                </tr>
                <tr>
				    <th>내용</th>
				    <td>
				    	<textarea>${content}</textarea>
				    </td>
                </tr>
            </table>
            
            <div>
	            <input type="button" value="취소하기" onclick="location.href='${path}/admin/cs/notice/view.do?bno=${bno}'"/>
	            <input type="button" value="등록하기" onclick="location.href='${path}/admin/cs/notice/modify.do'"/>
			</div>
    	</form>
	</section>
</section>
</main>
<%@ include file="../../inc/footer.jsp" %>
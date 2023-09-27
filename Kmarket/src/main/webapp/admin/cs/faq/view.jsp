<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp" %>
<main>
<%@ include file="../../inc/aside.jsp" %>
<section id="admin-cs-faq-view">
    <nav>
        <h3>자주묻는질문 보기</h3>
        <p>
            HOME > 고객센터 > <strong>자주묻는질문</strong>
        </p>
    </nav>
    <section>
            <table>
                <tr>
				    <th>유형</th>
				    <td>${cateName}</td>
                </tr>
                <tr>
				    <th>제목</th>
				    <td>${title}</td>
                </tr>
                <tr>
				    <th>내용</th>
				    <td><textarea readonly="readonly">${content}</textarea></td>
                </tr>
            </table>
            
            <div>
	            <input type="button" value="삭제" />
	            <input type="button" value="수정" onclick="location.href='${path}/admin/cs/faq/modify.do?bno=${bno }'"/>
				<input type="button" value="목록" onclick="location.href='${path}/admin/cs/faq/list.do?cate=All&pg=1'"/>
			</div>
        </section>     
</section>
</main>
<%@ include file="../../inc/footer.jsp" %>
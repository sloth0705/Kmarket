<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp" %>
<main>
<%@ include file="../../inc/aside.jsp" %>
<section id="admin-cs-notice-view">
    <nav>
        <h3>공지사항 보기</h3>
        <p>
            HOME > 고객센터 > <strong>공지사항</strong>
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
	            <input type="button" value="삭제" onclick="location.href='${path}/admin/cs/notice/delete.do?cate=${cate}&bno=${bno}'"/>
	            <input type="button" value="수정" onclick="location.href='${path}/admin/cs/notice/modify.do?cate=${cate}&type=${type}&bno=${bno}'"/>
				<input type="button" value="목록" onclick="location.href='${path}/admin/cs/notice/list.do?cate=All&pg=1'"/>
			</div>
        </section>     
</section>
</main>
<%@ include file="../../inc/footer.jsp" %>
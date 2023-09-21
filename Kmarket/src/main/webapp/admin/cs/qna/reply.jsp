<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp" %>
<main>
<%@ include file="../../inc/aside.jsp" %>
<section id="admin-cs-qna-reply">
    <nav>
        <h3>문의하기 답변</h3>
        <p>
            HOME > 고객센터 > <strong>문의하기</strong>
        </p>
    </nav>
    <section>
            <table>
                <tr>
				    <th>유형</th>
				    <td>회원 - 가입</td>
                </tr>
                <tr>
				    <th>제목</th>
				    <td>회원 종류 및 혜택 안내</td>
                </tr>
                <tr>
				    <th>내용</th>
				    <td>는 어떻게 되나요?</td>
                </tr>
                <tr>
				    <th>답변</th>
				    <td><textarea></textarea></td>
                </tr>
            </table>
            
            <div>
	            <input type="button" value="삭제" />
	            <input type="button" value="답변등록" />
				<input type="button" value="목록" onclick="location.href='${path}/admin/cs/qna/list.do'"/>
			</div>
        </section>     
</section>
</main>
<%@ include file="../../inc/footer.jsp" %>
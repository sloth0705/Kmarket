<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp" %>
<main>
<%@ include file="../../inc/aside.jsp" %>
<section id="admin-cs-qna-modify">
    <nav>
        <h3>문의하기 수정</h3>
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
				    <td>회원탈퇴 방법 알려주세요.</td>
                </tr>
                <tr>
				    <th>내용</th>
				    <td>탈퇴하고 싶은데 어떻게 해야하나요?</td>
                </tr>
                <tr>
				    <th>답변</th>
				    <td><textarea>안녕하세요. K마켓입니다. 회원 탈퇴하는 방법은~</textarea></td>
                </tr>
            </table>
            
            <div>
	            <input type="button" value="취소" onclick="location.href='${path}/admin/cs/qna/view.do'"/>
				<input type="button" value="목록" onclick="location.href='${path}/admin/cs/qna/list.do'"/>
			</div>
        </section>     
</section>
</main>
<%@ include file="../../inc/footer.jsp" %>
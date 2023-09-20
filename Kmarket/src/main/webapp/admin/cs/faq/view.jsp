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
				    <td>회원 - 가입</td>
                </tr>
                <tr>
				    <th>제목</th>
				    <td>아이디를 여러개 사용할 수 있나요?</td>
                </tr>
                <tr>
				    <th>내용</th>
				    <td>안녕하세요. K마켓입니다.<br>고객 전화번호 기준으로~</td>
                </tr>
            </table>
            
            <div>
	            <input type="button" value="삭제" />
	            <input type="button" value="수정" />
				<input type="button" value="목록" />
			</div>
        </section>     
</section>
</main>
<%@ include file="../../inc/footer.jsp" %>
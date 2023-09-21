<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp" %>
<main>
<%@ include file="../../inc/aside.jsp" %>
<section id="admin-cs-faq-modify">
    <nav>
        <h3>자주묻는질문 수정</h3>
        <p>
            HOME > 고객센터 > <strong>자주묻는질문</strong>
        </p>
    </nav>
    <section>
            <table>
                <tr>
				    <th>유형</th>
				    <td>
				    	<select name="cate">
						    <option value="" selected disabled>1차 선택</option>
						    <option value="">회원</option>
						</select>
		                <select name="type">
						    <option value="" selected disabled>2차 선택</option>
						    <option value="">가입</option>
						</select>
				    </td>
                </tr>
                <tr>
				    <th>제목</th>
				    <td><input type="text" value="아이디를 여러개 사용할 수 있나요?"></td>
                </tr>
                <tr>
				    <th>내용</th>
				    <td>
				    	<textarea>안녕하세요. K마켓입니다. 고객 전화번호 기준으로~</textarea>
				    </td>
                </tr>
            </table>
            
            <div>
	            <input type="button" value="취소하기" onclick="location.href='${path}/admin/cs/faq/view.do'"/>
	            <input type="button" value="등록하기"/>
			</div>
        </section>
</section>
</main>
<%@ include file="../../inc/footer.jsp" %>
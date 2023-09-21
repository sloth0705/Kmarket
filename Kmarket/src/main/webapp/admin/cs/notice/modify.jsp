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
            <table>
                <tr>
				    <th>유형</th>
				    <td>
				    	<select name="cate">
						    <option value="" selected disabled>1차 선택</option>
						    <option value="">고객서비스</option>
						</select>
				    </td>
                </tr>
                <tr>
				    <th>제목</th>
				    <td><input type="text" value="[안내] 해외결제 사칭 문자 주의"></td>
                </tr>
                <tr>
				    <th>내용</th>
				    <td>
				    	<textarea>안녕하세요. K마켓입니다. K마켓 해외직구를 사칭하는 피싱문자가 최근~</textarea>
				    </td>
                </tr>
            </table>
            
            <div>
	            <input type="button" value="취소하기" onclick="location.href='${path}/admin/cs/notice/view.do'"/>
	            <input type="button" value="등록하기"/>
			</div>
        </section>
</section>
</main>
<%@ include file="../../inc/footer.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp" %>
<main>
<%@ include file="../../inc/aside.jsp" %>
<section id="admin-cs-faq-write">
    <nav>
        <h3>자주묻는질문 작성</h3>
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
						    <option value="">전체</option>
						    <option value="">회원</option>
						    <option value="">쿠폰/이벤트</option>
						    <option value="">주문/결제</option>
						    <option value="">배송</option>
						    <option value="">취소/반품/교환</option>
						    <option value="">여행/숙박/항공</option>
						</select>
		                <select name="type">
						    <option value="" selected disabled>2차 선택</option>
						    <option value="">가입</option>
						    <option value="">회원정보</option>
						    <option value="">로그인</option>
						    <option value="">탈퇴</option>
						</select>
				    </td>
                </tr>
                <tr>
				    <th>제목</th>
				    <td><input type="text" placeholder="제목을 입력하세요."></td>
                </tr>
                <tr>
				    <th>내용</th>
				    <td><textarea placeholder="내용을 입력하세요."></textarea></td>
                </tr>
            </table>
            
            <div>
	            <input type="button" value="취소하기" onclick="location.href='${path}/admin/cs/faq/list.do'"/>
	            <input type="button" value="등록하기"/>
			</div>
        </section>
</section>
</main>
<%@ include file="../../inc/footer.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp" %>
<main>
<%@ include file="../../inc/aside.jsp" %>
<section id="admin-cs-notice-write">
    <nav>
        <h3>공지사항 작성</h3>
        <p>
            HOME > 고객센터 > <strong>공지사항</strong>
        </p>
    </nav>
    <section>
            <table>
                <tr>
				    <th>유형</th>
				    <td>
				    	<select name="">
						    <option value="" selected disabled>유형선택</option>
						    <option value="">전체</option>
						    <option value="">고객서비스</option>
						    <option value="">안전거래</option>
						    <option value="">위해상품</option>
						    <option value="">이벤트 당첨</option>
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
	            <input type="button" value="취소하기" onclick="location.href='${path}/admin/cs/notice/list.do'"/>
	            <input type="button" value="등록하기"/>
			</div>
        </section>
</section>
</main>
<%@ include file="../../inc/footer.jsp" %>
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
				    <td>고객서비스</td>
                </tr>
                <tr>
				    <th>제목</th>
				    <td>[안내] 해외결제 사칭 문자 주의</td>
                </tr>
                <tr>
				    <th>내용</th>
				    <td>안녕하세요. K마켓입니다.<br>K마켓 해외직구를 사칭하는 피싱문자가 최근~</td>
                </tr>
            </table>
            
            <div>
	            <input type="button" value="삭제" />
	            <input type="button" value="수정" onclick="location.href='${path}/admin/cs/notice/modify.do'"/>
				<input type="button" value="목록" onclick="location.href='${path}/admin/cs/notice/list.do'"/>
			</div>
        </section>     
</section>
</main>
<%@ include file="../../inc/footer.jsp" %>
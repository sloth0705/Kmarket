<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp" %>
<main>
<%@ include file="../../inc/aside.jsp" %>
<section id="admin-cs-list">
    <nav>
        <h3>공지사항 목록</h3>
        <p>
            HOME > 고객센터 > <strong>공지사항</strong>
        </p>
    </nav>
    <section>
		<div>
			<select name="">
			    <option value="" selected disabled>유형선택</option>
			    <option value="">전체</option>
			    <option value="">고객서비스</option>
			    <option value="">안전거래</option>
			    <option value="">위해상품</option>
			    <option value="">이벤트 당첨</option>
			</select>
		</div>
		<table>
			<tr>
			    <th><input type="checkbox" name="all"/></th>
			    <th>번호</th>
			    <th>유형</th>
			    <th>제목</th>
			    <th>조회</th>
			    <th>날짜</th>
			    <th>관리</th>
			</tr>
			<tr>
				<td><input type="checkbox" name=""/></td>
				<td>32</td>
				<td>고객서비스</td>
				<td><a href="#">[안내] 해외결제 사칭 문자 주의</a></td>
				<td>234</td>
				<td>23.09.18</td>
				<td>
					<a href="#">[삭제]</a>
					<a href="#">[수정]</a>
				</td>
			</tr>
		</table>
		
		<input type="button" value="선택삭제"/>
		
		<div class="paging">
			<span class="prev"><a href="#" class="prev">이전</a></span>
			<span class="num"><a href="#"class="on">1</a></span>
			<span class="next"><a href="#" class="next">다음</a></span>
		</div>
		
		<input type="button" value="작성하기"/>
    </section>
</section>
</main>
<%@ include file="../../inc/footer.jsp" %>
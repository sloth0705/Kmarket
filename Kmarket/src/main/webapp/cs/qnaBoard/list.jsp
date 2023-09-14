<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<c:import url="../inc/aside/${group }.jsp" />
			<article>
				<nav>
					<h1>${cateName }</h1>
					<h2>가장 자주 묻는 [${cateName }]질문입니다.</h2>
				</nav>
				
                <table>
				    <tbody>
				    	<c:choose>
							<c:when test="${!empty cs }">
            					<c:forEach var="cs" items="${cs }">
							        <tr>
							            <td>
							                <a href="./view.do?group=${group }&cate=${cate}&bno=${cs.bno}">
							                	[typeName] ${cs.title }
						                	</a>
							            </td>
							            <td>${cs.uid }</td>
							            <td>${cs.rdate }</td>
							        </tr>
					        	</c:forEach>
							</c:when>
							<c:otherwise>
		           			<tr>
								<td colspan="3">등록된 게시물이 없습니다.</td>
							</tr>
		           			</c:otherwise>
						</c:choose>
				    </tbody>
				</table>
				
				<div class="page">
                    <a href="#" 
                    	class="prev">&laquo;</a>
                    <a href="#" 
                    	class="prev">이전</a>
                    	
                    <a href="#" 
                    	class="num on">1</a>
                    	
                    <a href="#" 
                    	class="next">다음</a>
                    <a href="#" 
                    	class="next">&raquo;</a>
                </div>

				<!-- 로그인 한 "일반 유저"가 문의 하기 -->
				<a href="./write.do?group=${group }&cate=${cate}" 
					class="btnWrite">문의하기</a>
			</article>
		</section>
	</div>
</section>
<%@ include file="../inc/footer.jsp" %>
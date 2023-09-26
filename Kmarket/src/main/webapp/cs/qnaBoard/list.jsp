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
							                	[${cs.typeName }] ${cs.title }
						                	</a>
							            </td>
							            <td>
							            	<c:choose>
				                                <c:when test="${sessMember.type ge 2}">
				                                    ${cs.uid}
				                                </c:when>
				                                <c:otherwise>
			                                    	${cs.maskingUid(cs.uid)}
				                                </c:otherwise>
				                            </c:choose>
							            </td>
							            <td>${cs.rdate }</td>
							            <td>
							            	
							            </td>
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
                <c:if test="${pageGroupStart > 1}">
					<a href="list.do?group=${group }&cate=${cate }&pg=1" 
						class="prev">&laquo;</a> 
					<a href="list.do?group=${group }&cate=${cate }&pg=${pageGroupStart -1 }" 
						class="prev">이전</a>
				</c:if>
                 
                 <c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}">
					<a href="list.do?group=${group }&cate=${cate }&pg=${i}"
						class="num ${currentPage == i? 'on' : ''}">${i }</a>
				</c:forEach>   	
                 
                 <c:if test="${pageGroupEnd < lastPageNum}">
					<a href="list.do?group=${group }&cate=${cate }&pg=${pageGroupEnd +1 }" 
						class="next">다음</a> 
					<a href="list.do?group=${group }&cate=${cate }&pg=${lastPageNum }" 
						class="next">&raquo;</a>
				</c:if>   	
                </div>

				<!-- 로그인 한 "일반 유저"가 문의 하기 -->
				<c:if test="${sessMember.type eq 1}">
					<a href="./write.do?group=${group }&cate=${cate}" 
						class="btnWrite">문의하기</a>
				</c:if>
			</article>
		</section>
	</div>
</section>
<%@ include file="../inc/footer.jsp" %>
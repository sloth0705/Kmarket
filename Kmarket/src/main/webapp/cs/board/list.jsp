<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<c:import url="../inc/aside/${group }.jsp" />
                    <table>
                        <tbody>
                        	<c:choose >
	                        	<c:when test="${!empty cs }" >
		                        	<c:forEach var="cs" items="${cs }">
		                            <tr>
		                                <td>
		                                	<a href="${path }/cs/board/view.do?group=${group}&cate=${cate}&bno=${cs.bno}">
		                                		[type2] ${cs.title }
		                               		</a>
		                               	</td>
		                                <td>${cs.rdate }</td>
		                            </tr>
		                            </c:forEach>
	                            </c:when>
	                            <c:otherwise>
				           			<tr>
										<td colspan="2">등록된 게시물이 없습니다.</td>
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

                </article>
            </section>
        </div>
    </section>
<%@ include file="../inc/footer.jsp" %>
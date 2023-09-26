<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<c:import url="../inc/aside/faq.jsp" />
					<article>
					    <nav>
					        <h2 class="title">
					            <span>Q.</span>[${cs.typeName }] ${cs.title }
					        </h2>
					    </nav>
					
					    <div class="content">
					        <textarea><c:out value="${cs.content }" /></textarea>
					    </div>
					    
					  <%--   <!-- 댓글(답변) -->
						<div>
							<h3>답변</h3>
							<c:choose>
								<c:when test="${!empty comments }">
									<c:forEach var="comment" items="${comments }">
										<article class="comment">
											<form action="#" method="post">
												<span style="font-weight: bold;" >${comment.uid }</span> 
												<span style="font-weight: lighter;" >${comment.rdate }</span>
												<textarea class="textarea" name="comment" disabled>${comment.content }</textarea>
											</form>
										</article>
									</c:forEach>
									<!-- for end -->
								</c:when>
								<c:otherwise>
									<p class="empty">등록된 답변이 없습니다.</p>
								</c:otherwise>
							</c:choose>
						</div> --%>
						
					    <a href="./list.do?group=${group }&cate=${cate}" 
					        class="btnList">목록보기</a>
					</article>
				</section>
			</div>
		</section>
<%@ include file="../inc/footer.jsp" %>
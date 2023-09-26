<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<c:import url="../inc/aside/qna.jsp" />
                <article>
				    <nav>
				        <h2 class="title">[${cs.typeName}] ${cs.title }</h2>
				        <p>
				            <span>
					            <c:choose>
	                                <c:when test="${sessMember.type ge 2}">
	                                    ${cs.uid}
	                                </c:when>
	                                <c:otherwise>
	                                   	${cs.maskingUid(cs.uid)}
	                                </c:otherwise>
	                            </c:choose>
                            </span>
				            <span>${cs.rdate }</span>
				        </p>
				    </nav>
				
				    <div class="content">
				    	<%-- <c:out>으로 감싸주면 content안에서 장난질 막을 수 있음 --%>
				        <textarea><c:out value="${cs.content }" /></textarea>
				    </div>
				    
				    <!-- 댓글(답변) -->
					<div>
						<c:choose>
							<c:when test="${!empty comments }">
								<c:forEach var="comment" items="${comments }">
									<h3>✔ 답변</h3>&nbsp;&nbsp;<span style="font-weight: lighter;" >${comment.rdate }</span>
									<article class="comment">
										<form action="#" method="post">
											<%-- <span style="font-weight: bold;" >${comment.uid }</span> --%> 
											<textarea class="textarea" name="comment" readonly>${comment.content }</textarea>
										</form>
									</article>
								</c:forEach>
								<!-- for end -->
							</c:when>
							<c:otherwise>
								<p class="empty">등록된 답변이 없습니다.</p>
							</c:otherwise>
						</c:choose>
					</div>
				    
				    <!-- 댓글입력폼 -->
				    <c:if test="${sessMember.type ge 2}">
						<section class="commentForm">
							<h3>답변 달기</h3>
							<form action="${path }/cs/comment/write.do" method="post">
								<input type="hidden" name="bno" value="${cs.bno }" /> 
								<input type="hidden" name="uid" value="${sessMember.uid }" /> 
								<input type="hidden" name="cate" value="${cate }" />
								<input type="hidden" name="group" value="${group }" />
								<!-- 800px 170px -->
								<textarea class="textarea" name="content"></textarea>
								<div>
									<input type="submit" class="btnWrite2" value="작성완료" />
									<input type="reset" class="btnReset" value="취소" /> 
								</div>
							</form>
						</section>
					</c:if>
				    
				    <a href="./list.do?group=${group }&cate=${cate}" 
				        class="btnList2">목록보기</a>
				</article>
			</section>
		</div>
	</section>
<%@ include file="../inc/footer.jsp" %>
<script>
	$(function() {
		$(".cancel").click(function(e) {
			e.preventDefault();
			location.reload();
		});
	});
</script>
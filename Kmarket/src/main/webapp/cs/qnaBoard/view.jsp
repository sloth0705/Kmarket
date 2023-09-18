<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<c:import url="../inc/aside/qna.jsp" />
                <article>
				    <nav>
				        <h2 class="title">[${cs.typeName}] ${cs.title }</h2>
				        <p>
				            <span>${cs.uid }</span>
				            <span>${cs.rdate }</span>
				        </p>
				    </nav>
				
				    <div class="content">
				    	<%-- <c:out>으로 감싸주면 content안에서 장난질 막을 수 있음 --%>
				        <p><c:out value="${cs.content }" /></p>
				    </div>
				    
				    <!-- 댓글(답글) -->
					<div>
						<h3>댓글목록</h3>
						<c:choose>
							<c:when test="${!empty comments }">
								<c:forEach var="comment" items="${comments }">
									<article class="comment">
										<form action="#" method="post">
											<span style="font-weight: bold;" >${comment.uid }</span> 
											<span style="font-weight: lighter;" >${comment.rdate }</span>
											<textarea class="textarea" name="comment" disabled>${comment.content }</textarea>
											<c:if test="${sessMember.uid eq comment.uid }">
												<div>
													<a href="#" class="del" data-no="${comment.cno}">삭제</a> 
													<a href="#" class="cancel" data-no="${comment.cno}">취소</a> 
													<a href="#" class="modify" data-no="${comment.cno}">수정</a>
												</div>
											</c:if>
										</form>
									</article>
								</c:forEach>
								<!-- for end -->
							</c:when>
							<c:otherwise>
								<p class="empty">등록된 댓글이 없습니다.</p>
							</c:otherwise>
						</c:choose>
					</div>
				    
				    <!-- 댓글입력폼 -->
				    <c:if test="${sessMember.level eq 99 
				    				|| sessMember.level eq 5}">
						<section class="commentForm">
							<h3>댓글쓰기</h3>
							<form action="#" method="post">
								<input type="hidden" name="bno" value="${cs.bno }" /> 
								<input type="hidden" name="uid" value="${sessMember.uid }" /> 
								<input type="hidden" name="cate" value="${cate }" />
								<input type="hidden" name="group" value="${group }" />
								<!-- 800px 170px -->
								<textarea class="textarea" name="content"></textarea>
								<div>
									<input type="reset" class="btnReset" value="취소" /> 
									<input type="submit" class="btnWrite" value="작성완료" />
								</div>
							</form>
						</section>
					</c:if>
				    
				    <a href="./list.do?group=${group }&cate=${cate}" 
				        class="btnList">목록보기</a>
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
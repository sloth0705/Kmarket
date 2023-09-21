<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<c:import url="../inc/aside/faq.jsp" />
			<article>
				<nav>
					<h1>${cateName }</h1>
					<h2>[${cateName }] 문의 내용입니다.</h2>
				</nav>
				
				<c:choose>
					<c:when test="${!empty cs }">
						<c:forEach var="type" items="${types }">
			                <div>
			                    <h3>${type.typeName }</h3>
			                    <ul>
			                    	<!-- varStatus : 상태용 변수(참고 링크 : https://jetalog.net/20) -->
									<c:forEach var="board" items="${cs }" varStatus="status">
										<c:if test="${board.type eq type.type}">
					                        <li class="${status.index ge 3 
					                        	&& status.index le 9 ? board.type : '' }">
					                            <a href="${path }/cs/faqBoard/view.do?group=faq&cate=${cate}&bno=${board.bno}">
					                                <span>Q.</span>${board.title }
					                            </a>
					                        </li>
				                        </c:if>
			                        </c:forEach>
			                        <li class="more">
			                            <a class="moreAteg ${type.type }" href="#">더보기</a>
			                            <a class="lessAteg ${type.type }" style="display: none" href="#">간단히보기</a>
			                        </li>
			                    </ul>
			                </div>
	                	</c:forEach>
	                </c:when>
	                <c:otherwise>
		                <ul>
							<li>등록된 게시물이 없습니다.</li>
						</ul>
	                </c:otherwise>
                </c:choose>
            </article>
        </section>
    </div>
</section>
<%@ include file="../inc/footer.jsp" %>
<script src="${path }/cs/js/faqMore.js"></script>
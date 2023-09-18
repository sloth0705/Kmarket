<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<c:import url="../inc/aside/faq.jsp" />
					<article>
					    <nav>
					        <h2 class="title">
					            <span>Q.</span>${cs.title }
					        </h2>
					    </nav>
					
					    <div class="content">
					        <p>${cs.content }</p>
					    </div>
					    <a href="./list.do?group=${group }&cate=${cate}" 
					        class="btnList">목록보기</a>
					</article>
				</section>
			</div>
		</section>
<%@ include file="../inc/footer.jsp" %>
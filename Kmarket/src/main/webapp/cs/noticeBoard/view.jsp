<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<c:import url="../inc/aside/notice.jsp" />
                <article>
                    <nav>
                        <h2 class="title">[${cs.typeName}] ${cs.title }</h2>
                        <span class="date">${cs.rdate }</span>
                    </nav>

                    <div class="content">
                        <textarea><c:out value="${cs.content }" /></textarea>
                    </div>
	                <c:if test="${sessMember.uid eq cs.uid}">
		                <div>
		                    <!-- <a href="#" class="delete">삭제</a> -->
		                    <a href="${path}/cs/noticeBoard/modify.do?group=${group}&cate=${cate}&bno=${cs.bno}" 
		                    	class="modify">수정</a>
		                </div>
	               	</c:if>
                    <a href="./list.do?group=${group }&cate=${cate}" 
                    	class="btnList">목록보기</a>
                </article>
            </section>
        </div>
    </section>
<%@ include file="../inc/footer.jsp" %>
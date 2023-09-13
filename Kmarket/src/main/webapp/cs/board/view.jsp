<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<c:import url="../inc/aside/notice.jsp" />
                <article>
                    <nav>
                        <h2 class="title">[이거 뭘로 하지?] ${cs.title }</h2>
                        <span class="date">${cs.rdate }</span>
                    </nav>

                    <div class="content">
                        ${cs.content }
                    </div>
                    <a href="./list.do?group=${group }&cate=${cate}" 
                    	class="btnList">목록보기</a>
                </article>
            </section>
        </div>
    </section>
<%@ include file="../inc/footer.jsp" %>
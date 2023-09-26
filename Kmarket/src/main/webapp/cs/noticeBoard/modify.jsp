<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<c:import url="../inc/aside/notice.jsp" />
			<article>
		    	<form action="${path }/cs/noticeBoard/modify.do" method="post">
		    		<input type="hidden" name="group" value="${group }" />
		    		<input type="hidden" name="cate" value="${cate }" />
		    		<input type="hidden" name="bno" value="${board.bno}" />
		    		<input type="hidden" name="uid" value="${sessMember.uid }" />
			        <table>
			            <tbody>
			                <tr>
			                    <td>공지유형</td>
			                    <td>
			                        <!-- cateName이랑 동일함 -->
			                        <select name="cate" id="cate" required>
			                        	<option selected disabled value="0">1차 분류 선택</option>
				                        <c:forEach var="cateOption" items="${cs }">
				                        	<option value="${cateOption.cate}">${cateOption.cateName}</option>
				                        </c:forEach>
			                        </select>
			
			                        <!-- cateName에 따라서 선택지가 달라짐 -->
			                        <select name="type" id="type" required>
			                        	<option selected disabled value="0">2차 분류 선택</option>
			                        </select>
			                    </td>
			                </tr>
			                
			                <tr>
			                    <td>공지제목</td>
			                    <td>
			                        <input type="text" name="title" value="${board.title }" required />
			                    </td>
			                </tr>
			                <tr>
			                    <td>공지내용</td>
			                    <td>
			                        <textarea name="content" required>${board.content }</textarea>
			                    </td>
			                </tr>
			            </tbody>
			        </table>
			        <div>
			            <a href="./view.do?group=${group }&cate=${cate}&bno=${board.bno}" class="btnList">취소하기</a>
			            <input type="submit" class="btnSubmit" value="수정하기">
			        </div>
			    </form>
			</article>
		</section>
	</div>
</section>
<%@ include file="../inc/footer.jsp" %>
<script src="/Kmarket/cs/js/writeType.js"></script> 
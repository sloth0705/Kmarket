<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<c:import url="../inc/aside/qna.jsp" />
			<article>
		    	<form id="writeForm" action="${path }/cs/qnaBoard/write.do" method="post">
		    		<input type="hidden" name="group" value="${group }" />
		    		<input type="hidden" name="uid" value="${sessMember.uid }" />
			        <table>
			            <tbody>
			                <tr>
			                    <td>문의유형</td>
			                    <td>
			                        <!-- cateName이랑 동일함 -->
			                        <select name="cate" id="cate" required>
			                        	<option selected disabled value="0">1차 분류 선택</option>
				                        <c:forEach var="cateOption" items="${cate }">
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
			                    <td>문의제목</td>
			                    <td>
			                        <input type="text" name="title" required placeholder="제목을 입력하세요." />
			                    </td>
			                </tr>
			                <tr>
			                    <td>문의내용</td>
			                    <td>
			                        <textarea name="content" required placeholder="내용을 입력하세요."></textarea>
			                    </td>
			                </tr>
			            </tbody>
			        </table>
			        <div>
			            <input type="submit" class="btnSubmit" value="등록하기">
			            <a href="#" class="btnList">취소하기</a>
			        </div>
			    </form>
			</article>
		</section>
	</div>
</section>
<%@ include file="../inc/footer.jsp" %>
<script src="/Kmarket/cs/js/writeType.js"></script>  
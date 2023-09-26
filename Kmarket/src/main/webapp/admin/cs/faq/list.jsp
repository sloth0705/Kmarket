<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp" %>
<main>
<%@ include file="../../inc/aside.jsp" %>
<section id="admin-cs-faq-list">
<script>
$(function(){
	const url = "/Kmarket/cs/Board/ajaxWrite.do"
	// /admin/cs/qna/list.do
	
	$("#cate").change(function(){
		let optionValue = $(this).val();
		let selectType = $("#type");
		
		const jsonData = {
			"optionValue" : optionValue
		};
		console.log(jsonData);
		
		// cate가 바뀔 때 마다 type을 빈값으로 초기화 해주고
		// 그 뒤 append를 통해서 option을 추가해줌
		selectType.empty();
		selectType.append(
			$('<option>',{
				value: '',
                text: '2차 분류 선택',
                disabled: 'disabled',
                selected: 'selected'
			})
		);
		
		if(optionValue !== '0'){
			$.getJSON(url, jsonData, function(data){
				console.log("cate가 0이 아닐 때 type option 추가");
				console.log(data);
				
				$.each(data, function (index, type) {
					selectType.append(
						$('<option>',{
							value: type.type,
			                text: type.typeName,
						})
					); // appnd end
                }); // each end
			}); // ajax end
		} // if end
	}); // cate change end
});
</script>
    <nav>
        <h3>자주묻는질문 목록</h3>
        <p>
            HOME > 고객센터 > <strong>자주묻는질문</strong>
        </p>
    </nav>
    <section>
            <div>
                <!-- cateName이랑 동일함 -->
                <select name="cate" id="cate">
              
				    <option value="" selected disabled>1차 선택</option>
				    <c:forEach var="cateOption" items="${cate }">
				    	<option value="${cateOption.cate}">${cateOption.cateName}</option>
					    
				    </c:forEach>
				</select>
				
				 <!-- cateName에 따라서 선택지가 달라짐 -->
                <select name="type" id="type">
						
					<option selected disabled value="0">2차 선택</option>
				    
				</select>
            </div>
            <table>
                <tr>
                    <th><input type="checkbox" name="all"/></th>
				    <th>번호</th>
				    <th>1차유형</th>
				    <th>2차유형</th>
				    <th>제목</th>
				    <th>조회</th>
				    <th>날짜</th>
				    <th>관리</th>
                </tr>
                <tr>
                	<td><input type="checkbox" name=""/></td>
					<td>32</td>
					<td>회원</td>
					<td>가입</td>
					<td><a href="${path}/admin/cs/faq/view.do">아이디를 여러개 사용할 수 있나요?</a></td>
					<td>159</td>
					<td>23.09.18</td>
					<td>
						<a href="#">[삭제]</a>
						<br>
						<a href="#">[수정]</a>
					</td>
                </tr>
            </table>
            
            <input type="button" value="선택삭제" />
                                  
			<div class="paging">
				<span class="prev"><a href="#" class="prev">이전</a></span>
				<span class="num"><a href="#"class="on">1</a></span>
				<span class="next"><a href="#" class="next">다음</a></span>
			</div>
			
			<input type="button" value="작성하기" onclick="location.href='${path}/admin/cs/faq/write.do'"/>

        </section>     
</section>
</main>
<%@ include file="../../inc/footer.jsp" %>
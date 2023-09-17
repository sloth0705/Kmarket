<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<script src="/Kmarket/admin/js/validation.js"></script>
<script>
	$(document).ready(function(){
		
		// 카테고리 분류 AJAX로 불러오기
		$('#category1').on('change', function(){
			
			const cate1 = this.value;
			console.log(cate1);
			
			$('#category2').children('option:not(:first)').remove();
			
			const jsonData = {
				"cate1": cate1
			};
			console.log(jsonData);
			
			$.ajax({
				url: '${path}/admin/product/registerCateSelect.do',
				type: 'get',
				data: jsonData,
				dataType: 'json',
				success: function(data){
					
					let cate2List = data.map.cate2List; // map 넘겨받기
					
					for (var i=0 ; i<Object.keys(data.map.cate2List).length ; i++)
						$("#category2").append("<option id='cate2Value' value="+cate2List[i].cate2+">"+cate2List[i].c2Name+"</option>");
				},
				error: function(){
					alert("error");
				}
			});
		});
		
		// 카테고리 분류 파라미터로 넘기기(썸네일 업로드 폴더 경로 위해서)
		$("#category2").on('change', function(){
			
			var prodCate1 = $("#category1 :selected").val();
			var prodCate2 = $("#category2 :selected").val();
			console.log("cate1 선택됨 : "+prodCate1);
			console.log("cate2 선택됨 : "+prodCate2);
			
			const currentUrl = window.location.href; // 현재 주소
			console.log(currentUrl);
			
			history.pushState(null, null, '?prodCate1='+prodCate1+"&prodCate2="+prodCate2);
			const submitUrl = window.location.href; // 현재 주소
			console.log(submitUrl);
			
			var form = document.form;
			form.action = submitUrl;
			console.log("form action 변경함 - "+form.action);
		});
	});
	
	window.onkeydown = function() {
		var kcode = event.keyCode;
		if(kcode == 116)
			history.replaceState({}, null, location.pathname);
	}
</script>
<main>
<%@ include file="../inc/aside.jsp" %>
<section id="admin-product-register">
    <nav>
        <h3>상품등록</h3>
        <p>
            HOME > 상품관리 > <strong>상품등록</strong>
        </p>
    </nav>
    <article>
        <form id="form" name="form" action="${path}/admin/product/register.do" method="post" enctype="multipart/form-data">
        	<input type="hidden" name="seller" value="${sessMember.uid}"/>
            <section>
                <h4>상품분류</h4>
                <p>
                    기본분류는 반드시 선택하셔야 합니다. 하나의 상품에 1개의 분류를 지정 합니다.
                </p>
                <table>
                    <tr>
                        <td>1차 분류</td>
                        <td>
                            <select id="category1" name="prodCate1" required>
                                <option value="" selected disabled>1차 분류 선택</option>
                                <option value="10">브랜드패션</option>
                                <option value="11">패션의류/잡화/뷰티</option>
                                <option value="12">유아동</option>
                                <option value="13">식품/생필품</option>
                                <option value="14">홈데코/취미/반려</option>
                                <option value="15">컴퓨터/디지털/가전</option>
                                <option value="16">스포츠/건강/렌탈</option>
                                <option value="17">자동차/공구</option>
                                <option value="18">여행/도서/티켓/쿠폰</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>2차 분류</td>
                        <td>
                            <select id="category2" name="prodCate2" required>
                                <option value="" selected disabled>2차 분류 선택</option>
                                <!-- ajax로 option 추가됨 -->
                            </select>
                        </td>
                    </tr>
                </table>
            </section>

            <section>
                <h4>기본정보</h4>
                <p>
                    기본정보는 반드시 입력해야 합니다.
                </p>
                <table>
                    <tr>
                        <td>상품명</td>
                        <td>
                        	<input type="text" name="prodName" required/>
                        	<span class="resultProdName"></span>
                        </td>
                    </tr>
                    <tr>
                        <td>기본설명</td>
                        <td>
                            <span>상품명 하단에 상품에 대한 추가적인 설명이 필요한 경우에 입력</span>
                            <input type="text" name="descript"/>
                        </td>
                    </tr>
                    <tr>
                        <td>제조사</td>
                        <td>
                        	<input type="text" name="company" required/>
                        	<span class="resultCompany"></span>
                        </td>
                    </tr>
                    <tr>
                        <td>판매가격</td>
                        <td>
                        	<input type="text" name="price" required/>원
                        	<span class="resultPrice"></span>
                        </td>
                    </tr>                                    
                    <tr>
                        <td>할인율</td>
                        <td>
                            <span>0을 입력하면 할인율 없음</span>
                            <input type="text" name="discount" required/>원
                            <span class="resultDiscount"></span>
                        </td>
                    </tr>
                    <tr>
                        <td>포인트</td>
                        <td>
                            <span>0을 입력하면 포인트 없음</span>
                            <input type="text" name="point" required/>점
                            <span class="resultPoint"></span>
                        </td>
                    </tr>
                    <tr>
                        <td>재고수량</td>
                        <td>
                        	<input type="text" name="stock" required/>개
                        	<span class="resultStock"></span>
                        </td>
                    </tr>
                    <tr>
                        <td>배송비</td>
                        <td>
                            <span>0을 입력하면 배송비 무료</span>
                            <input type="text" name="delivery" required/>원
                            <span class="resultDelivery"></span>
                        </td>
                    </tr>
                    <tr>
                        <td>상품 썸네일</td>
                        <td>
                            <span>크기 190 x 190, 상품 목록에 출력될 이미지 입니다. </span>
                            <input type="file" name="thumb1" required/>

                            <span>크기 230 x 230, 상품 메인에 출력될 이미지 입니다. </span>
                            <input type="file" name="thumb2" required/>

                            <span>크기 456 x 456, 상품 상세에 출력될 이미지 입니다. </span>
                            <input type="file" name="thumb3" required/>
                        </td>
                    </tr>
                    <tr>
                        <td>상세 상품정보</td>
                        <td>
                            <span>크기 가로 940px 높이 제약없음, 크기 최대 1MB, 상세페이지 상품정보에 출력될 이미지 입니다.</span>
                            <input type="file" name="detail" required/>
                        </td>
                    </tr>
                </table>
            </section>
            
            <section>
                <h4>상품정보 제공고시</h4>
                <p>
                    [전자상거래에 관한 상품정보 제공에 관한 고시] 항목에 의거 등록해야 되는 정보입니다.
                </p>
                <table>
                    <tr>
                        <td>상품상태</td>
                        <td>
                        	<input type="text" name="status" value="새상품" required/>
                        	<span class="resultStatus"></span>
                        </td>
                    </tr>
                    <tr>
                        <td>부가세 면세여부</td>
                        <td>
                        	<input type="text" name="duty" value="과세상품" required/>
                        	<span class="resultDuty"></span>
                        </td>
                    </tr>
                    <tr>
                        <td>영수증발행</td>
                        <td><input type="text" name="receipt" value="발행가능 - 신용카드 전표, 온라인 현금영수증" required/></td>
                    </tr>
                    <tr>
                        <td>사업자구분</td>
                        <td><input type="text" name="bizType" value="사업자 판매자" required/></td>
                    </tr>
                    <tr>
                        <td>원산지</td>
                        <td>
                        	<input type="text" name="origin" value="국내산" required/>
                        	<span class="resultOrigin"></span>
                        </td>
                    </tr>
                </table>
            </section>
            <input id="submit" type="submit" value="등록하기"/>
        </form>
    </article>
    <p class="ico alert">
        <strong>Warning!</strong>
        전자상거래 등에서의 상품 등의 정보제공에 관한 고시에 따라 총 35개 상품군에 대해 상품 특성 등을 양식에 따라 입력할 수 있습니다.
    </p>
</section>
</main>
<%@ include file="../inc/footer.jsp" %>
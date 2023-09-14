<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./inc/header.jsp"%>
<%@ include file="./inc/aside.jsp"%>
<script>
	$(function() {
		// 전체 체크박스
		$('input[name=all]').change(function(){
			const isChecked = $(this).is(':checked');
			if (isChecked) {
				$('input[name=chk]').prop('checked', true);
				let count = 0;
				let price = 0;
				let disPrice = 0;
				let delivery = 0;
				let point = 0;
				let total = 0;
				const chk = $('input[name=chk]');
				for (let i = 0; i < chk.size(); i++) {
					const cartNo = $('input[name=chk]')[i].classList[0];
					let tmpCount = $('input[name=count' + cartNo + ']').val() * 1;
					let tmpPrice = $('input[name=price' + cartNo + ']').val() * 1 * tmpCount;
					let tmpDisPrice = $('input[name=disPrice' + cartNo + ']').val() * 1 * tmpCount;
					let tmpDisPrice2 = tmpPrice - tmpDisPrice;
					let tmpDelivery = $('input[name=delivery' + cartNo + ']').val() * 1;
					let tmpPoint = $('input[name=point' + cartNo + ']').val() * 1;
					let tmpTotal = tmpDisPrice + tmpDelivery;
					
					count += tmpCount;
					price += tmpPrice;
					disPrice += tmpDisPrice2;
					delivery += tmpDelivery;
					point += tmpPoint;
					total += tmpTotal;
				}
				$('#count').text(count.toLocaleString());
				$('#price').text(price.toLocaleString());
				$('#disPrice').text(disPrice.toLocaleString());
				$('#delivery').text(delivery.toLocaleString());
				$('#point').text(point.toLocaleString());
				$('#total').text(total.toLocaleString());
			} else {
				$('input[name=chk]').prop('checked', false);
				$('.totalForm').text(0);
			}
		});
	    
		$('input[name=chk]').change(function() {
			const chk = $('input[name=chk]');
			let count = 0;
			let price = 0;
			let disPrice = 0;
			let delivery = 0;
			let point = 0;
			let total = 0;
			for (let i = 0; i < chk.size(); i++) {
				if (chk[i].checked) {
					const cartNo = $('input[name=chk]')[i].classList[0];
					let tmpCount = $('input[name=count' + cartNo + ']').val() * 1;
					let tmpPrice = $('input[name=price' + cartNo + ']').val() * 1 * tmpCount;
					let tmpDisPrice = $('input[name=disPrice' + cartNo + ']').val() * 1 * tmpCount;
					let tmpDisPrice2 = tmpPrice - tmpDisPrice;
					let tmpDelivery = $('input[name=delivery' + cartNo + ']').val() * 1;
					let tmpPoint = $('input[name=point' + cartNo + ']').val() * 1;
					let tmpTotal = tmpDisPrice + tmpDelivery;
					
					count += tmpCount;
					price += tmpPrice;
					disPrice += tmpDisPrice2;
					delivery += tmpDelivery;
					point += tmpPoint;
					total += tmpTotal;
				}
			}
			$('#count').text(count.toLocaleString());
			$('#price').text(price.toLocaleString());
			$('#disPrice').text(disPrice.toLocaleString());
			$('#delivery').text(delivery.toLocaleString());
			$('#point').text(point.toLocaleString());
			$('#total').text(total.toLocaleString());
		});
		
		// 선택삭제
	    $('.cartDelete').click(function(e) {
	    	e.preventDefault();
	    	if (!confirm('해당 장바구니 품목을 삭제 하시겠습니까?')) {
	    		return false;
	    	}
	    	$('#formCheck').attr("action", "${path }/product/cart.do");
	    	$('#formCheck').attr("method", "post");
	    	$('#formCheck').submit();
	    });
		
	    $('#formCheck').submit(function() {
	    	if ($('#total').text() == 0) {
	    		alert('주문하실 상품을 선택해주세요.');
	    		return false;
	    	}
	    });
	});
</script>
<!-- 장바구니 페이지 시작 -->
<section class="cart">
	<!-- 제목, 페이지 네비게이션 -->
	<nav>
		<h1>장바구니</h1>
		<p>
			HOME > <span>패션·의류·뷰티</span> > <strong>장바구니</strong>
		</p>
	</nav>
	<form id="formCheck" action="${path }/product/order.do" method="get">
		<!-- 장바구니 목록 -->
		<table>
			<thead>
				<tr>
					<th><input type="checkbox" name="all"></th>
					<th>상품명</th>
					<th>총수량</th>
					<th>판매가</th>
					<th>할인</th>
					<th>포인트</th>
					<th>배송비</th>
					<th>소계</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${carts.size() eq 0 }">
						<tr>
							<td colspan="7">장바구니에 상품이 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="cart" items="${carts }" varStatus="status">
						<tr class="${cart.cartNo }">
							<td>
								<input type="checkbox" name="chk" class="${cart.cartNo }" value="${cart.cartNo }">
							</td>
							<td>
								<article>
									<a href="#"><img src="${path }/upload/${cart.product.thumb1}"
										alt=""></a>
									<div class="w450">
										<h2>
											<a href="#" class="eclipse">${cart.product.prodName }</a>
										</h2>
										<p class="overHidden">${cart.product.descript }</p>
									</div>
								</article>
							</td>
							<td class="count">
								<input type="hidden" name="count${cart.cartNo }" value="${cart.count }"/>
								${cart.count }
							</td>
							<td class="price">
								<input type="hidden" name="price${cart.cartNo }" value="${cart.product.price }"/>
								${cart.product.getPriceWithComma() }
							</td>
							<td class="discount">
								<input type="hidden" name="discount${cart.cartNo }" value="${cart.product.discount }"/>
								<input type="hidden" name="disPrice${cart.cartNo }" value="${cart.product.getDisPrice() }"/>
								${cart.product.discount }%
							</td>
							<td class="point">
								<input type="hidden" name="point${cart.cartNo }" value="${cart.product.point }"/>
								${cart.product.point }
							</td>
							<td class="delivery">
								<input type="hidden" name="delivery${cart.cartNo }" value="${cart.product.delivery }"/>
								<c:choose>
									<c:when test="${cart.product.delivery gt 0 }">
										${cart.product.getDeliveryWithComma() }
									</c:when>
									<c:otherwise>
										무료배송
									</c:otherwise>
								</c:choose>
							</td>
							<td class="total">
								<input type="hidden" name="total${cart.cartNo }" value="${cart.getTotal() }"/>
								${cart.getTotalWithComma() }
							</td>
						</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		<input class="cartDelete" type="button" name="del" value="선택삭제">
		<!-- 장바구니 전체합계 -->
		<div class="total">
			<h2>전체합계</h2>
			<table>
				<tr>
					<td>상품수</td>
					<td><span id="count" class="totalForm">0</span></td>
				</tr>
				<tr>
					<td>상품금액</td>
					<td><span id="price" class="totalForm">0</span></td>
				</tr>
				<tr>
					<td>할인금액</td>
					<td><span id="disPrice" class="totalForm">0</span></td>
				</tr>
				<tr>
					<td>배송비</td>
					<td><span id="delivery" class="totalForm">0</span></td>
				</tr>
				<tr>
					<td>포인트</td>
					<td><span id="point" class="totalForm">0</span></td>
				</tr>
				<tr>
					<td>전체주문금액</td>
					<td><span id="total" class="totalForm">0</span></td>
				</tr>
			</table>
			<input type="submit" name="" value="주문하기">
		</div>
	</form>
</section>
<!-- 장바구니 페이지 끝 -->
</main>
<%@ include file="./inc/footer.jsp"%>
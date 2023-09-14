<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./inc/header.jsp"%>
<%@ include file="./inc/aside.jsp"%>
<script>
	$(function() {
		// 초기 최종결제 정보
		const length = ${carts.size()}
		const count = $('input[name=count]');
		const price = $('input[name=price]');
		const disPrice = $('input[name=disPrice]');
		const delivery = $('input[name=delivery]');
		const total = 0;
		
		let ordPrice = 0;
		let ordDiscount = 0;
		let ordDelivery = 0;
		let ordTotPrice = 0;
		for (let i = 0; i < length; i++) {
			ordPrice += (count[i].value * 1) * (price[i].value * 1);
			ordDiscount += ((price[i].value * 1) - (disPrice[i].value * 1)) * (count[i].value * 1);
			ordDelivery += (delivery[i].value * 1);
		}
		ordTotPrice += ordPrice - ordDiscount + ordDelivery;
		
		$('input[name=ordPrice]').val(ordPrice);
		$('input[name=ordDiscount]').val(ordDiscount);
		$('input[name=ordDelivery]').val(ordDelivery);
		$('input[name=ordTotPrice]').val(ordTotPrice);
		$('#price').text(ordPrice.toLocaleString());
		$('#disPrice').text(ordDiscount.toLocaleString());
		$('#delivery').text(ordDelivery.toLocaleString());
		$('#total').text(ordTotPrice.toLocaleString());
	});
	// 포인트 사용 구현
	function usePoint() {
		const savePoint = $('input[name=savePoint]');
		const point = savePoint.val() * 1;
		const ordTotPrice = $('input[name=ordTotPrice]');
		let TotPrice = ordTotPrice.val() * 1;
		const usedPoint =  $('input[name=usedPoint]').val() * 1;
		TotPrice = TotPrice + point - usedPoint;
		savePoint.val(usedPoint);
		$('#point').text(usedPoint.toLocaleString());
		$('#total').text(TotPrice.toLocaleString());
		ordTotPrice.val(TotPrice);
	}
</script>
<!-- 주문 페이지 시작-->
<section class="order">
	<!-- 제목, 페이지 네비게이션 -->
	<nav>
		<h1>주문결제</h1>
		<p>
			HOME > 장바구니 > <strong>주문결제</strong>
		</p>
	</nav>

	<form action="#">
		<!-- 주문 상품 목록 -->
		<table>
			<thead>
				<tr>
					<th>상품명</th>
					<th>총수량</th>
					<th>판매가</th>
					<th>할인</th>
					<th>배송비</th>
					<th>소계</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cart" items="${carts }" varStatus="status">
					<tr>
						<td>
							<article>
								<a href="#"><img
									src="${path }/upload/${cart.product.thumb1}" alt=""></a>
								<div class="w450">
									<h2>
										<a href="#">${cart.product.prodName }</a>
									</h2>
									<p>${cart.product.descript }</p>
								</div>
							</article>
						</td>
						<td class="count">
							<input type="hidden" name="count" value="${cart.count }" />
							${cart.count }
						</td>
						<td class="price">
							<input type="hidden" name="price" value="${cart.product.price }"/>
							${cart.product.getPriceWithComma() }
						</td>
						<td class="discount">
							<input type="hidden" name="discount" value="${cart.product.discount }"/>
							<input type="hidden" name="disPrice" value="${cart.product.getDisPrice() }"/>
							${cart.product.discount }%
						</td>
						<td class="delivery">
							<input type="hidden" name="delivery" value="${cart.product.delivery }" />
							<c:choose>
								<c:when test="${cart.product.delivery gt 0 }">
									${cart.product.getDeliveryWithComma() }
								</c:when>
								<c:otherwise>
									무료배송
								</c:otherwise>
							</c:choose></td>
						<td class="total">
							<input type="hidden" name="total" value="${cart.getTotal() }" />
							${cart.getTotalWithComma() }
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- 최종 결제 정보 -->
		<div class="final">
			<h2>최종결제 정보</h2>
			<table>
				<tr>
					<td>총</td>
					<td>
						<input type="hidden" name="ordCount" value="${carts.size() }" />
						${carts.size() }건
					</td>
				</tr>
				<tr>
					<td>상품금액</td>
					<td>
						<input type="hidden" name="ordPrice" value="" />
						<span id="price" class="totalForm">0</span>
					</td>
				</tr>
				<tr>
					<td>할인금액</td>
					<td>
						<input type="hidden" name="ordDiscount" value="" />
						<span id="disPrice" class="totalForm">0</span>
					</td>
				</tr>
				<tr>
					<td>배송비</td>
					<td>
						<input type="hidden" name="ordDelivery" value="" />
						<span id="delivery" class="totalForm">0</span>
					</td>
				</tr>
				<tr>
					<td>포인트 할인</td>
					<td>
						<input type="hidden" name="savePoint" value="" />
						<span id="point" class="totalForm">0</span>
					</td>
				</tr>
				<tr>
					<td>전체주문금액</td>
					<td>
						<input type="hidden" name="ordTotPrice" value="" />
						<span id="total" class="totalForm">0</span>
					</td>
				</tr>
			</table>
			<input type="button" name="" value="결제하기">
		</div>

		<!-- 배송정보 -->
		<article class="delivery">
			<h1>배송정보</h1>
			<table>
				<tr>
					<td>수령인</td>
					<td><input type="text" name="recipName" value="ppp"/></td>
				</tr>
				<tr>
					<td>휴대폰</td>
					<td><input type="text" name="recipHp" /> <span>- 포함 입력</span></td>
				</tr>
				<tr>
					<td>우편번호</td>
					<td>
						<input type="text" name="recipZip" /> 
						<input type="button" value="검색" onclick="zipcode()"/>
					</td>
				</tr>
				<tr>
					<td>기본주소</td>
					<td><input type="text" name="recipAddr1" /></td>
				</tr>
				<tr>
					<td>상세주소</td>
					<td><input type="text" name="recipAddr2" /></td>
				</tr>
			</table>
		</article>

		<!-- 할인정보 -->
		<article class="discount">
			<h1>할인정보</h1>
			<div>
				<p>
					현재 포인트 : <span>500</span>점
				</p>
				<label> 
					<input type="number" name="usedPoint" min="0"/>점 
					<input type="button" value="적용" onclick="usePoint()"/>
				</label> <span>포인트 5,000점 이상이면 현금처럼 사용 가능합니다.</span>
			</div>
		</article>

		<!-- 결제방법 -->
		<article class="payment">
			<h1>결제방법</h1>
			<div>
				<span>신용카드</span>
				<p>
					<label>
						<input type="radio" name="ordPayment" value="1" />신용카드 결제
					</label> 
					<label>
						<input type="radio" name="ordPayment" value="2" />체크카드 결제
					</label>
				</p>
			</div>
			<div>
				<span>계좌이체</span>
				<p>
					<label>
						<input type="radio" name="ordPayment" value="3" />실시간 계좌이체
					</label> 
					<label>
						<input type="radio" name="ordPayment" value="4" />무통장 입금
					</label>
				</p>
			</div>
			<div>
				<span>기타</span>
				<p>
					<label>
						<input type="radio" name="ordPayment" value="5" />휴대폰결제
					</label>
					<label> 
						<input type="radio" name="ordPayment" value="6" />카카오페이
						<img src="./img/ico_kakaopay.gif" alt="카카오페이" />
					</label>
				</p>
			</div>
		</article>
		<!-- 경고 -->
		<article class="alert">
			<ul>
				<li><span>케이마켓의 모든 판매자는 안전거래를 위해 구매금액, 결제수단에 상관없이 모든거래에
						대하여 케이마켓 유한책임회사의 구매안전서비스(에스크로)를 제공하고 있습니다.</span></li>
				<li><span>케이마켓 유한책임회사의 전자금융거래법에 의해 결제대금예치업 등록번호는
						02-006-00008 입니다.</span></li>
				<li><span>등록여부는 금융감독원 홈페이지(www.fss.or.kr)의
						업무자료>인허가업무안내>전자금융업등록현황에서 확인하실수 있습니다.</span></li>
			</ul>
		</article>
	</form>
</section>
<!-- 주문 페이지 끝-->
</main>
<%@ include file="./inc/footer.jsp"%>
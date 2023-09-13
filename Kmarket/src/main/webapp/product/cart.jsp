<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./inc/header.jsp"%>
<%@ include file="./inc/aside.jsp"%>
<!-- 장바구니 페이지 시작 -->
<section class="cart">
	<!-- 제목, 페이지 네비게이션 -->
	<nav>
		<h1>장바구니</h1>
		<p>
			HOME > <span>패션·의류·뷰티</span> > <strong>장바구니</strong>
		</p>
	</nav>
	<form action="#">
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
						<tr>
							<td><input type="checkbox" name=""></td>
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
							<td>${cart.count }</td>
							<td>${cart.product.getPriceWithComma() }</td>
							<td>${cart.product.discount }%</td>
							<td>${cart.product.point }</td>
							<td>
								<c:choose>
									<c:when test="${cart.product.delivery gt 0 }">
										${cart.product.getDeliveryWithComma() }
									</c:when>
									<c:otherwise>
										무료배송
									</c:otherwise>
								</c:choose>
							</td>
							<td>${cart.getTotalWithComma() }</td>
						</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		<input type="button" name="del" value="선택삭제">
		<!-- 장바구니 전체합계 -->
		<div class="total">
			<h2>전체합계</h2>
			<table>
				<tr>
					<td>상품수</td>
					<td>0</td>
				</tr>
				<tr>
					<td>상품금액</td>
					<td>0</td>
				</tr>
				<tr>
					<td>할인금액</td>
					<td>0</td>
				</tr>
				<tr>
					<td>배송비</td>
					<td>0</td>
				</tr>
				<tr>
					<td>포인트</td>
					<td>0</td>
				</tr>
				<tr>
					<td>전체주문금액</td>
					<td>0</td>
				</tr>
			</table>
			<input type="submit" name="" value="주문하기">
		</div>
	</form>
</section>
<!-- 장바구니 페이지 끝 -->
</main>
<%@ include file="./inc/footer.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./inc/header.jsp" %>
<script>
	$(function() {
		$.ajax({
			url: '${path}/cate.do',
			type: 'GET',
			data: '',
			dataType: 'json',
		 	contentType: "application/json; charset:UTF-8", 
			success: function(data) {
				$('.category').children().remove();
				$('.category').append(data.cate);
			}
		});
		
		$(".bx_slider").bxSlider({
			auto: true,
			stopAutoOnClick: true,
			pager: true
		})
	});
</script>
      <main>
        <!-- 카테고리/베스트 상품 영역 -->
        <aside>
          <!-- 카테고리 -->
          <ul class="category">
          </ul>
          <!-- 베스트상품 배너 -->
          <article class="best">
            <h1><i class="fas fa-crown"></i>베스트상품</h1>
            <ol>
            	<c:forEach var="product" items="${bestProducts }" varStatus="status">
            		<c:choose>
            			<c:when test="${status.index eq 0 }">
	            			<li>
				                <a href="${path }/product/view.do?prodNo=${product.prodNo}&cate1=${product.prodCate1}&cate2=${product.prodCate2}">
				                  <div class="thumb">
				                    <i>1</i>
				                    <img src="${path }/thumb/${product.prodCate1}/${product.prodCate2}/${product.thumb1}" alt="item1" />
				                  </div>
				                  <h2>${product.prodName }</h2>
				                  <div class="org_price">
				                    <del>${product.getPriceWithComma() }</del>
				                    <span>${product.discount }%</span>
				                  </div>
				                  <div class="dis_price">
				                    <ins>${product.getDisPriceWithComma() }</ins>
				                  </div>
				                </a>
				              </li>
            			</c:when>
            			<c:otherwise>
            			<li>
			                <a href="${path }/product/view.do?prodNo=${product.prodNo}&cate1=${product.prodCate1}&cate2=${product.prodCate2}">
			                  <div class="thumb">
			                    <i>${status.index+1}</i>
			                    <img src="${path }/thumb/${product.prodCate1}/${product.prodCate2}/${product.thumb1}" alt="item1" />
			                  </div>
			                  <article>
			                    <h2>${product.prodName }</h2>
				                  <div class="org_price">
				                    <del>${product.getPriceWithComma() }</del>
				                    <span>${product.discount }%</span>
				                  </div>
				                  <div class="dis_price">
				                    <ins>${product.getDisPriceWithComma() }</ins>
				                  </div>
			                  </article>
			                </a>
			              </li>
            			</c:otherwise>
            		</c:choose>
            	</c:forEach>
            </ol>
          </article>
        </aside>
        <section>
          <!-- 슬라이더 영역 -->
          <section class="slider">
            <ul class="bx_slider">
              <li>
                <a href="#"
                  ><img src="${path }/img/slider1.jfif" alt="item1"
                /></a>
              </li>
              <li>
                <a href="#"
                  ><img src="${path }/img/slider2.jfif" alt="item2"
                /></a>
              </li>
              <li>
                <a href="#"
                  ><img src="${path }/img/slider3.jfif" alt="item3"
                /></a>
              </li>
              <li>
                <a href="#"
                  ><img src="${path }/img/slider4.jfif" alt="item4"
                /></a>
              </li>
              <li>
                <a href="#"
                  ><img src="${path }/img/slider5.jfif" alt="item5"
                /></a>
              </li>
            </ul>
          </section>
          <!-- 히트상품 영역 -->
          <section class="hit">
            <h3><span>히트상품</span></h3>
            <c:forEach var="product" items="${hitProducts }">
            <article>
              <a href="${path }/product/view.do?prodNo=${product.prodNo}&cate1=${product.prodCate1}&cate2=${product.prodCate2}">
                <div class="thumb">
                  <img class="i230" src="${path }/thumb/${product.prodCate1}/${product.prodCate2}/${product.thumb1}" alt="t1" />
                </div>
                <h2>${product.prodName }</h2>
                <p>${product.descript }</p>
                <div class="org_price">
                  <del>${product.getPriceWithComma() }</del>
                  <span>${product.discount }%</span>
                </div>
                <div class="dis_price">
                  <ins>${product.getDisPriceWithComma() }</ins>
                  <c:choose>
                  	<c:when test="${product.delivery eq 0 }">
                  		<span class="free">무료배송</span>
                  	</c:when>
                  	<c:otherwise>
                  		<span>${product.getDeliveryWithComma() }원</span>
                  	</c:otherwise>
                  </c:choose>
                </div>
              </a>
            </article>
            </c:forEach>
          </section>
          <!-- 추천상품 영역 -->
          <section class="recommend">
            <h3><span>추천상품</span></h3>
            <c:forEach var="product" items="${scoreProducts }">
            <article>
              <a href="${path }/product/view.do?prodNo=${product.prodNo}&cate1=${product.prodCate1}&cate2=${product.prodCate2}">
                <div class="thumb">
                  <img class="i230" src="${path }/thumb/${product.prodCate1}/${product.prodCate2}/${product.thumb1}" alt="t1" />
                </div>
                <h2>${product.prodName }</h2>
                <p>${product.descript }</p>
                <div class="org_price">
                  <del>${product.getPriceWithComma() }</del>
                  <span>${product.discount }%</span>
                </div>
                <div class="dis_price">
                  <ins>${product.getDisPriceWithComma() }</ins>
                  <c:choose>
                  	<c:when test="${product.delivery eq 0 }">
                  		<span class="free">무료배송</span>
                  	</c:when>
                  	<c:otherwise>
                  		<span>${product.getDeliveryWithComma() }원</span>
                  	</c:otherwise>
                  </c:choose>
                </div>
              </a>
            </article>
            </c:forEach>
          </section>
          <!-- 최신상품 영역 -->
          <section class="new">
            <h3><span>최신상품</span></h3>
            <c:forEach var="product" items="${rdateProducts }">
            <article>
              <a href="${path }/product/view.do?prodNo=${product.prodNo}&cate1=${product.prodCate1}&cate2=${product.prodCate2}">
                <div class="thumb">
                  <img class="i230" src="${path }/thumb/${product.prodCate1}/${product.prodCate2}/${product.thumb1}" alt="t1" />
                </div>
                <h2>${product.prodName }</h2>
                <p>${product.descript }</p>
                <div class="org_price">
                  <del>${product.getPriceWithComma() }</del>
                  <span>${product.discount }%</span>
                </div>
                <div class="dis_price">
                  <ins>${product.getDisPriceWithComma() }</ins>
                  <c:choose>
                  	<c:when test="${product.delivery eq 0 }">
                  		<span class="free">무료배송</span>
                  	</c:when>
                  	<c:otherwise>
                  		<span>${product.getDeliveryWithComma() }원</span>
                  	</c:otherwise>
                  </c:choose>
                </div>
              </a>
            </article>
            </c:forEach>
          </section>
          <!-- 할인상품 영역 -->
          <section class="discount">
            <h3><span>할인상품</span></h3>
            <c:forEach var="product" items="${discountProducts }">
            <article>
              <a href="${path }/product/view.do?prodNo=${product.prodNo}&cate1=${product.prodCate1}&cate2=${product.prodCate2}">
                <div class="thumb">
                  <img class="i230" src="${path }/thumb/${product.prodCate1}/${product.prodCate2}/${product.thumb1}" alt="t1" />
                </div>
                <h2>${product.prodName }</h2>
                <p>${product.descript }</p>
                <div class="org_price">
                  <del>${product.getPriceWithComma() }</del>
                  <span>${product.discount }%</span>
                </div>
                <div class="dis_price">
                  <ins>${product.getDisPriceWithComma() }</ins>
                  <c:choose>
                  	<c:when test="${product.delivery eq 0 }">
                  		<span class="free">무료배송</span>
                  	</c:when>
                  	<c:otherwise>
                  		<span>${product.getDeliveryWithComma() }원</span>
                  	</c:otherwise>
                  </c:choose>
                </div>
              </a>
            </article>
            </c:forEach>
          </section>
        </section>
      </main>
<%@ include file="./inc/footer.jsp" %>
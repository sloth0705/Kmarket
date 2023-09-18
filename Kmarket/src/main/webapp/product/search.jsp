<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./inc/header.jsp" %>
<%@ include file="./inc/aside.jsp" %>
    <section class="list">
      <!-- 제목, 페이지 네비게이션 -->
      <nav>
        <h1>상품목록</h1>
        <p>HOME</p>
      </nav>
      <!-- 정렬 메뉴 -->
      <ul class="sort">
          <li><a href="${path }/product/search.do?sort=sold&pg=1&search=${search}" class="${sort eq 'sold' ? 'on' : ''}">판매많은순</a></li>
          <li><a href="${path }/product/search.do?sort=priceA&pg=1&search=${search}" class="${sort eq 'priceA' ? 'on' : ''}">낮은가격순</a></li>
          <li><a href="${path }/product/search.do?sort=priceD&pg=1&search=${search}" class="${sort eq 'priceD' ? 'on' : ''}">높은가격순</a></li>
          <li><a href="${path }/product/search.do?sort=score&pg=1&search=${search}" class="${sort eq 'score' ? 'on' : ''}">평점높은순</a></li>
          <li><a href="${path }/product/search.do?sort=review&pg=1&search=${search}" class="${sort eq 'review' ? 'on' : ''}">후기많은순</a></li>
          <li><a href="${path }/product/search.do?sort=rdate&pg=1&search=${search}" class="${sort eq 'rdate' ? 'on' : ''}">최근등록순</a></li>
      </ul>
      <!-- 상품목록 -->              
      <table>     
      	<c:forEach var="product" items="${products}" varStatus="status">             
        <tr>
          <td><a href="#" class="thumb"><img src="${path }/upload/${product.thumb1}" alt="상품이미지"/></a></td>
          <td>
            <h3 class="name">${product.prodName }</h3>
            <a href="${path }/product/view.do?prodNo=${product.prodNo}&cate1=${cate1}&cate2=${cate2}" class="desc">${product.descript }</a>
          </td>
          <td>
            <ul>
              <li><ins class="dis-price">${product.getDisPriceWithComma() }</ins></li>
              <li>
                <del class="org-price">${product.getPriceWithComma() }</del>
                <span class="discount">${product.discount }%</span>
              </li>
              <li>
              	<c:choose>
              		<c:when test="${product.delivery gt 0 }">
              			<span>배송비 ${product.getDeliveryWithComma() }</span>
              		</c:when>
              		<c:otherwise>
              			<span class="free-delivery">무료배송</span>
              		</c:otherwise>
              	</c:choose>
              </li>
            </ul>
          </td>
          <td>
            <h4 class="seller"><i class="fas fa-home"></i>&nbsp;${product.seller }</h4>
            <h5 class="badge power">판매자등급</h5>
            <h6 class="rating star${product.score }">상품평</h6>
          </td>
        </tr>
        </c:forEach>
      </table>            
      <!-- 상품목록 페이지번호 -->
      <div class="paging">
      	<c:if test="${pageGroupStart gt 1 }">
	        <span class="prev">
	          <a href="#"><&nbsp;이전</a>
	        </span>
        </c:if>
        <c:forEach var="i" begin="${pageGroupStart }" end="${pageGroupEnd }">
	        <span class="num">
	          <a href="${path }/product/search.do?pg=${pg}&search=${search}" class="${i eq pg ? 'on' : '' }">${i }</a>
	        </span>
        </c:forEach>
        <c:if test="${pageGroupEnd lt lastPageNum }">
	        <span class="next">
	          <a href="#">다음&nbsp;></a>
	        </span>
        </c:if>
      </div>
    </section>
</main>
<%@ include file="./inc/footer.jsp" %>
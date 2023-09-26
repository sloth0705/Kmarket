<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./inc/header.jsp" %>
    <section id="cs">
        <div class="main">
            <h1 class="title"><strong>케이마켓</strong>이 도와드릴게요!</h1>
            <section class="notice">
                <h1>공지사항
                    <a href="${path }/cs/noticeBoard/list.do?group=notice&cate=All&pg=1">전체보기</a>
                </h1>
                <c:choose>
                <c:when test="${!empty boards }">
	                <c:forEach var="notice" items="${boards }">
	                <ul>
	                    <li>
	                        <a href="${path }/cs/noticeBoard/view.do?group=notice&cate=All&bno=${notice.bno}" class="title">
	                        	[${notice.typeName }] ${notice.title }
	                        </a>
	                        <span class="date">${notice.rdate }</span>
	                    </li>
	                </ul>
	                </c:forEach>
                </c:when>
                <c:otherwise>
           			<ul>
						<li>등록된 게시물이 없습니다.</li>
					</ul>
        		</c:otherwise>
        		</c:choose>
            </section>

            <section class="faq">
                <h1>자주 묻는 질문
                    <a href="${path }/cs/faqBoard/list.do?group=faq&cate=member">전체보기</a>
                </h1>
                <ol>
                    <li>
                        <a href="${path }/cs/faqBoard/list.do?group=faq&cate=member">
                        	<span>회원</span>
                        </a>
                    </li>
                    <li>
                        <a href="${path }/cs/faqBoard/list.do?group=faq&cate=coupon">
                        	<span>쿠폰/이벤트</span>
                        </a>
                    </li>
                    <li>
                        <a href="${path }/cs/faqBoard/list.do?group=faq&cate=order">
                        	<span>주문/결제</span>
                        </a>
                    </li>
                    <li>
                        <a href="${path }/cs/faqBoard/list.do?group=faq&cate=delivery">
                        	<span>배송</span>
                        </a>
                    </li>
                    <li>
                        <a href="${path }/cs/faqBoard/list.do?group=faq&cate=cancle">
                        	<span>취소/반품/교환</span>
                        </a>
                    </li>
                    <li>
                        <a href="${path }/cs/faqBoard/list.do?group=faq&cate=travel">
                        	<span>여행/숙박/항공</span>
                        </a>
                    </li>
                    <li>
                        <a href="${path }/cs/faqBoard/list.do?group=faq&cate=safe">
                        	<span>안전거래</span>
                        </a>
                    </li>
                </ol>
            </section>

            <section class="qna">
                <h1>
                    문의하기
                    <a href="${path }/cs/qnaBoard/list.do?group=qna&cate=member&pg=1">더보기</a>
                </h1>
                <c:choose>
				    <c:when test="${!empty qnas}">
				        <c:forEach var="qna" items="${qnas}">
				            <ul>
				                <li>
				                    <a href="${path}/cs/qnaBoard/view.do?group=qna&cate=${qna.cate }&bno=${qna.bno}" class="title">
				                        [${qna.typeName}] ${qna.title}
				                    </a>
				                    <p>
				                        <span class="uid">
				                            <c:choose>
				                                <c:when test="${sessMember.type ge 2}">
				                                    ${qna.uid}
				                                </c:when>
				                                <c:otherwise>
			                                    	${qna.maskingUid(qna.uid)}
				                                </c:otherwise>
				                            </c:choose>
				                        </span>
				                        <span class="date">${qna.rdate}</span>
				                    </p>
				                </li>
				            </ul>
				        </c:forEach>
				    </c:when>
				    <c:otherwise>
				        <ul>
				            <li>등록된 게시물이 없습니다.</li>
				        </ul>
				    </c:otherwise>
				</c:choose>
                <a href="${path }/cs/qnaBoard/write.do" class="ask">
                	문의글 작성 &gt;
               	</a>
            </section>

            <section class="tel">
                <h1>
                    1:1 상담이 필요하신가요?
                </h1>

                <article>
                    <div>
                        <h3>고객센터 이용안내</h3>
                        <p>
                            <span>일반회원/비회원</span><br />
                            <strong>1566-0001</strong><span>(평일 09:00 ~ 18:00)</span>
                        </p>
                        <p>
                            <span>스마일클럽 전용</span><br />
                            <strong>1566-0002</strong><span>(365일 09:00 ~ 18:00)</span>
                        </p>
                    </div>
                </article>
                <article>
                    <div>
                        <h3>판매상담 이용안내</h3>
                        <p>
                            <span>판매고객</span><br />
                            <strong>1566-5700</strong><span>(평일 09:00 ~ 18:00)</span>
                        </p>
                        <p>
                            <a href="${path }/cs/faqBoard/list.do?group=faq&cate=member">
                            	판매자 가입 및 서류 접수 안내 &gt;
                            </a>
                        </p>
                    </div>
                </article>
            </section>
        </div>
    </section>
<%@ include file="./inc/footer.jsp" %>
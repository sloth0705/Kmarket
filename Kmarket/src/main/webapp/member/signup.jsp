<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./inc/header.jsp" %>
<script>
$(function(){
	$('.agree').click(function(e){
		
		const chk1 = $('input:checkbox[name="agree1"]');
		const chk2 = $('input:checkbox[name="agree2"]');
		const chk3 = $('input:checkbox[name="agree3"]');
		
		if (chk1.is(':checked') == false)
		{
		e.preventDefault();
			alert('사이트 이용 약관에 동의를 하셔야 회원가입하실 수 있습니다.');
		}
		else if (chk2.is(':checked') == false)
		{
			e.preventDefault();
			alert('개인정보 수집동의를 하셔야 회원가입하실 수 있습니다.');
		}
		else if (chk3.is(':checked') == false)
		{
			e.preventDefault();
			alert('전자금융거래 이용약관에 동의를 하셔야 회원가입하실 수 있습니다.');
		}
	});
});
</script>
<main id="member">
    <div class="signup">
        <form action="${path}/member/register.do">
        	<input type="hidden" name="type" value="${type}"/>
        	<nav>
            	<h1>약관동의</h1>
         	</nav>
	         <section>
	             <h3><span class="essential">(필수)</span>케이마켓 이용약관</h3>
	             <c:if test="${type eq 'normal'}">
	             	<textarea class="terms" readonly>${dto.terms}</textarea>
	             </c:if>
	             <c:if test="${type eq 'seller'}">
	             	<textarea class="terms" readonly>${dto.tax}</textarea>
	             </c:if>
	             <label><input type="checkbox" name="agree1" />동의합니다.</label>
	
	             <h3><span class="essential">(필수)</span>개인정보 수집동의</h3>
	             <textarea class="financial" readonly>${dto.privacy}</textarea>
	             <label><input type="checkbox" name="agree2" />동의합니다.</label>
	
	             <h3><span class="essential">(필수)</span>전자금융거래 이용약관</h3>
	             <textarea class="privacy" readonly>${dto.finance}</textarea>
	             <label><input type="checkbox" name="agree3" />동의합니다.</label>
	         </section>
	
			 <c:if test="${type eq 'normal'}">
	         <section>
	             <h3><span class="optional">(선택)</span>위치정보 이용약관</h3>
	             <textarea class="location" readonly>${dto.location}</textarea>
	             <label><input type="checkbox" name="agree4" />동의합니다.</label>
	         </section>
	         </c:if>
	
	         <div>
	             <input type="submit" class="agree" value="동의하기" />
	         </div>
        </form>
    </div>
</main>
<%@ include file="./inc/footer.jsp" %>
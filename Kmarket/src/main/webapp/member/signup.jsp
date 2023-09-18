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
	
	// 체크박스 전체 선택
	$('input[name=agreeAll]').click(function(e){
	    $(this).parents(".checkbox_group").find('input').prop("checked", $(this).is(":checked"));
	});
	
	// 체크박스 개별 선택
	$(".checkbox_group").on("click", ".checkAgree", function() {
		
	    var is_checked = true;
	    
	    $(".checkbox_group .checkAgree").each(function(){
	        is_checked = is_checked && $(this).is(":checked");
	    });

	    $("input[name=agreeAll]").prop("checked", is_checked);
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
			<section class="checkbox_group">
				<c:if test="${type eq 'normal'}">
				 	<h3 class="normal">이용약관, 개인정보 수집, 전자금융거래 이용약관, 위치정보 이용약관(선택)에 <span>모두 동의</span>합니다.</h3>
			    </c:if>
			    <c:if test="${type eq 'seller'}">
			    	<h3 class="seller">이용약관, 개인정보 수집, 전자금융거래 이용약관에 <span>모두 동의</span>합니다.</h3>
			    </c:if>
			    <label><input type="checkbox" name="agreeAll"/>동의합니다.</label>
				 
			    <h3><span class="essential">(필수)</span>케이마켓 이용약관</h3>
			    <c:if test="${type eq 'normal'}">
			    	<textarea class="terms" readonly>${dto.terms}</textarea>
			    </c:if>
			    <c:if test="${type eq 'seller'}">
			    	<textarea class="terms" readonly>${dto.tax}</textarea>
			    </c:if>
			    <label><input type="checkbox" name="agree1" class="checkAgree"/>동의합니다.</label>
			
			    <h3><span class="essential">(필수)</span>개인정보 수집동의</h3>
			    <textarea class="financial" readonly>${dto.privacy}</textarea>
			    <label><input type="checkbox" name="agree2" class="checkAgree"/>동의합니다.</label>
			
			    <h3><span class="essential">(필수)</span>전자금융거래 이용약관</h3>
			    <textarea class="privacy" readonly>${dto.finance}</textarea>
			    <label><input type="checkbox" name="agree3" class="checkAgree"/>동의합니다.</label>
			    
			    <c:if test="${type eq 'normal'}">
				<section>
				    <h3><span class="optional">(선택)</span>위치정보 이용약관</h3>
				    <textarea class="location" readonly>${dto.location}</textarea>
				    <label><input type="checkbox" name="agree4" class="checkAgree"/>동의합니다.</label>
				</section>
				</c:if>
			</section>
			<div>
			    <input type="submit" class="agree" value="동의하기" />
			</div>
        </form>
    </div>
</main>
<%@ include file="./inc/footer.jsp" %>
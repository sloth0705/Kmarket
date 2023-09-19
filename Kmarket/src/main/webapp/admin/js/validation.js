/**
 * 상품 등록 시 입력데이터 유효성검증
 */

 // 폼 데이터 검증결과 상태변수
let isCompanyOk  = false;
let isPriceOk    = false;
let isDiscountOk = false;
let isPointOk    = false;
let isStockOk    = false;
let isDeliveryOk = false;
let isStatusOk   = false;
let isDutyOk     = false;
let isOriginOk   = false;

// 데이터 검증에 사용하는 정규표현식
const reCompany  = /^[가-힣a-zA-Z]+$/;
const rePrice    = /^[0-9]+$/;    // 숫자만 가능
const reDiscount = /[0-9]{1,2}$/; // 두자리 수까지 가능
const rePoint    = /^[0-9]+$/;
const reStock    = /^[0-9]+$/;
const reDelivery = /^[0-9]+$/;

// 유효성검증 (Validation)
$(function(){
	
	// 제조사 입력값 검사
	$('input[name=company]').focusout(function(){
		
		const company = $(this).val();
		
		if (!company.match(reCompany))
		{
			$('.resultCompany').css('color', 'red').text('숫자나 특수문자만 입력은 불가합니다.');
			isCompanyOk = false;
		}
		else
		{
			$('.resultCompany').text('');
			isCompanyOk = true;
		}
	});
	
	// 판매가격 입력값 검사
	$('input[name=price]').focusout(function(){
		
		const price = $(this).val();
		
		if (!price.match(rePrice))
		{
			$('.resultPrice').css('color', 'red').text('숫자만 입력 가능합니다.');
			isPriceOk = false;
		}
		else
		{
			$('.resultPrice').text('');
			isPriceOk = true;
		}
	});
	
	// 할인율 입력값 검사
	$('input[name=discount]').focusout(function(){
		
		const discount = $(this).val();
		
		if (!discount.match(reDiscount))
		{
			$('.resultDiscount').css('color', 'red').text('두 자리 수까지만 입력 가능합니다.');
			isDiscountOk = false;
		}
		else
		{
			$('.resultDiscount').text('');
			isDiscountOk = true;
		}
	});
	
	// 포인트 입력값 검사
	$('input[name=point]').focusout(function(){
		
		const point = $(this).val();
		
		if (!point.match(rePoint))
		{
			$('.resultPoint').css('color', 'red').text('숫자만 입력 가능합니다.');
			isPointOk = false;
		}
		else
		{
			$('.resultPoint').text('');
			isPointOk = true;
		}
	});
	
	// 재고수량 입력값 검사
	$('input[name=stock]').focusout(function(){
		
		const stock = $(this).val();
		
		if (!stock.match(reStock))
		{
			$('.resultStock').css('color', 'red').text('숫자만 입력 가능합니다.');
			isStockOk = false;
		}
		else
		{
			$('.resultStock').text('');
			isStockOk = true;
		}
	});
	
	// 배송비 입력값 검사
	$('input[name=delivery]').focusout(function(){
		
		const delivery = $(this).val();
		
		if (!delivery.match(reDelivery))
		{
			$('.resultDelivery').css('color', 'red').text('숫자만 입력 가능합니다.');
			isDeliveryOk = false;
		}
		else
		{
			$('.resultDelivery').text('');
			isDeliveryOk = true;
		}
	});
	
	// 상품등록 폼 최종전송
	$('#form').submit(function(){
		
		if (!isProdNameOk)
		{
			alert('상품명을 확인하십시오.');
			return false; // 폼 전송 취소
		}
		if (!isCompanyOk)
		{
			alert('제조사를 확인하십시오.');
			return false; // 폼 전송 취소
		}
		if (!isPriceOk)
		{
			alert('판매가격을 확인하십시오.');
			return false; // 폼 전송 취소
		}
		if (!isDiscountOk)
		{
			alert('할인율을 확인하십시오.');
			return false; // 폼 전송 취소
		}
		if (!isPointOk)
		{
			alert('포인트를 확인하십시오.');
			return false; // 폼 전송 취소
		}
		if (!isStockOk)
		{
			alert('재고수량을 확인하십시오.');
			return false; // 폼 전송 취소
		}
		if (!isDeliveryOk)
		{
			alert('배송비를 확인하십시오.');
			return false; // 폼 전송 취소
		}
		if (!isStatusOk)
		{
			alert('상품상태를 확인하십시오.');
			return false; // 폼 전송 취소
		}
		if (!isDutyOk)
		{
			alert('부가세 면세여부를 확인하십시오.');
			return false; // 폼 전송 취소
		}
		if (!isOriginOk)
		{
			alert('원산지를 확인하십시오.');
			return false; // 폼 전송 취소
		}
		
		return true; // 폼 전송 시작
	});
});
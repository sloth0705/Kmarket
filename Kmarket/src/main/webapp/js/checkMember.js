/**
 * 사용자 입력데이터 유효성검증 및 중복체크
 */
$(function(){
	
	// 아이디 입력데이터
	const inputUid    = document.getElementsByName('uid')[0];
	const resultUid   = document.getElementsByClassName('msgId')[0];
	const btnCheckUid = document.getElementById('btnCheckUid');
	
	if (btnCheckUid != null)
	{
		btnCheckUid.onclick = function(){
			
			const uid = inputUid.value;
			
			// 아이디 입력값 검사
			if (!uid.match(reUid))
			{
				resultUid.innerText = '아이디는 영문, 숫자로 4~12자까지만 가능합니다.';
				resultUid.style.color = 'red';
				isUidOk = false;
				return;
			}
			
			// 서버 전송
			const xhr = new XMLHttpRequest();
			xhr.open('GET', '/Kmarket/member/checkUid.do?uid='+inputUid.value);
			xhr.send();
			
			xhr.onreadystatechange = function(){
				if (xhr.readyState == XMLHttpRequest.DONE)
				{
					if (xhr.status == 200)
					{
						const data = JSON.parse(xhr.response);
						
						if (data.result > 0)
						{
							resultUid.innerText = '이미 사용중인 아이디입니다.';
							resultUid.style.color = 'red';
							isUidOk = false;
						}
						else
						{
							resultUid.innerText = '사용 가능한 아이디입니다.'
							resultUid.style.color = 'green';
							isUidOk = true;
						}
					}
				}
			}
		} // btnCheckUid.onclick end
	}
	
	// 이메일 입력데이터
	document.getElementsByName('email')[0].onfocusout = function(){

		const resultEmail   = document.getElementsByClassName('resultEmail')[0];

		// 입력 데이터 가져오기
		const email = this.value;

		if (!email.match(reEmail))
		{
			resultEmail.innerText = '유효한 이메일이 아닙니다.';
			resultEmail.style.color = 'red';
			isEmailOk = false;
			return;
		}

		// 데이터 전송
		const xhr = new XMLHttpRequest();
		xhr.open('GET', '/Kmarket/member/checkEmail.do?email='+email);
		xhr.send();

		// 응답 결과
		xhr.onreadystatechange = function(){    				
			if (xhr.readyState == XMLHttpRequest.DONE)
			{						
				if (xhr.status == 200)
				{
					const data = JSON.parse(xhr.response);
					console.log('data : ' + data);

					if (data.result >= 1)
					{
						resultEmail.innerText = '이미 사용중인 이메일 입니다.';
						resultEmail.style.color = 'red';
						isEmailOk = false;
					}
					else
					{
						resultEmail.innerText = '사용 가능한 이메일 입니다.';
						resultEmail.style.color = 'green';
						isEmailOk = true;
					}
				}
			}    				
		}
	}
	
	// 휴대폰번호 입력데이터
	$('input[name=hp]').focusout(function(){
		
		const hp  = $(this).val();
		
		// 휴대폰번호 입력값 검사
		if(!hp.match(reHp))
		{
			$('.msgHp').css('color', 'red').text('유효한 휴대폰번호가 아닙니다.');
			isHpOk = false;
			return;	
		}
		
		// 데이터 전송
		const url = '/Kmarket/member/checkHp.do?hp='+hp;
		$.get(url, function(result){
			
			const data = JSON.parse(result);
			
			if(data.result > 0)
			{
				$('.msgHp').css('color', 'red').text('이미 사용중인 휴대폰번호입니다.');
				isHpOk = false;
			}
			else
			{
				$('.msgHp').css('color', 'green').text('사용 가능한 휴대폰번호입니다.');
				isHpOk = true;
			}
		});
	});
	
	// 회사명 입력데이터
	$('input[name=company]').focusout(function(){
		
		const company = $(this).val();
		
		// 회사명 입력값 검사
		if(!company.match(reCompany))
		{
			$('.msgCompany').css('color', 'red').text('유효한 회사명 형식이 아닙니다. (주)포함 입력하여야 합니다.');
			isCompanyOk = false;
			return;	
		}
		
		// 데이터 전송
		const url = '/Kmarket/member/checkCompany.do?company='+company;
		$.get(url, function(result){
			
			const data = JSON.parse(result);
			
			if(data.result > 0)
			{
				$('.msgCompany').css('color', 'red').text('이미 가입한 회사입니다.');
				isCompanyOk = false;
			}
			else
			{
				$('.msgCompany').css('color', 'green').text('해당 회사로 가입 가능합니다.');
				isCompanyOk = true;
			}
		});
	});
	
	// 사업자등록번호 입력데이터
	$('input[name=bizRegNum]').focusout(function(){
		
		const bizRegNum = $(this).val();
		
		// 사업자등록번호 입력값 검사
		if(!bizRegNum.match(reBizRegNum))
		{
			$('.msgCorp').css('color', 'red').text('유효한 사업자등록번호가 아닙니다.');
			isBizRegNumOk = false;
			return;	
		}
		
		// 데이터 전송
		const url = '/Kmarket/member/checkBizRegNum.do?bizRegNum='+bizRegNum;
		$.get(url, function(result){
			
			const data = JSON.parse(result);
			
			if(data.result > 0)
			{
				$('.msgCorp').css('color', 'red').text('이미 존재하는 사업자등록번호입니다.');
				isBizRegNumOk = false;
			}
			else
			{
				$('.msgCorp').css('color', 'green').text('해당 사업자등록번호로 가입 가능합니다.');
				isBizRegNumOk = true;
			}
		});
	});
	
	// 통신판매신고번호 입력데이터
	$('input[name=comRegNum]').focusout(function(){
		
		const comRegNum = $(this).val();
		
		// 통신판매신고번호 입력값 검사
		if(!comRegNum.match(reComRegNum))
		{
			$('.msgOnline').css('color', 'red').text('유효한 통신판매신고번호가 아닙니다.');
			isComRegNumOk = false;
			return;	
		}
		
		// 데이터 전송
		const url = '/Kmarket/member/checkComRegNum.do?comRegNum='+comRegNum;
		$.get(url, function(result){
			
			const data = JSON.parse(result);
			
			if(data.result > 0)
			{
				$('.msgOnline').css('color', 'red').text('이미 존재하는 통신판매신고번호입니다.');
				isComRegNumOk = false;
			}
			else
			{
				$('.msgOnline').css('color', 'green').text('해당 통신판매신고번호로 가입 가능합니다.');
				isComRegNumOk = true;
			}
		});
	});
	
	// 회사 전화번호 입력데이터
	$('input[name=tel]').focusout(function(){
		
		const tel = $(this).val();
		
		// 회사 전화번호 입력값 검사
		if(!tel.match(reTel))
		{
			$('.msgTel').css('color', 'red').text('유효한 전화번호 양식이 아닙니다.');
			isTelOk = false;
			return;	
		}
		
		// 데이터 전송
		const url = '/Kmarket/member/checkTel.do?tel='+tel;
		$.get(url, function(result){
			
			const data = JSON.parse(result);
			
			if(data.result > 0)
			{
				$('.msgTel').css('color', 'red').text('이미 존재하는 전화번호입니다.');
				isTelOk = false;
			}
			else
			{
				$('.msgTel').css('color', 'green').text('해당 전화번호로 가입 가능합니다.');
				isTelOk = true;
			}
		});
	});
	
	// 팩스번호 입력데이터
	$('input[name=fax]').focusout(function(){
		
		const fax = $(this).val();
		
		// 팩스번호 입력값 검사
		if(!fax.match(reFax))
		{
			$('.msgFax').css('color', 'red').text('유효한 팩스번호 양식이 아닙니다.');
			isFaxOk = false;
			return;	
		}
		
		// 데이터 전송
		const url = '/Kmarket/member/checkFax.do?fax='+fax;
		$.get(url, function(result){
			
			const data = JSON.parse(result);
			
			if(data.result > 0)
			{
				$('.msgFax').css('color', 'red').text('이미 존재하는 팩스번호입니다.');
				isFaxOk = false;
			}
			else
			{
				$('.msgFax').css('color', 'green').text('해당 팩스번호로 가입 가능합니다.');
				isFaxOk = true;
			}
		});
	});
});
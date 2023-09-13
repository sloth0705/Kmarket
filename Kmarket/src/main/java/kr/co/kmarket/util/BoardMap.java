package kr.co.kmarket.util;

import java.util.HashMap;
import java.util.Map;

public class BoardMap {

	 public static Map<String, String> map 
	 	= new HashMap<String, String>() {
			private static final long serialVersionUID = -848437154327382613L;{
					// notice
			        put("All", "전체");
			        put("cs", "고객서비스");
			        put("safe", "안전거래");
			        put("dangerProd", "위해상품");
			        put("event", "이벤트당첨");
		          
			        // faq & qna 동일..?
			        put("member", "회원");
			        put("coupon", "쿠폰/이벤트");
			        put("order", "주문/결제");
			        put("delivery", "배달");
			        put("cancle", "취소/반품/교환");
			        put("travel", "여행/숙박/항공");
			        
				} // serialVersionUID 괄호
		}; // HashMap end 
}
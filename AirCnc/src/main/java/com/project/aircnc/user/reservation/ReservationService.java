package com.project.aircnc.user.reservation;

import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.aircnc.common.AircncMsg;
import com.project.aircnc.common.AircncMsglist;
import com.project.aircnc.common.KakaoApproveVO;
import com.project.aircnc.common.KakaoConstVO;
import com.project.aircnc.common.KakaoPayMentReady;
import com.project.aircnc.common.MsgRoomVO;
import com.project.aircnc.common.MyUtils;
import com.project.aircnc.common.ReservationVO;
import com.project.aircnc.common.RoomIMGVO;
import com.project.aircnc.common.RsvCancelVO;
import com.project.aircnc.common.RsvChangeVO;
import com.project.aircnc.common.SearchDetaileVO;
import com.project.aircnc.common.SearchVO;
import com.project.aircnc.common.TUserVO;
import com.project.aircnc.common.TripVO;
import com.project.aircnc.common.UserRsvCancelVO;
import com.project.aircnc.common.UserRsvChangeVO;

@Service
public class ReservationService {
	
	@Autowired
	ReservationMapper mapper;
	// 예약 화면 
	public SearchDetaileVO selReservation(SearchVO param) {
		SearchDetaileVO dbVO= mapper.selReservation(param);
		// host 유저 profile 경로 수정 
		String profileImg = dbVO.getPro_img();
		
		if(profileImg == null || profileImg.equals("")) {
			profileImg = "/resources/img/pimg.jpg";
		} else {
			profileImg = "/resources/user_img/user" + dbVO.getHost_i_user() + "/" + profileImg;
		}
		dbVO.setMy_profile(profileImg);
		// 숙소 이미지 ,추가 규칙 추가 
		dbVO.setRoomImgList(mapper.selRoomImg(param));
		dbVO.setDtlRuleList(mapper.selDtRule(param));
		
		for(RoomIMGVO imgVO : dbVO.getRoomImgList()) {
			String room_poto = "/resources/room_img/host" + imgVO.getI_host() + "/" + imgVO.getImg_url();
			imgVO.setRoom_poto(room_poto);
		}
		
		return dbVO;
	}
	
	// 예약 (메시지 방 생성및 메시지 추가 )
	public List<MsgRoomVO> inserRSV(ReservationVO param,HttpSession hs){
		// loginUser 정보 
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		param.setI_user(loginUser.getI_user());
		
		int result = 0;
		result = mapper.inserRSV(param);
		
		// 해당 숙소 인원 상태 변경(명수) 
		result = mapper.upRSV(param);
		
		
		// 메시지 방 생성 
		 // 숙소 주인과 함께 톡방 만들기 
		AircncMsglist msListVO = new AircncMsglist();
		msListVO.setI_reser(param.getI_reser()); // 예약 번호 pk
		msListVO.setI_host(param.getI_host()); // 예약 숙소 pk
		msListVO.setMs_title(param.getMs_title());// 톡방 제목 
		
		System.out.println(msListVO.toString());
		
		//System.out.println("i_user : "+msListVO.getI_user());
		result = mapper.inserMsglist(msListVO); // insert  
		
		//System.out.println("i_milst : "+msListVO.getI_mlist());
		
		// 톡방에 들어갈 사람들 정보 
		msListVO.setI_user(loginUser.getI_user()); // 현재 로그인 i_user
		result = mapper.inserMsgUsers(msListVO);
		msListVO.setI_user(param.getOp_i_user()); // 방주인 i_user 메시지 보낼 사람 
		result = mapper.inserMsgUsers(msListVO);
		
		AircncMsg msgVO = new AircncMsg(); // 톡방 메시지 insert 
		msgVO.setI_mlist(msListVO.getI_mlist());
		msgVO.setI_reser(msListVO.getI_reser());
		msgVO.setI_host(msListVO.getI_host());
		msgVO.setCmt(param.getCmt());
		msgVO.setI_user(loginUser.getI_user());
		result = mapper.inserMsg(msgVO); // insert 
		
		List<MsgRoomVO> list = mapper.selMsgRoom(msgVO);
		// 룸 이미지 경로 수정 
		for (MsgRoomVO dbVO : list) {
			String room_poto = "/resources/room_img/host" + dbVO.getI_host() + "/" + dbVO.getImg_url();
			dbVO.setRoom_poto(room_poto);
			
		}
		
		return list;
	}
	// 예약 취소 변경 메인 화면 
	public TripVO selRsv(ReservationVO param, HttpSession hs) {
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		param.setI_user(loginUser.getI_user());
		TripVO dbVO = mapper.selRsv(param);
		// 일수 계산 
		long date = 0;
		try {
			date = MyUtils.changeDate(dbVO.getChin(),dbVO.getChout());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbVO.setDate(date);
		
		return dbVO;
	}
	
	// 예약 취소 화면 
	public RsvCancelVO selrsvCancel(ReservationVO param,HttpSession hs) {
		TUserVO loginUser = (TUserVO) hs.getAttribute("loginUser");
		param.setI_user(loginUser.getI_user());
		
		RsvCancelVO dbVO = mapper.selrsvCancel(param);
		// 일수 계산 
		long date = 0;
		try {
			date = MyUtils.changeDate(dbVO.getChin(),dbVO.getChout());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbVO.setDate(date);
		// 사진 경로 수정 
		String room_poto = "/resources/room_img/host" + dbVO.getI_host() + "/" + dbVO.getImg_url();
		dbVO.setRoom_poto(room_poto);
		
		return dbVO;
	}
	
	// 예약 취소 실행 
	public int upInserRsv(UserRsvCancelVO param) {
		int result = 0;
		result =mapper.inserRsvCancel(param); // 취소 요청 데이터 삽입 
		
		return mapper.upRsv(param); // 예약 정보 상태값 변경 
	}
	
	// 예약 변경 화면 
	public RsvChangeVO selRsvChange(ReservationVO param, HttpSession hs) {
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		param.setI_user(loginUser.getI_user());
//		System.out.println("i_user : "+loginUser.getI_user());
		RsvChangeVO dbVO = mapper.selRsvChange(param);
		// 일수 게산 
		long date = 0;
		try {
			date = MyUtils.changeDate(dbVO.getChin(),dbVO.getChout());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbVO.setDate(date);
		// 사진 경로 수정 
		String room_poto = "/resources/room_img/host" + dbVO.getI_host() + "/" + dbVO.getImg_url();
		dbVO.setRoom_poto(room_poto);
		
		return dbVO;
	}
	
	public int upInserRsvChange(UserRsvChangeVO param, HttpSession hs) {
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		param.setI_user(loginUser.getI_user());
		int result = mapper.inserRsvChange(param); // 변경 요청 데이터 삽입 
		
		return mapper.upRsvChange(param); // 예약 정보 상태값 변경 
	}
	
	// 숙박 여부 확인 
	public String selExist(int i_host, int i_reser, String chin, String chout, int date , int qty) {
		SearchVO param = new SearchVO();
		
		param.setI_host(i_host);
		param.setI_reser(i_reser);
		param.setChin(chin);
		param.setChout(chout);
		param.setDate(date);
		param.setQty(qty);
		
		int inout = mapper.existInOut(param); // 해당 날짜 예약 가능 여부
		int inoutDate = mapper.existInOutDate(param); // 숙박 일 가능여부
		int Rvation = mapper.existRvation(param); // 인원 가능여부 
		
		if(inout != 1) {
			return "해당 날짜에 숙박이 불가 합니다.";
		}else if(inoutDate != 1) {
			return "최소, 최대 숙박 일수를 초과 했습니다.";
		}else if(Rvation != 1) {
			return "현재 숙박 가능인원을 초과 했습니다.";
		}else {
			return "o";
		}
		
	}
	
	// 기존 예약  숙박 일 . 인원 출력 (submit 확인용)
	public int checkData(RsvChangeVO param, HttpSession hs) {
		// user pk 받아오기 
		param.setI_user(MyUtils.getSesstion(hs));
		
		RsvChangeVO dbVO = mapper.checkData(param);
		
		System.out.println("param -> "+param);
		System.out.println("dbVO -> "+dbVO);
		
		if(dbVO.getChin().equals(param.getChin())  && dbVO.getChout().equals(param.getChout())  && dbVO.getQty() == param.getQty()) {
			return 0; // 변경 내용 없음 
		}
		return 1; // 변경 내용 있음 
	}
	
	// 카카오 페이 준비 
	public KakaoPayMentReady redKakaoPay(ReservationVO param,HttpSession hs) {
		
		// ----------------- 페이 고유 tid 받기 -----------------[start]
		HttpHeaders headers = new HttpHeaders();
		
		Charset utf8 = Charset.forName("UTF-8"); // meta 정보 주기(인코딩 유형)
		//요청을 JSON TYPE의 데이터만 담고있는 요청을 처리하겠다는 의미가 된다.
		MediaType mediaType = new MediaType(MediaType.APPLICATION_JSON, utf8);		
		headers.setAccept(Arrays.asList(mediaType)); // 미디어 유형 지정
//				List<MediaType> lst = Arrays.asList(mediaType);
//				System.out.println(lst);
		
		// url 인코딩(암호화)	
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.set("Authorization", "KakaoAK " +KakaoConstVO.KAKAO_APP_ADMIN_KEY);
		//내용 유형 헤더에 지정된 대로 본문의 미디어 유형을 설정합니다.
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>(); // parameter 데이터 추가할때 쓰는 변수
		//parameter
		map.add("cid", "TC0ONETIME");  // cid는 가맹점 승인을 받아야 쓸수 있습니다. 
		map.add("partner_order_id", "partner_order_id");
		map.add("partner_user_id", "partner_user_id");
		map.add("item_name", Integer.toString(param.getI_host())); // 제품이름
		map.add("quantity", Integer.toString(param.getQty()));// 상품 수량
		map.add("total_amount", Integer.toString(param.getTotal_fee())); // 결재 금액
		map.add("tax_free_amount", "0"); // 비과새
		map.add("approval_url", KakaoConstVO.KAKAO_APPROVAL_URL); // 성공 url
		map.add("fail_url", KakaoConstVO.KAKAO_CANCEL_URL); // 취소 url
		map.add("cancel_url", KakaoConstVO.KAKAO_FAIL_URL); // 실패 url
		
				
		HttpEntity<LinkedMultiValueMap<String, String>> entity = new HttpEntity(map,headers); // Entity 계체	 ->> map: 파라미터(보내줄 데이터) headers: 헤더 설정 정보
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> respEntity = restTemplate.exchange(KakaoConstVO.KAKAO_PAYMENT_READY, HttpMethod.POST, entity, String.class);
		//		KakaoConstVO.KAKAO_ACCESS_TOKEN_HOST : 요청 URL 
		//		HttpMethod.POST : 요청 방식 post		 
		//		entity : 헤더정보 및 파라미터 정보 
		
		String result = respEntity.getBody(); // 응답 데이터 받기(JSON)
		//System.out.println("result : "+result);
		
		ObjectMapper om = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		KakaoPayMentReady kpmr = null;
		try {
			kpmr = om.readValue(result, KakaoPayMentReady.class);
			
			//System.out.println("result :"+kpmr.toString());
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		KakaoApproveVO kaVO = new KakaoApproveVO();
		kaVO.setRv(param); // 예약 숙소 정보
		kaVO.setKpmr(kpmr); // 결제 고유 번호 (tid & redirect urls) 
		
		hs.setAttribute("KakaoApproveVO",kaVO); // 세션에 저장 
				
		return kpmr;
	}
	
	// 카카오 페이 결제 성공 
	public  List<MsgRoomVO> kakaoApprove(String pg_token,HttpSession hs) {
		/*
		 hs : sesstion
		 result : 결과 값
		 pg_token : 결재 토큰 
		 kaVO // 예약 숙소 정보 
		 */
		String result = "";
		KakaoApproveVO kaVO = (KakaoApproveVO) hs.getAttribute("KakaoApproveVO");
		kaVO.setPg_token(pg_token); 
		//----------------------------------------------------------
		HttpHeaders headers = new HttpHeaders();
		
		Charset utf8 = Charset.forName("UTF-8"); // meta 정보 주기(인코딩 유형)
		//요청을 JSON TYPE의 데이터만 담고있는 요청을 처리하겠다는 의미가 된다.
		MediaType mediaType = new MediaType(MediaType.APPLICATION_JSON, utf8);		
		headers.setAccept(Arrays.asList(mediaType)); // 미디어 유형 지정
//				List<MediaType> lst = Arrays.asList(mediaType);
//				System.out.println(lst);
		
		// url 인코딩(암호화)	
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.set("Authorization", "KakaoAK "+KakaoConstVO.KAKAO_APP_ADMIN_KEY);
		//내용 유형 헤더에 지정된 대로 본문의 미디어 유형을 설정합니다.
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>(); // parameter 데이터 추가할때 쓰는 변수
		//parameter
		map.add("cid", "TC0ONETIME"); 
		map.add("tid", kaVO.getKpmr().getTid()); 
		map.add("partner_order_id", "partner_order_id"); 
		map.add("partner_user_id", "partner_user_id"); 
		map.add("pg_token", kaVO.getPg_token()); 
		
		HttpEntity<LinkedMultiValueMap<String, String>> entity = new HttpEntity(map,headers); // Entity 계체	 ->> map: 파라미터(보내줄 데이터) headers: 헤더 설정 정보
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> respEntity = restTemplate.exchange(KakaoConstVO.KAKAO_PAYMENT_APPROVE, HttpMethod.POST, entity, String.class);
		//		KakaoConstVO.KAKAO_ACCESS_TOKEN_HOST : 요청 URL 
		//		HttpMethod.POST : 요청 방식 post		 
		//		entity : 헤더정보 및 파라미터 정보 
		
		result = respEntity.getBody();
		
		System.out.println("test result : "+result);
		
		List<MsgRoomVO> list = new ArrayList<MsgRoomVO>();
		ReservationVO vo = kaVO.getRv();
		vo.setCard_num("9436465158495031");
		vo.setCard_user_nm("카카오");
		vo.setCountry("korea");
		vo.setCvv("123");
		vo.setYm("05/15");
		
		//System.out.println("vo : "+vo.toString());
		
		list = inserRSV(vo, hs);
		
		return list;
	}

	
	
	
}

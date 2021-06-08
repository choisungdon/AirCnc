package com.project.aircnc.user;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.aircnc.common.KakaoConstVO;
import com.project.aircnc.common.KakaoTokenVO;
import com.project.aircnc.common.KakaoUserInfo;
import com.project.aircnc.common.MyUtils;
import com.project.aircnc.common.ProfitReviewVO;
import com.project.aircnc.common.RsvVO;
import com.project.aircnc.common.TUserVO;
import com.project.aircnc.common.UserLListVO;
import com.project.aircnc.common.UserLikeVO;
import com.project.aircnc.common.UserShowVO;


@Service
public class UserService {
	@Autowired
	private UserMapper mapper;
	// 회원 가입 
	public int join(TUserVO param) {
		// 암호화 
		String salt = MyUtils.gensalt(); // 암호화  Salt 받기 
		String pw = param.getC_pw(); // 비밀번호 
		String hashPw = MyUtils.hashPassword(pw, salt); // 비밀번호 암호화 
		
		param.setC_pw(hashPw); // 암호화 비밀번호 저장 
		param.setSalt(salt); // salt 저장 
		
		switch (checkEmail(param)) { // Email 중복 확인
		case 1: // 
			return 0; // 회원 가입 실패 :Email 중복

		default:
			return mapper.join(param); // return 1 -> 회원 가입 성공 
		}
		
	}
	 // Email 중복 확인 
	public int checkEmail(TUserVO param) {
		return mapper.checkEmail(param);
	}
	
	// 로그인 
	public String login (TUserVO param ,HttpSession hs) {
		//param에 email과 pw를 받아오고, vo에 db의 email, pw, salt를 받아온다.	
		String result= "오류";
		TUserVO vo;
		vo = mapper.login(param);
		
		// result ->   오류./ 1: 로그인 성공. /비밀번호 틀림 . /아이디 없음
		if (vo.getE_mail() != null) {
			String pw= MyUtils.hashPassword(param.getC_pw(), vo.getSalt());
			if(pw.equals(vo.getC_pw())) {
				vo.setC_pw(null);
				vo.setSalt(null);
				hs.setAttribute("loginUser",vo); // 로그인 유저 정보 저장 
				setProUrl(hs);
				result= "1";
			} else {
				result = "비밀번호 틀림";
			}
		} else {
			result= "아이디 없음";
		}
		
		return result;
	}
		
	// 카카카오 로그인 
	public int  kakaoLogin(String code,HttpSession hs) {
		int data = 0;
			//System.out.println("code : " + code); // 인가코드 
			
			// ----------------- 사용자 토큰 받기 -----------------[start]
			HttpHeaders headers = new HttpHeaders();
			
			Charset utf8 = Charset.forName("UTF-8"); // meta 정보 주기 
			//요청을 JSON TYPE의 데이터만 담고있는 요청을 처리하겠다는 의미가 된다.
			MediaType mediaType = new MediaType(MediaType.APPLICATION_JSON, utf8);		
			headers.setAccept(Arrays.asList(mediaType)); // 미디어 유형 지정
//			List<MediaType> lst = Arrays.asList(mediaType);
//			System.out.println(lst);
			
			// url 인코딩(암호화)	
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			//내용 유형 헤더에 지정된 대로 본문의 미디어 유형을 설정합니다.
			MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>(); // parameter 데이터 추가할때 쓰는 변수
			//parameter
			map.add("grant_type", "authorization_code");
			map.add("client_id", KakaoConstVO.KAKAO_CLIENT_ID);
			map.add("redirect_uri", KakaoConstVO.KAKAO_TOKEN_REDIRECT_URI);
			map.add("code", code);
			
			HttpEntity<LinkedMultiValueMap<String, String>> entity = new HttpEntity(map,headers); // Entity 계체	 ->> map: 파라미터(보내줄 데이터) headers: 헤더 설정 정보
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> respEntity = restTemplate.exchange(KakaoConstVO.KAKAO_ACCESS_TOKEN_HOST, HttpMethod.POST, entity, String.class);
			//		KakaoConstVO.KAKAO_ACCESS_TOKEN_HOST : 요청 URL 
			//		HttpMethod.POST : 요청 방식 post		 
			//		entity : 헤더정보 및 파라미터 정보 
			
			String result = respEntity.getBody(); // 응답 데이터 받기(JSON)
			System.out.println("result : "+result);
			// json 데이터 일반 java Object로 변환 
			ObjectMapper om = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			
			//	configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
			//  : 모르는 property에 대해 무시하고 넘어간다. 
			
			KakaoTokenVO tokenVO = null;
			try {
				// om.readValue : json 데이터 읽어 들임 (class는 KakaoTokenVO)
				tokenVO = om.readValue(result, KakaoTokenVO.class);
				//System.out.println("tokenVO : "+ tokenVO.toString()); // 
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//-----------------------사용자 정보 가져오기 위한 통신 세팅------------------------
			
			HttpHeaders headers2	= new HttpHeaders();	
			MediaType	mediaType2	= new MediaType(MediaType.APPLICATION_JSON,utf8);
			headers2.setAccept(Arrays.asList(mediaType2));
			headers2.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
			headers2.set("Authorization", "Bearer " +tokenVO.getAccess_token());
			
			HttpEntity<LinkedMultiValueMap<String, String>> entity2 = new HttpEntity("",headers2); // Entity 계체	 ->> map: 파라미터(보내줄 데이터) headers: 헤더 설정 정보
			
			ResponseEntity<String> respEntity2 = restTemplate.exchange(KakaoConstVO.KAKAO_API_HOST+"/v2/user/me", HttpMethod.POST, entity2, String.class);
			String result2 = respEntity2.getBody();
			//System.out.println("result2 : " + result2);
			
			KakaoUserInfo kui = null;
			
			try {
				kui = om.readValue(result2, KakaoUserInfo.class);
				
				System.out.println("id : "+kui.getId());
				System.out.println("connected_at: "+kui.getConnected_at());
				System.out.println("닉네임 : "+kui.getProperties().getNickname() );
				System.out.println("profile_image : "+kui.getProperties().getProfile_image() );
				System.out.println("thumbnail_image : "+kui.getProperties().getThumbnail_image());
				
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		return 1;
	}
	
	
	public String upUserPro(MultipartFile userPro,HttpSession hs) {
		// 로그인 유저정보 
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		
		// 파일 경로 설정 
		String realPath = hs.getServletContext().getRealPath("/"); //루트 절대경로 가져오기
		String imgFolder = realPath + "/resources/user_img/user" + loginUser.getI_user();
		
		// 기존 이미지가 있으면 삭제 처리 
		if(!"".equals(loginUser.getPro_img())) { 
			String imgPath = imgFolder + "/" + loginUser.getPro_img();
			MyUtils.deleteFile(imgPath);
		}
		// 프로필 이름 받기 
		String fileNm = MyUtils.saveFile(imgFolder, userPro);
		// 유정보 수정 
		loginUser.setPro_img(fileNm);
		// 프로필 update
		int result = mapper.upUserPro(loginUser);
		// 로그인 유저 프로필 경로 수정 
		setProUrl(hs);
		
		String profileImg = "/resources/user_img/user" + loginUser.getI_user() + "/" + loginUser.getPro_img();
		
		return profileImg;
	}
	
	// 프로필 삭제 
	public int delProfile(HttpSession hs) {
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		
		// 파일 경로 설정 
		String realPath = hs.getServletContext().getRealPath("/"); //루트 절대경로 가져오기
		String imgFolder = realPath + "/resources/user_img/user" + loginUser.getI_user();
		// 기존 이미지가 있으면 삭제 처리 
		if(!"".equals(loginUser.getPro_img())) { 
			String imgPath = imgFolder + "/" + loginUser.getPro_img();
			MyUtils.deleteFile(imgPath);
		}
		
		loginUser.setPro_img(null);
		// 로그인 유저 정보 수정 
		hs.setAttribute("loginUser", loginUser);
		setProUrl(hs);	
	
		return mapper.upUserPro(loginUser);
	}
	
	// 프로필 url  setter
	public void setProUrl(HttpSession hs) {
		// 로그인 유저정보 
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		
		String profileImg = loginUser.getPro_img(); // 이미지 파일 이름 
		
		if(profileImg == null || profileImg.equals("")) {
			profileImg = "/resources/img/pimg.jpg"; // 없으면 기본 이미지 
		} else {// 있으면 경로 삽입 
			profileImg = "/resources/user_img/user" + loginUser.getI_user() + "/" + profileImg;  
		}
		// 프로필 경로 수정 
		loginUser.setMy_profile(profileImg);
		// 로그인 유저 정보수정 
		hs.setAttribute("loginUser", loginUser);
	}
	
	// user 개인 수정 비동기  
	public int upUserVO(TUserVO param, HttpSession hs) {
		// 기존 로그인 유저 받아오기 
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		// i_user pk 받아오기 
		param.setI_user(MyUtils.getSesstion(hs));
		int result = mapper.upUserVO(param);
		if(result > 0) { // update 성공시 
			// 변경 정보에 따라 기존 정보 변경 
			switch (param.getKey()) {
			case "nm":
				loginUser.setNm(param.getNm());
				break;
				
			case "e_mail":
				loginUser.setE_mail(param.getE_mail());	
				break;
				
			case "bir_day":
				loginUser.setBir_day(param.getBir_day());
				break;
				
			case "ph":
				loginUser.setPh(param.getPh());
				break;
			}
			// 기존 login 정보 삭제 
			hs.removeAttribute("loginUser");
			// 변경 login 정보 삽입  
			hs.setAttribute("loginUser", loginUser);
		}
		
		return result;
	}
	
	// 로그인 보안(PW) 페이지 
	public TUserVO selUserMd(HttpSession hs) {
		// user pk 가져오기 
		TUserVO loginUser = new TUserVO();
		loginUser.setI_user(MyUtils.getSesstion(hs));
		// pw 수정날짜  가져오기
		return mapper.selUserMd(loginUser);
	}
	// 로그인 보안(PW 변경) 페이지 비동기
	public int upUserPW(String c_pw , String r_pw, HttpSession hs){
		int result = 0;
		// 변경  pw 정보 담기 
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		loginUser.setC_pw(c_pw);
		loginUser.setR_pw(r_pw);
		
		//(암호화) salt 값 가져오기 
		TUserVO	dbVO = mapper.login(loginUser);
		String pw = MyUtils.hashPassword(loginUser.getC_pw(), dbVO.getSalt());
		loginUser.setC_pw(pw);
		dbVO = mapper.selTUserVO(loginUser);
		// return 0: 오류, 1: 성공  2: 비밀번호 틀림
		if(dbVO != null) {
			// update 
			String salt = MyUtils.gensalt();
			String hashPw = MyUtils.hashPassword(loginUser.getR_pw(), salt);
			loginUser.setC_pw(hashPw);
			loginUser.setSalt(salt);
			// 변경 실행 
			return mapper.upUserPW(loginUser);
		}else {
			return 2;
		}
	}
	// 좋아요 목록 새로 만들기 
	public int inslikeList(int i_host,String title,HttpSession hs) {
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		
		UserLikeVO likeVO = new UserLikeVO(); // mapper에 넘겨줄 객체 
		UserLListVO listVO = new UserLListVO(); // mapper에 넘겨줄 객체 
		
		// 파라미터 객체 데이터 setter (숙소 제목) DB 저장 데이터 
		listVO.setI_user(loginUser.getI_user()); 
		listVO.setList_title(title);
		 
		mapper.insLikeList(listVO); // 목록 생성 (DB insert) listVO안에 새로 생성된 PK(i_list) 저장된 상태 
		
		// 파라미터 객체 데이터 setter (DB 저장 데이터)
		likeVO.setI_list(listVO.getI_list());
		likeVO.setI_host(i_host);
		likeVO.setI_user(loginUser.getI_user());
		int result = 0; // 결과 값 
		// 새로 생성된 저장 목록에 데이터 저장 
		result = mapper.insLikeUser(likeVO);
		if(result != 0) { // DB insert 성공시  i_list(저장 목록 pk) return 
			return listVO.getI_list();
		}
		return result;// 아니면 0 return 
	}
	// 좋아요 비활성화 
	public int delLikeUser(int i_host, HttpSession hs) {
		// 파라미터 객체 데이터 setter (DB 삭제 할 데이터)
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		UserLikeVO likeVO = new UserLikeVO();
		
		likeVO.setI_user(loginUser.getI_user());
		likeVO.setI_host(i_host);
		
		return mapper.delLikeUser(likeVO);
	}
	// 기존 좋아요 목록에 저장 
	public int insLikeUser(int i_host, int i_list, HttpSession hs) {
		// 파라미터 객체 데이터 setter (DB 저장 데이터)
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		
		UserLikeVO likeVO = new UserLikeVO();
		likeVO.setI_host(i_host);
		likeVO.setI_user(loginUser.getI_user());
		likeVO.setI_list(i_list);
		
		return mapper.insLikeUser(likeVO);
	}
	
	// 프로필 이동  페이지 
	public UserShowVO selUsePro(HttpSession hs) {
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		return mapper.selUsePro(loginUser);
	}
	
	// 나의 프로필 > 내가 작성한 후기 (내가 작성할 후기)
	public List<RsvVO> writeReview(HttpSession hs) {
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		return mapper.writeReview(loginUser);
	}
	
	// 나의 프로필 > 내가 작성한 후기 (내가 작성한 후기)
	public List<ProfitReviewVO> beWriteReview(HttpSession hs){
		// 로그인 유저 정보 받아오기 
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		// 내가 작성한 후기 list로 받아오기  
		List<ProfitReviewVO> dbVO = mapper.beWriteReview(loginUser);
		
		// 이미지 경로 변경 
		for (ProfitReviewVO profitReviewVO : dbVO) {
			profitReviewVO.setPro_img(proImgChange(profitReviewVO.getPro_img(),profitReviewVO.getI_user()));
			profitReviewVO.setImg_url(imgUrlChange(profitReviewVO.getImg_url(),profitReviewVO.getI_host()));
			// 후기 내용 (줄바꿈) 
			profitReviewVO.setContents(MyUtils.setStrFilter(profitReviewVO.getContents()));
		}
		return dbVO;
	}
	
	// 프로필 > 후기 페이지 후기 수정 삽입  (비동기)
	public Map<String, Object> ctrUserReview(ProfitReviewVO param, HttpSession hs) {
		// 유저 pk 받아오기 
		param.setI_user(MyUtils.getSesstion(hs));
		Map<String, Object> map = new HashMap<String, Object>();
		// db결과 값 
		int reviewResult = 0;
		
		if(param.getI_contents() > 0) { //후기 수정
			reviewResult = mapper.upUserReview(param);
			// 후기 수정 성공시  
			if(reviewResult > 0) {
				// 후기 내용 받기 
				ProfitReviewVO dbVO = mapper.selUserReview(param);
				// 숙소  이미지 경로 변경 ,유저   이미지 경로 변경
				dbVO.setPro_img(proImgChange(dbVO.getPro_img(),dbVO.getI_user()));
				dbVO.setImg_url(imgUrlChange(dbVO.getImg_url(),dbVO.getI_host()));
				//후기 내용 적기 
				dbVO.setContents(MyUtils.setStrFilter(dbVO.getContents()));
				map.put("reviewResult", dbVO);
			}else map.put("reviewResult", 0); // 후기 수정 실패시
			
		}else { // 후기 삽입 
			reviewResult = mapper.insUserReview(param);
			// 후기 수정 성공시
			if(reviewResult > 0) {
				// 후기 내용 받기 
				ProfitReviewVO dbVO = mapper.selUserReview(param);
				// 숙소  이미지 경로 변경 ,유저   이미지 경로 변경
				dbVO.setPro_img(proImgChange(dbVO.getPro_img(),dbVO.getI_user()));
				dbVO.setImg_url(imgUrlChange(dbVO.getImg_url(),dbVO.getI_host()));
				//후기 내용 적기 
				dbVO.setContents(MyUtils.setStrFilter(dbVO.getContents()));
				map.put("reviewResult", dbVO);
			}else map.put("reviewResult", 0);// 후기 수정 실패시
		}
		
		return map;
	}
	
	public ProfitReviewVO selUserReview(ProfitReviewVO param, HttpSession hs) {
		// 유저 pk 받아오기 
		param.setI_user(MyUtils.getSesstion(hs));
		// 후기 내용 받기 
		ProfitReviewVO dbVO = mapper.selUserReview(param);
		// 숙소  이미지 경로 변경 ,유저   이미지 경로 변경 
		dbVO.setPro_img(proImgChange(dbVO.getPro_img(),dbVO.getI_user()));
		dbVO.setImg_url(imgUrlChange(dbVO.getImg_url(),dbVO.getI_host()));
		//후기 내용 적기 
		dbVO.setContents(MyUtils.setStrFilter(dbVO.getContents()));
		return dbVO;
	}
	
	// 숙소  이미지 경로 변경 
	public String imgUrlChange(String url,int i_host) {
		String room_poto = "/resources/room_img/host" + i_host + "/" + url;
		if(url== null|| url.equals("")) { // 이미지 파일이 없으면 기본 이미지 출력
			room_poto = "/resources/room_img/roomDfault.png";
		}
		return room_poto;
	}
	
	// 유저   이미지 경로 변경 
	public String proImgChange(String url,int i_user) {
		String pro_img = "/resources/user_img/user" + i_user + "/" + url;
		if(url== null|| url.equals("")) {// 이미지 파일이 없으면 기본 이미지 출력
			pro_img = "/resources/img/pimg.jpg";
		}
		return pro_img;
	}
}

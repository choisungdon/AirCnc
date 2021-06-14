package com.project.aircnc.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.project.aircnc.auth.NaverUserVO;
import com.project.aircnc.auth.SNSLogin;
import com.project.aircnc.auth.SnsValue;
import com.project.aircnc.common.KakaoConstVO;
import com.project.aircnc.common.ProfitReviewVO;
import com.project.aircnc.common.TUserVO;

@Controller
public class UserController {
	@Autowired
	private UserService service;
	@Inject
	private SnsValue naverSns;
	
	@PostMapping("/login")
	public @ResponseBody Map<String, Object> login (@RequestBody TUserVO param,
			Model model, HttpSession hs) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.login(param,hs));
		return map;
	}
	
	
    @PostMapping("/join")
	public @ResponseBody Map<String, Object> join (@RequestBody TUserVO param,
			Model model, HttpSession hs) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.join(param));
		return map;
	}
    //************************ 카카오 로그인 ************************/
    // 카카오 로그인 인증 코드 받기(요청) 개인정보 동의 없음
 	@RequestMapping(value = "/loginKAKAO", method = RequestMethod.GET)
 	public String loginKAKAO() {
 		String uri = String.format(
 				"redirect:https://kauth.kakao.com/oauth/authorize?client_id=%s&redirect_uri=%s&response_type=code&scope=%s", // 카카오 서버에 요청후 인증 코드와 함께 (개발자가 설정한)redirect Url()로 다시 요청
 				KakaoConstVO.KAKAO_CLIENT_ID, KakaoConstVO.KAKAO_LOGIN_REDIRECT_URI,KakaoConstVO.KAKAO_REQUIRED_SCOPES);
 		/*
 		  KAKAO_CLIENT_ID 			: API application key값 
 		  KAKAO_AUTH_REDIRECT_URI	: 인증코드 받기 (응답) url(http://aircnc.co.kr:8090/joinKAKAO01)
 		  KAKAO_REQUIRED_SCOPES		: 개인정보 동의 종류 (프로필, 카카오계정(이메일), 성별 , 연령대, 생일)
 		 */
 		
 		return uri; 
 	}
 	
 // 인증코드 받기 (응답)
  	@RequestMapping(value="/loginKAKAO01", method=RequestMethod.GET)
  	public String loginKAKAO01(@RequestParam(value = "code",required=false) String code,
  			@RequestParam(value = "error", required=false) String error, HttpSession hs, HttpServletResponse response) {
  		
//  		System.out.println("code : " + code); // 인증코드 
//  		System.out.println("error : " + error); // 에러 메시지 
  		
  		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out;
  		
  		if(code == null) { // 인가코드 (토큰) 없으면 로그인 화면으로
 			try {
 				out = response.getWriter();
 				out.println("<script>alert('카카오 로그인 실패 :'+'"+error+"');</script>");
 		        out.flush();
 			} catch (IOException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
 			return "index";
  		}else { // 인증코드 (토큰) 있으면 회원 정보 추출 및 유정 정보 insert
  		
 	 		String result = service.kakaoLogin(code, hs); // 로그인 정보 저장 
 	 		
 	 		 // success : 성공 /(일반 회원 일때 )일반 회원입니다. 일반 로그인으로 접속하세요./(이메일이 없을때)카카오 회원가입을 하세요.
 	 		if(!(result.equals("success"))) {
 				try {
 					out = response.getWriter();
 					out.println("<script>alert('"+result+"');</script>");
 			        out.flush();
 				} catch (IOException e) {
 					// TODO Auto-generated catch block
 					e.printStackTrace();
 				}
 					
 				return "index";
 	 		}else { // 성공
 	 			return "index";
 	 		}
  		}
  		
  	}
  	
 	//************************ naver 회원가입 ************************/
	
	// 인증코드 받기 (응답)
	@RequestMapping(value="/loginNAVER01", method= {RequestMethod.GET,RequestMethod.POST})
	public String loginNaver01(@RequestParam(value = "code",required=false) String code,
			@RequestParam(value = "state", required=false) String state, @RequestParam(value = "error_description", required=false) String error_description, 
			HttpSession hs, HttpServletResponse response,HttpServletRequest request) throws Exception {
		
		System.out.println("code : " + code); // 인증코드 
		System.out.println("state : " + state); // 상태 값  
		
		TUserVO param = new TUserVO(); // 유저 정보 
		SNSLogin snsLogin = new SNSLogin(naverSns);
		
		// 유저 프로필 요청 
		NaverUserVO oauthResult = snsLogin.getUserProfile(code);
		// 성공 여부 확인  success: 성공 / 이외 : 에러 났음  
		if(!oauthResult.getMessage().equals("success")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('"+oauthResult.getMessage()+"');</script>");
 			out.flush();
		}else {
			
			// login user 데이터 삽입 
			param.setE_mail(oauthResult.getResponse().getEmail());
			param.setLogintype("naver");
			String result = service.loginNaver(param, hs);
			// 로그인 성공 여부 확인  success: 성공 / 예외 : 실패 
			if(!result.equals("success")) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('"+result+"');</script>");
	 			out.flush();
			}
		}
		return "index"; 
	}
	
	
	@RequestMapping(value="/user/userSetting", method=RequestMethod.GET)
	public String userSetting (Model model, HttpSession hs) {
		return "/user/userSetting";
	}
	// 프로필 이동  페이지 
	@RequestMapping(value="/user/userShow", method=RequestMethod.GET)
	public String userShow (Model model, HttpSession hs) {
		model.addAttribute("data", service.selUsePro(hs));
		return "/user/userShow";
	}
	// 개인 정보 수정 페이지 
	@RequestMapping(value="/user/userInfo", method=RequestMethod.GET)
	public String userInfo (Model model, HttpSession hs) {
		return "/user/userInfo";
	}
	// 개인정보 수정 비동기 
	@RequestMapping(value="/user/info", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> upInfo(@RequestBody TUserVO param , Model model, HttpSession hs){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.upUserVO(param,hs));
		return map;
	}
	
	// 프로필 수정 페이지 이동 
	@RequestMapping(value="/user/userProfile", method=RequestMethod.GET)
	public String userProfile (Model model, HttpSession hs) {
		return "/user/userProfile";
	}
	// 프로필 수정 
	@RequestMapping(value="/user/userProfile", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> userProChange (@RequestParam("userPro")  MultipartFile userPro ,Model model, HttpSession hs) {
		Map<String, Object> map = new HashMap();
		map.put("result", service.upUserPro(userPro, hs));
		return map;
	}
	// 프로필 삭제 
	@RequestMapping(value="/user/delProfile", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> delProfile (Model model, HttpSession hs) {
		Map<String, Object> map = new HashMap();
		map.put("result", service.delProfile(hs));
		return map;
	}
	// 로그인 보안(PW 변경) 페이지 
	@RequestMapping(value="/user/userPW", method=RequestMethod.GET)
	public String userPW (Model model, HttpSession hs) {
		model.addAttribute("data",service.selUserMd(hs));
		return "/user/userPW";
	}
	
	// 로그인 보안(PW 변경) 페이지 비동기 
	@RequestMapping(value="/user/userPWCahnge", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> userPWCahnge (@RequestParam String c_pw ,@RequestParam String r_pw, 
															Model model, HttpSession hs) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.upUserPW(c_pw, r_pw, hs));
		return map;
	}
	// 좋아요 활성화 
	@RequestMapping(value="/user/likelist", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> userLike (@RequestParam int i_host,  @RequestParam String title  
			,Model model, HttpSession hs) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.inslikeList(i_host, title, hs));
		return map;
	}
	
	// 좋아용 활성화 (기존 저장 목록에 추가)
	@RequestMapping(value="/user/llSave", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> llSave (@RequestParam int i_host,  @RequestParam int i_list  
			,Model model, HttpSession hs){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.insLikeUser(i_host, i_list, hs));
		return map;
	}
	
	// 좋아요 비활성화
	@RequestMapping(value="/user/disLike", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> userDisLike (@RequestParam int i_host, Model model, HttpSession hs) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.delLikeUser(i_host,hs));
		return map;
	}
	
	// 나의 프로필 > 내가 작성한 후기 
	@RequestMapping(value="/user/userReview", method=RequestMethod.GET)
	public String hostReview (Model model, HttpSession hs) 
	{
		// 내가 작성할 후기 , 내가 작성한 후기 
		model.addAttribute("writeReview",service.writeReview(hs));
		model.addAttribute("upReview",service.beWriteReview(hs));
		return "/user/userReview";
	}
	
	// 프로필 > 후기 (기존 후기 추출)
	@RequestMapping(value="/user/selUserReview", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> selUserReview (@RequestBody ProfitReviewVO param, Model model, HttpSession hs) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.selUserReview(param,hs));
		return map;
	}
		
	// 프로필 > 후기 페이지 후기 수정 삽입  (비동기)
	@RequestMapping(value="/user/ctrUserReview", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> ctrUserReview (@RequestBody ProfitReviewVO param, Model model, HttpSession hs) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.ctrUserReview(param, hs));
		return map;
	}
}

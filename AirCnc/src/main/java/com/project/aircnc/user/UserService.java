package com.project.aircnc.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.aircnc.common.MyUtils;
import com.project.aircnc.common.TUserVO;
import com.project.aircnc.common.UserLListVO;
import com.project.aircnc.common.UserLikeVO;

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
	
	public int upUserVO(TUserVO param) {
		return mapper.upUserVO(param);
	}
	
	public int upUserPW(@RequestParam String c_pw ,@RequestParam String r_pw, HttpSession hs){
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
			return mapper.upUserPW(loginUser);
		}else {
			return 2;
		}
	}
	
	public int inslikeList(int i_host,String title,HttpSession hs) {
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		// likeList -> insert
		UserLikeVO likeVO = new UserLikeVO();
		UserLListVO listVO = new UserLListVO();
		listVO.setI_user(loginUser.getI_user());
		listVO.setList_title(title);
		 
		mapper.insLikeList(listVO);
	//  user_like - > insert
		likeVO.setI_list(listVO.getI_list());
		likeVO.setI_host(i_host);
		likeVO.setI_user(loginUser.getI_user());
		int result = 0;
		result = mapper.insLikeUser(likeVO);
		if(result != 0) {
			return listVO.getI_list();
		}
		return result;
	}
	
	public int delLikeUser(int i_host, HttpSession hs) {
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		UserLikeVO likeVO = new UserLikeVO();
		
		likeVO.setI_user(loginUser.getI_user());
		likeVO.setI_host(i_host);
		
		return mapper.delLikeUser(likeVO);
	}
	
	public int insLikeUser(int i_host, int i_list, HttpSession hs) {
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		
		UserLikeVO likeVO = new UserLikeVO();
		likeVO.setI_host(i_host);
		likeVO.setI_user(loginUser.getI_user());
		likeVO.setI_list(i_list);
		
		return mapper.insLikeUser(likeVO);
	}
}

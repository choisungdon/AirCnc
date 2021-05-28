package com.project.aircnc.trip;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.aircnc.common.HostReviewVO;
import com.project.aircnc.common.MyUtils;
import com.project.aircnc.common.TUserVO;
import com.project.aircnc.common.TripVO;

@Service
public class TripService {
	@Autowired
	private TripMapper mapper;
	
	public List<TripVO> selReser(HttpSession hs) {
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		List<TripVO> dbVO = mapper.selReser(loginUser);
		// 숙소 이미지 수정 
		for (TripVO tripVO : dbVO) {
			tripVO.setRoom_poto(imgUrlChange(tripVO.getImg_url(),tripVO.getI_host()));
		}
		return dbVO;
	}
	
	public List<TripVO> selBfReser(HttpSession hs){
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		
		List<TripVO> dbVO = mapper.selBfReser(loginUser);
		// 숙소 이미지 수정 
		for (TripVO tripVO : dbVO) {
			tripVO.setRoom_poto(imgUrlChange(tripVO.getImg_url(),tripVO.getI_host()));
		}
		return dbVO;
	}
	// 후기 작성 비동기(수정,삽입 )
	public int goReview(HostReviewVO param, HttpSession hs) {
		// 후기 text 문자열 줄바꿈 변환 , 유저 pk 받기 
		param.setContents(MyUtils.setStrFilter(param.getContents()));
		param.setI_user(MyUtils.getSesstion(hs));
		
		int result = mapper.comfirmReview(param);
		// 후기  있음 (update)
		if(result > 0) {
			result = mapper.upHostReview(param);
		}else {
			// 후기 없음 (insert)
			result = mapper.insHostReview(param);
		}
		
		return result;
	}
	
	// 기존 후기 select  비동기
	public HostReviewVO selReview(HostReviewVO param, HttpSession hs) {
		// 후기 text 문자열 줄바꿈 변환 , 유저 pk 받기 
		param.setI_user(MyUtils.getSesstion(hs));
		
		// 기존후기 text 문자열 줄바꿈 변환  <br> -> \n 
		HostReviewVO dbVO = mapper.selReview(param);
		dbVO.setContents(MyUtils.setStrFilter(dbVO.getContents()));
		
		return dbVO;
	}
	
	// 숙소 이미지 경로 지정 
	public String imgUrlChange(String url,int i_host) {
		
		String room_poto = "/resources/room_img/host" + i_host + "/" + url;
		if(url== null|| url.equals("")) { // 이미지 파일이 없으면 기본 이미지 출력
			room_poto = "/resources/room_img/roomDfault.png";
		}
		return room_poto;
	}
}

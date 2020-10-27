package com.project.aircnc.trip;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.aircnc.common.TUserVO;
import com.project.aircnc.common.TripVO;

@Service
public class TripService {
	@Autowired
	private TripMapper mapper;
	
	public List<TripVO> selReser(HttpSession hs) {
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		List<TripVO> dbVO = setRoomPoto(mapper.selReser(loginUser));
		
		return dbVO;
	}
	
	public List<TripVO> selBfReser(HttpSession hs){
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		List<TripVO> dbVO = setRoomPoto(mapper.selBfReser(loginUser));
		
		return dbVO;
	}
	
	// 숙소 이미지 경로 지정 
	public List<TripVO> setRoomPoto(List<TripVO> list) {
		for (TripVO tripVO : list) {
			String room_poto = "/resources/room_img/host" + tripVO.getI_host() + "/" + tripVO.getImg_url();
			tripVO.setRoom_poto(room_poto);
		}
		
		return list;
	}
}

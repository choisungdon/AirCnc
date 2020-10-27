package com.project.aircnc.search;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.protobuf.TextFormat.ParseException;
import com.project.aircnc.common.AddSchVO;
import com.project.aircnc.common.HostListVO;
import com.project.aircnc.common.MyUtils;
import com.project.aircnc.common.RoomIMGVO;
import com.project.aircnc.common.SearchVO;
import com.project.aircnc.common.TUserVO;
import com.project.aircnc.common.UserLListVO;

@Service
public class SearchSearvice {
	
	@Autowired
	private SearchMapper mapper;
	
	public List<AddSchVO> searchList(String s_addr) {
		
		return mapper.searchList(s_addr);
	}
	
	public List<HostListVO> hostList(SearchVO param){
		
		long date; // chin chout 사이 일수 계산 
		try {
			date = MyUtils.changeDate(param.getChin(), param.getChout());
			param.setDate(date);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// DB 데이터 가져오기(숙소)
		List<HostListVO> list = new ArrayList<HostListVO>();
		//  요금 최소 값 
		SearchVO feeVO = mapper.avgFee(param);
		param.setMin_fee(feeVO.getMin_fee());
		param.setMax_fee(feeVO.getMax_fee());
		
		list = mapper.hostList(param);
		// 숙소 이미지  가져오기 
		for (HostListVO hostListVO : list) {
			// 방 사진 list
			List<RoomIMGVO> vo = mapper.room_img_list(hostListVO);
			// 사진 경로 추가 
			for (RoomIMGVO RoomIMGVO : vo) {
				String profileImg = "/resources/room_img/host" + RoomIMGVO.getI_host() + "/" + RoomIMGVO.getImg_url();
				RoomIMGVO.setRoom_poto(profileImg);
			}
			// 최종 
			hostListVO.setList(vo);
		}
		
		return list;
	}
	
	public List<UserLListVO> selLikeList(HttpSession hs){
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		return mapper.selLikeList(loginUser);
	}
}

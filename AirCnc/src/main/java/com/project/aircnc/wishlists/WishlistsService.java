package com.project.aircnc.wishlists;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.aircnc.common.RoomIMGVO;
import com.project.aircnc.common.TUserVO;
import com.project.aircnc.common.UserLListVO;
import com.project.aircnc.common.UserLikeVO;
import com.project.aircnc.common.WishlistsVO;

@Service
public class WishlistsService {
	
	@Autowired
	private WishlistsMapper mapper;
	
	public List<UserLListVO> selWishL(HttpSession hs) {
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		// 저장 목록 이미지 경로 추가  
		List<UserLListVO> list =  mapper.selWishL(loginUser);
		for (UserLListVO userLListVO : list) {
			String like_profile = null;
			// 이미지가 없을시  roomDfault 이미지 출력
			if(userLListVO.getImg_url() == null || userLListVO.getImg_url() == "") {
				like_profile = "/resources/room_img/roomDfault.png"; 
			}else {
				like_profile =  "/resources/room_img/host" + userLListVO.getI_host() + "/" + userLListVO.getImg_url();
			}
			userLListVO.setLike_profile(like_profile);
		}
		
		return list;
	}
	//// ******************wishDetail 화면 정보 *******************************
	public UserLListVO selLinfo(UserLListVO param) {
		UserLListVO result = mapper.selLinfo(param);
		return result;
	}
	
	public List<WishlistsVO> selHInfo(UserLListVO param) {
		List<WishlistsVO> list = mapper.selHInfo(param);
		for (WishlistsVO wishlistsVO : list) {
			// 숙소 이미지 가지고 오기 
			List<RoomIMGVO> RoomImgList = mapper.selRoomImg(wishlistsVO);
			// 숙소 이미지 경로 수정 
			for ( RoomIMGVO roomVO : RoomImgList) {
				String url =  "/resources/room_img/host" + roomVO.getI_host() + "/" + roomVO.getImg_url();
				roomVO.setRoom_poto(url);
			}
			// setter
			wishlistsVO.setList(RoomImgList);
		}
		return list;
	}
	
	public List<UserLListVO> selUserLList(HttpSession hs){
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		return mapper.selWishL(loginUser);
	}
	///// *******************************************************
	
	public void insWishL(UserLListVO param, HttpSession hs) {
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		param.setI_user(loginUser.getI_user());
		
		mapper.insWishL(param);
	}
	
	public void insLfromS (UserLListVO param) {
		mapper.insLfromS(param);
	}
	
	public void insHost (UserLikeVO param) {
		mapper.insHost(param);
	} 

}

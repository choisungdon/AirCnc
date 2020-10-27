package com.project.aircnc.wishlists;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.aircnc.common.HostReviewVO;
import com.project.aircnc.common.HostUserVO;
import com.project.aircnc.common.RoomFeeVO;
import com.project.aircnc.common.RoomIMGVO;
import com.project.aircnc.common.TUserVO;
import com.project.aircnc.common.UserLListVO;
import com.project.aircnc.common.UserLikeVO;
import com.project.aircnc.common.WishlistsVO;

@Mapper
public interface WishlistsMapper {
	public List<UserLListVO> selWishL(TUserVO param);
	public UserLListVO selLinfo(UserLListVO param);
	public List<WishlistsVO> selHInfo(UserLListVO param);
	public List<RoomIMGVO> selRoomImg(WishlistsVO param);
	
	public void insWishL (UserLListVO param);
	public void insHost(UserLikeVO param);
	public void insLfromS(UserLListVO param);
}

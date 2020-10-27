package com.project.aircnc.search.detail;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.aircnc.common.DTLRuleVO;
import com.project.aircnc.common.HostReviewVO;
import com.project.aircnc.common.RoomIMGVO;
import com.project.aircnc.common.SearchDetaileVO;
import com.project.aircnc.common.SearchVO;
import com.project.aircnc.common.TUserVO;
import com.project.aircnc.common.UserLListVO;

@Mapper
public interface DetaileMapper {
	
	public SearchDetaileVO	selDetaile(SearchVO param);
	public List<RoomIMGVO>	selRoomImg(SearchVO param);
	public List<DTLRuleVO>	selDtRule(SearchVO param);
	public List<HostReviewVO> selHostReview(SearchVO param);
	public List<UserLListVO> selLikeList(TUserVO param);
	/// 예약 가능 여부 확인 쿼리 실행 
	public int existInOut(SearchVO param);
	public int existInOutDate(SearchVO param);
	public int existRvation(SearchVO param);
	
	
}
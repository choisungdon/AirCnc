package com.project.aircnc.user;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.aircnc.common.HostReviewVO;
import com.project.aircnc.common.ProfitReviewVO;
import com.project.aircnc.common.RsvVO;
import com.project.aircnc.common.TUserVO;
import com.project.aircnc.common.UserLListVO;
import com.project.aircnc.common.UserLikeVO;
import com.project.aircnc.common.UserShowVO;

@Mapper
public interface UserMapper {
	
	public int join (TUserVO param);
	public int checkEmail(TUserVO param);
	public TUserVO login (TUserVO param);
	public int upUserPro(TUserVO param);
	// user 개인 수정 비동기  
	public int upUserVO(TUserVO param);
	// 개인 정보 수정 페이지 
	public TUserVO selUserMd(TUserVO param);
	// 프로필 이동  페이지 
	public UserShowVO selUsePro(TUserVO param);
	public TUserVO selTUserVO(TUserVO param);
	public int upUserPW(TUserVO param);
	public int insLikeList(UserLListVO param);
	public int insLikeUser(UserLikeVO param);
	public int delLikeUser(UserLikeVO param);
	
	// 나의 프로필 > 내가 작성한 후기 (내가 작성할 후기)
	public List<RsvVO> writeReview(TUserVO param);
	// 나의 프로필 > 내가 작성한 후기 (내가 작성한 후기)
	public List<ProfitReviewVO> beWriteReview(TUserVO param);
	
	// 프로필 > 후기 페이지 후기 수정   (비동기)
	public  int upUserReview(ProfitReviewVO param);
	// 프로필 > 후기 페이지 후기 삽입  (비동기)
	public  int insUserReview(ProfitReviewVO param);
	// 포로필 > 후기 (후기 출력) 
	public  ProfitReviewVO selUserReview(ProfitReviewVO param);
}



package com.project.aircnc.user;


import org.apache.ibatis.annotations.Mapper;

import com.project.aircnc.common.TUserVO;
import com.project.aircnc.common.UserLListVO;
import com.project.aircnc.common.UserLikeVO;

@Mapper
public interface UserMapper {
	
	public int join (TUserVO param);
	public int checkEmail(TUserVO param);
	public TUserVO login (TUserVO param);
	public int upUserPro(TUserVO param);
	// user 개인 수정 비동기  
	public int upUserVO(TUserVO param);
	public TUserVO selTUserVO(TUserVO param);
	public int upUserPW(TUserVO param);
	public int insLikeList(UserLListVO param);
	public int insLikeUser(UserLikeVO param);
	public int delLikeUser(UserLikeVO param);
}



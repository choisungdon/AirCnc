package com.project.aircnc.trip;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Mapper;

import com.project.aircnc.common.HostReviewVO;
import com.project.aircnc.common.TUserVO;
import com.project.aircnc.common.TripVO;

@Mapper
public interface TripMapper {
	
	public List<TripVO> selReser(TUserVO param);
	
	public List<TripVO> selBfReser(TUserVO param);
	
	public int comfirmReview(HostReviewVO param);
	// 후기 작성 비동기(수정,삽입 )
	public int insHostReview(HostReviewVO param);
	// 후기 작성 비동기(수정,삽입 )
	public int upHostReview(HostReviewVO param);
	// 기존 후기 select  비동기
	public HostReviewVO selReview(HostReviewVO param);
	
}

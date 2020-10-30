package com.project.aircnc.hostmanage;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.aircnc.common.RsvVO;
import com.project.aircnc.common.RsvViewData;
import com.project.aircnc.common.TUserVO;

@Mapper
public interface HostManageMapper {
	
	public int selUserReserCc(TUserVO param);
	
	public int selUserReser(TUserVO param);
	// 숙소 관리 예약 화면 
	public List<RsvVO> selRsv(TUserVO param);// 예정된 예약 불러오기(현재 로그인 한 숙소 주인이 볼수 있는)
	// 예약 숙박 내용 확인 
	public RsvViewData selViewData(int i_reser);
	
}

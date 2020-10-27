package com.project.aircnc.hostmanage;

import org.apache.ibatis.annotations.Mapper;

import com.project.aircnc.common.TUserVO;

@Mapper
public interface HostManageMapper {
	
	public int selUserReserCc(TUserVO param);
	
	public int selUserReser(TUserVO param);
	
}

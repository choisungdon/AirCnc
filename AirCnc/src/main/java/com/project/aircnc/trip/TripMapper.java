package com.project.aircnc.trip;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Mapper;

import com.project.aircnc.common.TUserVO;
import com.project.aircnc.common.TripVO;

@Mapper
public interface TripMapper {
	
	public List<TripVO> selReser(TUserVO param);
	
	public List<TripVO> selBfReser(TUserVO param);
}

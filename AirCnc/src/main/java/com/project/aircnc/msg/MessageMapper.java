package com.project.aircnc.msg;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.aircnc.common.AircncMsg;
import com.project.aircnc.common.AircncMsgUsers;
import com.project.aircnc.common.AircncMsglist;
import com.project.aircnc.common.MsgRoomVO;
import com.project.aircnc.common.TUserVO;

@Mapper
public interface MessageMapper {
	
	public List<MsgRoomVO> selMsg(TUserVO param);
	
	public List<AircncMsg> selMsgList(int i_mlist);
	
	public AircncMsgUsers selMsgUsers(AircncMsgUsers param);
	
	public int insMsg(AircncMsg param);
	
	public int delMsg(AircncMsglist param);
}

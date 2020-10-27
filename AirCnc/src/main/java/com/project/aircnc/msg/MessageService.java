package com.project.aircnc.msg;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.aircnc.common.AircncMsg;
import com.project.aircnc.common.AircncMsgUsers;
import com.project.aircnc.common.AircncMsglist;
import com.project.aircnc.common.MsgRoomVO;
import com.project.aircnc.common.TUserVO;

@Service
public class MessageService {
	
	@Autowired 
	private MessageMapper mapper;
	
	public List<MsgRoomVO> selMsg(HttpSession hs) {
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		
		List<MsgRoomVO> list = mapper.selMsg(loginUser);
		// 룸 이미지 경로 수정 
		for (MsgRoomVO dbVO : list) {
			String room_poto = "/resources/room_img/host" + dbVO.getI_host() + "/" + dbVO.getImg_url();
			dbVO.setRoom_poto(room_poto);
		}
		
		return list;
	}
	
	public List<AircncMsg> selMsgList(int i_mlist){
		return mapper.selMsgList(i_mlist);
	}
	
	public AircncMsgUsers selMsgUsers(int i_mlist, HttpSession hs) {
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		AircncMsgUsers inData = new AircncMsgUsers();
		inData.setI_mlist(i_mlist);
		inData.setI_user(loginUser.getI_user());
		
		return mapper.selMsgUsers(inData);
	}
	
	public int insMsg(int i_mlist,String cmt,HttpSession hs) {
		TUserVO loginUser = (TUserVO)hs.getAttribute("loginUser");
		AircncMsg inData = new AircncMsg();
		inData.setCmt(cmt);
		inData.setI_mlist(i_mlist);
		inData.setI_user(loginUser.getI_user());
		
		return mapper.insMsg(inData);
	}
	
	public int delMsg(int i_mlist, int i_user) {
		AircncMsglist param = new AircncMsglist();
		param.setI_mlist(i_mlist);
		param.setI_user(i_user);
		
		return mapper.delMsg(param);
	}
	
	
	
}

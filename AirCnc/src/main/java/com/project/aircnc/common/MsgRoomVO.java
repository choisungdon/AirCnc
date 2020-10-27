package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("MsgRoomVO")
public class MsgRoomVO extends AircncMsglist{
	private String img_url;
	private String room_poto;
	
	public String getRoom_poto() {
		return room_poto;
	}

	public void setRoom_poto(String room_poto) {
		this.room_poto = room_poto;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	
	
}

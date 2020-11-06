package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("HostHouseVO")
public class HostHouseVO extends HostUserVO{
	private String img_url;
	private String state ; //숙보 정보 10단계 중 1개라도 입력 안될시 'x'
	// 등록 완료 'o'

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}

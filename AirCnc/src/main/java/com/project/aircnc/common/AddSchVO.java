package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("AddSchVO")
public class AddSchVO {
	private String addr;

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}

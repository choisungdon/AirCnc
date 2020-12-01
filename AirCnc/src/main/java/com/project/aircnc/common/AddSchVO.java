package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("AddSchVO")
public class AddSchVO {
	private String hidden_addr;
	private String addr;
	
	public String getHidden_addr() {
		return hidden_addr;
	}

	public void setHidden_addr(String hidden_addr) {
		this.hidden_addr = hidden_addr;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}

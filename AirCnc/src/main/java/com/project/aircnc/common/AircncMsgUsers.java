package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("AircncMsgUsers")
public class AircncMsgUsers {
	int i_msgUsers;  //'pk', 
	int i_mlist; // 톡방 번호 aircnc_msglist (pk)
	int i_user;	// t_user pk
	int i_host; // 'host_user pk 건물 '
	
	public int getI_msgUsers() {
		return i_msgUsers;
	}
	public void setI_msgUsers(int i_msgUsers) {
		this.i_msgUsers = i_msgUsers;
	}
	public int getI_mlist() {
		return i_mlist;
	}
	public void setI_mlist(int i_mlist) {
		this.i_mlist = i_mlist;
	}
	public int getI_user() {
		return i_user;
	}
	public void setI_user(int i_user) {
		this.i_user = i_user;
	}
	public int getI_host() {
		return i_host;
	}
	public void setI_host(int i_host) {
		this.i_host = i_host;
	}
	
	
}

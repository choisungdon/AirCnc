package com.project.aircnc.common;

import java.util.List;

import org.apache.ibatis.type.Alias;
@Alias("DtlRuleListVO")
public class DtlRuleListVO {
	private List<DTLRuleVO> list;

	public List<DTLRuleVO> getList() {
		return list;
	}

	public void setList(List<DTLRuleVO> list) {
		this.list = list;
	}
	
}

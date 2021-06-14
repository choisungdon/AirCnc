package com.project.aircnc.auth;

public class NaverUserVO {
	private String resultcode;
	private String message;
	private NaverReponse response;
	
	public String getResultcode() {
		return resultcode;
	}
	public void setResultcode(String resultcode) {
		this.resultcode = resultcode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public NaverReponse getResponse() {
		return response;
	}
	public void setResponse(NaverReponse response) {
		this.response = response;
	}
	@Override
	public String toString() {
		return "NaverUserVO [resultcode=" + resultcode + ", message=" + message + ", response=" + response + "]";
	}
	
	
	
	
}

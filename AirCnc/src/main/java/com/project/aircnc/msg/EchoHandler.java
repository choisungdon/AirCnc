package com.project.aircnc.msg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistration;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.project.aircnc.common.TUserVO;

public class EchoHandler extends TextWebSocketHandler{
	
	List<WebSocketSession> sessions = new ArrayList<>();
	Map<TUserVO, WebSocketSession> userSessions = new HashMap<>();
	
	
	// 연결됐을때 
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception{
		System.out.println("세션 생성:" + session);
		sessions.add(session); // 로그인 된 유저 세션마다 생성된다.
	}
	// 메시지 보냈을때 
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("받은 메시지 ^ 세션:" + session + " : " + message);
		TUserVO senderId = getSession(session);// 보낸 유저 정보 
		
		for(WebSocketSession sess : sessions) {// 지금 까지 소켓에 들어온 사람들 확인 
			if(senderId != null) {// 보낸 사람 유저 정보 확인 
				TUserVO optUser = getSession(sess);// 받는 사람 유저정보 
				if(optUser != null) { // 받는 사람 유저정보 있으면 실행 
					if(senderId.getI_user() != optUser.getI_user()) { // 보낸 사람 정보와 받는 사람 정보가 다른 사람에게 메시지 전달 
						String str[] = message.getPayload().split("/");// 메시지 정보 
						String cmt = str[0]; // 메시지 
						int opponent =  Integer.parseInt(str[1]); // 받는 사람 i_user
						int i_mlist = Integer.parseInt(str[2]); // 톡방 번호 
						if(optUser.getI_user() == opponent) { // 받는 사람 i_user하고 opponent가 같은면 메시지 전달 (보낼 i_user하고 같은면 )
							sess.sendMessage(new TextMessage(senderId.getNm() +"/"+ cmt+"/"+i_mlist));
						}
					}
				}
			}
		}
	}
	
	private TUserVO getSession(WebSocketSession session) {
		Map<String,Object> hs=  session.getAttributes();
		if(hs != null) {
			return (TUserVO)hs.get("loginUser");
		}else {
			return null;
		}
		
	}
	// 연결 끊었을때 
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("연결 끈김:" + session + ":" + status);
	}

}
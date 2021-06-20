package com.project.aircnc.auth;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.catalina.mapper.Mapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.aircnc.common.KakaoConstVO;
import com.project.aircnc.common.TUserVO;

public class GoogleRestTemplate {
	SnsValue googleSns;
	
	public GoogleRestTemplate(SnsValue googleSns) {
		this.googleSns = googleSns;
	}
	
	public String getOauthURL() {
		
		String url  = String.format("https://accounts.google.com/o/oauth2/v2/auth?"
				+ "scope=%s&"
				+"access_type=offline&"
				+"include_granted_scopes=true&"
				+ "response_type=code&"
				+ "redirect_uri=%s&"
				+"client_id=%s", googleSns.getGoogle_scope(),googleSns.getRedirectUrl(),googleSns.getClientId());
		
		return url;
	}
	
	public String getAccessToken (String code) throws Exception {
		
		// ----------------- 사용자 토큰 받기 -----------------[start]
		HttpHeaders headers = new HttpHeaders();
		
		Charset utf8 = Charset.forName("UTF-8"); // meta 정보 주기(인코딩 유형)
		//요청을 JSON TYPE의 데이터만 담고있는 요청을 처리하겠다는 의미가 된다.
		MediaType mediaType = new MediaType(MediaType.APPLICATION_JSON, utf8);		
		headers.setAccept(Arrays.asList(mediaType)); // 미디어 유형 지정
//				List<MediaType> lst = Arrays.asList(mediaType);
//				System.out.println(lst);
		
		// url 인코딩(암호화)	
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		//내용 유형 헤더에 지정된 대로 본문의 미디어 유형을 설정합니다.
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>(); // parameter 데이터 추가할때 쓰는 변수
		//parameter
		
		map.add("client_id", googleSns.getClientId());
		map.add("client_secret", googleSns.getClientSecret());
		map.add("redirect_uri", googleSns.getRedirectUrl());
		map.add("code", code);
		
		HttpEntity<LinkedMultiValueMap<String, String>> entity = new HttpEntity(map,headers); // Entity 계체	 ->> map: 파라미터(보내줄 데이터) headers: 헤더 설정 정보
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> respEntity = restTemplate.exchange(googleSns.getGoogle_access_token(), HttpMethod.POST, entity, String.class);
		//		KakaoConstVO.KAKAO_ACCESS_TOKEN_HOST : 요청 URL 
		//		HttpMethod.POST : 요청 방식 post		 
		//		entity : 헤더정보 및 파라미터 정보 
		
		String result = respEntity.getBody(); // 응답 데이터 받기(JSON)
		
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readTree(result);
		
		String access_token = rootNode.get("access_token").asText();
		
		
		return access_token;
	}
	
	public TUserVO getGoogleProfile(String code) throws Exception {
		//-----------------------사용자 정보 가져오기 위한 통신 세팅------------------------
		Charset utf8 = Charset.forName("UTF-8");
		HttpHeaders headers	= new HttpHeaders();	
		MediaType	mediaType	= new MediaType(MediaType.APPLICATION_JSON,utf8);
		headers.setAccept(Arrays.asList(mediaType));
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.set("Authorization", "Bearer " +this.getAccessToken(code));
		
		HttpEntity<LinkedMultiValueMap<String, String>> entity = new HttpEntity("",headers); // Entity 계체	 ->> map: 파라미터(보내줄 데이터) headers: 헤더 설정 정보
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> respEntity = restTemplate.exchange(googleSns.getProfileURL()+"&key="+googleSns.getApiKey(), HttpMethod.GET, entity, String.class);
		String result = respEntity.getBody();
		//System.out.println("result2 : " + result);
		
		ObjectMapper mapper = new ObjectMapper();
		// 트리 형태로 json pasing
		JsonNode rootNode = mapper.readTree(result);
		// 이메일 노드 받기 
		Iterator<JsonNode> emailNodes =  rootNode.path("emailAddresses").elements();
		// return uservo 
		TUserVO userVO = new TUserVO();
		// 이메일 받기 
 		while(emailNodes.hasNext()) {
			JsonNode emailNode = emailNodes.next();
			userVO.setE_mail(emailNode.get("value").asText());
		}
 		// 로그인 타입 지정
 		userVO.setLogintype("google");
		
		return userVO;
	}
	
}

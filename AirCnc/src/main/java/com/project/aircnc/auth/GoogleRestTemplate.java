package com.project.aircnc.auth;

import java.nio.charset.Charset;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.project.aircnc.common.KakaoConstVO;

public class GoogleRestTemplate {
	private	OAuth2AccessToken	oauth2AccessToken;
	private OAuthRequest		oauthRequest;
	
	public GoogleRestTemplate (OAuth2AccessToken oauth2AccessToken, OAuthRequest oauthRequest) {
		this.oauth2AccessToken	= oauth2AccessToken;
		this.oauthRequest		= oauthRequest;
	}
	
	
	public GoogleUserVO getBody() {
		GoogleUserVO vo = null;
		//-----------------------사용자 정보 가져오기 위한 통신 세팅------------------------
		Charset utf8 = Charset.forName("UTF-8"); // meta 정보 주기(인코딩 유형)
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers2	= new HttpHeaders();	
		MediaType	mediaType2	= new MediaType(MediaType.APPLICATION_JSON,utf8);
		headers2.setAccept(Arrays.asList(mediaType2));
		headers2.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers2.set("Authorization", "Bearer " +oauth2AccessToken.getAccessToken());
		
		HttpEntity<LinkedMultiValueMap<String, String>> entity2 = new HttpEntity("",headers2); // Entity 계체	 ->> map: 파라미터(보내줄 데이터) headers: 헤더 설정 정보
		ResponseEntity<String> respEntity2 = restTemplate.exchange(oauthRequest.getUrl(), HttpMethod.GET, entity2, String.class);
		String result2 = respEntity2.getBody();
		System.out.println("result2 : " + result2);
		
		
		return vo;
	}

	public OAuth2AccessToken getOauth2AccessToken() {
		return oauth2AccessToken;
	}

	public void setOauth2AccessToken(OAuth2AccessToken oauth2AccessToken) {
		this.oauth2AccessToken = oauth2AccessToken;
	}

	public OAuthRequest getOauthRequest() {
		return oauthRequest;
	}

	public void setOauthRequest(OAuthRequest oauthRequest) {
		this.oauthRequest = oauthRequest;
	}
	
	
}

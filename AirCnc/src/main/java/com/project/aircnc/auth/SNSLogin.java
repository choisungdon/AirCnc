package com.project.aircnc.auth;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.project.aircnc.common.TUserVO;

public class SNSLogin {
	private OAuth20Service oathService;
	private String profileURL; // 프로필 요청 URL
	
	public  SNSLogin(SnsValue sns) {
		this.oathService = new ServiceBuilder(sns.getClientId())
				.apiSecret(sns.getClientSecret())
				.callback(sns.getRedirectUrl())
				.scope("profile")
				.build(sns.getApi20Instance());
				
				this.profileURL = sns.getProfileURL();
	}


	public String getNaverAuthURL( ) {
		
		return this.oathService.getAuthorizationUrl();
	}
	
	

	// 받은 code로 유저 프로필 요청
	public NaverUserVO getUserProfile(String code) throws Exception {
		// 인가 코드 가지고 토큰 요청 
		OAuth2AccessToken accessToken = oathService.getAccessToken(code);
		// 요청 방식 : GET  삽입 
		// URL :  요청 URL 삽입 
		OAuthRequest request = new OAuthRequest(Verb.GET, this.profileURL);
		// 토큰 정보 및 요청 URL 삽입 
		oathService.signRequest(accessToken, request);
		// execute : 응답 (프로필 정보)
		Response response = oathService.execute(request);
		// json (string) 리턴 
		return userParseJson(response.getBody());
	}
	
	 // 유저 프로필 json 파싱 (naver)
	public NaverUserVO userParseJson(String body) throws Exception {
		TUserVO t_user = new TUserVO();
		
		NaverUserVO naverUser = null;
		ObjectMapper om = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		
		naverUser = om.readValue(body, NaverUserVO.class);
		
		/*JsonNode rootNode = mapper.readTree(body);
		
		JsonNode resultcode = rootNode.get("resultcode");
		
		JsonNode message = rootNode.get("message"); // 성공 여부 
		
		JsonNode response = rootNode.get("response"); // 프로필 정보 
		
		System.out.println("email: "+response.get("email").asText());
		System.out.println("id : "+response.get("id").asText());
//		t_user.setE_mail(response.get("email").asText()); // email
//		t_user.setId(response.get("id").asText()); // id(회원번호)
		*/
		
		
		return naverUser;
	}
	
	
}

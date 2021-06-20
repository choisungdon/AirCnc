package com.project.aircnc.auth;


import com.github.scribejava.apis.GoogleApi20;
import com.github.scribejava.core.builder.api.DefaultApi20;

public class SnsValue implements SnsUrls{
		private String service;
		private String clientId;
		private String clientSecret;
		private String redirectUrl;
		private DefaultApi20 api20Instance;
		private String profileURL;
		private String apiKey;
		private String google_scope;
		private String google_access_token;
		
		
		public SnsValue(String service, String clientId, String clientSecret, String redirectUrl) {
			this.service		= service;
			this.clientId		= clientId;
			this.clientSecret	= clientSecret;
			this.redirectUrl 	= redirectUrl;
			
			if(this.service.equalsIgnoreCase("naver")) {
				this.api20Instance = NaverAPI20.getInstance();
				this.profileURL 			= NAVER_PROFILE_URL;
				this.apiKey					= "";
				this.google_scope			= "";
				this.google_access_token	= "";
			}else if(this.service.equalsIgnoreCase("google")) {
				this.api20Instance = GoogleApi20.instance();
				this.apiKey					= GOOGLE_API_KEY;
				this.profileURL 			= GOOGLE_PROFILE_URL;
				this.google_scope			= GOOGLE_SCOPE;
				this.google_access_token	= GOOGLE_ACCESS_TOKEN;
			}
			
		}


		public String getService() {
			return service;
		}


		public void setService(String service) {
			this.service = service;
		}


		public String getClientId() {
			return clientId;
		}


		public void setClientId(String clientId) {
			this.clientId = clientId;
		}


		public String getClientSecret() {
			return clientSecret;
		}


		public void setClientSecret(String clientSecret) {
			this.clientSecret = clientSecret;
		}


		public String getRedirectUrl() {
			return redirectUrl;
		}


		public void setRedirectUrl(String redirectUrl) {
			this.redirectUrl = redirectUrl;
		}


		public DefaultApi20 getApi20Instance() {
			return api20Instance;
		}


		public void setApi20Instance(DefaultApi20 api20Instance) {
			this.api20Instance = api20Instance;
		}


		public String getProfileURL() {
			return profileURL;
		}


		public void setProfileURL(String profileURL) {
			this.profileURL = profileURL;
		}


		public String getApiKey() {
			return apiKey;
		}


		public void setApiKey(String apiKey) {
			this.apiKey = apiKey;
		}
		
		


		public String getGoogle_scope() {
			return google_scope;
		}


		public void setGoogle_scope(String google_scope) {
			this.google_scope = google_scope;
		}


		public String getGoogle_access_token() {
			return google_access_token;
		}


		public void setGoogle_access_token(String google_access_token) {
			this.google_access_token = google_access_token;
		}
		
		
}

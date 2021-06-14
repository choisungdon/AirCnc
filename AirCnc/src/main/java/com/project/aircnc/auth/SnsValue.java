package com.project.aircnc.auth;


import com.github.scribejava.core.builder.api.DefaultApi20;

public class SnsValue implements SnsUrls{
		private String service;
		private String clientId;
		private String clientSecret;
		private String redirectUrl;
		private DefaultApi20 api20Instance;
		private String profileURL;
		
		
		public SnsValue(String service, String clientId, String clientSecret, String redirectUrl) {
			this.service		= service;
			this.clientId		= clientId;
			this.clientSecret	= clientSecret;
			this.redirectUrl 	= redirectUrl;
			
			if(this.service.equalsIgnoreCase("naver")) {
				this.api20Instance = NaverAPI20.getInstance();
				this.profileURL = NAVER_PROFILE_URL;
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

		@Override
		public String toString() {
			return "SnsValue [service=" + service + ", clientId=" + clientId + ", clientSecret=" + clientSecret
					+ ", redirectUrl=" + redirectUrl + "]";
		}

		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			return super.equals(obj);
		}
		
		
		
}

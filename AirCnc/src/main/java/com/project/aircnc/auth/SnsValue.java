package com.project.aircnc.auth;

public class SnsValue implements SnsUrls{
		private String service;
		private String clientId;
		private String clientSecret;
		private String redirectUrl;
		
		public SnsValue(String service, String clientId, String clientSecret, String redirectUrl) {
			this.service		= service;
			this.clientId		= clientId;
			this.clientSecret	= clientSecret;
			this.redirectUrl 	= redirectUrl;
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

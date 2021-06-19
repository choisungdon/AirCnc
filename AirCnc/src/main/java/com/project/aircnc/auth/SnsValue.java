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
		
		
		public SnsValue(String service, String clientId, String clientSecret, String redirectUrl) {
			this.service		= service;
			this.clientId		= clientId;
			this.clientSecret	= clientSecret;
			this.redirectUrl 	= redirectUrl;
			
			if(this.service.equalsIgnoreCase("naver")) {
				this.api20Instance = NaverAPI20.getInstance();
				this.profileURL = NAVER_PROFILE_URL;
				this.apiKey		= "";
			}else if(this.service.equalsIgnoreCase("google")) {
				this.api20Instance = GoogleApi20.instance();
				this.profileURL = GOOGLE_PROFILE_URL;
				this.apiKey	= GOOGLE_API_KEY;
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


		@Override
		public String toString() {
			return "SnsValue [service=" + service + ", clientId=" + clientId + ", clientSecret=" + clientSecret
					+ ", redirectUrl=" + redirectUrl + ", api20Instance=" + api20Instance + ", profileURL=" + profileURL
					+ ", apiKey=" + apiKey + "]";
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((api20Instance == null) ? 0 : api20Instance.hashCode());
			result = prime * result + ((apiKey == null) ? 0 : apiKey.hashCode());
			result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
			result = prime * result + ((clientSecret == null) ? 0 : clientSecret.hashCode());
			result = prime * result + ((profileURL == null) ? 0 : profileURL.hashCode());
			result = prime * result + ((redirectUrl == null) ? 0 : redirectUrl.hashCode());
			result = prime * result + ((service == null) ? 0 : service.hashCode());
			return result;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			SnsValue other = (SnsValue) obj;
			if (api20Instance == null) {
				if (other.api20Instance != null)
					return false;
			} else if (!api20Instance.equals(other.api20Instance))
				return false;
			if (apiKey == null) {
				if (other.apiKey != null)
					return false;
			} else if (!apiKey.equals(other.apiKey))
				return false;
			if (clientId == null) {
				if (other.clientId != null)
					return false;
			} else if (!clientId.equals(other.clientId))
				return false;
			if (clientSecret == null) {
				if (other.clientSecret != null)
					return false;
			} else if (!clientSecret.equals(other.clientSecret))
				return false;
			if (profileURL == null) {
				if (other.profileURL != null)
					return false;
			} else if (!profileURL.equals(other.profileURL))
				return false;
			if (redirectUrl == null) {
				if (other.redirectUrl != null)
					return false;
			} else if (!redirectUrl.equals(other.redirectUrl))
				return false;
			if (service == null) {
				if (other.service != null)
					return false;
			} else if (!service.equals(other.service))
				return false;
			return true;
		}
		
		
		
		
		
}

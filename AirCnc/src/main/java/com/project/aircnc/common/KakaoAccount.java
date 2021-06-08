package com.project.aircnc.common;
/*여기 있는 프로필 정보 안씁니다.*/
public class KakaoAccount {
	private Boolean profile_needs_agreement;
	private KakaoProfile profile;
	private Boolean has_email;
	private Boolean email_needs_agreement;
	private Boolean	is_email_valid;
	private Boolean is_email_verified;
	private String email;
	private Boolean has_age_range;
	private Boolean age_range_needs_agreement;
	private String age_range;
	private Boolean has_birthday;
	private Boolean birthday_needs_agreement;
	private String birthday;
	private String birthday_type;
	private String has_gender;
	private Boolean gender_needs_agreement;
	private String gender;
	
	public Boolean getProfile_needs_agreement() {
		return profile_needs_agreement;
	}
	public void setProfile_needs_agreement(Boolean profile_needs_agreement) {
		this.profile_needs_agreement = profile_needs_agreement;
	}
	public KakaoProfile getProfile() {
		return profile;
	}
	public void setProfile(KakaoProfile profile) {
		this.profile = profile;
	}
	public Boolean getHas_email() {
		return has_email;
	}
	public void setHas_email(Boolean has_email) {
		this.has_email = has_email;
	}
	public Boolean getEmail_needs_agreement() {
		return email_needs_agreement;
	}
	public void setEmail_needs_agreement(Boolean email_needs_agreement) {
		this.email_needs_agreement = email_needs_agreement;
	}
	public Boolean getIs_email_valid() {
		return is_email_valid;
	}
	public void setIs_email_valid(Boolean is_email_valid) {
		this.is_email_valid = is_email_valid;
	}
	public Boolean getIs_email_verified() {
		return is_email_verified;
	}
	public void setIs_email_verified(Boolean is_email_verified) {
		this.is_email_verified = is_email_verified;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getHas_age_range() {
		return has_age_range;
	}
	public void setHas_age_range(Boolean has_age_range) {
		this.has_age_range = has_age_range;
	}
	public Boolean getAge_range_needs_agreement() {
		return age_range_needs_agreement;
	}
	public void setAge_range_needs_agreement(Boolean age_range_needs_agreement) {
		this.age_range_needs_agreement = age_range_needs_agreement;
	}
	public String getAge_range() {
		return age_range;
	}
	public void setAge_range(String age_range) {
		this.age_range = age_range;
	}
	public Boolean getHas_birthday() {
		return has_birthday;
	}
	public void setHas_birthday(Boolean has_birthday) {
		this.has_birthday = has_birthday;
	}
	public Boolean getBirthday_needs_agreement() {
		return birthday_needs_agreement;
	}
	public void setBirthday_needs_agreement(Boolean birthday_needs_agreement) {
		this.birthday_needs_agreement = birthday_needs_agreement;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getBirthday_type() {
		return birthday_type;
	}
	public void setBirthday_type(String birthday_type) {
		this.birthday_type = birthday_type;
	}
	public String getHas_gender() {
		return has_gender;
	}
	public void setHas_gender(String has_gender) {
		this.has_gender = has_gender;
	}
	public Boolean getGender_needs_agreement() {
		return gender_needs_agreement;
	}
	public void setGender_needs_agreement(Boolean gender_needs_agreement) {
		this.gender_needs_agreement = gender_needs_agreement;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}

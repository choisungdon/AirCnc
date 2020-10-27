package com.project.aircnc.common;

import org.apache.ibatis.type.Alias;

@Alias("Room_Dt_RuleVO")
public class Room_Dt_RuleVO {
	private int i_dtr; // pk
	private int i_host;
	private int i_user;
	private String stairs; //계단을 올라가야 함
	private String noise; // 소음이 발생할 수 있음
	private String animal; //숙소에 반려동물 있음
	private String in_pking; //건물 내 주차 불가
	private String public_space; //일부 공용 공간 있음
	private String plant; //편의시설 제한
	private String cctv; //숙소에 감시 또는 녹화 장치 설치
	private String weapon; //숙소에 무기 있음
	private String denger_dog; // 숙소에 위험한 동물 있음
	

	public int getI_host() {
		return i_host;
	}
	public void setI_host(int i_host) {
		this.i_host = i_host;
	}
	public int getI_user() {
		return i_user;
	}
	public void setI_user(int i_user) {
		this.i_user = i_user;
	}
	public int getI_dtr() {
		return i_dtr;
	}
	public void setI_dtr(int i_dtr) {
		this.i_dtr = i_dtr;
	}
	public String getStairs() {
		return stairs;
	}
	public void setStairs(String stairs) {
		this.stairs = stairs;
	}
	public String getNoise() {
		return noise;
	}
	public void setNoise(String noise) {
		this.noise = noise;
	}
	public String getAnimal() {
		return animal;
	}
	public void setAnimal(String animal) {
		this.animal = animal;
	}
	public String getIn_pking() {
		return in_pking;
	}
	public void setIn_pking(String in_pking) {
		this.in_pking = in_pking;
	}
	public String getPublic_space() {
		return public_space;
	}
	public void setPublic_space(String public_space) {
		this.public_space = public_space;
	}
	public String getPlant() {
		return plant;
	}
	public void setPlant(String plant) {
		this.plant = plant;
	}
	public String getCctv() {
		return cctv;
	}
	public void setCctv(String cctv) {
		this.cctv = cctv;
	}
	public String getWeapon() {
		return weapon;
	}
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	public String getDenger_dog() {
		return denger_dog;
	}
	public void setDenger_dog(String denger_dog) {
		this.denger_dog = denger_dog;
	}
	
	
}

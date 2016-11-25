package com.slimsmart.model.bus.voice;


import com.slimsmart.common.model.BaseEntity;

public class VoiceLocation extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 经纬度
	 */
	private String lon;
	private String lat;
	//地址的详细描述
	private String addr;
	//地址的模糊描述
	private String locationDesc;
	/**
	 *提交记录的用户 
	 */
	private String userId;
	/**
	 *声音分贝值集合 
	 */
	private Voice voice;
	
	
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getLocationDesc() {
		return locationDesc;
	}
	public void setLocationDesc(String locationDesc) {
		this.locationDesc = locationDesc;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public Voice getVoice() {
		return voice;
	}
	public void setVoice(Voice voice) {
		this.voice = voice;
	}
	
	
	
}

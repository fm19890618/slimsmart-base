package com.slimsmart.model.bus.voice;

import com.slimsmart.common.model.BaseEntity;

public class Voice extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 最小分贝值
	 */
	private int minVoiceDb;
	/**
	 * 最大分贝值
	 */
	private int maxVoiceDb;
	/**
	 * 等效分贝值
	 */
	private int voiceDb;
	
	/**
	 * 原始声音字分贝符串
	 */
	private String voiceStr;
	/**
	 * 获取改测量值的用户
	 */
	private String userId;
	
	/**
	 *所属位置id 
	 */
	private String locationId;
	
	/**
	 *是否是声暴露级
	 */
	private int isTask;
	
	/**
	 *是否已发布到地图
	 */
	private int isRelease;
	
	
	public int getIsTask() {
		return isTask;
	}

	public void setIsTask(int isTask) {
		this.isTask = isTask;
	}

	public int getIsRelease() {
		return isRelease;
	}

	public void setIsRelease(int isRelease) {
		this.isRelease = isRelease;
	}

	public int getMinVoiceDb() {
		return minVoiceDb;
	}

	public void setMinVoiceDb(int minVoiceDb) {
		this.minVoiceDb = minVoiceDb;
	}

	public int getMaxVoiceDb() {
		return maxVoiceDb;
	}

	public void setMaxVoiceDb(int maxVoiceDb) {
		this.maxVoiceDb = maxVoiceDb;
	}

	public int getVoiceDb() {
		return voiceDb;
	}

	public void setVoiceDb(int voiceDb) {
		this.voiceDb = voiceDb;
	}

	public String getVoiceStr() {
		return voiceStr;
	}

	public void setVoiceStr(String voiceStr) {
		this.voiceStr = voiceStr;
	}


	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}

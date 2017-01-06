package com.slimsmart.common.model;

import java.io.Serializable;

public class VoiceQueryVo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String addr;
	
	private int type;
	
	private int isRelease;
	
	private String userId;
	
	/**
	 * 分页相关
	 */
	private int page;
	
	private int total;
	
	private int start;
	
	private int rows;
	//是否是个体声暴露数据
	private int isTask;

	private String createDateStr;
	
	
	
	public String getCreateDateStr() {
		return createDateStr;
	}

	public void setCreateDateStr(String createDateStr) {
		this.createDateStr = createDateStr;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getIsTask() {
		return isTask;
	}

	public void setIsTask(int isTask) {
		this.isTask = isTask;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getIsRelease() {
		return isRelease;
	}

	public void setIsRelease(int isRelease) {
		this.isRelease = isRelease;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
	
	
	
	
	
}

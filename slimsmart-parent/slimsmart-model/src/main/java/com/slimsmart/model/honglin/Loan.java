package com.slimsmart.model.honglin;

import com.slimsmart.common.model.BaseEntity;

public class Loan extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private String description;
	
	private Long applyNum;
	
	private String rate;
	
	private String logoUrl;
	
	private String tapUrl;
	
	private int remark1;
	
	private String remark2;
	
	private String remark3;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getApplyNum() {
		return applyNum;
	}

	public void setApplyNum(Long applyNum) {
		this.applyNum = applyNum;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getTapUrl() {
		return tapUrl;
	}

	public void setTapUrl(String tapUrl) {
		this.tapUrl = tapUrl;
	}

	public int getRemark1() {
		return remark1;
	}

	public void setRemark1(int remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getRemark3() {
		return remark3;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}
	
	
	 
	
}

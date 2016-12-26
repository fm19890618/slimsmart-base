package com.slimsmart.model.taobao;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.slimsmart.common.model.BaseEntity;
import com.slimsmart.common.util.date.DateTimeSerializer;

public class SearchKey extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	
	private String searchKey;
	
	//创建时间
	private Date createTime;
	
	
	@JsonSerialize(using = DateTimeSerializer.class)
	public Date getCreateTime() {
		return createTime;
	}
	@JsonSerialize(using = DateTimeSerializer.class)
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	
	

}

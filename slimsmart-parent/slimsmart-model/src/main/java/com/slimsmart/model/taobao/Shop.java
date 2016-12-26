package com.slimsmart.model.taobao;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.slimsmart.common.model.BaseEntity;
import com.slimsmart.common.util.date.DateTimeSerializer;

public class Shop extends BaseEntity{

	
	private static final long serialVersionUID = 1L;
	//店铺名称
	private String shopName;
	//店铺地址
	private String shopUrl;
	//店铺旺旺
	private String wangwang;
	//店铺主营
	private String sellWhat;
	//店铺销量
	private String sellNum;
	//店铺宝贝数量
	private String productNum;
	//店铺所在省份
	private String provinceId;
	private String provinceName;
	//店铺所在城市
	private String cityId;
	private String cityName;
	//店铺等级
	private String level;
	//店铺联系电话
	private String telphone;
	//好评率
	private String goodratePercent;
	//创建时间
	private Date createTime;
	//搜索关键词
	private String searchKey;
	//搜索关键词id
	private String searchKeyId;
	
	
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public String getSearchKeyId() {
		return searchKeyId;
	}
	public void setSearchKeyId(String searchKeyId) {
		this.searchKeyId = searchKeyId;
	}
	@JsonSerialize(using = DateTimeSerializer.class)
	public Date getCreateTime() {
		return createTime;
	}
	@JsonSerialize(using = DateTimeSerializer.class)
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getGoodratePercent() {
		return goodratePercent;
	}
	public void setGoodratePercent(String goodratePercent) {
		this.goodratePercent = goodratePercent;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopUrl() {
		return shopUrl;
	}
	public void setShopUrl(String shopUrl) {
		this.shopUrl = shopUrl;
	}
	public String getWangwang() {
		return wangwang;
	}
	public void setWangwang(String wangwang) {
		this.wangwang = wangwang;
	}
	public String getSellWhat() {
		return sellWhat;
	}
	public void setSellWhat(String sellWhat) {
		this.sellWhat = sellWhat;
	}
	public String getSellNum() {
		return sellNum;
	}
	public void setSellNum(String sellNum) {
		this.sellNum = sellNum;
	}
	public String getProductNum() {
		return productNum;
	}
	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}
	public String getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	
}

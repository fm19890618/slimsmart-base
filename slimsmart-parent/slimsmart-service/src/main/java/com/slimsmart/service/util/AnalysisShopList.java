package com.slimsmart.service.util;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.htmlparser.util.ParserException;

import com.slimsmart.common.util.http.HttpClientUtil;
import com.slimsmart.dao.taobao.ShopDao;
import com.slimsmart.model.taobao.Shop;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class AnalysisShopList implements Runnable{
	
	private String searcheKeyId;
	private String searcheKey;
	private String url;
	
	private final String preUrl = "https://shopsearch.taobao.com/search?app=shopsearch&q=";
	private final String shopListDomClass = "list-item";
	private ShopDao shopDao;
	private int rows;
	
	
	public AnalysisShopList(String searcheKey,String searcheKeyId,ShopDao shopDao,int rows){
		this.searcheKeyId = searcheKeyId;
		this.searcheKey = searcheKey;
		this.url = preUrl + URLEncoder.encode(searcheKey);
		this.shopDao = shopDao;
		this.rows = rows;
	}
	
	@Override
	public void run(){
		System.out.println("========================================="+rows);
		try {
			getData(rows);
		} catch (ParserException e) {
			e.printStackTrace();
		}
	}
	
	public void getData(int rows) throws ParserException{
		String html = HttpClientUtil.get(url+"&s="+rows, null);
		String shopStr = html.split("g_srp_loadCss()")[0].split("g_page_config = ")[1].replace(";", "");
		JSONObject shopJson = new JSONObject().fromObject(shopStr);
		JSONArray shopArr = shopJson.getJSONObject("mods").getJSONObject("shoplist").getJSONObject("data").getJSONArray("shopItems");
		for (int i = 0; i < shopArr.size(); i++) {
			JSONObject shopObj = shopArr.getJSONObject(i);
			Shop shop = new Shop();
			try {shop.setShopName(shopObj.getString("title")==null?"":shopObj.getString("title"));} catch (Exception e) {}	
			try {shop.setWangwang(shopObj.getString("nick")==null?"":shopObj.getString("nick"));} catch (Exception e) {}	
			try {shop.setSellNum(String.valueOf(shopObj.get("totalsold")==null?"0":shopObj.getInt("totalsold")));} catch (Exception e) {}	
			try {shop.setProductNum(String.valueOf(shopObj.get("procnt")==null?"0":shopObj.get("procnt")));} catch (Exception e) {}	
			try {shop.setGoodratePercent(shopObj.getString("goodratePercent")==null?"":shopObj.getString("goodratePercent"));} catch (Exception e) {}	
			try {shop.setShopUrl("https:"+shopObj.getString("shopUrl")==null?"":shopObj.getString("shopUrl"));} catch (Exception e) {}	
			try {shop.setLevel(shopObj.getJSONObject("shopIcon").getString("iconClass"));} catch (Exception e) {}	
			try {shop.setSellWhat(shopObj.getString("mainAuction")==null?"":shopObj.getString("mainAuction"));} catch (Exception e) {}	
			try {shop.setProvinceName(shopObj.getString("provcity")==null?"":shopObj.getString("provcity"));} catch (Exception e) {}	
			shop.setTelphone(GetShopPhone.getShopPhone(shop.getShopUrl()));
			shop.setSearchKey(searcheKey);
			shop.setSearchKeyId(searcheKeyId);
			shopDao.insert(shop);
		}
	}
	
	private void log(String str){
		System.out.println(str);
	}

}

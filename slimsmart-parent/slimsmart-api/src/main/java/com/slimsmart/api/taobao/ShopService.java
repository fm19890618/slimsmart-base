package com.slimsmart.api.taobao;

import org.htmlparser.util.ParserException;

import com.slimsmart.common.service.BaseService;
import com.slimsmart.model.taobao.Shop;

public interface ShopService extends BaseService<Shop>{
	
	int getShopListData(String keyword) throws ParserException;
	
	void deleteShopAndSearchKey(String id);

}

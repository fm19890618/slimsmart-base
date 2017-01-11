package com.slimsmart.dao.taobao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.slimsmart.common.dao.MyBatisDao;
import com.slimsmart.model.taobao.Shop;
@Repository
public class ShopDao extends MyBatisDao<Shop> {
	
	
	public void batchInsertShop(List<Shop> list){
		batchInsert("batchInsert", list);
	}

	public void deleteShopAndSearchKey(String id){
		update("deleteSearchKey", id);
		update("deleteShop", id);
	}
}

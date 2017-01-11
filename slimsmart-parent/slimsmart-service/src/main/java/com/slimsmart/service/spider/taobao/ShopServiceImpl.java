package com.slimsmart.service.spider.taobao;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.htmlparser.util.ParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slimsmart.api.taobao.SearchKeyService;
import com.slimsmart.api.taobao.ShopService;
import com.slimsmart.common.service.AbstractBaseService;
import com.slimsmart.common.util.UUID;
import com.slimsmart.dao.taobao.ShopDao;
import com.slimsmart.model.taobao.SearchKey;
import com.slimsmart.model.taobao.Shop;
import com.slimsmart.service.util.AnalysisShopList;
import com.slimsmart.service.util.GetShopPhone;
@Service
public class ShopServiceImpl extends AbstractBaseService<Shop> implements ShopService{
	//每页显示的条数
	private final int rows = 20;
	//限定搜索结果的页数
	private final int pageCout = 50;
	@Autowired
	private ShopDao shopDao;
	@Autowired
	private SearchKeyService searchKeyService;
	@Override
	public int getShopListData(String keyword) throws ParserException {
		SearchKey sk = new SearchKey();
		String searcheKeyId = UUID.getUUID();
		sk.setId(searcheKeyId);
		sk.setSearchKey(keyword);
		searchKeyService.insert(sk);
		//创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newSingleThreadExecutor();
		for(int i = 0; i < 50; i ++){
			AnalysisShopList asl = new AnalysisShopList(keyword,searcheKeyId, shopDao, rows*i);
			pool.execute(asl);
		}
		return 0;
	}
	@Override
	public void deleteShopAndSearchKey(String id) {
		shopDao.deleteShopAndSearchKey(id);
		
	}

}

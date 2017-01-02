package com.slimsmart.weboss.taobao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.htmlparser.util.ParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slimsmart.api.taobao.SearchKeyService;
import com.slimsmart.api.taobao.ShopService;
import com.slimsmart.common.page.Page;
import com.slimsmart.common.util.ReflectionUtil;
import com.slimsmart.common.web.BaseController;
import com.slimsmart.model.taobao.SearchKey;
import com.slimsmart.model.taobao.Shop;

@Controller
@RequestMapping("/taobao/shop/*")
public class ShopController extends BaseController<Shop>{
	@Autowired
	private ShopService shopService;
	@Autowired
	private SearchKeyService searchKeyService;
	
	@RequestMapping("location")
	@ResponseBody
	public int getShop(HttpServletRequest request,String key) throws ParserException{
		
		return shopService.getShopListData(key);
	}

	@Override
	public String index() {
		System.out.println();
		return getNameSpace()+"shop-list";
	}
	
	@RequestMapping("list")
	@ResponseBody
	public Page<Shop> list(Shop shop, Integer page, Integer rows, HttpServletRequest request) throws Exception {
		Page<Shop> pageItem = new Page<Shop>(page, rows);
		if (shop == null) {
			filterMap = new HashMap<String, Object>();
		} else {
			filterMap = ReflectionUtil.convertBean(shop);
		}
		return shopService.findPage(pageItem, filterMap);
	}
	
	
	@RequestMapping("getListSearchKey")
	@ResponseBody
	public List<SearchKey> getListSearchKey(){
		
		return searchKeyService.findList(null);
	}
	
	@RequestMapping("exportExcel")
	public void exportExcel(HttpServletRequest request,HttpServletResponse response,String searchKeyId,Shop shop,String hasphone) throws Exception{
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("searchKeyId", searchKeyId);
		List<Shop> list = shopService.findList(map);
		
		
		String fileName = request.getParameter("f");  
		fileName="template.xlsx";  
		String rootpath = request.getSession().getServletContext().getRealPath("/template/");  
		writeDataToExcel(list,rootpath+fileName,shop,hasphone);
		
        response.setContentType("text/html;charset=UTF-8");   
        BufferedInputStream in = null;  
        BufferedOutputStream out = null;  
        request.setCharacterEncoding("UTF-8");  
        
        try {  
            File f = new File(rootpath + fileName);  
            response.setContentType("application/x-excel");  
            response.setCharacterEncoding("UTF-8");  
            response.setHeader("Content-Disposition", "attachment;filename="+new String((list.get(0).getSearchKey()+".xlsx").getBytes("gbk"),"iso-8859-1"));  
            response.setHeader("Content-Length",String.valueOf(f.length()));  
            in = new BufferedInputStream(new FileInputStream(f));  
            out = new BufferedOutputStream(response.getOutputStream());  
            byte[] data = new byte[1024];  
            int len = 0;  
            while (-1 != (len=in.read(data, 0, data.length))) {  
                out.write(data, 0, len);  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            if (in != null) {  
                in.close();  
            }  
            if (out != null) {  
                out.close();  
            }  
        }  
	}
	
	
	private void writeDataToExcel(List<Shop> shops,String filePath,Shop shopCon,String hasphone) throws Exception{
		//创建文件流   
        OutputStream stream = new FileOutputStream(filePath);  
        Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet("sheet1"); 
		//设置文件头部信息
		sheet.setColumnWidth((short) 0, 20 * 256);
		sheet.setColumnWidth((short) 2, 30 * 256);
		sheet.setColumnWidth((short) 4, 60 * 256);
		CellStyle style = wb.createCellStyle(); // 样式对象      
        // 设置单元格的背景颜色为淡蓝色  
        style.setFillForegroundColor(HSSFColor.PALE_BLUE.index); 
        
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);// 垂直      
        style.setAlignment(CellStyle.ALIGN_CENTER);// 水平   
        style.setWrapText(true);// 指定当单元格内容显示不下时自动换行
       
        Font font = wb.createFont();  
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);  
        font.setFontName("宋体");  
        font.setFontHeight((short) 280);  
        style.setFont(font);  
        
		Row row = sheet.createRow(0);
		Cell cell1 = row.createCell(0);
		if(null!=shopCon.getShopName()){
			cell1.setCellValue("店铺名称");
			cell1.setCellStyle(style);
		}else{
			sheet.setColumnWidth((short) 0, 0);
		}
		
		Cell cell2 = row.createCell(1);
		if(null!=shopCon.getShopUrl()){
			cell2.setCellValue("店铺地址");
			cell2.setCellStyle(style);
		}else{
			sheet.setColumnWidth((short) 1, 0);
		}
		
		
		Cell cell3 = row.createCell(2);
		if(null!=shopCon.getTelphone()){
			cell3.setCellValue("联系电话");
			cell3.setCellStyle(style);
		}else{
			sheet.setColumnWidth((short) 2, 0);
		}
		
		Cell cell4 = row.createCell(3);
		if(null!=shopCon.getWangwang()){
			cell4.setCellValue("旺旺id");
			cell4.setCellStyle(style);
		}else{
			sheet.setColumnWidth((short) 3, 0);
		}
		
		Cell cell5 = row.createCell(4);
		if(null!=shopCon.getSellWhat()){
			cell5.setCellValue("主营");
			cell5.setCellStyle(style);
		}else{
			sheet.setColumnWidth((short) 4, 0);
		}
		
		Cell cell6 = row.createCell(5);
		if(null!=shopCon.getSellNum()){
			cell6.setCellValue("销量");
			cell6.setCellStyle(style);
		}else{
			sheet.setColumnWidth((short) 5, 0);
		}
		
		Cell cell7 = row.createCell(6);
		if(null!=shopCon.getProductNum()){
			cell7.setCellValue("宝贝数量");
			cell7.setCellStyle(style);
		}else{
			sheet.setColumnWidth((short) 6, 0);
		}
		
		
		Cell cell8 = row.createCell(7);
		if(null!=shopCon.getProvinceName()){
			cell8.setCellValue("省份");
			cell8.setCellStyle(style);
		}else{
			sheet.setColumnWidth((short) 7, 0);
		}	
		Cell cell9 = row.createCell(8);
		if(null!=shopCon.getLevel()){
			cell9.setCellValue("店铺等级");
			cell9.setCellStyle(style);
		}else{
			sheet.setColumnWidth((short) 8, 0);
		}	
		
		Cell cell10 = row.createCell(9);
		if(null!=shopCon.getGoodratePercent()){
			cell10.setCellValue("好评率");
			cell10.setCellStyle(style);
		}else{
			sheet.setColumnWidth((short) 9, 0);
		}	
		Cell cell11 = row.createCell(10);
		cell11.setCellValue("关键词");
		cell11.setCellStyle(style);
		
		int i = 1;
		for(Shop shop : shops){
			Row r = sheet.createRow(i);
			if(null != hasphone){
				if(null == shop.getTelphone() || shop.getTelphone().trim().equals("")){
					continue;
				}
			}
			Cell cell1_ = r.createCell(0);
			cell1_.setCellValue(shop.getShopName());
			
			Cell cell2_ = r.createCell(1);
			cell2_.setCellValue("https:"+shop.getShopUrl());
			
			Cell cell3_ = r.createCell(2);
			cell3_.setCellValue(shop.getTelphone());
			
			Cell cell4_ = r.createCell(3);
			cell4_.setCellValue(shop.getWangwang());
			Cell cell5_ = r.createCell(4);
			cell5_.setCellValue(shop.getSellWhat());
			Cell cell6_ = r.createCell(5);
			cell6_.setCellValue(Integer.parseInt(shop.getSellNum()==null?"0":shop.getSellNum()));
			Cell cell7_ = r.createCell(6);
			cell7_.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell7_.setCellValue(shop.getProductNum());
			Cell cell8_ = r.createCell(7);
			cell8_.setCellValue(shop.getProvinceName());
			Cell cell9_ = r.createCell(8);
			cell9_.setCellValue(shop.getLevel().replace("rank seller-rank-", "").replace("icon-service-tianmao-large", ""));
			Cell cell10_ = r.createCell(9);
			cell10_.setCellValue(shop.getGoodratePercent());
			Cell cell11_ = r.createCell(10);
			cell11_.setCellValue(shop.getSearchKey());
			i ++;
		}
		
        //写入数据   
        wb.write(stream);  
        //关闭文件流   
        stream.close();  
	}
	

	@Override
	protected String getNameSpace() {
		
		return "/pages/taobao/shop/";
	}
	

}

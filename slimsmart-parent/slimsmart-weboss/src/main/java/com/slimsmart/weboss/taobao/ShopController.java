package com.slimsmart.weboss.taobao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
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
	public void exportExcel(HttpServletRequest request,HttpServletResponse response,String searchKeyId) throws IOException{
		
		
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet("sheet1"); 
		Row row = sheet.createRow(1);
		Cell cell = row.createCell(1);
		cell.setCellValue("被保险人员清单");
		
		
		response.setContentType("text/html;charset=UTF-8");   
        BufferedInputStream in = null;  
        BufferedOutputStream out = null;  
        request.setCharacterEncoding("UTF-8");  
        String rootpath = request.getSession().getServletContext().getRealPath(  
                "/template/");  
        String fileName = request.getParameter("f");  
        
        
      //创建文件流   
        OutputStream stream = new FileOutputStream(rootpath + fileName);  
        //写入数据   
        wb.write(stream);  
        //关闭文件流   
        stream.close();  
        
        
        fileName="template.xlsx";  
        try {  
            File f = new File(rootpath + fileName);  
            response.setContentType("application/x-excel");  
            response.setCharacterEncoding("UTF-8");  
            response.setHeader("Content-Disposition", "attachment;filename="+new String("电脑啊.xlsx".getBytes("gbk"),"iso-8859-1"));  
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
	

	@Override
	protected String getNameSpace() {
		
		return "/pages/taobao/shop/";
	}
	

}

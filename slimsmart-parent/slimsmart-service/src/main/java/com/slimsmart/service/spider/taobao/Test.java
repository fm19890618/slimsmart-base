package com.slimsmart.service.spider.taobao;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.filters.RegexFilter;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import com.slimsmart.common.util.PasswordUtil;
import com.slimsmart.common.util.http.HttpClientUtil;
import com.slimsmart.service.util.AnalysisShopList;
import com.slimsmart.service.util.HtmlPaserUtil;

public class Test {
	
	
	
	public static void main(String[] args) throws ParserException {
		String password = "1111";
		password = PasswordUtil.getMD5(password);
		password = PasswordUtil.getSaltMD5(password);
		System.out.println(password);
//		AnalysisShopList an = new AnalysisShopList("电脑");
//		an.getData(0);
		/*Parser parser = new Parser ("https://yipeism.tmall.com/shop/view_shop.htm?spm=a230r.7195193.1997079397.194.B03AMu");
		NodeIterator iterator = parser.elements();
		while (iterator.hasMoreNodes()) {
			Node node = iterator.nextNode();
			getPhone(node.toPlainTextString());
			//System.out.println(node.toPlainTextString());
		}*/
		
		
	}
	
	
	public static boolean isMobileNO(String mobiles){  
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(14[57])|(17[0])|(17[7])|(18[0,0-9]))\\d{8}$");  
		Matcher m = p.matcher(mobiles);  
		System.out.println(m.matches()+"---");  
		return m.matches();  
	}  
	
	public static String getPhone(String string) {
        Pattern pattern = Pattern.compile("(?<!\\d)(?:(?:1[3578]\\d{9})|(?:861[34578]\\d{9}))(?!\\d)");
        Matcher matcher = pattern.matcher(string);
        StringBuffer bf = new StringBuffer(64);
        while (matcher.find()) {
            bf.append(matcher.group()).append(",");
            System.out.println(matcher.group());
            string = matcher.group().trim();
        }
        
//		int len = bf.length();
//		if (len > 0) {
//			bf.deleteCharAt(len - 1);
//		}
//		System.out.println(bf.toString());
	
        return string;
    }

}

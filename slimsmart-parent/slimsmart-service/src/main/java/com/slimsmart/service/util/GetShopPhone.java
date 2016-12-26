package com.slimsmart.service.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.ParserException;

import com.slimsmart.common.util.http.HttpClientUtil;

public class GetShopPhone {
	
	public static String  getShopPhone(String url) throws ParserException{
		String phones = "";
		try {
			Parser parser = new Parser ("https:"+url);
			NodeFilter filter = new HasAttributeFilter("class", "service-content");
			NodeIterator iterator = parser.extractAllNodesThatMatch(filter).elements();
			while (iterator.hasMoreNodes()) {
				Node node = iterator.nextNode();
				phones += getPhone(node.toPlainTextString());
			}
		} catch (Exception e) {
		}
		if(!"".equals(phones)){
			phones.substring(0,phones.length()-1);
		}
		return phones;
	}
	
	
	private static String getPhone(String string) {
        Pattern pattern = Pattern.compile("(?<!\\d)(?:(?:1[3578]\\d{9})|(?:861[34578]\\d{9}))(?!\\d)");
        Matcher matcher = pattern.matcher(string);
        StringBuffer bf = new StringBuffer(64);
        while (matcher.find()) {
        	if(!string.contains("document.getElementById")){
        		bf.append(matcher.group()).append(",");
        	}
            
        }
        return bf.toString();
    }
	
	
	public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }
	
	
	
	
	
	public static void main(String[] args) throws ParserException {
		String a = getShopPhone("//shop60998674.taobao.com/");
		System.out.println(a);
	}
}

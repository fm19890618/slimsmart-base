package com.slimsmart.service.util;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.nodes.TextNode;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.springframework.util.StringUtils;

public class HtmlPaserUtil {
	
	
	/**
	 * 过滤掉html中的脚本信息
	 * @param html
	 * @return
	 */
	public static String filterScriptAndStyle(String html){
	    if(StringUtils.isEmpty(html)) return html;
	        ScriptFilter scriptFilter = new ScriptFilter();
	    try{
	        StringBuilder text = new StringBuilder();
	        Parser parser = new Parser();
	        parser.setEncoding("8859_1");
	        parser.setInputHTML(html);
	        //遍历所有的节点
	        NodeList nodes = parser.extractAllNodesThatMatch(scriptFilter);         
	        for(int i=0;i<nodes.size();i++){
	            Node node = nodes.elementAt(i);
	            if(node instanceof TextNode)
	                text.append(node.getText());
	            else{
	                text.append('<');
	                text.append(node.getText());
	                text.append('>');
	            }
	        }
	        return text.toString();
	    }catch(ParserException e){
	        e.printStackTrace();
	    }
	    return html;
	}

}

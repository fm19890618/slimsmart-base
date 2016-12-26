package com.slimsmart.service.util;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Tag;
import org.htmlparser.tags.FrameTag;
import org.htmlparser.tags.ScriptTag;
import org.htmlparser.tags.StyleTag;

public class ScriptFilter implements NodeFilter {

	@Override
	public boolean accept(Node node) {
		if(node == null)
            return false;
        if(node instanceof Tag){
            String tag = ((Tag)node).getTagName();
            if("iframe".equalsIgnoreCase(tag))
                return false;
        }
        if(node instanceof StyleTag)
            return false;
        if(node instanceof ScriptTag)
            return false;
        if(node instanceof FrameTag)
            return false;
        //if(node.getParent()!=null)
        //  return accept(node.getParent());
        return true;
	}

}

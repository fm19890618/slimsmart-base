package com.slimsmart.weboss.honglin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.slimsmart.common.web.BaseController;
import com.slimsmart.model.honglin.Loan;

@Controller
@RequestMapping("/loan/*")
public class IndexCotroller extends BaseController<Loan>{

	
	@Override
	public String index() {
		
		return getNameSpace()+"index";
	}
	@Override
	protected String getNameSpace() {
		
		return "/pages/honglin/";
	}
}

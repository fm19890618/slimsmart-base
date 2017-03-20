package com.slimsmart.weboss.honglin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.slimsmart.api.honglin.LoanService;
import com.slimsmart.common.page.Page;
import com.slimsmart.common.util.http.ResponseMsg;
import com.slimsmart.common.web.BaseController;
import com.slimsmart.model.honglin.Loan;
import com.slimsmart.model.usercenter.BackUser;
import com.slimsmart.service.util.FileUtil;

@Controller
@RequestMapping("/loan/*")
public class IndexCotroller extends BaseController<Loan>{

	@Autowired
	private LoanService loanService;
	
	@Override
	public String index() {
		
		return getNameSpace()+"index";
	}
	
	@RequestMapping("getLoanList")
	@ResponseBody
	public Map<String,Object> getLoanList(){
		
		List<Loan> list = loanService.findList();
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("result",list);
		
		return map;
		
	}
	
	@RequestMapping("save")
	@ResponseBody
	public ResponseMsg save(Loan loan,HttpServletRequest request,@RequestParam(value = "file", required = false) MultipartFile file){
		ResponseMsg res = new ResponseMsg();
		try {
			String strDirPath = request.getSession().getServletContext().getRealPath("/")+"pages/honglin/upload/";
			if(file.getSize()>0){
				String fileName = file.getOriginalFilename();
				String name = System.currentTimeMillis()+"."+fileName.substring(fileName.lastIndexOf(".")+1);
				FileUtil.savePic(file.getInputStream(),name,strDirPath);
				loan.setLogoUrl("/pages/honglin/upload/"+name);
			}
		} catch (Exception e) {
			res.setData("error");
		}
		res.setData("success");
		res.setMessage("保存成功");
		loanService.save(loan);
		return res;
	}
	
	@RequestMapping("update")
	@ResponseBody
	public ResponseMsg update(Loan loan,HttpServletRequest request,@RequestParam(value = "file", required = false) MultipartFile file){
		ResponseMsg res = new ResponseMsg();
		try {
			String strDirPath = request.getSession().getServletContext().getRealPath("/")+"pages/honglin/upload/";
			if(file.getSize()>0){
				String fileName = file.getOriginalFilename();
				String name = System.currentTimeMillis()+"."+fileName.substring(fileName.lastIndexOf(".")+1);
				FileUtil.savePic(file.getInputStream(),name,strDirPath);
				loan.setLogoUrl("/pages/honglin/upload/"+name);
			}
		} catch (Exception e) {
			res.setData("error");
		}
		res.setData("success");
		res.setMessage("保存成功");
		loanService.update(loan);
		return res;
	}
	
	@RequestMapping("detail")
	@ResponseBody
	public Loan detail(String id, HttpServletRequest request){
		
		return loanService.get(id);
	}
	
	
	
	@RequestMapping("managerIndex")
	public String managerIndex() {
		
		return getNameSpace()+"manager/loan-list";
	}
	
	@RequestMapping("managerList")
	@ResponseBody
	public Page<Loan> managerList(Integer page, Integer rows, HttpServletRequest request) {
		Page<Loan> pageItem = new Page<Loan>(page, rows);
		
		return loanService.findPage(pageItem, null);
	}
	
	
	@RequestMapping("register")
	public String register(){
		
		return getNameSpace()+"register";
	}
	
	@RequestMapping("registerSuccess")
	public String registerSuccess(){
		
		return getNameSpace()+"registerSuccess";
	}
	
	@Override
	protected String getNameSpace() {
		
		return "/pages/honglin/";
	}
}

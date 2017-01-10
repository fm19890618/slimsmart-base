package com.slimsmart.weboss.usercenter;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slimsmart.api.bus.voice.VoiceLocationService;
import com.slimsmart.api.bus.voice.VoiceService;
import com.slimsmart.api.usercenter.BackUserService;
import com.slimsmart.common.model.VoiceQueryVo;
import com.slimsmart.common.util.UUID;
import com.slimsmart.model.bus.voice.Voice;
import com.slimsmart.model.bus.voice.VoiceLocation;
import com.slimsmart.model.usercenter.BackUser;

import net.sf.json.JSONObject;

@Controller
public class VoiceAppController{

	@Autowired
	private VoiceService voiceService;
	@Autowired
	private VoiceLocationService voiceLocationService;
	@Autowired
	private BackUserService userService;
	
	
	@RequestMapping("location")
	@ResponseBody
	public String location(HttpServletRequest request){
		Map<String,String> map = showParams(request);
		Voice v = getVoiceArr(map.get("voice"));
		VoiceLocation vl = parseJson(map.get("location"));
		v.setLocationId(vl.getId());
		v.setIsRelease(Integer.parseInt(map.get("isRelease")));
		v.setIsTask(Integer.parseInt(map.get("isTask")));
		v.setUserId(map.get("userId"));
		voiceService.save(v);
		vl.setUserId(v.getUserId());
		voiceLocationService.save(vl);
		
		return "ok";
	}
	
	@RequestMapping("getVoiceLocationInfo")
	@ResponseBody
	public Map<String,Object> getVoiceLocationInfo(HttpServletRequest request,VoiceQueryVo vo){
		System.out.println("============="+vo.getIsRelease());
		return voiceService.getLocationAndVoice(vo);
	}
	
	@RequestMapping("releaseVoice")
	@ResponseBody
	public Map<String,Object> releaseVoice(HttpServletRequest request,String id,String delete,String time,String userId){
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			if(delete.equals("1")){
				voiceService.deleteVoice(id);
			}else if(delete.equals("0")){
				voiceService.releaseVoice(id);
			}else if(delete.equals("2")){
				voiceService.deleteVoiceTask(userId, time);
			}
			
			map.put("isok","1");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("isok","0");
		}
		return map;
	}
	
	@RequestMapping("loginOrRegist")
	@ResponseBody
	public Map<String,String> loginOrRegist(HttpServletRequest request){
		Map<String,String> json = new HashMap<String,String>();
		try {
			Map<String,String> map = showParams(request);
			String userName = map.get("loginName");
			String password = map.get("password");
			json.put("loginName", userName);
			if(map.get("isRegist").toString().equals("0")){//登录
				BackUser en = userService.getBackUserByLoginName(userName);
				if(en.getPassword().equals(password)){
					json.put("isok", "1");
				}else{
					json.put("isok", "0");
				}
			}else if(map.get("isRegist").toString().equals("1")){//注册
				BackUser bu = new BackUser();
				bu.setLoginName(userName);
				bu.setPassword(password);
				bu.setStatus("0");
				userService.insert(bu);
				json.put("isok", "3");
			}
		} catch (Exception e) {
			json.put("isok", "0");
		}
		
		
		
		return new JSONObject().fromObject(json);
	}
	
	
	@RequestMapping("getLineChartData")
	@ResponseBody
	public String getLineChartData(String userId,String time){
		String result = voiceService.getLineChartData(userId,time);
		System.out.println("统计结果========="+result);
		return result.substring(0, result.length()-1);
	}
	
	
	
	
	public static void main(String[] args) {
		//getVoiceArr("");
		System.out.println(0/0);
	}
	public Voice getVoiceArr(String str){
		//str = "12.041201,18.0618,22.922562,22.922562,24.608978,,";
		DecimalFormat df = new DecimalFormat("######0");
		String[] arr = str.split(",");
		List<Double> dbList = new ArrayList<Double>();
		Double sum = 0.0;
		for(int i = 0;i < arr.length;i ++){
			if(StringUtils.isNotBlank(arr[i])){
				Double db = Double.parseDouble(arr[i]);
				dbList.add(db);
				sum += db;
			}
		}
		Voice voice = new Voice();
		voice.setMaxVoiceDb(Integer.parseInt(df.format(Collections.max(dbList))));
		voice.setMinVoiceDb(Integer.parseInt(df.format(Collections.min(dbList))));
		voice.setVoiceDb(Integer.parseInt(df.format(sum/dbList.size())));
		voice.setId(UUID.getUUID());
		if(str.length() <= 20480){
			voice.setVoiceStr(str);
		}else{
			voice.setVoiceStr("it's too long");
		}
		//System.out.println(voice);
		return voice;
	}
	
	private VoiceLocation parseJson(String str){
		JSONObject json = new JSONObject().fromObject(str);
		VoiceLocation vl = new VoiceLocation();
		vl.setId(UUID.getUUID());
		vl.setLat(json.getString("lat"));
		vl.setLon(json.getString("lon"));
		vl.setLocationDesc(json.getString("locationDesc"));
		vl.setAddr(json.getString("addr"));
		return vl;
	}
	
	
	private Map<String,String> showParams(HttpServletRequest request) {
		Map<String,String> result = new HashMap<String,String>();
		Map map=request.getParameterMap();
	    Set keSet=map.entrySet();
	    for(Iterator itr=keSet.iterator();itr.hasNext();){
	        Map.Entry me=(Map.Entry)itr.next();
	        Object ok=me.getKey();
	        Object ov=me.getValue();
	        String[] value=new String[1];
	        if(ov instanceof String[]){
	            value=(String[])ov;
	        }else{
	            value[0]=ov.toString();
	        }

	        for(int k=0;k<value.length;k++){
	        	result.put(ok.toString(), value[k]);
	        	System.out.println(value[k]);
	        }
	      }
	    return result;
    }
	
}

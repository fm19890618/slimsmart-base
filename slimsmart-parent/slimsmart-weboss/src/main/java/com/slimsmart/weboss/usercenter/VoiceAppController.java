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
import com.slimsmart.common.model.VoiceQueryVo;
import com.slimsmart.common.util.UUID;
import com.slimsmart.model.bus.voice.Voice;
import com.slimsmart.model.bus.voice.VoiceLocation;

import net.sf.json.JSONObject;

@Controller
public class VoiceAppController{

	@Autowired
	private VoiceService voiceService;
	@Autowired
	private VoiceLocationService voiceLocationService;
	
	
	@RequestMapping("location")
	@ResponseBody
	public String location(HttpServletRequest request){
		Map<String,String> map = showParams(request);
		Voice v = getVoiceArr(map.get("voice"));
		VoiceLocation vl = parseJson(map.get("location"));
		v.setLocationId(vl.getId());
		voiceService.save(v);
		voiceLocationService.save(vl);
		
		return "ok";
	}
	
	@RequestMapping("getVoiceLocationInfo")
	@ResponseBody
	public Map<String,Object> getVoiceLocationInfo(VoiceQueryVo vo){
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("result", "success");
		result.put("data", voiceService.getLocationAndVoice(vo));
		return result;
	}
	
	
	public static void main(String[] args) {
		//getVoiceArr("");
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

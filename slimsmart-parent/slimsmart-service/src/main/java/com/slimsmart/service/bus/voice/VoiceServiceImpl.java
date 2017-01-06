package com.slimsmart.service.bus.voice;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.slimsmart.api.bus.voice.VoiceService;
import com.slimsmart.common.model.VoiceQueryVo;
import com.slimsmart.common.service.AbstractBaseService;
import com.slimsmart.common.util.date.DateUtil;
import com.slimsmart.common.util.string.StringUtil;
import com.slimsmart.dao.usercenter.VoiceDao;
import com.slimsmart.model.bus.voice.Voice;

@Service
public class VoiceServiceImpl extends AbstractBaseService<Voice> implements VoiceService {

	@Autowired
	private VoiceDao voiceDao;
	@Override
	public Map<String, Object> getLocationAndVoice(VoiceQueryVo vo) {
		
		List<Map<String,Object>> taskList = voiceDao.getSingleTaskDay(vo);
		Map<String, Object> map = new HashMap<String,Object>();
		if(vo.getPage() != 0){
			if(vo.getRows() == 0){
				vo.setRows(20);
			}
			vo.setStart((vo.getPage()-1)*vo.getRows());
		}
		List<Map<String,Object>> voiceList = voiceDao.getLocationAndVoice(vo);
		if(CollectionUtils.isEmpty(taskList)){
			map.put("data", voiceList);
		}else{
			taskList.addAll(voiceList);
			map.put("data", taskList);
		}
		
		map.put("total", voiceDao.getLocationAndVoiceTotal(vo));
		return map;
	}
	
	
	@Override
	public String getLineChartData(String userId,String time) {
		String result = "";
		VoiceQueryVo vo = new VoiceQueryVo();
		vo.setUserId(userId);
		vo.setIsTask(1);
		if(StringUtil.isEmpty(time)){
			vo.setCreateDateStr(DateUtil.formatDateToString(new Date()));
		}else{
			vo.setCreateDateStr(time);
		}
		
		List<Voice> list = voiceDao.getLineChartData(vo);
		DecimalFormat df = new DecimalFormat("######0");	
		for (int i = 0; i < 24; i++) {
			int sum = 0;
			int num = 0;
			for(int k = 0; k < list.size(); k++){
				Voice voice = list.get(k);
				int hour = getHours(voice.getCreateDate());
				if(hour == i){
					sum += voice.getVoiceDb();
					list.remove(k);
					num ++;
				}
			}
			if(num == 0){
				result += "0,";
			}else{
				result += (df.format(sum/num))+",";
			}
			
		}
		return result;
	}

	
	private int getHours(Date d){
		String date = DateUtil.formatToSimpleDate(d);
		String hours = date.substring(11,13); 
		if(hours.indexOf("0")==0 && !hours.equals("00")){
			hours = hours.replace("0", "");
		}else if(hours.equals("00")){
			hours = "0";
		}
		int hour = Integer.parseInt(hours);
		return hour;
	}


	@Override
	public void releaseVoice(String id) {
		voiceDao.releaseVoice(id);
	}


	@Override
	public void deleteVoice(String id) {
		voiceDao.deleteLocation(id);
		voiceDao.deleteVoice(id);
	}
	

}

package com.slimsmart.dao.usercenter;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.slimsmart.common.dao.MyBatisDao;
import com.slimsmart.common.model.VoiceQueryVo;
import com.slimsmart.model.bus.voice.Voice;
@Repository
public class VoiceDao extends MyBatisDao<Voice> {

	public List<Map<String,Object>> getLocationAndVoice(VoiceQueryVo vo){
		
		return findList("selectVoiceAndLocation", vo);
	}
	
	public long getLocationAndVoiceTotal(VoiceQueryVo vo){
		return count("selectVoiceAndLocationTotal", vo);
	}
	
	public List<Voice> getLineChartData(VoiceQueryVo vo){
		
		return findList("selectLineChartData", vo);
	}
	
	public void releaseVoice(String id){
		Voice v = new Voice();
		v.setIsRelease(1);
		v.setId(id);
		update("releaseVoice", v);
	}
	
	public List<Map<String,Object>> getSingleTaskDay(VoiceQueryVo vo){
		return findList("singleTaskDay", vo);
	}
	
	public void deleteVoice(String id){
		update("deleteVoice", id);
	}
	public void deleteLocation(String id){
		update("deleteLocation", id);
	}
}

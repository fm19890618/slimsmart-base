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
}

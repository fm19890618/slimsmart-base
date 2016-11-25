package com.slimsmart.service.bus.voice;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slimsmart.api.bus.voice.VoiceService;
import com.slimsmart.common.model.VoiceQueryVo;
import com.slimsmart.common.service.AbstractBaseService;
import com.slimsmart.dao.usercenter.VoiceDao;
import com.slimsmart.model.bus.voice.Voice;

@Service
public class VoiceServiceImpl extends AbstractBaseService<Voice> implements VoiceService {

	@Autowired
	private VoiceDao voiceDao;
	@Override
	public List<Map<String, Object>> getLocationAndVoice(VoiceQueryVo vo) {
		if(vo.getPage() != 0){
			if(vo.getRows() == 0){
				vo.setRows(15);
			}
			vo.setStart((vo.getPage()-1)*vo.getRows());
		}
		return voiceDao.getLocationAndVoice(vo);
	}

	

}

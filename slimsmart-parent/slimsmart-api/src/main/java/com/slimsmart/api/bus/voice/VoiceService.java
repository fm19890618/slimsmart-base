package com.slimsmart.api.bus.voice;

import java.util.List;
import java.util.Map;

import com.slimsmart.common.model.VoiceQueryVo;
import com.slimsmart.common.service.BaseService;
import com.slimsmart.model.bus.voice.Voice;

public interface VoiceService extends BaseService<Voice> {
	public Map<String,Object> getLocationAndVoice(VoiceQueryVo vo);
}

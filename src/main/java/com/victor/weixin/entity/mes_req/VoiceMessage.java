package com.victor.weixin.entity.mes_req;

/**
 * Created by Aaron on 2017/12/22.
 * 音频消息
 */
public class VoiceMessage extends BaseMessage4Req{

	// 媒体ID
	private String MediaId;
	// 语音格式
	private String Format;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}
}

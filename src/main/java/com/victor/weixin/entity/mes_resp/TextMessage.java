package com.victor.weixin.entity.mes_resp;

import com.victor.weixin.entity.mes_req.BaseMessage4Req;

/**
 * Created by Aaron on 2017/12/22.
 * 文本消息
 */
public class TextMessage extends BaseMessage4Req{

	// 回复的消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}

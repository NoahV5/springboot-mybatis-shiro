package com.victor.weixin.entity.mes_req;

/**
 * Created by Aaron on 2017/12/22.
 * 图片消息
 */
public class ImageMessage extends BaseMessage4Req{

	// 图片链接
	private String PicUrl;

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

}

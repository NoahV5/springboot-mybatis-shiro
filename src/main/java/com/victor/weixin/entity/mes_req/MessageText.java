package com.victor.weixin.entity.mes_req;

/**
 * Created by Aaron on 2017/12/22.
 * 消息内容主体
 */
public class MessageText extends BaseMessage4Req{

	private String Content;//文本消息内容

	private String MsgId;//消息id，64位整型

	public MessageText(){

	}


	public MessageText(String toUserName, String fromUserName,
			long createTime, String msgType, String content, String msgId) {
		super();
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
		MsgType = msgType;
		Content = content;
		MsgId = msgId;
	}


	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getMsgId() {
		return MsgId;
	}

	public void setMsgId(String msgId) {
		MsgId = msgId;
	}

}

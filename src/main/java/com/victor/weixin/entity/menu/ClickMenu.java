package com.victor.weixin.entity.menu;

/**
 * 点击事件
 * 
 * @author Victor
 * 
 */
public class ClickMenu extends BasicMenu {
	private String key;
	private String type=Menu.CLICK;

	public String getKey() {
		return key;
	}

	public void setKey(String key){
		this.key = key;
	}
	public String getType() {
		return type;
	}
}

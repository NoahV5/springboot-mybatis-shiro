package com.victor.weixin.entity.menu;

/**
 * 扫码推事件
 * 
 * @author Victor
 * 
 */
public class ScanPush extends BasicMenu {
	private String key;
	private String sub_button[] = new String[]{};
	private String type =Menu.SCANCODE_PUSH;

	public String getType() {
		return type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String[] getSub_button() {
		return sub_button;
	}
}

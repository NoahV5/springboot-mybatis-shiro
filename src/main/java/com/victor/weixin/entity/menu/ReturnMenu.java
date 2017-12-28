package com.victor.weixin.entity.menu;


/**
 * 返回菜单
 * @author Victor
 *
 */
public class ReturnMenu extends BasicMenu{
	private MenuAllInfo[] sub_button;

	public MenuAllInfo[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(MenuAllInfo[] subButton) {
		sub_button = subButton;
	}
	
}

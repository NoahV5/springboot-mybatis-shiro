package com.victor.weixin.menu.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.victor.common.result.JsonResult;
import com.victor.weixin.entity.menu.Menu;
import com.victor.weixin.entity.menu.ReturnMenu;
import com.victor.weixin.utils.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 菜单连接类
 * 
 * @author Victor
 * 
 */
public class MenuConnection extends Connection {

	private static Logger logger = LoggerFactory.getLogger(MenuConnection.class);
	// 创建菜单
	private static String menu_create = "https://api.weixin.qq.com/cgi-bin/menu/create";
	// 查询自定义菜单
	private static String menu_get = "https://api.weixin.qq.com/cgi-bin/menu/get";
	// 删除自定义菜单
	private static String menu_delte = "https://api.weixin.qq.com/cgi-bin/menu/delete";

	/**
	 * 创建的菜单
	 * 
	 * @param menu
	 *            菜单项
	 * @param token
	 *            授权token
	 * @return {"errcode":0,"errmsg":"ok"}
	 */
	public static JsonResult createMenu(Menu menu, String token) {
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("access_token", token);
		String jsonData = JSONObject.toJSON(menu).toString();
		String result = HttpsDefaultExecute("POST", menu_create, map, jsonData);
		logger.info(result);
		return ConvertResult(result);
	}

	/**
	 * 第二种方式创建菜单
	 * 
	 * @param menu
	 *            菜单项
	 * @param token
	 *            授权token
	 * @return {"errcode":0,"errmsg":"ok"}
	 */
	public static JsonResult createTwoMenu(Menu menu, String token) {
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("access_token", token);
		String jsonData = JSONObject.toJSON(menu).toString();
		String result = HttpsDefaultExecute("POST", menu_create, map, jsonData);
		return ConvertResult(result);
	}

	/**
	 * 获取自定义菜单(此处待改进)
	 * 
	 * @param token
	 * @return
	 */
	public static String getMenu(String token) {
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("access_token", token);
		String result = HttpsDefaultExecute("GET", menu_get, map, "");
		return result;
	}

	/**
	 * 将json格式的字符串转换为Menu对象
	 * 
	 * @param jsonReuslt
	 * @return
	 */
	public static List<ReturnMenu> converMenu(String jsonReuslt) {
		List<ReturnMenu> list = new ArrayList<ReturnMenu>();
		if (jsonReuslt != null && !"".equals(jsonReuslt)) {
			JSONObject object = JSONObject.parseObject(jsonReuslt);
			JSONArray array = object.getJSONObject("menu").getJSONArray("button");
			for (int i = 0; i < array.size(); i++) {
				ReturnMenu group = new ReturnMenu();
				group = array.getObject(i, ReturnMenu.class);
				list.add(group);
			}
		}
		return list;
	}

	/**
	 * 删除自定义菜单
	 * 
	 * @param token
	 * @return
	 */
	public static boolean deleteMenu(String token) {
		boolean fig = true;
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("access_token", token);
		String result = HttpsDefaultExecute("GET", menu_delte, map, "");
		JSONObject object = JSONObject.parseObject(result);
		if (object.getInteger("errcode") != 0|| object.getString("errmsg") != "ok") { // 删除失败
			fig = false;
		}
		return fig;
	}
}

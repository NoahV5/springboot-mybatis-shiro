package com.victor.weixin.test;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.victor.common.controller.BaseController;
import com.victor.common.result.JsonResult;
import com.victor.sys.service.IAccessTokenService;
import com.victor.weixin.entity.results.AccessToken;
import com.victor.weixin.menu.test.TestMenuConnection;
import com.victor.weixin.utils.Connection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author Victor
 * @date 2017/12/28
 */
@Controller
@RequestMapping("/wx")
public class WxDemoTest extends BaseController{

    private static String appID = "wx2db12e2ea6075665";
    private static String appsecret = "07368fd72c8a8144232c7eb474471adb";

    @Resource
    private IAccessTokenService accessTokenService;


    @RequestMapping("/token")
    public void getToken(){
        String datas = Connection.getAccessToken(appID, appsecret);
        JSONObject result = JSONObject.parseObject(datas);
        AccessToken accessToken =new AccessToken();
        accessToken.setAccessToken(result.getString("access_token"));
        accessToken.setExpiresIn(result.getString("expires_in"));
        accessToken.setId(1L);
        EntityWrapper<AccessToken> ew = new EntityWrapper<>();
        ew.where("id = {0} ",1L);
        if(null != accessTokenService.selectOne(ew)){
            accessTokenService.updateAllColumnById(accessToken);
        }else {
            accessTokenService.updateAllColumnById(accessToken);
        }
    }

    @RequestMapping("/savemenu")
    @ResponseBody
    public JsonResult saveMenu(){

        AccessToken accessToken = new AccessToken();
        EntityWrapper<AccessToken> ew  = new EntityWrapper<>();
        JsonResult jsonResult = new JsonResult();
        ew.where("id = {0}" ,1L);
        accessToken = accessTokenService.selectOne(ew);
        if(null != accessToken){
            TestMenuConnection.testCustomMenu(accessToken.getAccessToken());
            return renderError("自定义菜单success");
        }
        return renderError("自定义菜单fail");
    }
}

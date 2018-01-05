package com.victor.redis2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Victor
 * @date 2018/01/05
 */
@Controller
@RequestMapping("/wx")
public class TestDemo {

    @Autowired
    TestRoleService testRoleService;

    @RequestMapping("1")
    public void test() throws Exception{

        for(int i  =1;i<100;i++){
            testRoleService.addAsync();
        }

    }

    @RequestMapping("2")
    public void test2() throws Exception{

        for(int i  =1;i<100;i++){
            testRoleService.addNoAsync();
        }

    }

}


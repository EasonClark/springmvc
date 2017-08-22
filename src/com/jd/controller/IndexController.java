package com.jd.controller;

import com.jd.beans.ResultData;
import com.jd.beans.UserInfo;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * test index controller
 *
 * @author hasee
 * 2017-08-17
 */

@Controller
@RequestMapping(value = "/")
public class IndexController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = "/login.do",method = RequestMethod.POST,headers = "Accept=application/json")
    @ResponseBody
    public ResultData loginController(@RequestBody UserInfo userInfo){
        logger.debug("step into method IndexController");

        String userName = userInfo.getUserName();
        String password = userInfo.getPassword();
        ResultData rd = new ResultData();
        if (userName != null && password != null) {
            if("abc".equals(userName) && "123".equals(password)){
                rd.setStatus("1");
                rd.setMessage("login successfully");
            }else{
                rd.setStatus("2");
                rd.setMessage("userName or password is wrong,please confirm");
            }
        }

        logger.debug("step out method IndexController");
        logger.info("execute method over");
        return rd;
    }

}

package com.jd.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import java.util.Date;

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
    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/index")
    public ModelAndView IndexController(){
        logger.debug("step into method IndexController");

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        ModelAndView mav = new ModelAndView();
        mav.addObject("msg","Hello World");
        mav.getModelMap().put("time",new Date());

        if (name != null && password != null) {
            if("abc".equals(name) && "123".equals(password)){
                mav.addObject("flag","true");
            }else{
                mav.addObject("flag","false");
            }
        }

        logger.debug("step out method IndexController");
        logger.info("execute method over");
        return mav;
    }

}

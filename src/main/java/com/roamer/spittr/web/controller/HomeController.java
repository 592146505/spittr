package com.roamer.spittr.web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 首页控制器
 *
 * @author roamer
 * @version V1.0
 * @date 2018/1/10
 */
@Controller
public class HomeController {

    private static Logger logger = LogManager.getLogger(HomeController.class);

    @RequestMapping(value = "homePage", method = RequestMethod.GET)
    public String home() {
        logger.debug("Go To home Page");
        return "home";
    }
}

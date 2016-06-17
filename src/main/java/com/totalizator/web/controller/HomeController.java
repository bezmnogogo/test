package com.totalizator.web.controller;

import com.totalizator.services.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by home on 12.06.16.
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {

    @Autowired
    IDataService dataService;

    @RequestMapping(value = "*", method = RequestMethod.GET)
    public String home(HttpServletRequest request) {
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index(){
        return "home";
    }
}

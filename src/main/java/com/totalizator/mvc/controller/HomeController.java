package com.totalizator.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by home on 12.06.16.
 */
@Controller
@RequestMapping(value = "/home")
public class HomeController {
    @RequestMapping(value = "/test")
    public String home(ModelMap model){

        model.addAttribute("message", "hello");

        return "test";
    }

    @RequestMapping(value = "/test1")
    public String test1(@RequestParam("message") String message, ModelMap model){

        model.addAttribute("message", message);

        return "test1";
    }
}

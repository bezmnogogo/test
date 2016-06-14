package com.totalizator.mvc.controller;

import com.totalizator.mvc.viewmodels.SendViewModel;
import com.totalizator.mvc.viewmodels.TestViewModel;
import com.totalizator.services.DataService;
import com.totalizator.services.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by home on 12.06.16.
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {

    @Autowired
    IDataService dataService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index(){
        return "home";
    }
}

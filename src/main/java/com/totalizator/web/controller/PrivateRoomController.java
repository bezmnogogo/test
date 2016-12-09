package com.totalizator.web.controller;

import com.totalizator.dao.entities.User;
import com.totalizator.services.IBetsService;
import com.totalizator.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Andrei Savchuk.
 */
@Controller
@RequestMapping(value = "/privateRoom")
public class PrivateRoomController {

    private final IUserService userService;
    private final IBetsService betsService;

    @Autowired
    public PrivateRoomController(IUserService userService, IBetsService betsService) {
        this.userService = userService;
        this.betsService = betsService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String room(@AuthenticationPrincipal User curUser, ModelMap model){
        if(curUser == null) return "error";
        model.addAttribute("betList",betsService.getBetsByUserId(curUser.getId()));
        model.addAttribute("login", curUser.getUsername());
        model.addAttribute("amount", curUser.getCash());
        model.addAttribute("purse", curUser.getWebPurse());
        return "Privateroom";
    }
}

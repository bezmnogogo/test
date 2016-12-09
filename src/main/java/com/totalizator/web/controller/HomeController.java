package com.totalizator.web.controller;

import com.totalizator.dao.entities.User;
import com.totalizator.services.IDataService;
import com.totalizator.services.IUserService;
import com.totalizator.web.modules.MapperModule;
import com.totalizator.web.modules.interfaces.IMapperModule;
import com.totalizator.web.viewmodels.UserViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by home
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {

    @Autowired
    public HomeController(IDataService dataService, IUserService userService){
        this.dataService = dataService;
        this.userService = userService;
    }

    private final IUserService userService;
    private final IDataService dataService;


    @RequestMapping(value = "*", method = RequestMethod.GET)
    public String home(HttpServletRequest request, @AuthenticationPrincipal User user, ModelMap model) {
        if(user != null){
            model.addAttribute("login", "(" + user.getUsername() + ")");
            model.addAttribute("status","Выйти");
            return "homePage";
        }
        else{
            model.addAttribute("status","Войти");
        }
        return "homePage";  //"redirect:/";
    }

    /*@RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(@AuthenticationPrincipal User user) {
        if (user == null)
            return "redirect:/homePage";
            return "homePage";
    }*/

    /**
     * Страница логина
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", params = {"auth=fail"}, method = RequestMethod.GET)
    public String login(ModelMap model) {
        model.put("loginFailed", true);
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(){
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(HttpServletRequest request, ModelMap model){
        User user = new User();
        user.setMail(request.getParameter("mail"));
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setWebPurse(request.getParameter("webPurse"));
        user.setEnabled(true);
        if(userService.checkIfMailExists(user.getMail())){
            String message = "this mail is already exist. Please fix it";
            model.addAttribute("message", message);
            return "/registration";
        }
        userService.setUserRole(user);
        User usr = userService.saveUser(user);

        return "login";
    }

    /*@RequestMapping(value = "/registration", method = RequestMethod.POST)
    @ResponseBody
    public String registration(@RequestBody @Valid UserViewModel userViewModel, BindingResult bindingResult) throws Exception{
        if (bindingResult.hasErrors()) {
            throw new Exception("error binding model");
        }
        //String mail = request.getParameter("mail");
        User user = mapperModule.map(userViewModel, User.class);
        String mail = user.getMail();
        return "login";
    }*/


    /**
     * Страница ошибки 403
     *
     * @return
     */
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView error403() {
        ModelAndView model = new ModelAndView("error");
        model.addObject("error", "У вас недостаточно прав для выполнения данного действия.");
        return model;
    }
}

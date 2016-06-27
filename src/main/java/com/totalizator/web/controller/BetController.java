package com.totalizator.web.controller;

import com.totalizator.dao.entities.Bet;
import com.totalizator.dao.entities.Match;
import com.totalizator.dao.entities.Role;
import com.totalizator.dao.entities.User;
import com.totalizator.dao.repository.IMatchRepository;
import com.totalizator.services.IBetsService;
import com.totalizator.services.IMatchService;
import com.totalizator.services.ISetCoefficientService;
import com.totalizator.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

/**
 * Created by Andrei Savchuk.
 */
@Controller
@RequestMapping(value = "/bet")
public class BetController {

    private final IBetsService betsService;
    private final IMatchService matchService;
    private final ISetCoefficientService setCoefficientService;
    private final IUserService userService;

    @Autowired
    public BetController(IBetsService betsService, IMatchRepository matchRepository, IMatchService matchService, ISetCoefficientService setCoefficientService, IUserService userService){
        this.betsService = betsService;
        this.matchService = matchService;
        this.setCoefficientService = setCoefficientService;
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/bet")
    public String bets(@AuthenticationPrincipal User user, ModelMap model,HttpServletRequest request){
        model.addAttribute("matchList", matchService.getMatchesByStatus(false));
        String s = request.getParameter("id");
        Set<Role> roles = user.getRoles();
        for (Role role: roles) {
            if(role.getType().toString() == "admin")
                return "AdminBetPage";
        }
        return "BetPage";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/getId")
    public String bet(@AuthenticationPrincipal User user, ModelMap model, HttpServletRequest request){
        //String id = request.getParameter("id");
        //id = request.getParameter("betChoise");
        HashSet<Bet> bets = new HashSet<Bet>();
        Bet bet = new Bet();
        bet.setMatch(matchService.findMatchById(Long.parseLong(request.getParameter("id"))));
        bet.setAmount(Float.parseFloat(request.getParameter("amount")));
        bet.setGoal(Long.parseLong(request.getParameter("betChoise")));
        bet.setUser(user);
        bet.setDate(Date.valueOf(LocalDate.now()));
        switch (bet.getGoal()){
            case 0:bet.setWinCoefficient(bet.getMatch().getHomeClubWinCoefficient());break;
            case 1:bet.setWinCoefficient(bet.getMatch().getDrawCoeffficient()); break;
            case 2:bet.setWinCoefficient(bet.getMatch().getGuestClubWinCoefficient());break;
        }
        if(bet.getAmount() > user.getCash()){
            model.addAttribute("noCash", "Sorry, you don't have enough money");
            model.addAttribute("matchList", matchService.findAll());
            return "BetPage";
        }
        bets.add(bet);
        user.setCash(user.getCash() - ((bet.getAmount()*99)/100));
        user.setBets(bets);
        User admin = userService.findUserByUsername("sa");
        admin.addCash(bet.getAmount()/100);
        User usr = userService.saveUser(admin);
        Match match = bet.getMatch();
        match.setBets(bets);
        //matchService.saveMatch(match);
        //betsService.makeBet(bet);
        match = setCoefficientService.setCoefficients(bet.getMatch());
        //matchService.saveMatch(match);
        usr = userService.saveUser(user);
        model.addAttribute("matchList", matchService.getMatchesByStatus(false));
        return "BetPage";
    }

    @RequestMapping(value = "/endMatch", method = RequestMethod.POST)
    public String endMatch(HttpServletRequest request, ModelMap model){
        Match match = matchService.findMatchById(Long.parseLong(request.getParameter("id")));
        Random random = new Random(System.currentTimeMillis());
        match.setGuestGoals(random.nextInt(5));
        match.setHomeGoals(random.nextInt(5));
        if(match.getGuestGoals() > match.getHomeGoals())
            match.setResult(2);
        if (match.getGuestGoals() < match.getHomeGoals())
            match.setResult(0);
        if(match.getGuestGoals() == match.getHomeGoals())
            match.setResult(1);
        match.setFinished(true);
        List<Bet> bets = betsService.getBetsByMatchId(match.getId());
        for (Bet bet: bets) {
            if(bet.getGoal() == match.getResult())
                bet.setWinAmount(bet.getWinCoefficient()*bet.getAmount());
            else bet.setWinAmount(0);
            betsService.makeBet(bet);
        }
        Match match1 = matchService.saveMatch(match);
        model.addAttribute(matchService.getMatchesByStatus(false));
        return "AdminBetPage";
    }

    @RequestMapping(value = "/results", method = RequestMethod.GET)
    public String results(@AuthenticationPrincipal User user, ModelMap model){
        List<Bet> usrBets = betsService.getBetsByUserId(user.getId());
        List<Bet> bets = new ArrayList<Bet>();
        for (Bet bet: usrBets) {
            if(bet.getMatch().isFinished())
                bets.add(bet);
        }
        model.addAttribute("betList", bets);
        return "result";
    }
}

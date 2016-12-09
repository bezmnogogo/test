package com.totalizator.web.controller;

import com.totalizator.dao.entities.Match;
import com.totalizator.services.IBetsService;
import com.totalizator.services.IClubService;
import com.totalizator.services.IMatchService;
import com.totalizator.services.ITournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

/**
 * Created by Andrei Savchuk.
 */
@Controller
@RequestMapping(value = "/match")
public class MatchesController {

    private final IMatchService matchService;
    private final IBetsService betsService;
    private final ITournamentService tournamentService;
    private final IClubService clubService;

    @Autowired
    public MatchesController(IMatchService matchService, IBetsService betsService, ITournamentService tournamentService, IClubService clubService) {
        this.matchService = matchService;
        this.betsService = betsService;
        this.tournamentService = tournamentService;
        this.clubService = clubService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String match(){
        return "matches";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addMatch(HttpServletRequest request, ModelMap model){
        Match match = new Match();
        match.setDate(Date.valueOf(request.getParameter("date")));
        match.setTournament(tournamentService.getTournamentById(1));
        match.setHomeClub(clubService.getClubByName(request.getParameter("homeClub")));
        match.setGuestClub(clubService.getClubByName(request.getParameter("guestClub")));
        Match match1 = matchService.saveMatch(match);
        model.addAttribute("message","Матч успешно добавлен! Добавь еще!");
        return "matches";
    }
}

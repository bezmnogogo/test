package com.totalizator.services;

import com.totalizator.dao.entities.Bet;

import java.util.List;

/**
 * Created by Andrei Savchuk.
 */
public interface IBetsService {

    List<Bet> getAllBets();

    Bet getBetById(long id);

    Bet makeBet(Bet bet);

    List<Bet> getBetsByUserId(long id);

    List<Bet> getFinishedBets();

    public List<Bet> getBetsByMatchId(long id);
}

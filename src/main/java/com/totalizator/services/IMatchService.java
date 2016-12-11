package com.totalizator.services;

import com.totalizator.dao.entities.Match;

import java.util.List;

/**
 * Created by Andrei Savchuk.
 */
public interface IMatchService {

    List<Match> findAll();

    Match findMatchById(long id);

    Match saveMatch(Match match);

    List<Match> getMatchesByStatus(boolean finished);

    void updateMatch(long id, long homeGoal, long guestGoal, boolean finish, long result1);
}

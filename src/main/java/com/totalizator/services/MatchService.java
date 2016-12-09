package com.totalizator.services;

import com.totalizator.dao.entities.Match;
import com.totalizator.dao.repository.IMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Andrei Savchuk.
 */
@Service
@Transactional
public class MatchService implements IMatchService {

    private final IMatchRepository matchRepository;

    @Autowired
    public MatchService(IMatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }


    @Override
    public List<Match> findAll() {
        return matchRepository.findAll();
    }

    @Override
    public Match saveMatch(Match match) {
        return matchRepository.saveAndFlush(match);
    }

    @Override
    public Match findMatchById(long id) {
        return matchRepository.findOne(id);
    }

    @Override
    public List<Match> getMatchesByStatus(boolean finished) {
        return matchRepository.getMatchesByStatus(finished);
    }
}

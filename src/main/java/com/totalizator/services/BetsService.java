package com.totalizator.services;

import com.totalizator.dao.entities.Bet;
import com.totalizator.dao.repository.IBetRepository;
import com.totalizator.dao.repository.IMatchRepository;
import com.totalizator.dao.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Andrei Savchuk.
 */
@Service
@Transactional
public class BetsService implements IBetsService {

    private final IBetRepository betRepository;
    private final IMatchRepository matchRepository;
    private final IUserRepository userRepository;

    @Autowired
    public BetsService(IBetRepository betRepository, IMatchRepository matchRepository, IUserRepository userRepository) {
        this.betRepository = betRepository;
        this.matchRepository = matchRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public List<Bet> getAllBets() {
        return betRepository.findAll();
    }

    @Override
    @Transactional
    public Bet getBetById(long id) {
        return betRepository.findOne(id);
    }

    @Transactional
    @Override
    public List<Bet> getBetsByUserId(long id) {
        return betRepository.getBetsByUserId(id);
    }

    @Override
    @Transactional
    public Bet makeBet(Bet bet) {
        return betRepository.saveAndFlush(bet);
    }

    @Override
    @Transactional
    public List<Bet> getFinishedBets() {
        return betRepository.getFinishedBets();
    }
}

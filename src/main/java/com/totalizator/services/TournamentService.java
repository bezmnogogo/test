package com.totalizator.services;

import com.totalizator.dao.entities.Tournament;
import com.totalizator.dao.repository.ITournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Andrei Savchuk.
 */
@Service
@Transactional
public class TournamentService implements ITournamentService {

    private final ITournamentRepository tournamentRepository;

    @Autowired
    public TournamentService(ITournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    @Override
    public Tournament getTournamentById(long id) {
        return tournamentRepository.findOne(id);
    }
}

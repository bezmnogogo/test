package com.totalizator.services;

import com.totalizator.dao.entities.Tournament;

/**
 * Created by Andrei Savchuk.
 */
public interface ITournamentService {
    Tournament getTournamentById(long id);
}

package com.totalizator.services;

import com.totalizator.dao.entities.Club;
import com.totalizator.dao.repository.IClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Andrei Savchuk.
 */
@Service
@Transactional
public class ClubService implements IClubService{

    private final IClubRepository clubRepository;

    @Autowired
    public ClubService(IClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public Club getClubByName(String name) {
        return clubRepository.getClubByName(name);
    }
}

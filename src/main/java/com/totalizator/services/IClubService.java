package com.totalizator.services;

import com.totalizator.dao.entities.Club;

/**
 * Created by Andrei Savchuk.
 */
public interface IClubService {
    Club getClubByName(String name);
}

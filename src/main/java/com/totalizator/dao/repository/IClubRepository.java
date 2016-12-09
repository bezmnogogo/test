package com.totalizator.dao.repository;

import com.totalizator.dao.entities.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by home
 */
public interface IClubRepository extends JpaRepository<Club,Long> {
    @Query("SELECT DISTINCT u FROM Club u WHERE u.name = :clubname")
    Club getClubByName(@Param("clubname") String clubname);
}

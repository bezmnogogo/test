package com.totalizator.dao.repository;

import com.totalizator.dao.entities.Club;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IClubRepository extends JpaRepository<Club,Long> {
}

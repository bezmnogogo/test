package com.totalizator.dao.repository;

import com.totalizator.dao.entities.Bet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Andrei Savchuk.
 */
public interface IBetRepository extends JpaRepository<Bet, Long> {
    @Query("SELECT DISTINCT b FROM Bet b where b.user.id = :id")
    List<Bet> getBetsByUserId(@Param("id") long id);

    @Query("SELECT DISTINCT b FROM Bet b where b.match.id = :id")
    List<Bet> getBetsByMatchId(@Param("id") long id);

    @Query("SELECT DISTINCT b FROM Bet b where b.match.finished = TRUE")
    List<Bet> getFinishedBets();
}

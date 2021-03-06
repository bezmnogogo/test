package com.totalizator.dao.repository;

import com.totalizator.dao.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Andrei Savchuk.
 */
public interface IMatchRepository extends JpaRepository<Match, Long> {
    @Query("SELECT DISTINCT m FROM Match m where m.finished = :finished")
    List<Match> getMatchesByStatus(@Param("finished") boolean finished);

    @Procedure(name = "Match.updateMatch")
    void updateMatch(@Param("matchId") Long matchId, @Param("homeGoal") Long homeGoal, @Param("guestGoal") Long guestGoal, @Param("finish") Boolean finish, @Param("result1") Long result1);
}

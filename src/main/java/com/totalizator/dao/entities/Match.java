package com.totalizator.dao.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 * Created by Andrei Savchuk.
 */
@Entity
@Table(name = "match")
public class Match extends GenericEntity {

    @Column(name = "homeClubWinCoefficient", nullable = false)
    private float homeClubWinCoefficient;

    @Column(name = "guestClubWinCoefficient", nullable = false)
    private float guestClubWinCoefficient;

    @Column(name = "drawCoeffficient", nullable = false)
    private float drawCoeffficient;

    public Set<Bet> getBets() {
        return bets;
    }

    public void setBets(Set<Bet> bets) {
        this.bets = bets;
    }

    @Override
    public String toString() {
        return homeClub.getName() + " " +guestClub.getName();
    }

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "popularity", nullable = false)
    private long popularity;

    @Column(name = "finished", nullable = false)
    private boolean finished;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "homeClub")
    private Club homeClub;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "guestClub")
    private Club guestClub;

    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
    private Set<Bet> bets;

    @Column(name = "homeGoals", nullable = true)
    private long homeGoals = 0;

    public long getGuestGoals() {
        return guestGoals;
    }

    public void setGuestGoals(long guestGoals) {
        this.guestGoals = guestGoals;
    }

    public long getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(long homeGoals) {
        this.homeGoals = homeGoals;
    }

    @Column(name = "guestGoals", nullable = true)
    private long guestGoals = 0;

    public long getResult() {
        return result;
    }

    public void setResult(long result) {
        this.result = result;
    }

    @Column(name = "result", nullable = false)
    private long result;

    public Club getTournament() {
        return tournament;
    }

    public void setTournament(Club tournament) {
        this.tournament = tournament;
    }

    public long getPopularity() {
        return popularity;
    }

    public void setPopularity(long popularity) {
        this.popularity = popularity;
    }

    public float getHomeClubWinCoefficient() {
        return homeClubWinCoefficient;
    }

    public void setHomeClubWinCoefficient(float homeClubWinCoefficient) {
        this.homeClubWinCoefficient = homeClubWinCoefficient;
    }

    public Club getHomeClub() {
        return homeClub;
    }

    public void setHomeClub(Club homeClub) {
        this.homeClub = homeClub;
    }

    public float getGuestClubWinCoefficient() {
        return guestClubWinCoefficient;
    }

    public void setGuestClubWinCoefficient(float guestClubWinCoefficient) {
        this.guestClubWinCoefficient = guestClubWinCoefficient;
    }

    public Club getGuestClub() {
        return guestClub;
    }

    public void setGuestClub(Club guestClub) {
        this.guestClub = guestClub;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public float getDrawCoeffficient() {
        return drawCoeffficient;
    }

    public void setDrawCoeffficient(float drawCoeffficient) {
        this.drawCoeffficient = drawCoeffficient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tournament")
    private Club tournament;

    public String getStatus(){
        if(this.finished == true) return "Окончен";
        else return "Не окончен";
    }
}

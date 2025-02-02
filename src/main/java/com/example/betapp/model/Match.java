package com.example.betapp.model;

import com.example.betapp.enums.SportEnum;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.Set;

@Entity
@Table(name = "match")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "team_a", nullable = false)
    private String teamA;

    @Column(name = "team_b", nullable = false)
    private String teamB;

    @Column(name = "match_date", nullable = false)
    private Date matchDate;

    @Column(name = "match_time", nullable = false)
    private Time matchTime;

    @Column(name = "sport", nullable = false)
    private SportEnum sport;

    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MatchOdds> odds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public Time getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(Time matchTime) {
        this.matchTime = matchTime;
    }

    public SportEnum getSport() {
        return sport;
    }

    public void setSport(SportEnum sport) {
        this.sport = sport;
    }

    public Set<MatchOdds> getOdds() {
        return odds;
    }

    public void setOdds(Set<MatchOdds> odds) {
        this.odds = odds;
    }
}

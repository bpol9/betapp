package com.example.betapp.dto;

import java.util.List;

public class MatchDto {
    private String description;
    private String teamA;
    private String teamB;
    private String matchDate;
    private String matchTime;
    private String sport;
    List<MatchOddsDto> odds;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public String getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public List<MatchOddsDto> getOdds() {
        return odds;
    }

    public void setOdds(List<MatchOddsDto> odds) {
        this.odds = odds;
    }

    @Override
    public String toString() {
        return "NewMatchDto{" +
                "description='" + description + '\'' +
                ", teamA='" + teamA + '\'' +
                ", teamB='" + teamB + '\'' +
                ", matchDate='" + matchDate + '\'' +
                ", matchTime='" + matchTime + '\'' +
                ", sport='" + sport + '\'' +
                ", odds=" + odds +
                '}';
    }
}

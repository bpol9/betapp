package com.example.betapp.dto;

import java.math.BigDecimal;

public class OddsDto {
    private Long matchId;
    private String specifier;
    private BigDecimal odds;

    public String getSpecifier() {
        return specifier;
    }

    public void setSpecifier(String specifier) {
        this.specifier = specifier;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public BigDecimal getOdds() {
        return odds;
    }

    public void setOdds(BigDecimal odds) {
        this.odds = odds;
    }

    @Override
    public String toString() {
        return "EditOddsDto{" +
                "matchId=" + matchId +
                ", specifier='" + specifier + '\'' +
                ", odds=" + odds +
                '}';
    }
}

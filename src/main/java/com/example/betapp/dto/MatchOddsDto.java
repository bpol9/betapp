package com.example.betapp.dto;

import java.math.BigDecimal;

public class MatchOddsDto {
    private String specifier;
    private BigDecimal odds;

    public String getSpecifier() {
        return specifier;
    }

    public void setSpecifier(String specifier) {
        this.specifier = specifier;
    }

    public BigDecimal getOdds() {
        return odds;
    }

    public void setOdds(BigDecimal odds) {
        this.odds = odds;
    }

    @Override
    public String toString() {
        return "MatchOddsDto{" +
                "specifier='" + specifier + '\'' +
                ", odds=" + odds +
                '}';
    }
}

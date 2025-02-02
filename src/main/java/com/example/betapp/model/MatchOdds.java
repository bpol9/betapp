package com.example.betapp.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "match_odds")
public class MatchOdds {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "specifier", nullable = false)
    private String specifier;

    @Column(name = "odds", precision = 7, scale = 2)
    private BigDecimal odds;

    @ManyToOne
    @JoinColumn(name = "match_id_fk", nullable = false)
    private Match match;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
}

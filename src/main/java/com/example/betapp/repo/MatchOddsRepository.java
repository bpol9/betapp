package com.example.betapp.repo;

import com.example.betapp.model.MatchOdds;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MatchOddsRepository extends JpaRepository<MatchOdds, Long> {
}

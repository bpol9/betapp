package com.example.betapp.service;

import com.example.betapp.dto.OddsDto;
import com.example.betapp.dto.EditStartTimeDto;
import com.example.betapp.dto.MatchOddsDto;
import com.example.betapp.dto.MatchDto;
import com.example.betapp.enums.SportEnum;
import com.example.betapp.exception.BadRequestException;
import com.example.betapp.model.Match;
import com.example.betapp.model.MatchOdds;
import com.example.betapp.repo.MatchOddsRepository;
import com.example.betapp.repo.MatchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.*;

@Service
public class MatchService {

    private static final Logger logger = LoggerFactory.getLogger("MatchService");

    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private MatchOddsRepository matchOddsRepository;

    public MatchDto getMatch(Long id) {
        Match match = matchRepository.findById(id).orElse(null);
        return convertMatchToDto(match);
    }

    public MatchDto addMatch(MatchDto matchDto) throws BadRequestException {
        try {
            Match match = new Match();
            match.setTeamA(matchDto.getTeamA());
            match.setTeamB(matchDto.getTeamB());
            match.setDescription(matchDto.getDescription());
            match.setMatchDate(Date.valueOf(matchDto.getMatchDate()));
            match.setMatchTime(convertTime(matchDto.getMatchTime()));
            match.setSport(SportEnum.getByValue(matchDto.getSport()));
            Set<MatchOdds> oddsSet = new HashSet<>();
            for (MatchOddsDto matchOddsDto: matchDto.getOdds()) {
                MatchOdds matchOdds = new MatchOdds();
                matchOdds.setMatch(match);
                matchOdds.setSpecifier(matchOddsDto.getSpecifier());
                matchOdds.setOdds(matchOddsDto.getOdds());
                oddsSet.add(matchOdds);
            }
            match.setOdds(oddsSet);
            matchRepository.save(match);
            return matchDto;
        } catch (IllegalArgumentException e) {
            logger.error("newMatchDto: {}", matchDto, e);
            throw new BadRequestException("Invalid matchDto");
        }
    }

    public MatchDto addMatchOdds(OddsDto oddsDto) throws BadRequestException {
        Match match = matchRepository.findById(oddsDto.getMatchId())
                .orElseThrow(() -> new BadRequestException("Match id " + oddsDto.getMatchId() + " not found"));
        if (getOddsBySpecifier(match, oddsDto.getSpecifier()).isPresent()) {
            throw new BadRequestException("Specifier " + oddsDto.getSpecifier() + " exists");
        }
        MatchOdds matchOdds = new MatchOdds();
        matchOdds.setMatch(match);
        matchOdds.setSpecifier(oddsDto.getSpecifier());
        matchOdds.setOdds(oddsDto.getOdds());
        match.getOdds().add(matchOdds);
        matchRepository.save(match);
        return convertMatchToDto(match);
    }

    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }

    public MatchDto editOdds(OddsDto oddsDto) throws BadRequestException{
        Match match = matchRepository.findById(oddsDto.getMatchId())
                .orElseThrow(() -> new BadRequestException("Match id " + oddsDto.getMatchId() + " not found"));
        MatchOdds odds = getOddsBySpecifier(match, oddsDto.getSpecifier())
                .orElseThrow(() -> new BadRequestException("specifier " + oddsDto.getSpecifier() + " not found"));
        odds.setOdds(oddsDto.getOdds());
        matchOddsRepository.save(odds);
        return convertMatchToDto(match);
    }

    public MatchDto editStartTime(EditStartTimeDto editStartTimeDto) throws BadRequestException {
        Match match = matchRepository.findById(editStartTimeDto.getMatchId())
                .orElseThrow(() -> new BadRequestException("Match id " + editStartTimeDto.getMatchId() + " not found"));
        try {
            match.setMatchTime(convertTime(editStartTimeDto.getTime()));
            match.setMatchDate(Date.valueOf(editStartTimeDto.getDate()));
            matchRepository.save(match);
            return convertMatchToDto(match);
        } catch (IllegalArgumentException e) {
            logger.error("editStartTimeDto: {}", editStartTimeDto, e);
            throw new BadRequestException("Invalid editStartTimeDto");
        }
    }

    private MatchDto convertMatchToDto(Match match) {
        if (match == null) {
            return null;
        }
        MatchDto dto = new MatchDto();
        dto.setDescription(match.getDescription());
        dto.setMatchDate(match.getMatchDate().toString());
        dto.setMatchTime(match.getMatchTime().toString());
        dto.setSport(match.getSport().getValue());
        dto.setTeamA(match.getTeamA());
        dto.setTeamB(match.getTeamB());
        dto.setOdds(
                match.getOdds().stream().map(this::convertOddsToDto).toList()
        );
        return dto;
    }

    private MatchOddsDto convertOddsToDto(MatchOdds matchOdds) {
        MatchOddsDto dto = new MatchOddsDto();
        dto.setOdds(matchOdds.getOdds());
        dto.setSpecifier(matchOdds.getSpecifier());
        return dto;
    }

    private Optional<MatchOdds> getOddsBySpecifier(Match match, String specifier) {
        for (MatchOdds odds: match.getOdds()) {
            if (odds.getSpecifier().equals(specifier)) {
                return Optional.of(odds);
            }
        }
        return Optional.empty();
    }

    private Time convertTime(String time) {
        return Time.valueOf(time + ":00");
    }
}

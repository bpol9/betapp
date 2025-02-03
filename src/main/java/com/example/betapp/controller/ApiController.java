package com.example.betapp.controller;

import com.example.betapp.dto.OddsDto;
import com.example.betapp.dto.EditStartTimeDto;
import com.example.betapp.dto.MatchDto;
import com.example.betapp.exception.BadRequestException;
import com.example.betapp.service.MatchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.HandlerMethod;

@RestController
@RequestMapping(value = "/api")
public class ApiController {

    private static final Logger logger = LoggerFactory.getLogger("ApiController");

    @Autowired
    private MatchService matchService;

    @PostMapping(value = "/match", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MatchDto> addMatch(@RequestBody MatchDto matchDto) throws BadRequestException {
        return ResponseEntity.ok(matchService.addMatch(matchDto));
    }

    @GetMapping(value = "/match/{id}")
    public ResponseEntity<MatchDto> getMatch(@PathVariable("id") Long id) {
        MatchDto matchDto = matchService.getMatch(id);
        return matchDto != null ? ResponseEntity.ok(matchDto) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PostMapping(value = "/match/add-odds", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MatchDto> addMatchOdds(@RequestBody OddsDto oddsDto) throws BadRequestException {
        return ResponseEntity.ok(matchService.addMatchOdds(oddsDto));
    }

    @PatchMapping(value = "/edit-odds", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MatchDto> editOdds(@RequestBody OddsDto oddsDto) throws BadRequestException {
        return ResponseEntity.ok(matchService.editOdds(oddsDto));
    }

    @PatchMapping(value = "/edit-start-time", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MatchDto> editStartTime(@RequestBody EditStartTimeDto editStartTimeDto) throws BadRequestException {
        return ResponseEntity.ok(matchService.editStartTime(editStartTimeDto));
    }

    @DeleteMapping(value = "/match/{id}")
    public ResponseEntity<Boolean> deleteMatch(@PathVariable("id") Long matchId) {
        matchService.deleteMatch(matchId);
        return ResponseEntity.ok(true);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public void handlerMethod(HandlerMethod handlerMethod, BadRequestException e) {
        logger.error("Exiting {}.{} with BadRequest error {}",
                handlerMethod.getMethod().getDeclaringClass().getSimpleName(),
                handlerMethod.getMethod().getName(), e.getMessage()
        );
    }
}

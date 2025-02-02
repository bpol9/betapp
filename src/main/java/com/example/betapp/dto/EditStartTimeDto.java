package com.example.betapp.dto;

public class EditStartTimeDto {
    private Long matchId;
    private String time;
    private String date;

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "EditStartTimeDto{" +
                "matchId=" + matchId +
                ", time='" + time + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

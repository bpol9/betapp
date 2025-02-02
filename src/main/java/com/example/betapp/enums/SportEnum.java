package com.example.betapp.enums;

public enum SportEnum {
    FOOTBALL(1, "FOOTBALL"),
    BASKETBALL(2, "BASKETBALL");

    private final Integer code;
    private final String value;

    SportEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    static public SportEnum getByCode(Integer code) {
        for (SportEnum sport: SportEnum.values()) {
            if (sport.getCode().equals(code)) {
                return sport;
            }
        }
        throw new IllegalArgumentException("Unknown sport code: " + code);
    }

    static public SportEnum getByValue(String value) {
        for (SportEnum sport: SportEnum.values()) {
            if (sport.getValue().equalsIgnoreCase(value)) {
                return sport;
            }
        }
        throw new IllegalArgumentException("Unknown sport value: " + value);
    }
}

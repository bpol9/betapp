package com.example.betapp.model;

import com.example.betapp.enums.SportEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SportEnumConverter implements AttributeConverter<SportEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(SportEnum sportEnum) {
        return sportEnum.getCode();
    }

    @Override
    public SportEnum convertToEntityAttribute(Integer code) {
        return SportEnum.getByCode(code);
    }
}

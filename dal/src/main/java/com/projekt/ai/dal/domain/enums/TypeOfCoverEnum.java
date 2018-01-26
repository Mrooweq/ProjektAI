package com.projekt.ai.dal.domain.enums;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by Lenovo on 2017-11-08.
 */
public enum TypeOfCoverEnum {
    HARD("hard"), SOFT("soft");

    private String name;

    TypeOfCoverEnum(String name){
        this.name = name;
    }

    @Enumerated(EnumType.STRING)
    public String getName() {
        return name;
    }

    public static TypeOfCoverEnum getTypeOfCoverByName(String name){
        return TypeOfCoverEnum.valueOf(name);
    }
}

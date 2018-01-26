package com.projekt.ai.dal.domain.enums;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by Lenovo on 2017-11-08.
 */
public enum Role {
    USER("user"), ADMIN("admin");

    private String name;

    Role(String name){
        this.name = name;
    }

    @Enumerated(EnumType.STRING)
    public String getName() {
        return name;
    }
}

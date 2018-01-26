package com.projekt.ai.dal.domain.enums;

/**
 * Created by Lenovo on 2017-12-04.
 */
public class RoleParser {

    public static Role getRoleByName (String roleName){
        for (Role role : Role.values()) {
            if(role.toString().equals(roleName))
                return role;
        }
        return null;
    }
}

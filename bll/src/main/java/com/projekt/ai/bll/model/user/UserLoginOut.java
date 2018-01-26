package com.projekt.ai.bll.model.user;

import com.projekt.ai.dal.domain.enums.Role;
import lombok.Data;

/**
 * Created by Lenovo on 2017-12-03.
 */

@Data
public class UserLoginOut {
    private String token;
    private Long userId;
    private String firstname;
    private Role role;
}

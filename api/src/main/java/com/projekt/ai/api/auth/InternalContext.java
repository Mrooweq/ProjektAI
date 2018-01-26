package com.projekt.ai.api.auth;

import com.projekt.ai.dal.domain.enums.Role;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created by Lenovo on 2017-11-23.
 */

@Component
@Data
public class InternalContext {
    private String userName;
    private Role role;
}

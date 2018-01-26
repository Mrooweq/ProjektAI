package com.projekt.ai.bll.service.user;

import com.projekt.ai.bll.model.user.UserRegisterIn;
import com.projekt.ai.common.app.BookstoreAppException;
import com.projekt.ai.common.app.Dictionary;
import com.projekt.ai.common.app.RegexPattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

/**
 * Created by Lenovo on 2017-12-18.
 */

@Service
public class RegistrationValidatorService {

    @Autowired
    private UserService userService;

    public void validateUser(UserRegisterIn userRegisterIn) {
        if(!validate(userRegisterIn))
            throw new BookstoreAppException(Dictionary.INVALID_REGISTRATION_DATA_FORMAT);
    }

    private boolean validate(UserRegisterIn userRegisterIn) {
        if(!userService.checkUsername(userRegisterIn.getUsername()))
            return false;

        if(!userService.checkEmail(userRegisterIn.getEmail()))
            return false;

        if(!check(userRegisterIn.getUsername(), RegexPattern.USERNAME))
            return false;

        if(!check(userRegisterIn.getPassword(), RegexPattern.PASSWORD))
            return false;

        if(!check(userRegisterIn.getFirstname(), RegexPattern.FIRSTNAME))
            return false;

        if(!check(userRegisterIn.getLastname(), RegexPattern.LASTNAME))
            return false;

        if(!check(userRegisterIn.getEmail(), RegexPattern.EMAIL))
            return false;

        if(!check(userRegisterIn.getCity(), RegexPattern.CITY))
            return false;

        if(!check(userRegisterIn.getStreet(), RegexPattern.STREET))
            return false;

        if(!check(userRegisterIn.getHouseNumber(), RegexPattern.HOUSE_NUMBER))
            return false;

        if(!check(userRegisterIn.getPostNumber(), RegexPattern.POST_NUMBER))
            return false;

        return true;
    }

    private boolean check(String field, String regex) {
        return Pattern.matches(regex, field);
    }
}

package com.projekt.ai.common.app;

/**
 * Created by Lenovo on 2017-12-18.
 */
public class RegexPattern {
    public static final String USERNAME = "^(?=.*[a-z])[\\wąćęłńóśźżĄĘŁŃÓŚŹŻ\\d]{3,20}$";
    public static final String PASSWORD = "^(?=.*[A-Z])(?=.*[0-9]).{6,20}$";
    public static final String FIRSTNAME = "^[A-ZŁŻ][a-ząćęłńóśźżĄĘŁŃÓŚŹŻ]{1,20}$";
    public static final String LASTNAME = "^[A-ZĆŁŚŻŹ][a-ząćęłńóśźżĄĘŁŃÓŚŹŻ]{1,20}((-|\\\\s)?[A-ZĆŁŚŻŹ][a-ząćęłńóśźżĄĘŁŃÓŚŹŻ]{1,20})?$";
    public static final String EMAIL = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
    public static final String CITY = "^[A-ZŁŻ]([a-ząćęłńóśźżĄĘŁŃÓŚŹŻA-ZŁŻ\\s]){1,30}$";
    public static final String STREET = "^[A-ZŁŻ]([a-ząćęłńóśźżĄĘŁŃÓŚŹŻA-ZŁŻ\\s]){1,30}$";
    public static final String HOUSE_NUMBER = "^[\\d]{1,3}(/[\\d]{1,3})?[a-zA-Z]?$";
    public static final String POST_NUMBER = "^[\\d]{2}-[\\d]{3}$";
}

package com.automation.ui;

import net.serenitybdd.screenplay.targets.Target;

public class RegistrationPage {
    public static final Target FIRST_NAME = Target.the("first name")
            .locatedBy("#customer\\.firstName");
    public static final Target LAST_NAME = Target.the("last name")
            .locatedBy("#customer\\.lastName");
    public static final Target ADDRESS = Target.the("address")
            .locatedBy("#customer\\.address\\.street");
    public static final Target CITY = Target.the("city")
            .locatedBy("#customer\\.address\\.city");
    public static final Target STATE = Target.the("state")
            .locatedBy("#customer\\.address\\.state");
    public static final Target ZIP = Target.the("zip")
            .locatedBy("#customer\\.address\\.zipCode");
    public static final Target PHONE = Target.the("phone")
            .locatedBy("#customer\\.phoneNumber");
    public static final Target SSN = Target.the("ssn")
            .locatedBy("#customer\\.ssn");
    public static final Target USERNAME = Target.the("username")
            .locatedBy("#customer\\.username");
    public static final Target PASSWORD = Target.the("password")
            .locatedBy("#customer\\.password");
    public static final Target CONFIRM_PASSWORD = Target.the("confirm password")
            .locatedBy("#repeatedPassword");
    public static final Target SUBMIT = Target.the("register button")
            .locatedBy("//input[@type='submit' and @value='Register']");
}

package com.automation.tasks;

import com.automation.models.UserData;
import com.automation.ui.RegistrationPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

@Subject("Register a new user")
public class Register implements Task {

    private final UserData user;

    public Register(UserData user) {
        this.user = user;
    }

    public static Register withData(UserData user) {
        return new Register(user);
    }

    @Step("Registering user with username {0}")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user.getFirstName()).into(RegistrationPage.FIRST_NAME),
                Enter.theValue(user.getLastName()).into(RegistrationPage.LAST_NAME),
                Enter.theValue(user.getAddress()).into(RegistrationPage.ADDRESS),
                Enter.theValue(user.getCity()).into(RegistrationPage.CITY),
                Enter.theValue(user.getState()).into(RegistrationPage.STATE),
                Enter.theValue(user.getZipCode()).into(RegistrationPage.ZIP),
                Enter.theValue(user.getPhone()).into(RegistrationPage.PHONE),
                Enter.theValue(user.getSsn()).into(RegistrationPage.SSN),
                Enter.theValue(user.getUsername()).into(RegistrationPage.USERNAME),
                Enter.theValue(user.getPassword()).into(RegistrationPage.PASSWORD),
                Enter.theValue(user.getPassword()).into(RegistrationPage.CONFIRM_PASSWORD),
                WaitUntil.the(RegistrationPage.SUBMIT, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(RegistrationPage.SUBMIT)
        );
    }
}

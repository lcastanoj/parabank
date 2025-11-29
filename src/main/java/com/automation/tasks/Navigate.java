package com.automation.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class Navigate implements Task {

    private final String url;

    private Navigate(String url) {
        this.url = url;
    }

    public static Navigate toUrl(String url) {
        return new Navigate(url);
    }

    public static Navigate toRegistrationPage() {
        return new Navigate("https://parabank.parasoft.com/parabank/register.htm");
    }

    public static Navigate toLoginPage() {
        return new Navigate("https://parabank.parasoft.com/parabank/index.htm");
    }

    @Step("{0} navigates to the url: #url")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }
}

package com.automation.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Navigate implements Task {

    private final String url;

    public Navigate(String url) {
        this.url = url;
    }

    @Step("{0} navigates to the url: #url")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }

    public static Navigate toRegistrationPage() {
        return instrumented(Navigate.class, "https://parabank.parasoft.com/parabank/register.htm");
    }

    public static Navigate toLoginPage() {
        return instrumented(Navigate.class, "https://parabank.parasoft.com/parabank/index.htm");
    }
}

package com.automation.tasks;

import com.automation.ui.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OveralBalances implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        String from = actor.recall("fromAccount");

        actor.attemptsTo(
                Click.on(HomePage.ACCOUNTS_OVERVIEW_LINK),
                Click.on(HomePage.ACCOUNT_BY_ID.of(from))
        );
    }

    public static OveralBalances resume() {
        return instrumented(OveralBalances.class);
    }
}

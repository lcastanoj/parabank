package com.automation.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import com.automation.ui.HomePage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Logout implements Task {
    @Step("{0} logs out of the application")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePage.LOGOUT_BUTTON)
        );
    }

    public static Logout fromApp() {
        return instrumented(Logout.class);
    }
}

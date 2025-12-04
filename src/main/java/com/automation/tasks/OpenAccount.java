package com.automation.tasks;

import com.automation.ui.HomePage;
import com.automation.ui.OpenAccountPage;
import com.automation.utils.SessionData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.automation.utils.Timeouts.MEDIUM;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class OpenAccount implements Task {

    private final String typeAccount;

    public OpenAccount(String typeAccount) {
        this.typeAccount = typeAccount;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePage.OPEN_ACCOUNT_LINK),
                SelectFromOptions.byVisibleText(typeAccount).from(OpenAccountPage.TYPE_ACCOUNT_SELECT),
                Click.on(OpenAccountPage.OPEN_ACCOUNT_BUTTON),
                WaitUntil.the(OpenAccountPage.MESSAGE_SUCCESSFUL_LABEL, isPresent()).forNoMoreThan(MEDIUM).seconds(),
                Ensure.that(OpenAccountPage.MESSAGE_SUCCESSFUL_LABEL).isDisplayed()
        );

        String newAccount = OpenAccountPage.NEW_ACCOUNT_ID.resolveFor(actor).getText();
        SessionData.setCreatedAccount(newAccount);

        actor.attemptsTo(
                Click.on(HomePage.ACCOUNTS_OVERVIEW_LINK)
        );
    }

    public static OpenAccount add(String typeAccount) {
        return instrumented(OpenAccount.class, typeAccount);
    }
}

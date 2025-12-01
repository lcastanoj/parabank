package com.automation.tasks;

import com.automation.ui.HomePage;
import com.automation.utils.SessionData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ValidateBalances implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        String from = SessionData.getAccountFrom();
        String to = SessionData.getAccountTo();

        double amount = SessionData.getTransferAmount();
        double initialFrom = SessionData.getInitialFromBalance();
        double initialTo   = SessionData.getInitialToBalance();

        actor.attemptsTo(
                Click.on(HomePage.ACCOUNTS_OVERVIEW_LINK)
        );
        
        String fromBalanceStr = HomePage.ACCOUNT_BALANCE.of(from).resolveFor(actor).getText();
        String toBalanceStr   = HomePage.ACCOUNT_BALANCE.of(to).resolveFor(actor).getText();

        double currentFrom = parse(fromBalanceStr);
        double currentTo   = parse(toBalanceStr);

        double expectedFrom = initialFrom - amount;
        double expectedTo   = initialTo + amount;

        actor.attemptsTo(
                Ensure.that(currentFrom).isEqualTo(expectedFrom),
                Ensure.that(currentTo).isEqualTo(expectedTo)
        );

        System.out.printf("FROM: init=%.2f expected=%.2f current=%.2f%n",
                initialFrom, expectedFrom, currentFrom);

        System.out.printf("TO:   init=%.2f expected=%.2f current=%.2f%n",
                initialTo, expectedTo, currentTo);
    }

    private double parse(String raw) {
        return Double.parseDouble(raw.replace("$", "").replace(",", ""));
    }

    public static ValidateBalances check() {
        return instrumented(ValidateBalances.class);
    }
}

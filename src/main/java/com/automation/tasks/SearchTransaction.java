package com.automation.tasks;

import com.automation.ui.FindTransactionsPage;
import com.automation.ui.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchTransaction implements Task {

    private final String amount;

    public SearchTransaction(String amount) {
        this.amount = amount;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(HomePage.FIND_TRANSACTIONS_LINK),
                Enter.theValue(amount).into(FindTransactionsPage.AMOUNT_FIELD),
                Click.on(FindTransactionsPage.SEARCH_BUTTON)
        );
    }

    public static SearchTransaction withAmount(String amount) {
        return instrumented(SearchTransaction.class, amount);
    }
}

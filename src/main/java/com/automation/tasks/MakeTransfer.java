package com.automation.tasks;

import com.automation.ui.HomePage;
import com.automation.ui.TransferPage;
import com.automation.utils.SessionData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class MakeTransfer implements Task {

    private final String amount;

    public MakeTransfer(String amount) {
        this.amount = amount;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String from = actor.recall("fromAccount");
        String to = actor.recall("toAccount");

        double initialFrom = HomePage.ACCOUNT_BALANCE.of(from).resolveFor(actor).getText()
                .replace("$", "").replace(",", "")
                .isEmpty() ? 0.0 :
                Double.parseDouble(HomePage.ACCOUNT_BALANCE.of(from).resolveFor(actor).getText().replace("$", "").replace(",", ""));

        double initialTo = HomePage.ACCOUNT_BALANCE.of(to).resolveFor(actor).getText()
                .replace("$", "").replace(",", "")
                .isEmpty() ? 0.0 :
                Double.parseDouble(HomePage.ACCOUNT_BALANCE.of(to).resolveFor(actor).getText().replace("$", "").replace(",", ""));

        SessionData.setTransferContext(from, to, Double.parseDouble(amount), initialFrom, initialTo);

        actor.attemptsTo(
                Click.on(TransferPage.TRANSFER_LINK),
                SelectFromOptions.byVisibleText(from).from(TransferPage.FROM_ACCOUNT_SELECT),
                SelectFromOptions.byVisibleText(to).from(TransferPage.TO_ACCOUNT_SELECT),
                Enter.theValue(amount).into(TransferPage.AMOUNT_FIELD),
                Click.on(TransferPage.TRANSFER_BUTTON)
        );
    }

    public static MakeTransfer of(String amount) {
        return instrumented(MakeTransfer.class, amount);
    }
}

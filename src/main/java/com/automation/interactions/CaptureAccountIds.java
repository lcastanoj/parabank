package com.automation.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CaptureAccountIds implements Interaction {

    private final Target accountsList;

    public CaptureAccountIds(Target accountsList) {
        this.accountsList = accountsList;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<String> accounts = accountsList.resolveAllFor(actor)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        if (accounts.size() < 2) {
            throw new IllegalStateException("No se encontraron al menos dos cuentas para operar.");
        }

        actor.remember("fromAccount", accounts.get(0));
        actor.remember("toAccount", accounts.get(1));
    }

    public static CaptureAccountIds from(Target accountsList) {
        return instrumented(CaptureAccountIds.class, accountsList);
    }
}

package com.automation.questions;

import com.automation.ui.HomePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;
import java.util.stream.Collectors;

public class AccountsList implements Question<List<String>> {

    @Override
    public List<String> answeredBy(Actor actor) {
        return HomePage.ACCOUNT_ROWS.resolveAllFor(actor)
                .stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }

    public static AccountsList displayed() {
        return new AccountsList();
    }
}

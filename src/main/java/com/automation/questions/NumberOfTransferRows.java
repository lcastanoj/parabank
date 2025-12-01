package com.automation.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import com.automation.ui.AccountActivityPage;

public class NumberOfTransferRows implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        return AccountActivityPage.TRANSFER_ROWS.resolveAllFor(actor).size();
    }

    public static NumberOfTransferRows value() {
        return new NumberOfTransferRows();
    }
}

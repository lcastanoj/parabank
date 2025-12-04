package com.automation.questions;

import com.automation.ui.FindTransactionsPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.math.BigDecimal;
import java.util.List;

public class MatchingTransactions implements Question<Boolean> {

    private final BigDecimal expectedAmount;

    public MatchingTransactions(String expectedAmount) {
        this.expectedAmount = new BigDecimal(expectedAmount);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        List<WebElementFacade> rows = FindTransactionsPage.RESULTS_ROWS
                .resolveAllFor(actor);

        if (rows.isEmpty()) {
            return false;
        }

        for (int i = 1; i <= rows.size(); i++) {
            String rawAmount =
                    FindTransactionsPage.RESULT_AMOUNT
                            .of(String.valueOf(i))
                            .resolveFor(actor)
                            .getText();

            String cleanAmount = rawAmount.replace("$", "").replace(",", "");
            BigDecimal actualAmount = new BigDecimal(cleanAmount);

            System.out.println("Comparando: expected=" + expectedAmount + " actual=" + actualAmount);

            if (actualAmount.compareTo(expectedAmount) == 0) {
                return true;
            }
        }

        return false;
    }

    public static MatchingTransactions forAmount(String amount) {
        return new MatchingTransactions(amount);
    }
}

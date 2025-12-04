package com.automation.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FindTransactionsPage {
    public static final Target AMOUNT_FIELD = Target.the("Amount field")
            .located(By.id("amount"));

    public static final Target SEARCH_BUTTON = Target.the("Search button")
            .locatedBy("//button[@id='findByAmount']");

    public static final Target RESULTS_ROWS = Target.the("Result rows")
            .located(By.cssSelector("#transactionTable tbody tr"));

    public static final Target RESULT_AMOUNT = Target.the("Transaction amount column")
            .locatedBy("//*[@id='transactionTable']//tbody/tr[1]/td[3]");
}

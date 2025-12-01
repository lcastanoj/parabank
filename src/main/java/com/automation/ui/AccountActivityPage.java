package com.automation.ui;

import net.serenitybdd.screenplay.targets.Target;

public class AccountActivityPage {
    public static final Target TRANSFER_ROWS = Target.the("transfer rows")
            .locatedBy("//div[@id='accountActivity']//table//tbody/tr");
    public static final Target TRANSACTION_LINK = Target.the("transaction name")
            .locatedBy("//div[@id='accountActivity']//table//tbody/tr/td[2]");
    public static final Target DEBIT_AMOUNT = Target.the("debit amount")
            .locatedBy("//div[@id='accountActivity']//table//tbody/tr/td[3]");
    public static final Target CREDIT_AMOUNT = Target.the("credit amount")
            .locatedBy("//div[@id='accountActivity']//table//tbody/tr/td[4]");


}

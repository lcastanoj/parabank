package com.automation.ui;

import net.serenitybdd.screenplay.targets.Target;

public class TransferPage {
    public static final Target TRANSFER_LINK = Target.the("transfer link")
            .locatedBy("//a[text()='Transfer Funds']");
    public static final Target AMOUNT_FIELD = Target.the("amount field")
            .locatedBy("//input[@id='amount']");
    public static final Target FROM_ACCOUNT_SELECT = Target.the("from account select")
            .locatedBy("//select[@id='fromAccountId']");
    public static final Target TO_ACCOUNT_SELECT = Target.the("to account select")
            .locatedBy("//select[@id='toAccountId']");
    public static final Target TRANSFER_BUTTON = Target.the("transfer button")
            .locatedBy("//input[@value='Transfer']");

    public static final Target SUCCESS_MESSAGE = Target.the("success message")
            .locatedBy("//h1[contains(text(),'Transfer Complete')]");
}

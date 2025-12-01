package com.automation.ui;

import net.serenitybdd.screenplay.targets.Target;

public class AccountActivityPage {
    public static final Target TRANSFER_ROWS = Target.the("transfer rows")
            .locatedBy("//div[@id='accountActivity']//table//tbody/tr");
}

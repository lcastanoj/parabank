package com.automation.ui;

import net.serenitybdd.screenplay.targets.Target;

public class OpenAccountPage {
    public static final Target TYPE_ACCOUNT_SELECT = Target.the("type account select")
            .locatedBy("//select[@id='type']");
    public static final Target OPEN_ACCOUNT_BUTTON = Target.the("open account")
            .locatedBy("//input[@value='Open New Account']");
    public static final Target MESSAGE_SUCCESSFUL_LABEL = Target.the("message successful label")
            .locatedBy("//div[@id='openAccountResult']/p[contains(text(), 'Congratulations, your account is now open.')]");
    public static final Target NEW_ACCOUNT_ID = Target.the("new account id")
                    .locatedBy("//a[contains(@href,'activity.htm?id=')]");
}

package com.automation.ui;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {
    public static final Target SUCCESS_MESSAGE = Target.the("success message")
            .locatedBy("//p[contains(text(), 'Your account was created successfully. You are now logged in.')]");
    public static final Target LOGOUT_BUTTON = Target.the("logout botton")
            .locatedBy("//a[contains(text(), 'Log Out')]");
    public static final Target WELCOME_MESSAGE = Target.the("welcome message login")
            .locatedBy("//p[@class='smallText'][contains(., 'Welcome')]");
    public static final Target OPEN_ACCOUNT_LINK = Target.the("open account link")
            .locatedBy("//ul/li/a[contains(text(), 'Open New Account')]");
    public static final Target ACCOUNT_ROWS = Target.the("account rows")
                    .locatedBy("//table[@id='accountTable']//tr/td[1]");
    public static final Target ACCOUNTS_OVERVIEW_LINK = Target.the("accounts overview link")
            .locatedBy("//a[text()='Accounts Overview']");

}

package com.automation.ui;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {
    public static final Target SUCCESS_MESSAGE = Target.the("success message")
            .locatedBy("//p[contains(text(), 'Your account was created successfully. You are now logged in.')]");
    public static final Target LOGOUT_BUTTON = Target.the("logout botton")
            .locatedBy("//a[contains(text(), 'Log Out')]");
    public static final Target WELCOME_MESSAGE = Target.the("welcome message login")
            .locatedBy("//p[@class='smallText'][contains(., 'Welcome')]");
}

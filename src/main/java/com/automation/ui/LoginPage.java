package com.automation.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static final Target USERNAME = Target.the("username field")
            .located(By.name("username")); // o el locator que uses
    public static final Target PASSWORD = Target.the("password field")
            .located(By.name("password"));
    public static final Target LOGIN_BUTTON = Target.the("login button")
            .located(By.xpath("//input[@value='Log In']"));
}

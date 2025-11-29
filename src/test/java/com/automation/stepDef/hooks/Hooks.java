package com.automation.stepDef.hooks;

import com.automation.models.UserData;
import com.automation.tasks.Logout;
import com.automation.tasks.Navigate;
import com.automation.tasks.Register;
import com.automation.utils.DataGenerator;
import com.automation.utils.SessionData;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;
import com.automation.utils.DriverFactory;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class Hooks {
    @Before(order = 0)
    public void setUp() {
        setTheStage(new OnlineCast());

        WebDriver customDriver = DriverFactory.getDriver();
        theActorCalled("user").whoCan(BrowseTheWeb.with(customDriver));
    }

    @Before(value = "@needsUser", order = 1)
    public void registerUser() {
        UserData user = DataGenerator.randomUser();
        SessionData.setCurrentUser(user);

        OnStage.theActorInTheSpotlight().attemptsTo(
                Navigate.toRegistrationPage(),
                Register.withData(user),
                Logout.fromApp()
        );

        System.out.println("User created for scenario: " + user);
    }
}

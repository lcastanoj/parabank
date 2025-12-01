package com.automation.stepDef;

import com.automation.tasks.Login;
import com.automation.tasks.Navigate;
import com.automation.ui.HomePage;
import com.automation.utils.SessionData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginStepDef {

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        theActorInTheSpotlight().attemptsTo(
                Navigate.toLoginPage()
        );
    }

    @When("the user logs in with valid credentials")
    public void theUserLogsInWithValidCredentials() {
        theActorInTheSpotlight().attemptsTo(
                Login.withCredentials(
                        SessionData.getCurrentUser().getUsername(),
                        SessionData.getCurrentUser().getPassword()
                )
        );
    }

    @Then("the user should see the welcome message")
    public void theUserShouldSeeTheWelcomeMessage() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(HomePage.WELCOME_MESSAGE).isDisplayed()
        );
    }
}

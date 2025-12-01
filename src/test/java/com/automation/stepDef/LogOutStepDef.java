package com.automation.stepDef;

import com.automation.tasks.Logout;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LogOutStepDef {

    @When("the user logs out")
    public void theUserLogsOut() {
        theActorInTheSpotlight().attemptsTo(
                Logout.fromApp()
        );
    }

    @Then("the login page should be displayed")
    public void theLoginPageShouldBeDisplayed() {

    }
}

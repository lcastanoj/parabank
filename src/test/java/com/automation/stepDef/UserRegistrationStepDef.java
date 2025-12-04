package com.automation.stepDef;

import com.automation.models.UserData;
import com.automation.tasks.Navigate;
import com.automation.tasks.Register;
import com.automation.ui.HomePage;
import com.automation.utils.DataGenerator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.automation.utils.Timeouts.MEDIUM;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class UserRegistrationStepDef {

    @Given("the user is on the registration page")
    public void theUserIsOnTheRegistrationPage() {
        theActorInTheSpotlight().attemptsTo(
                Navigate.toRegistrationPage()
        );
    }

    @When("the user registers with valid data")
    public void theUserRegistersWithValidData() {
        UserData user = DataGenerator.randomUser();
        System.out.println("User registered: " + user);

        theActorInTheSpotlight().attemptsTo(
                Register.withData(user)
        );

        theActorInTheSpotlight().remember("registeredUser", user);
    }

    @Then("the user should see the message {string}")
    public void theUserShouldSeeTheMessage(String expectedMessage) {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(HomePage.SUCCESS_MESSAGE, isPresent()).forNoMoreThan(MEDIUM).seconds(),
                Ensure.that(Text.of(HomePage.SUCCESS_MESSAGE)).asAString().isEqualTo(expectedMessage)
        );
    }
}

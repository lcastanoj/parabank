package com.automation.stepDef;

import com.automation.models.UserData;
import com.automation.tasks.Navigate;
import com.automation.tasks.Register;
import com.automation.utils.DataGenerator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;

import static com.automation.ui.HomePage.SUCCESS_MESSAGE;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

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
                Ensure.that(Text.of(SUCCESS_MESSAGE)).asAString().isEqualTo(expectedMessage)
        );
    }
}

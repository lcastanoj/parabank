package com.automation.stepDef;

import com.automation.questions.AccountsList;
import com.automation.tasks.Login;
import com.automation.tasks.Navigate;
import com.automation.tasks.OpenAccount;
import com.automation.ui.HomePage;
import com.automation.utils.SessionData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.hasItem;

public class OpenAccountStepDef {

    @Given("the user is authenticated")
    public void theUserIsAuthenticated() {
        theActorInTheSpotlight().attemptsTo(
                Navigate.toLoginPage(),
                Login.withCredentials(
                        SessionData.getCurrentUser().getUsername(),
                        SessionData.getCurrentUser().getPassword()
                )
        );
    }

    @When("the user opens a new {string} account")
    public void theUserOpensANewAccount(String typeAccount) {
        theActorInTheSpotlight().attemptsTo(
                OpenAccount.add(typeAccount)
        );
    }

    @Then("the new account should be displayed in the accounts overview")
    public void theNewAccountShouldBeDisplayedInTheAccountsOverview() {
        String createdAccount = SessionData.getCreatedAccount();

        theActorInTheSpotlight().should(
                seeThat("the account appears on the overall",
                        AccountsList.displayed(),
                        hasItem(createdAccount)
                )
        );
    }
}

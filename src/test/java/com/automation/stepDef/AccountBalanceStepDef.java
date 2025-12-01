package com.automation.stepDef;

import com.automation.interactions.CaptureAccountIds;
import com.automation.tasks.MakeTransfer;
import com.automation.tasks.OpenAccount;
import com.automation.tasks.OverallBalances;
import com.automation.tasks.ValidateBalances;
import com.automation.ui.AccountActivityPage;
import com.automation.ui.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.greaterThan;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AccountBalanceStepDef {

    @Given("the user has recent transfer operations {string} {string}")
    public void theUserHasRecentTransferOperations(String typeAccount, String amount) {
        theActorInTheSpotlight().attemptsTo(
                OpenAccount.add(typeAccount),
                CaptureAccountIds.from(HomePage.ACCOUNTS_IDS),
                MakeTransfer.of(amount)
        );
    }

    @When("the user checks the account balances")
    public void theUserChecksTheAccountBalances() {
        theActorInTheSpotlight().attemptsTo(
                ValidateBalances.check()
        );
    }

    @Then("the balances should reflect the last transfer")
    public void theBalancesShouldReflectTheLastTransfer() {
        theActorInTheSpotlight().attemptsTo(
                OverallBalances.resume()
        );

        theActorInTheSpotlight().should(
                seeThat("the table isn't empty",
                        actor -> AccountActivityPage.TRANSFER_ROWS.resolveAllFor(actor).size(),
                        greaterThan(0)
                )
        );
    }
}

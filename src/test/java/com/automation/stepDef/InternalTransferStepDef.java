package com.automation.stepDef;

import com.automation.interactions.CaptureAccountIds;
import com.automation.tasks.MakeTransfer;
import com.automation.tasks.OpenAccount;
import com.automation.ui.HomePage;
import com.automation.ui.TransferPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class InternalTransferStepDef {

    @Given("the user has at least two active accounts {string}")
    public void theUserHasAtLeastTwoActiveAccounts(String typeAccount) {
        theActorInTheSpotlight().attemptsTo(
                OpenAccount.add(typeAccount)
        );
    }

    @When("the user transfers {string} dollars from the first account to the second account")
    public void theUserTransfersDollarsFromTheFirstAccountToTheSecondAccount(String amount) {
        theActorInTheSpotlight().attemptsTo(
                CaptureAccountIds.from(HomePage.ACCOUNTS_IDS),
                MakeTransfer.of(amount)
        );
    }

    @Then("the transfer confirmation should be displayed")
    public void theTransferConfirmationShouldBeDisplayed() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(TransferPage.SUCCESS_MESSAGE).isDisplayed()
        );
    }
}

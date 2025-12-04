package com.automation.stepDef;

import com.automation.interactions.CaptureAccountIds;
import com.automation.questions.MatchingTransactions;
import com.automation.tasks.MakeTransfer;
import com.automation.tasks.SearchTransaction;
import com.automation.ui.HomePage;
import com.automation.utils.SessionData;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class TransactionSearchStepDef {

    @And("the users do a transfer {string}")
    public void theUsersDoATransfer(String amount) {
        theActorInTheSpotlight().attemptsTo(
                CaptureAccountIds.from(HomePage.ACCOUNTS_IDS),
                MakeTransfer.of(amount)
        );
    }

    @When("the user searches for transactions with amount {string}")
    public void theUserSearchesForTransactionsWithAmount(String amount) {
        theActorInTheSpotlight().attemptsTo(
                SearchTransaction.withAmount(amount)
        );
    }

    @Then("at least one matching transaction should be displayed")
    public void atLeastOneMatchingTransactionShouldBeDisplayed() {
        String lastAmount = SessionData.getTransferAmount() + "";
        System.out.println("last amount " + lastAmount);

        theActorInTheSpotlight().should(
                seeThat(
                        "matching transaction exists",
                        MatchingTransactions.forAmount(lastAmount),
                        equalTo(true)
                )
        );
    }
}

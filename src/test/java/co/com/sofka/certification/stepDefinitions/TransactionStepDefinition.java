package co.com.sofka.certification.stepDefinitions;

import static co.com.sofka.certification.questions.BancaryBalanceQuestion.calculatedBalance;
import static co.com.sofka.certification.questions.FixedBalance.fixedStringBalance;
import static co.com.sofka.certification.tasks.IgnoreWarningTask.ignoreWarning;
import static co.com.sofka.certification.tasks.LoginTask.doLogin;
import static co.com.sofka.certification.tasks.PaymentTask.makeAPayment;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;
import java.util.Map;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TransactionStepDefinition {
    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    @Before
    public void actorConfig() {
        OnStage.setTheStage(new OnlineCast());
    }


    @Given("{actor} login into eribank application account using account {string} and password {string}")
    public void juanLoginIntoEribankApplicationAccountUsingAccountAndPassword(Actor actor, String username, String password) {
        actor.attemptsTo(
                ignoreWarning(),
                doLogin().withUserName(username)
                        .andPassword(password)
        );
    }


    @When("{actor} makes a transaction using data:")
    public void heMakesATransactionUsingData(Actor actor, List<Map<String, String>> userTable) {
        Map<String, String> transactionData = userTable.get(0);
        actor.attemptsTo(
                makeAPayment().withTransactionData(transactionData)
        );

    }

    @Then("{actor} should see that the correct amount was sent")
    public void heShouldSeeThatTheCorrectAmountWasSent(Actor actor) {
        actor.attemptsTo(
                Ensure.that(fixedStringBalance())
                        .isEqualTo(calculatedBalance().answeredBy(actor))

        );
    }


}

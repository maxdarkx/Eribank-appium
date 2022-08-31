package co.com.sofka.certification.stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.ui.PageElement;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

import static co.com.sofka.certification.tasks.IgnoreWarningTask.ignoreWarning;
import static co.com.sofka.certification.tasks.LoginTask.doLogin;
import static co.com.sofka.certification.userinterfaces.DashboardUI.BT_MAKE_PAYMENT;
import static co.com.sofka.certification.userinterfaces.PaymentUI.*;

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
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        Map<String, String> dataUser = userTable.get(0);
        String countryXpath = "//*[contains(@text,'"+dataUser.get("country")+"')]";


        actor.attemptsTo(
                Click.on(BT_MAKE_PAYMENT),
                Enter.theValue(dataUser.get("phone")).into(ET_PHONE),
                Enter.theValue(dataUser.get("name")).into(ET_NAME),
                Enter.theValue(dataUser.get("amount")).into(SR_AMOUNT),
                Click.on(BT_SELECT_COUNTRY),
                MoveMouse.to(PageElement.located(By.xpath(countryXpath))),
                Click.on(PageElement.located(By.xpath(countryXpath))),
                Click.on(BT_SEND_PAYMENT)
        );

    }

    @Then("{actor} should see that the correct amount was sent")
    public void heShouldSeeThatTheCorrectAmountWasSent(Actor actor) {

    }


}

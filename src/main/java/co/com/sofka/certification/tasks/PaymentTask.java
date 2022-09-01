package co.com.sofka.certification.tasks;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static co.com.sofka.certification.questions.CountryQuestion.theCountryIsOnTheList;
import static co.com.sofka.certification.tasks.SwipeToXpath.swipeToXpath;
import static co.com.sofka.certification.userinterfaces.DashboardUI.BT_MAKE_PAYMENT;
import static co.com.sofka.certification.userinterfaces.DashboardUI.VW_BALANCE;
import static co.com.sofka.certification.userinterfaces.PaymentUI.BT_CONFIRM_PAYMENT;
import static co.com.sofka.certification.userinterfaces.PaymentUI.BT_SELECT_COUNTRY;
import static co.com.sofka.certification.userinterfaces.PaymentUI.BT_SEND_PAYMENT;
import static co.com.sofka.certification.userinterfaces.PaymentUI.ET_COUNTRY;
import static co.com.sofka.certification.userinterfaces.PaymentUI.ET_NAME;
import static co.com.sofka.certification.userinterfaces.PaymentUI.ET_PHONE;
import static co.com.sofka.certification.userinterfaces.PaymentUI.SR_AMOUNT;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ui.PageElement;
import net.serenitybdd.screenplay.waits.WaitUntil;


import org.openqa.selenium.By;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Map;

import co.com.sofka.certification.models.FixCountryFormat;


public class PaymentTask implements Task {
    private Map<String, String> transactionData;
    private ArrayList<String> countryList;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.remember("actualBalance", VW_BALANCE.resolveFor(actor).getText());
        actor.remember("paymentAmount", transactionData.get("amount"));
        FixCountryFormat fix = new FixCountryFormat(transactionData.get("country"));
        String country = fix.fixFormat();
        String countryXpath = "//*[contains(@text,'" + country + "')]";
        String middleCountryXpath = "//*[contains(@text,'Italy')]";
        actor.attemptsTo(
                Click.on(BT_MAKE_PAYMENT),
                Enter.theValue(transactionData.get("phone")).into(ET_PHONE),
                Enter.theValue(transactionData.get("name")).into(ET_NAME),
                Enter.theValue(transactionData.get("amount")).into(SR_AMOUNT),
                Check.whether(theCountryIsOnTheList().using(transactionData.get("country")))
                        .andIfSo(
                                Click.on(BT_SELECT_COUNTRY),
                                Check.whether(PageElement.located(By.xpath(countryXpath)).resolveFor(actor).isPresent())
                                        .andIfSo(Click.on(PageElement.located(By.xpath(countryXpath))))
                                        .otherwise(
                                                swipeToXpath(middleCountryXpath),
                                                Click.on(PageElement.located(By.xpath(countryXpath)))
                                        )
                        )
                        .otherwise(
                                Enter.theValue(country).into(ET_COUNTRY)
                        ),
                Click.on(BT_SEND_PAYMENT),
                Click.on(BT_CONFIRM_PAYMENT)
        );

    }

    public static PaymentTask makeAPayment() {
        return new PaymentTask();
    }

    public PaymentTask withTransactionData(Map<String, String> data) {
        transactionData = data;
        return this;
    }


}

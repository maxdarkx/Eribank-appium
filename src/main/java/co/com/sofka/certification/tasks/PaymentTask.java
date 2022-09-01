package co.com.sofka.certification.tasks;

import static co.com.sofka.certification.userinterfaces.DashboardUI.BT_MAKE_PAYMENT;
import static co.com.sofka.certification.userinterfaces.DashboardUI.VW_BALANCE;
import static co.com.sofka.certification.userinterfaces.PaymentUI.BT_CONFIRM_PAYMENT;
import static co.com.sofka.certification.userinterfaces.PaymentUI.BT_SELECT_COUNTRY;
import static co.com.sofka.certification.userinterfaces.PaymentUI.BT_SEND_PAYMENT;
import static co.com.sofka.certification.userinterfaces.PaymentUI.ET_NAME;
import static co.com.sofka.certification.userinterfaces.PaymentUI.ET_PHONE;
import static co.com.sofka.certification.userinterfaces.PaymentUI.SR_AMOUNT;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.ui.PageElement;

import org.openqa.selenium.By;

import java.util.Map;

public class PaymentTask implements Task {
    private Map<String, String> transactionData;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.remember("actualBalance", VW_BALANCE.resolveFor(actor).getText());
        actor.remember("paymentAmount", transactionData.get("amount"));
        String countryXpath = "//*[contains(@text,'"+transactionData.get("country")+"')]";
        actor.attemptsTo(
                Click.on(BT_MAKE_PAYMENT),
                Enter.theValue(transactionData.get("phone")).into(ET_PHONE),
                Enter.theValue(transactionData.get("name")).into(ET_NAME),
                Enter.theValue(transactionData.get("amount")).into(SR_AMOUNT),
                Click.on(BT_SELECT_COUNTRY),
                MoveMouse.to(PageElement.located(By.xpath(countryXpath))),
                Click.on(PageElement.located(By.xpath(countryXpath))),
                Click.on(BT_SEND_PAYMENT),
                Click.on(BT_CONFIRM_PAYMENT)
        );
    }

    public static PaymentTask makeAPayment()
    {
        return new PaymentTask();
    }

    public PaymentTask withTransactionData(Map<String, String> data)
    {
        transactionData = data;
        return this;
    }
}

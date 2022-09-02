package co.com.sofka.certification.tasks;

import static co.com.sofka.certification.tasks.EnterAccountDataAndTransactionAmount.enterAccountDataAndTransactionAmount;
import static co.com.sofka.certification.tasks.SelectEntryMethodAndEnterForCountry.selectEntryMethodAndEnter;
import static co.com.sofka.certification.userinterfaces.DashboardUI.BT_MAKE_PAYMENT;
import static co.com.sofka.certification.userinterfaces.DashboardUI.VW_BALANCE;
import static co.com.sofka.certification.userinterfaces.PaymentUI.BT_CONFIRM_PAYMENT;
import static co.com.sofka.certification.userinterfaces.PaymentUI.BT_SEND_PAYMENT;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.ArrayList;
import java.util.Map;


public class PaymentTask implements Task {
    private Map<String, String> transactionData;
    private ArrayList<String> countryList;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.remember("actualBalance", VW_BALANCE.resolveFor(actor).getText());
        actor.remember("paymentAmount", transactionData.get("amount"));
        String country = transactionData.get("country");

        actor.attemptsTo(
                Click.on(BT_MAKE_PAYMENT),
                selectEntryMethodAndEnter().forCountry(country),
                enterAccountDataAndTransactionAmount()
                        .withTransactionData(transactionData),
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

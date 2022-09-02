package co.com.sofka.certification.tasks;

import static co.com.sofka.certification.userinterfaces.PaymentUI.ET_NAME;
import static co.com.sofka.certification.userinterfaces.PaymentUI.ET_PHONE;
import static co.com.sofka.certification.userinterfaces.PaymentUI.SR_AMOUNT;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.Map;

public class EnterAccountDataAndTransactionAmount implements Task {
    public Map<String, String> transaction;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(transaction.get("phone")).into(ET_PHONE),
                Enter.theValue(transaction.get("name")).into(ET_NAME),
                Enter.theValue(transaction.get("amount")).into(SR_AMOUNT)
        );
    }

    public static EnterAccountDataAndTransactionAmount enterAccountDataAndTransactionAmount() {
        return new EnterAccountDataAndTransactionAmount();
    }

    public EnterAccountDataAndTransactionAmount withTransactionData(Map<String, String> data) {
        transaction = data;
        return this;
    }
}

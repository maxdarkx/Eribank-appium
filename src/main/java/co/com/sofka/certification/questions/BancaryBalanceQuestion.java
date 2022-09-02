package co.com.sofka.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.Locale;

public class BancaryBalanceQuestion implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        String actualBalance[] = ((String) actor.recall("actualBalance")).split(" ");
        String paymentAmount = (String) actor.recall("paymentAmount");
        Float actualBalanceNumber = Float.parseFloat(actualBalance[3].replace("$", ""));
        Float paymentAmountNumber = Float.parseFloat(paymentAmount.replace("$", ""));
        Float expectedBalanceNumber = actualBalanceNumber - paymentAmountNumber;
        String expectedBalance = String.format(Locale.ROOT, "%.2f$", expectedBalanceNumber);
        return expectedBalance;
    }

    public static BancaryBalanceQuestion calculatedBalance() {
        return new BancaryBalanceQuestion();
    }

}

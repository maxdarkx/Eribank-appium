package co.com.sofka.certification.questions;

import static co.com.sofka.certification.userinterfaces.DashboardUI.VW_BALANCE;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class FixedBalance implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        String balance[] = VW_BALANCE.resolveFor(actor).getText().split(" ");
        return balance[3];
    }

    public static FixedBalance fixedStringBalance()
    {
        return new FixedBalance();
    }
}

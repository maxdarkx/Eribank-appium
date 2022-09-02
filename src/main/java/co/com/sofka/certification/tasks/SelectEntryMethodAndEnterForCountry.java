package co.com.sofka.certification.tasks;

import static co.com.sofka.certification.tasks.SelectAndClickOnCountryTask.selectAndClickOnCountry;
import static co.com.sofka.certification.userinterfaces.PaymentUI.BT_SELECT_COUNTRY;
import static co.com.sofka.certification.userinterfaces.PaymentUI.ET_COUNTRY;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;

import co.com.sofka.certification.models.Countries;
import co.com.sofka.certification.models.FixCountryFormat;

public class SelectEntryMethodAndEnterForCountry implements Task {

    private String country;

    @Override
    public <T extends Actor> void performAs(T actor) {
        FixCountryFormat fix = new FixCountryFormat(country);
        String fixedCountry = fix.fixFormat();

        actor.attemptsTo(
                Check.whether(Countries.find(country))
                        .andIfSo(
                                Click.on(BT_SELECT_COUNTRY),
                                selectAndClickOnCountry().withIdentifier(country)
                        )
                        .otherwise(
                                Enter.theValue(fixedCountry).into(ET_COUNTRY)
                        )
        );
    }

    public static SelectEntryMethodAndEnterForCountry selectEntryMethodAndEnter() {
        return new SelectEntryMethodAndEnterForCountry();
    }

    public SelectEntryMethodAndEnterForCountry forCountry(String selectedCountry) {
        country = selectedCountry;
        return this;
    }
}
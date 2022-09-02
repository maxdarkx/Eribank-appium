package co.com.sofka.certification.tasks;

import static co.com.sofka.certification.tasks.SwipeToXpath.swipeToXpath;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ui.PageElement;

import org.openqa.selenium.By;

import co.com.sofka.certification.models.FixCountryFormat;

public class SelectAndClickOnCountryTask implements Task {
    private String country;


    @Override
    public <T extends Actor> void performAs(T actor) {
        FixCountryFormat fix = new FixCountryFormat(country);
        String country = fix.fixFormat();
        String countryXpath = "//android.widget.TextView[contains(@text,'" + country + "')]";
        String middleCountryXpath = "//android.widget.TextView[contains(@text,'India')]";

        actor.attemptsTo(
                Check.whether( PageElement.located(By.xpath(countryXpath)).isVisibleFor(actor))
                        .andIfSo(
                                Click.on(PageElement.located(By.xpath(countryXpath)))
                        )
                        .otherwise(
                                swipeToXpath(middleCountryXpath)
                                        .lookingFor(countryXpath)
                        )
        );
    }

    public static SelectAndClickOnCountryTask selectAndClickOnCountry()
    {
        return new SelectAndClickOnCountryTask();
    }

    public SelectAndClickOnCountryTask withIdentifier(String countryIdentifier)
    {
        country = countryIdentifier;
        return this;
    }
}

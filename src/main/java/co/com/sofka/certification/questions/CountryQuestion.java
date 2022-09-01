package co.com.sofka.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import co.com.sofka.certification.models.Countries;

public class CountryQuestion implements Question<Boolean> {
    private String countryToTest;
    @Override
    public Boolean answeredBy(Actor actor) {
        return Countries.find(countryToTest);
    }

    public CountryQuestion using(String country)
    {
        countryToTest = country;
        return this;
    }

    public static CountryQuestion theCountryIsOnTheList()
    {
        return new CountryQuestion();
    }

}

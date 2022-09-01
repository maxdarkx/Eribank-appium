package co.com.sofka.certification.models;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Countries {
    INDIA("India"),
    USA("USA"),
    ICELAND("Iceland"),
    GREENLAND("Greenland"),
    SWITZERLAND("Switzerland"),
    NORWAY("Norway"),
    NEW_ZEALAND("New Zealand"),
    GREECE("Greece"),
    ITALY("Italy"),
    IRELAND("Ireland"),
    CHINA("China"),
    JAPAN("Japan"),
    FRANCE("France"),
    RUSSIA("Russia"),
    AUSTRALIA("Australia"),
    CANADA("Canada");

    private final String countryName;

    Countries(String country)
    {
        countryName = country;
    }

    public static List<String> asList()
    {
        return Arrays.stream(values()).map(Enum::name).collect(Collectors.toList());
    }

    public static Boolean find(String lookingForCountry)
    {
        return asList().contains(lookingForCountry);
    }

    public String getCountryName()
    {
        return countryName;
    }

}

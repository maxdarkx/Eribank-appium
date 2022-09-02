package co.com.sofka.certification.models;

import java.util.Locale;

public class FixCountryFormat {
    private String country;

    public FixCountryFormat(String country) {
        this.country = country;
    }

    public String fixFormat()
    {
        String returnWord;
        returnWord = fixAll(country.split("_"));
        if(returnWord.contains("Usa"))
            returnWord = returnWord.toUpperCase(Locale.ROOT);
        return returnWord;
    }

    public String fixAll(String[] word)
    {
        String fixedWord= "";
        String firstLetter;
        String rest;

        for (int i = 0; i < word.length; i++) {
            firstLetter = String.valueOf(word[i].charAt(0));
            rest = word[i].substring(1).toLowerCase();
            if(i+1< word.length)
                fixedWord = fixedWord.concat(firstLetter.concat(rest)).concat(" ");
            else
                fixedWord = fixedWord.concat(firstLetter.concat(rest));
        }
        return fixedWord;
    }
}

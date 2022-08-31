package co.com.sofka.certification.runners;

import net.serenitybdd.cucumber.CucumberWithSerenity;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = "co.com.sofka.certification.stepDefinitions",
        features = "src/test/resources/features/bancaryTransaction.feature",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class TransactionRunner {
}

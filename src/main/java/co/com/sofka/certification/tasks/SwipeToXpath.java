package co.com.sofka.certification.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.DriverTask;
import net.serenitybdd.screenplay.ui.PageElement;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import io.appium.java_client.touch.*;

import java.lang.annotation.Target;

public class SwipeToXpath implements Task {
    private String xpath;

    public SwipeToXpath(String xpath) {
        this.xpath = xpath;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                //  swipeDown()
                swipeDown(PageElement.located(By.xpath(xpath)).resolveFor(actor))
        );
    }

    public static SwipeToXpath swipeToXpath(String xpath) {
        return Tasks.instrumented(SwipeToXpath.class, xpath);
    }

    public Performable swipeDown(WebElement element) {
        return new DriverTask(
                driver -> {
                    TouchActions actions = new TouchActions(driver);
                    actions.clickAndHold(element);
                    actions.moveByOffset(0, 1000);
                    actions.release(element);
                    actions.perform();
                }
        );
    }

    public Performable swipeDown() {
        return new DriverTask(
                driver -> {
                    TouchActions actions = new TouchActions(driver);
                    actions.move(500, 500);
                    actions.clickAndHold();
                    actions.scroll(0, 1000);
                    actions.release();
                    actions.perform();
                }
        );
    }
}

package co.com.sofka.certification.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.DriverTask;
import net.serenitybdd.screenplay.ui.PageElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

public class SwipeToXpath implements Task {
    private String xpath;
    private String itemXpath;

    public SwipeToXpath(String xpath) {
        this.xpath = xpath;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                swipeDown(PageElement.located(By.xpath(xpath)).resolveFor(actor)),
                Click.on(PageElement.located(By.xpath(itemXpath)))
        );
    }

    public static SwipeToXpath swipeToXpath(String xpath) {
        return Tasks.instrumented(SwipeToXpath.class, xpath);
    }

    public Performable swipeDown(WebElement element) {
        return new DriverTask(
                driver -> {
                    int height = driver.manage().window().getSize().getHeight();
                    int moveHeight = (int) (height * 0.5);

                    TouchActions actions = new TouchActions(driver);
                    actions.clickAndHold(element);
                    actions.moveByOffset(0, moveHeight);
                    actions.release(element);
                    actions.perform();
                }
        );
    }

    public SwipeToXpath lookingFor(String countryXpath)
    {
        itemXpath = countryXpath;
        return this;
    }
}

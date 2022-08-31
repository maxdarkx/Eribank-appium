package co.com.sofka.certification.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;

import static co.com.sofka.certification.userinterfaces.LoginUI.BT_DISMISS_WARNING;

public class IgnoreWarningTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Check.whether(BT_DISMISS_WARNING.resolveFor(actor).isPresent())
                        .andIfSo(Click.on(BT_DISMISS_WARNING))
        );
    }

    public static IgnoreWarningTask ignoreWarning()
    {
        return new IgnoreWarningTask();
    }
}

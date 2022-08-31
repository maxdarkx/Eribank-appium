package co.com.sofka.certification.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.sofka.certification.userinterfaces.LoginUI.*;

public class LoginTask implements Task {
    private String userName;
    private String pass;
    @Override

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(userName).into(ET_USERNAME),
                Enter.theValue(pass).into(ET_PASSWORD),
                Click.on(BT_DO_LOGIN)
        );
    }

    public static LoginTask doLogin() {
        return new LoginTask();
    }

    public LoginTask withUserName(String user)
    {
        userName = user;
        return this;
    }

    public LoginTask andPassword(String password)
    {
        pass = password;
        return this;
    }
}

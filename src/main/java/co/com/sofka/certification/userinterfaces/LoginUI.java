package co.com.sofka.certification.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;

public class LoginUI {

    public static final Target BT_DISMISS_WARNING = Target.the("Button to dismiss the OS warning").located(By.id("android:id/button1"));
    public static final Target ET_USERNAME = Target.the("EditText to fill username field").located(By.id("com.experitest.ExperiBank:id/usernameTextField"));
    public static final Target ET_PASSWORD = Target.the("EditText to fill password field").located(By.id("com.experitest.ExperiBank:id/passwordTextField"));
    public static final Target BT_DO_LOGIN = Target.the("Button to do login into the account").located(By.id("com.experitest.ExperiBank:id/loginButton"));
}

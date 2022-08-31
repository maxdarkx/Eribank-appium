package co.com.sofka.certification.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DashboardUI {
    public static final Target BT_MAKE_PAYMENT = Target.the("Button to make a payment").located(By.id("makePaymentButton"));
    public static final Target VW_BALANCE = Target.the("View to show the current balance").located(By.xpath("//android.view.View"));
    public static final Target BT_LOGOUT = Target.the("Button to do logout").located(By.xpath("//android.view.View"));
}

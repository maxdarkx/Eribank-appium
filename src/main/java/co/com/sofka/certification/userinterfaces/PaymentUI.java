package co.com.sofka.certification.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaymentUI {
    public static final Target ET_PHONE = Target.the("EditText to write the phone number").located(By.id("phoneTextField"));
    public static final Target ET_NAME = Target.the("EditText to write the name of the payment receipt").located(By.id("nameTextField"));
    public static final Target SR_AMOUNT = Target.the("Slider to put the payment amount").located(By.id("amount"));
    public static final Target ET_COUNTRY = Target.the("EditText to write the receipt country").located(By.id("countryTextField"));
    public static final Target BT_SELECT_COUNTRY = Target.the("Button to display the available receipt countries").located(By.id("countryButton"));
    public static final Target BT_SEND_PAYMENT = Target.the("Button to send a payment").located(By.id("sendPaymentButton"));
    public static final Target BT_CANCEL = Target.the("Button to cancel the payment").located(By.id("cancelButton"));
}

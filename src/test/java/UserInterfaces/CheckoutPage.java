package UserInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage {

    public static final Target Firstname_Locator = Target.the("FirstName field")
            .located(By.id("first-name"));

    public static final Target Lastname_Locator = Target.the("LastName field")
            .located(By.id("last-name"));

    public static final Target ZipCod_Locator = Target.the("Postal Code field")
            .located(By.id("postal-code"));

    public static final Target Continue_Button = Target.the("Continue button")
            .located(By.id("continue"));
    public static final Target finish_Button = Target.the("Finish button")
            .located(By.id("finish"));

    public static final Target ConfirmationMessage_locator = Target.the("Order Confirmation Message")
            .located(By.xpath("//h2[text()='Thank you for your order!']"));
}

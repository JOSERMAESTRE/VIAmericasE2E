package UserInterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {
    public static final Target Username_Field = Target.the("User name").located(By.id("user-name"));
    public static final Target Password_Field = Target.the("Password").located(By.id("password"));
    public static final Target Login_Button = Target.the("Login Button").located(By.id("login-button"));
    public static final Target Inventory_locator = Target.the("Inventory").located(By.id("inventory_container"));
}

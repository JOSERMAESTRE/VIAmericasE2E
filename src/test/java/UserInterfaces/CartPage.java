package UserInterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage extends PageObject {

    public static Target productName(String productName) {
        return Target.the("Product Name in Cart")
                .located(By.xpath(String.format("//div[@class='cart_item']//div[@data-test='inventory-item-name' and text()='%s']", productName)));
    }

    public static Target productPrice(String productName) {
        return Target.the("Product Price in Cart")
                .located(By.xpath(String.format("//div[@class='cart_item']//div[@data-test='inventory-item-name' and text()='%s']/ancestor::div[@class='cart_item_label']//div[@data-test='inventory-item-price']", productName)));
    }

    public static final Target Checkout_Button = Target.the("Checkout Button").located(By.id("checkout"));
}

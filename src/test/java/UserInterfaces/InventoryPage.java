package UserInterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InventoryPage extends PageObject {
    public static Target productName(String productName) {
        return Target.the("Product Name")
                .located(By.xpath(String.format("//div[contains(text(),'%s')]", productName)));
    }

    public static Target productPrice(String productName) {
        return Target.the("Product Price")
                .located(By.xpath(String.format("//div[text()='%s']/ancestor::div[contains(@class,'inventory_item_description')]//div[contains(@class,'inventory_item_price')]", productName)));
    }

    public static Target addToCartButton(String productName) {
        return Target.the("Add to cart button")
                .located(By.xpath(String.format("//div[contains(text(),'%s')]/ancestor::div[contains(@class,'inventory_item')]//button", productName)));
    }
    public static final Target ShoppingCartButton = Target.the("Shopping Cart")
            .located(By.xpath("//a[@class='shopping_cart_link']"));
}

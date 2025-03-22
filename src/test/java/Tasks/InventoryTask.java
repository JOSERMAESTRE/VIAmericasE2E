package Tasks;

import UserInterfaces.InventoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class InventoryTask implements Task {
    public static final String Product_name = "PRODUCT_NAME";
    public static final String Product_price = "PRODUCT_PRICE";
    private final String product;

    public InventoryTask(String Product) {
        this.product = Product;
    }

    public static InventoryTask addProduct(String Product) {
        return instrumented(InventoryTask.class, Product);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String productName = InventoryPage.productName(product).resolveFor(actor).getText();
        String productPrice = InventoryPage.productPrice(product).resolveFor(actor).getText();
        actor.remember("PRODUCT_NAME_" + product, productName);
        actor.remember("PRODUCT_PRICE_" + product, productPrice);

        actor.attemptsTo(
                Click.on(InventoryPage.addToCartButton(product)),
                Click.on(InventoryPage.ShoppingCartButton)
        );

    }
}

package Questions;

import UserInterfaces.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.testng.Assert;

public class VerifyProducts implements Question<Boolean> {
    private final String productName;

    public VerifyProducts(String productName) {
        this.productName = productName;
    }

    public static VerifyProducts hasCorrectProduct(String productName) {
        return new VerifyProducts(productName);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String expectedName = actor.recall("PRODUCT_NAME_" + productName);
        String expectedPrice = actor.recall("PRODUCT_PRICE_" + productName);
        String actualName = CartPage.productName(productName).resolveFor(actor).getText();
        String actualPrice = CartPage.productPrice(productName).resolveFor(actor).getText();

        Assert.assertEquals(expectedName, actualName, "El nombre del producto en el carrito no coincide");
        Assert.assertEquals(expectedPrice, actualPrice, "El precio del producto en el carrito no coincide");

        return true;
    }
}

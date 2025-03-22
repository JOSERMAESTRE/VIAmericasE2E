package Questions;

import UserInterfaces.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class VerifyOrderCompletion implements Question<Boolean> {

    public static VerifyOrderCompletion isDisplayed() {
        return new VerifyOrderCompletion();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            return CheckoutPage.ConfirmationMessage_locator.resolveFor(actor).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

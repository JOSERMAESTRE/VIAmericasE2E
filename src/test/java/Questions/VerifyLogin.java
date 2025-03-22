package Questions;

import UserInterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class VerifyLogin implements Question<Boolean> {
    public static VerifyLogin wasSuccessful(){
        return new VerifyLogin();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            return LoginPage.Inventory_locator.resolveFor(actor).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

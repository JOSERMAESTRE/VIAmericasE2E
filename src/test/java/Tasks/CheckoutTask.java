package Tasks;


import Interactions.EnterUserData;
import UserInterfaces.CartPage;
import UserInterfaces.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CheckoutTask implements Task {
    private final String firstName;
    private final String lastName;
    private final String postalCode;

    public CheckoutTask(String FirstName, String LastName, String ZipCode) {
        this.firstName = FirstName;
        this.lastName = LastName;
        this.postalCode = ZipCode;
    }

    public static CheckoutTask withData(String FirstName, String LastName, String ZipCode) {
        return instrumented(CheckoutTask.class, FirstName, LastName, ZipCode);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CartPage.Checkout_Button),
                EnterUserData.with(firstName,lastName,postalCode),
                Click.on(CheckoutPage.Continue_Button)
        );
    }
}

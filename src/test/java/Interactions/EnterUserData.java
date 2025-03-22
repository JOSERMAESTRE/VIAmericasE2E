package Interactions;

import UserInterfaces.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EnterUserData implements Interaction {
    private final String firstName;
    private final String lastName;
    private final String postalCode;

    public EnterUserData(String FirstName, String LastName, String ZipCode) {
        this.firstName = FirstName;
        this.lastName = LastName;
        this.postalCode = ZipCode;
    }

    public static EnterUserData with(String FirstName, String LastName, String ZipCode) {
        return instrumented(EnterUserData.class, FirstName, LastName, ZipCode);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(firstName).into(CheckoutPage.Firstname_Locator),
                Enter.theValue(lastName).into(CheckoutPage.Lastname_Locator),
                Enter.theValue(postalCode).into(CheckoutPage.ZipCod_Locator)
        );
    }
}

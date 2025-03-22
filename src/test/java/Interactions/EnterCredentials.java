package Interactions;

import UserInterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EnterCredentials implements Interaction {
    private final String username;
    private final String password;

    public EnterCredentials(String Username, String Password) {
        this.username = Username;
        this.password = Password;
    }

    public static EnterCredentials with(String Username, String Password){
        return instrumented(EnterCredentials.class,Username,Password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(LoginPage.Username_Field),
                Enter.theValue(password).into(LoginPage.Password_Field)
        );
    }
}

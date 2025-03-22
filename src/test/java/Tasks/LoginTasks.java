package Tasks;

import Interactions.EnterCredentials;
import UserInterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginTasks implements Task {
    private final String username;
    private final String password;

    public LoginTasks(String Username, String Password) {
        this.username = Username;
        this.password = Password;
    }

    public static LoginTasks withCredentials(String Username, String Password){
        return instrumented(LoginTasks.class,Username,Password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url("https://www.saucedemo.com/"),
                EnterCredentials.with(username,password),
                Click.on(LoginPage.Login_Button)
        );
    }
}

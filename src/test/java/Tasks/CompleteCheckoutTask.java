package Tasks;

import UserInterfaces.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CompleteCheckoutTask implements Task {

    public static CompleteCheckoutTask finalizeOrder() {
        return instrumented(CompleteCheckoutTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CheckoutPage.finish_Button)
        );
    }
}

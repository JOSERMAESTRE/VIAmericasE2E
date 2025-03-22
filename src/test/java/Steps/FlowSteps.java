package Steps;

import Questions.VerifyLogin;
import Questions.VerifyOrderCompletion;
import Questions.VerifyProducts;
import Tasks.CheckoutTask;
import Tasks.CompleteCheckoutTask;
import Tasks.InventoryTask;
import Tasks.LoginTasks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.is;
public class FlowSteps {

    @Given("User is on login page")
    public void User_is_on_login_page(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("User");
    }

    @When("User enters {string} and {string} and clicks login button")
    public void User_enters_valid_credentials_and_clicks_login_button(String username,String password){
        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginTasks.withCredentials(username,password)
        );
    }

    @Then("The inventory is displayed")
    public void The_inventory_is_displayed(){
        OnStage.theActorInTheSpotlight().should(
                seeThat(VerifyLogin.wasSuccessful(), is(true))
        );
    }

    @Then("User adds product {string} to cart")
    public void User_adds_product_to_cart(String Product){
        OnStage.theActorInTheSpotlight().attemptsTo(
                InventoryTask.addProduct(Product)
        );
    }

    @Then("User goes to the cart and verifies product {string}")
    public void user_goes_to_cart_and_verifies_product(String productName) {
             OnStage.theActorInTheSpotlight().should(
                seeThat(VerifyProducts.hasCorrectProduct(productName))
        );
    }

    @Then("User proceeds to checkout with first name {string}, last name {string}, and postal code {string}")
    public void user_proceeds_to_checkout(String firstName, String lastName, String zipCode) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CheckoutTask.withData(firstName,lastName,zipCode)
        );
    }

    @Then("User completes the checkout process")
    public void user_completes_the_checkout_process() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                CompleteCheckoutTask.finalizeOrder()
        );
    }

    @Then("The order confirmation message is displayed")
    public void the_order_confirmation_message_is_displayed() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(VerifyOrderCompletion.isDisplayed(), is(true))
        );
    }
}

package com.sebastian.automationexercise.steps;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

import com.sebastian.automationexercise.screenplay.questions.CartContents;
import com.sebastian.automationexercise.screenplay.tasks.AddProductToCart;
import com.sebastian.automationexercise.screenplay.tasks.NavigateToCart;
import com.sebastian.automationexercise.screenplay.tasks.RemoveProductFromCart;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

/**
 * Step definitions for shopping cart management scenarios.
 * Handles adding, removing, and viewing products in the shopping cart.
 */
public class ShoppingCartSteps {

    /**
     * Adds a product to the cart as a precondition (Given context).
     */
    @Given("I have added a product to the cart")
    public void givenIHaveAddedAProductToTheCart() {
        Actor user = StepContext.getCurrentActor();
        user.attemptsTo(AddProductToCart.firstProduct());
    }

    /**
     * Adds a product to the cart as an action (When context).
     */
    @When("I add a product to the cart")
    public void iAddAProductToTheCart() {
        Actor user = StepContext.getCurrentActor();
        user.attemptsTo(AddProductToCart.firstProduct());
    }

    /**
     * Adds a different product to the cart.
     */
    @When("I add another different product")
    public void iAddAnotherDifferentProduct() {
        Actor user = StepContext.getCurrentActor();
        user.attemptsTo(AddProductToCart.secondProduct());
    }

    /**
     * Navigates to the shopping cart.
     */
    @When("I go to the shopping cart")
    public void iGoToTheShoppingCart() {
        Actor user = StepContext.getCurrentActor();
        user.attemptsTo(NavigateToCart.now());
    }

    /**
     * Navigates to the shopping cart (alternative phrasing).
     */
    @When("I navigate to the shopping cart")
    public void iNavigateToTheShoppingCart() {
        Actor user = StepContext.getCurrentActor();
        user.attemptsTo(NavigateToCart.now());
    }

    /**
     * Removes one of the products from the cart.
     */
    @When("I remove one of the products")
    public void iRemoveOneOfTheProducts() {
        Actor user = StepContext.getCurrentActor();
        user.attemptsTo(RemoveProductFromCart.firstProduct());
    }

    /**
     * Verifies that the product is displayed in the cart.
     */
    @Then("the product is displayed in the cart")
    public void theProductIsDisplayedInTheCart() {
        Actor user = StepContext.getCurrentActor();
        user.attemptsTo(NavigateToCart.now());
        user.should(seeThat(CartContents.hasProducts(), equalTo(true)));
    }

    /**
     * Verifies that both products are visible in the cart list.
     */
    @Then("I can see both products in the cart list")
    public void iCanSeeBothProductsInTheCartList() {
        Actor user = StepContext.getCurrentActor();
        user.attemptsTo(NavigateToCart.now());
        user.should(seeThat(CartContents.hasMultipleProducts(), equalTo(true)));
    }

    /**
     * Verifies that the product is no longer visible in the cart after removal.
     */
    @Then("the product is no longer visible in the cart")
    public void theProductIsNoLongerVisibleInTheCart() {
        Actor user = StepContext.getCurrentActor();
        user.should(seeThat(CartContents.doesNotHaveProduct(), equalTo(true)));
    }

    /**
     * Verifies that the list with added products is visible.
     */
    @Then("I can see the list with the added products")
    public void iCanSeeTheListWithTheAddedProducts() {
        Actor user = StepContext.getCurrentActor();
        user.should(seeThat(CartContents.showsProductList(), equalTo(true)));
    }

    /**
     * Verifies that the cart is empty.
     */
    @Then("the cart is empty")
    public void theCartIsEmpty() {
        Actor user = StepContext.getCurrentActor();
        user.should(seeThat(CartContents.isEmpty(), equalTo(true)));
    }
}

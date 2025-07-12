package com.sebastian.automationexercise.steps;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

import com.sebastian.automationexercise.screenplay.questions.HomePageVisibility;
import com.sebastian.automationexercise.screenplay.questions.LoginPageVisibility;
import com.sebastian.automationexercise.screenplay.questions.ProductsPageVisibility;
import com.sebastian.automationexercise.screenplay.tasks.Navigate;
import com.sebastian.automationexercise.screenplay.tasks.NavigateToProducts;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;

/**
 * Step definitions for navigation-related scenarios.
 * Handles all navigation between different pages of the application.
 */
public class NavigationSteps {

    /**
     * Navigates the user to the home page of the application.
     */
    @Given("User navigates to the home page")
    public void userNavigatesToTheHomePage() {
        Actor user = StepContext.getCurrentActor();
        user.attemptsTo(Navigate.toHomePage());
    }

    /**
     * Navigates to the products section of the application.
     */
    @Given("I am on the products section")
    public void iAmOnTheProductsSection() {
        Actor user = StepContext.getCurrentActor();
        user.attemptsTo(
            Navigate.toHomePage(),
            NavigateToProducts.now()
        );
        user.should(seeThat(ProductsPageVisibility.isVisible(), equalTo(true)));
    }

    /**
     * Verifies that the user can see the home page.
     */
    @Then("User should see the home page")
    public void userShouldSeeTheHomePage() {
        Actor user = StepContext.getCurrentActor();
        user.should(seeThat(HomePageVisibility.isVisible(), equalTo(true)));
    }

    /**
     * Verifies that the user is redirected to the login page.
     */
    @Then("User is redirected to the login page")
    public void userIsRedirectedToTheLoginPage() {
        Actor user = StepContext.getCurrentActor();
        user.should(seeThat(LoginPageVisibility.isVisible(), equalTo(true)));
    }
}

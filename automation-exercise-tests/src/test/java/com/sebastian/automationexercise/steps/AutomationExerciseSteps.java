package com.sebastian.automationexercise.steps;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

import com.sebastian.automationexercise.screenplay.actors.Users;
import com.sebastian.automationexercise.screenplay.questions.BannerText;
import com.sebastian.automationexercise.screenplay.questions.CartContents;
import com.sebastian.automationexercise.screenplay.questions.ErrorMessage;
import com.sebastian.automationexercise.screenplay.questions.HomePageVisibility;
import com.sebastian.automationexercise.screenplay.questions.LoginPageVisibility;
import com.sebastian.automationexercise.screenplay.questions.LoggedInStatus;
import com.sebastian.automationexercise.screenplay.questions.ProductsPageVisibility;
import com.sebastian.automationexercise.screenplay.tasks.AddProductToCart;
import com.sebastian.automationexercise.screenplay.tasks.ContinueToHomePage;
import com.sebastian.automationexercise.screenplay.tasks.DeleteAccount;
import com.sebastian.automationexercise.screenplay.tasks.Login;
import com.sebastian.automationexercise.screenplay.tasks.Logout;
import com.sebastian.automationexercise.screenplay.tasks.Navigate;
import com.sebastian.automationexercise.screenplay.tasks.NavigateToCart;
import com.sebastian.automationexercise.screenplay.tasks.NavigateToProducts;
import com.sebastian.automationexercise.screenplay.tasks.Register;
import com.sebastian.automationexercise.screenplay.tasks.RemoveProductFromCart;
import com.sebastian.automationexercise.screenplay.tasks.SignupWithExistingEmail;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import java.util.List;
import java.util.Map;

/**
 * Step definitions for the automation exercise test scenarios.
 */
public class AutomationExerciseSteps {

  private Actor user;
  private Register registrationTask;

  @Before
  public void setUpActor() {
    user = Users.user();
  }

  @Given("User navigates to the home page")
  public void userNavigatesToTheHomePage() {
    user.attemptsTo(Navigate.toHomePage());
  }

  @When("User signs up with fresh random credentials")
  public void userSignsUpWithFreshRandomCredentials() {
    registrationTask = Register.withRandomData();
    user.attemptsTo(registrationTask);
  }

  @When("User logs in with valid credentials")
  public void userLogsInWithValidCredentials(DataTable dataTable) {
    List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
    Map<String, String> credential = credentials.get(0);
    
    user.attemptsTo(
        Login.withCredentials(credential.get("email"), credential.get("password"))
    );
  }

  @When("User attempts to log in with invalid credentials")
  public void userAttemptsToLogInWithInvalidCredentials(DataTable dataTable) {
    List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
    Map<String, String> credential = credentials.get(0);
    
    user.attemptsTo(
        Login.withCredentials(credential.get("email"), credential.get("password"))
    );
  }

  @When("User attempts to register with existing email")
  public void userAttemptsToRegisterWithExistingEmail(DataTable dataTable) {
    List<Map<String, String>> userInfo = dataTable.asMaps(String.class, String.class);
    Map<String, String> info = userInfo.get(0);
    
    user.attemptsTo(SignupWithExistingEmail.withCredentials(info.get("name"), info.get("email")));
  }

  @When("User logs out")
  public void userLogsOut() {
    user.attemptsTo(Logout.now());
  }

  @When("User deletes the account")
  public void userDeletesTheAccount() {
    user.attemptsTo(DeleteAccount.confirm());
  }

  @Then("^\"([^\"]*)\" banner is visible$")
  public void bannerIsVisible(String bannerText) {
    user.should(seeThat(BannerText.isVisible(bannerText), equalTo(true)));
  }

  @And("User continues to the home page")
  public void userContinuesToTheHomePage() {
    user.attemptsTo(ContinueToHomePage.after());
  }

  @And("^\"([^\"]*)\" label displays the username \"([^\"]*)\"$")
  public void labelDisplaysTheUsername(String label, String username) {
    user.should(seeThat(LoggedInStatus.showsUsername(username), equalTo(true)));
  }

  @And("^\"([^\"]*)\" label displays the username$")
  public void labelDisplaysTheUsername(String label) {
    if (registrationTask != null) {
      user.should(seeThat(LoggedInStatus.showsUsername(registrationTask.getName()), equalTo(true)));
    } else {
      user.should(seeThat(LoggedInStatus.isLoggedIn(), equalTo(true)));
    }
  }

  @And("User is successfully logged in")
  public void userIsSuccessfullyLoggedIn() {
    user.should(seeThat(LoggedInStatus.isLoggedIn(), equalTo(true)));
  }

  @Then("A login error message is displayed")
  public void aLoginErrorMessageIsDisplayed() {
    user.should(seeThat(ErrorMessage.isDisplayed(), equalTo(true)));
  }

  @Then("A signup error message is displayed")
  public void aSignupErrorMessageIsDisplayed() {
    user.should(seeThat(ErrorMessage.isDisplayed(), equalTo(true)));
  }

  @And("User remains on the login page")
  public void userRemainsOnTheLoginPage() {
    // Verify that user is not logged in (no username display)
    user.should(seeThat(LoggedInStatus.isLoggedIn(), equalTo(false)));
  }

  @And("User remains on the signup page")
  public void userRemainsOnTheSignupPage() {
    // Verify that user is not logged in (no username display)
    user.should(seeThat(LoggedInStatus.isLoggedIn(), equalTo(false)));
  }

  @Then("User is redirected to the login page")
  public void userIsRedirectedToTheLoginPage() {
    user.should(seeThat(LoginPageVisibility.isVisible(), equalTo(true)));
  }

  @And("User is no longer logged in")
  public void userIsNoLongerLoggedIn() {
    user.should(seeThat(LoggedInStatus.isLoggedIn(), equalTo(false)));
  }

  @Then("User should see the home page")
  public void userShouldSeeTheHomePage() {
    user.should(seeThat(HomePageVisibility.isVisible(), equalTo(true)));
  }

  // Shopping Cart Step Definitions

  @Given("I am on the products section")
  public void iAmOnTheProductsSection() {
    user.attemptsTo(
        Navigate.toHomePage(),
        NavigateToProducts.now()
    );
    user.should(seeThat(ProductsPageVisibility.isVisible(), equalTo(true)));
  }

  @When("I add a product to the cart")
  public void iAddAProductToTheCart() {
    user.attemptsTo(AddProductToCart.firstProduct());
  }

  @When("I add another different product")
  public void iAddAnotherDifferentProduct() {
    user.attemptsTo(AddProductToCart.secondProduct());
  }

  @When("I go to the shopping cart")
  public void iGoToTheShoppingCart() {
    user.attemptsTo(NavigateToCart.now());
  }

  @When("I navigate to the shopping cart")
  public void iNavigateToTheShoppingCart() {
    user.attemptsTo(NavigateToCart.now());
  }

  @When("I remove one of the products")
  public void iRemoveOneOfTheProducts() {
    user.attemptsTo(RemoveProductFromCart.firstProduct());
  }

  @Then("the product is displayed in the cart")
  public void theProductIsDisplayedInTheCart() {
    user.attemptsTo(NavigateToCart.now());
    user.should(seeThat(CartContents.hasProducts(), equalTo(true)));
  }

  @Then("I can see both products in the cart list")
  public void iCanSeeBothProductsInTheCartList() {
    user.attemptsTo(NavigateToCart.now());
    user.should(seeThat(CartContents.hasMultipleProducts(), equalTo(true)));
  }

  @Then("the product is no longer visible in the cart")
  public void theProductIsNoLongerVisibleInTheCart() {
    user.should(seeThat(CartContents.doesNotHaveProduct(), equalTo(true)));
  }

  @Then("I can see the list with the added products")
  public void iCanSeeTheListWithTheAddedProducts() {
    user.should(seeThat(CartContents.showsProductList(), equalTo(true)));
  }
}

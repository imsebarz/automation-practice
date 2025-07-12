package com.sebastian.automationexercise.steps;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

import com.sebastian.automationexercise.screenplay.questions.BannerText;
import com.sebastian.automationexercise.screenplay.questions.ErrorMessage;
import com.sebastian.automationexercise.screenplay.questions.LoggedInStatus;
import com.sebastian.automationexercise.screenplay.tasks.ContinueToHomePage;
import com.sebastian.automationexercise.screenplay.tasks.DeleteAccount;
import com.sebastian.automationexercise.screenplay.tasks.Register;
import com.sebastian.automationexercise.screenplay.tasks.SignupWithExistingEmail;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import java.util.List;
import java.util.Map;

/**
 * Step definitions for user registration scenarios.
 * Handles user signup, account creation, and related validations.
 */
public class RegistrationSteps {

    private Register registrationTask;

    /**
     * Performs user registration with fresh random credentials.
     */
    @When("User signs up with fresh random credentials")
    public void userSignsUpWithFreshRandomCredentials() {
        Actor user = StepContext.getCurrentActor();
        registrationTask = Register.withRandomData();
        user.attemptsTo(registrationTask);
    }

    /**
     * Attempts to register with an existing email address.
     * 
     * @param dataTable Table containing name and email for registration
     */
    @When("User attempts to register with existing email")
    public void userAttemptsToRegisterWithExistingEmail(DataTable dataTable) {
        Actor user = StepContext.getCurrentActor();
        Map<String, String> userInfo = extractUserInfoFromTable(dataTable);
        
        user.attemptsTo(
            SignupWithExistingEmail.withCredentials(
                userInfo.get("name"), 
                userInfo.get("email")
            )
        );
    }

    /**
     * Deletes the user account.
     */
    @When("User deletes the account")
    public void userDeletesTheAccount() {
        Actor user = StepContext.getCurrentActor();
        user.attemptsTo(DeleteAccount.confirm());
    }

    /**
     * Verifies that a specific banner text is visible.
     * 
     * @param bannerText The expected banner text
     */
    @Then("^\"([^\"]*)\" banner is visible$")
    public void bannerIsVisible(String bannerText) {
        Actor user = StepContext.getCurrentActor();
        user.should(seeThat(BannerText.isVisible(bannerText), equalTo(true)));
    }

    /**
     * Continues to the home page after registration.
     */
    @And("User continues to the home page")
    public void userContinuesToTheHomePage() {
        Actor user = StepContext.getCurrentActor();
        user.attemptsTo(ContinueToHomePage.after());
    }

    /**
     * Verifies that the login status label displays the username from registration.
     * 
     * @param label The label identifier (e.g., "Logged in as")
     */
    @And("^\"([^\"]*)\" label displays the username$")
    public void labelDisplaysTheUsername(String label) {
        Actor user = StepContext.getCurrentActor();
        
        if (registrationTask != null) {
            user.should(seeThat(LoggedInStatus.showsUsername(registrationTask.getName()), equalTo(true)));
        } else {
            user.should(seeThat(LoggedInStatus.isLoggedIn(), equalTo(true)));
        }
    }

    /**
     * Verifies that the user remains on the signup page (registration failed).
     */
    @And("User remains on the signup page")
    public void userRemainsOnTheSignupPage() {
        Actor user = StepContext.getCurrentActor();
        user.should(seeThat(LoggedInStatus.isLoggedIn(), equalTo(false)));
    }

    /**
     * Verifies that a signup error message is displayed.
     */
    @Then("A signup error message is displayed")
    public void aSignupErrorMessageIsDisplayed() {
        Actor user = StepContext.getCurrentActor();
        user.should(seeThat(ErrorMessage.isDisplayed(), equalTo(true)));
    }

    /**
     * Extracts user information from the data table.
     * 
     * @param dataTable The data table containing user information
     * @return Map with name and email
     * @throws IllegalArgumentException if the table is empty or malformed
     */
    private Map<String, String> extractUserInfoFromTable(DataTable dataTable) {
        List<Map<String, String>> userInfoList = dataTable.asMaps(String.class, String.class);
        
        if (userInfoList.isEmpty()) {
            throw new IllegalArgumentException("User info table cannot be empty");
        }
        
        Map<String, String> userInfo = userInfoList.get(0);
        
        if (!userInfo.containsKey("name") || !userInfo.containsKey("email")) {
            throw new IllegalArgumentException("User info table must contain 'name' and 'email' columns");
        }
        
        return userInfo;
    }
}

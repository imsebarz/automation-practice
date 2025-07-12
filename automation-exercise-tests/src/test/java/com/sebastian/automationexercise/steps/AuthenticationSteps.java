package com.sebastian.automationexercise.steps;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

import com.sebastian.automationexercise.screenplay.questions.ErrorMessage;
import com.sebastian.automationexercise.screenplay.questions.LoggedInStatus;
import com.sebastian.automationexercise.screenplay.tasks.Login;
import com.sebastian.automationexercise.screenplay.tasks.Logout;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import java.util.List;
import java.util.Map;

/**
 * Step definitions for user authentication scenarios.
 * Handles login, logout, and related authentication validations.
 */
public class AuthenticationSteps {

    /**
     * Performs login with valid credentials provided in a data table.
     * 
     * @param dataTable Table containing email and password credentials
     */
    @When("User logs in with valid credentials")
    public void userLogsInWithValidCredentials(DataTable dataTable) {
        Actor user = StepContext.getCurrentActor();
        Map<String, String> credentials = extractCredentialsFromTable(dataTable);
        
        user.attemptsTo(
            Login.withCredentials(credentials.get("email"), credentials.get("password"))
        );
    }

    /**
     * Attempts to log in with invalid credentials provided in a data table.
     * 
     * @param dataTable Table containing invalid email and password credentials
     */
    @When("User attempts to log in with invalid credentials")
    public void userAttemptsToLogInWithInvalidCredentials(DataTable dataTable) {
        Actor user = StepContext.getCurrentActor();
        Map<String, String> credentials = extractCredentialsFromTable(dataTable);
        
        user.attemptsTo(
            Login.withCredentials(credentials.get("email"), credentials.get("password"))
        );
    }

    /**
     * Performs logout operation.
     */
    @When("User logs out")
    public void userLogsOut() {
        Actor user = StepContext.getCurrentActor();
        user.attemptsTo(Logout.now());
    }

    /**
     * Verifies that the login status label displays the specified username.
     * 
     * @param label The label identifier (e.g., "Logged in as")
     * @param username The expected username to be displayed
     */
    @And("^\"([^\"]*)\" label displays the username \"([^\"]*)\"$")
    public void labelDisplaysTheUsername(String label, String username) {
        Actor user = StepContext.getCurrentActor();
        user.should(seeThat(LoggedInStatus.showsUsername(username), equalTo(true)));
    }

    /**
     * Verifies that the user is successfully logged in.
     */
    @And("User is successfully logged in")
    public void userIsSuccessfullyLoggedIn() {
        Actor user = StepContext.getCurrentActor();
        user.should(seeThat(LoggedInStatus.isLoggedIn(), equalTo(true)));
    }

    /**
     * Verifies that the user is no longer logged in after logout.
     */
    @And("User is no longer logged in")
    public void userIsNoLongerLoggedIn() {
        Actor user = StepContext.getCurrentActor();
        user.should(seeThat(LoggedInStatus.isLoggedIn(), equalTo(false)));
    }

    /**
     * Verifies that the user remains on the login page (not logged in).
     */
    @And("User remains on the login page")
    public void userRemainsOnTheLoginPage() {
        Actor user = StepContext.getCurrentActor();
        user.should(seeThat(LoggedInStatus.isLoggedIn(), equalTo(false)));
    }

    /**
     * Verifies that a login error message is displayed.
     */
    @Then("A login error message is displayed")
    public void aLoginErrorMessageIsDisplayed() {
        Actor user = StepContext.getCurrentActor();
        user.should(seeThat(ErrorMessage.isDisplayed(), equalTo(true)));
    }

    /**
     * Extracts credentials from the data table.
     * 
     * @param dataTable The data table containing credentials
     * @return Map with email and password
     * @throws IllegalArgumentException if the table is empty or malformed
     */
    private Map<String, String> extractCredentialsFromTable(DataTable dataTable) {
        List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
        
        if (credentials.isEmpty()) {
            throw new IllegalArgumentException("Credentials table cannot be empty");
        }
        
        Map<String, String> credential = credentials.get(0);
        
        if (!credential.containsKey("email") || !credential.containsKey("password")) {
            throw new IllegalArgumentException("Credentials table must contain 'email' and 'password' columns");
        }
        
        return credential;
    }
}

package com.sebastian.automationexercise.screenplay.tasks;

import static com.sebastian.automationexercise.ui.HomePage.SIGNUP_LOGIN_LINK;
import static com.sebastian.automationexercise.ui.LoginPage.SIGNUP_BUTTON;
import static com.sebastian.automationexercise.ui.LoginPage.SIGNUP_EMAIL_FIELD;
import static com.sebastian.automationexercise.ui.LoginPage.SIGNUP_NAME_FIELD;

import com.sebastian.automationexercise.screenplay.interactions.CompleteSignup;
import com.sebastian.automationexercise.screenplay.interactions.FillRegistrationForm;
import com.sebastian.automationexercise.screenplay.interactions.NavigateTo;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

/**
 * Task for registering a new user account.
 */
public class Register implements Task {

  private static final String DEFAULT_PASSWORD = "S3curePwd_2025";
  
  private final String name;
  private final String email;

  private Register(String name, String email) {
    this.name = name;
    this.email = email;
  }

  /**
   * Creates a registration task with random generated data.
   *
   * @return a Register task with unique credentials
   */
  public static Register withRandomData() {
    long timestamp = System.currentTimeMillis();
    String uniqueName = "TestUser" + timestamp;
    String uniqueEmail = "testuser" + timestamp + "@example.com";
    return new Register(uniqueName, uniqueEmail);
  }

  /**
   * Creates a registration task with specific credentials.
   *
   * @param name the user's name
   * @param email the user's email
   * @return a Register task with the specified credentials
   */
  public static Register withCredentials(String name, String email) {
    return new Register(name, email);
  }

  @Override
  @Step("{0} registers with name '#name' and email '#email'")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        // Navigate to signup page and complete initial signup
        NavigateTo.page(SIGNUP_LOGIN_LINK),
        CompleteSignup.with(name, email, SIGNUP_NAME_FIELD, SIGNUP_EMAIL_FIELD, SIGNUP_BUTTON),
        
        // Fill complete registration form
        FillRegistrationForm.builder()
            .firstName("John")
            .lastName("Doe")
            .password(DEFAULT_PASSWORD)
            .birthDate("1", "January", "1990")
            .address("123 Test Street")
            .country("United States")
            .state("California")
            .city("Los Angeles")
            .zipcode("90210")
            .mobileNumber("1234567890")
            .build()
    );
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }
}

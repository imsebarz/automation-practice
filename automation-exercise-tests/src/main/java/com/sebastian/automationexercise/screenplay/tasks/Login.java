package com.sebastian.automationexercise.screenplay.tasks;

import static com.sebastian.automationexercise.ui.HomePage.SIGNUP_LOGIN_LINK;
import static com.sebastian.automationexercise.ui.LoginPage.LOGIN_BUTTON;
import static com.sebastian.automationexercise.ui.LoginPage.LOGIN_EMAIL_FIELD;
import static com.sebastian.automationexercise.ui.LoginPage.LOGIN_PASSWORD_FIELD;

import com.sebastian.automationexercise.screenplay.interactions.EnterCredentials;
import com.sebastian.automationexercise.screenplay.interactions.NavigateTo;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

/**
 * Task for logging into the application.
 */
public class Login implements Task {

  private final String email;
  private final String password;

  private Login(String email, String password) {
    this.email = email;
    this.password = password;
  }

  /**
   * Creates a login task with the specified credentials.
   *
   * @param email the user's email
   * @param password the user's password
   * @return a Login task with the specified credentials
   */
  public static Login withCredentials(String email, String password) {
    return new Login(email, password);
  }

  /**
   * Creates a login task with existing test account credentials.
   *
   * @return a Login task with predefined test account credentials
   */
  public static Login withExistingAccount() {
    return new Login("existing_user@example.com", "S3curePwd_2025");
  }

  /**
   * Creates a login task with invalid credentials for testing failure scenarios.
   *
   * @return a Login task with invalid credentials
   */
  public static Login withInvalidCredentials() {
    return new Login("invalid@example.com", "wrongpassword");
  }

  @Override
  @Step("{0} logs in with email '#email'")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        NavigateTo.page(SIGNUP_LOGIN_LINK),
        EnterCredentials.of(email, password, LOGIN_EMAIL_FIELD, LOGIN_PASSWORD_FIELD),
        Click.on(LOGIN_BUTTON)
    );
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }
}

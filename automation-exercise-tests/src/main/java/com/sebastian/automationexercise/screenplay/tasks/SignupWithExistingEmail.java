package com.sebastian.automationexercise.screenplay.tasks;

import static com.sebastian.automationexercise.ui.HomePage.SIGNUP_LOGIN_LINK;
import static com.sebastian.automationexercise.ui.LoginPage.SIGNUP_BUTTON;
import static com.sebastian.automationexercise.ui.LoginPage.SIGNUP_EMAIL_FIELD;
import static com.sebastian.automationexercise.ui.LoginPage.SIGNUP_NAME_FIELD;

import com.sebastian.automationexercise.screenplay.interactions.CompleteSignup;
import com.sebastian.automationexercise.screenplay.interactions.NavigateTo;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

/**
 * Task for attempting to sign up with an existing email.
 * This task only fills the initial signup form and stops there,
 * expecting an error message instead of proceeding to the full registration form.
 */
public class SignupWithExistingEmail implements Task {

  private final String name;
  private final String email;

  private SignupWithExistingEmail(String name, String email) {
    this.name = name;
    this.email = email;
  }

  /**
   * Creates a signup task for attempting registration with existing email.
   *
   * @param name the user's name
   * @param email the existing email address
   * @return a SignupWithExistingEmail task
   */
  public static SignupWithExistingEmail withCredentials(String name, String email) {
    return new SignupWithExistingEmail(name, email);
  }

  @Override
  @Step("{0} attempts signup with existing email '#email'")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        // Navigate to signup page and attempt signup (should show error)
        NavigateTo.page(SIGNUP_LOGIN_LINK),
        CompleteSignup.with(name, email, SIGNUP_NAME_FIELD, SIGNUP_EMAIL_FIELD, SIGNUP_BUTTON)
    );
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }
}

package com.sebastian.automationexercise.screenplay.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.annotations.Step;

/**
 * Interaction for entering login credentials.
 */
public class EnterCredentials implements Interaction {

  private final String email;
  private final String password;
  private final Target emailField;
  private final Target passwordField;

  private EnterCredentials(String email, String password, Target emailField, Target passwordField) {
    this.email = email;
    this.password = password;
    this.emailField = emailField;
    this.passwordField = passwordField;
  }

  /**
   * Creates an interaction to enter credentials into specified fields.
   *
   * @param email the email to enter
   * @param password the password to enter
   * @param emailField the target email field
   * @param passwordField the target password field
   * @return an EnterCredentials interaction
   */
  public static EnterCredentials of(String email, String password, Target emailField, Target passwordField) {
    return new EnterCredentials(email, password, emailField, passwordField);
  }

  @Override
  @Step("{0} enters credentials with email '#email'")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Enter.theValue(email).into(emailField),
        Enter.theValue(password).into(passwordField)
    );
  }
}

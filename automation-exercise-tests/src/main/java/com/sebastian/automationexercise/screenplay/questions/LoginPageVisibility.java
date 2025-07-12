package com.sebastian.automationexercise.screenplay.questions;

import static com.sebastian.automationexercise.ui.LoginPage.LOGIN_HEADER;
import static com.sebastian.automationexercise.ui.LoginPage.NEW_USER_SIGNUP_HEADER;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

/**
 * Questions related to the login page visibility and state.
 */
public final class LoginPageVisibility implements Question<Boolean> {

  private LoginPageVisibility() {
    // Private constructor for static factory methods
  }

  /**
   * Checks if the login page is visible.
   *
   * @return a Question that returns true if the login page is visible
   */
  public static Question<Boolean> isVisible() {
    return new LoginPageVisibility();
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    return Visibility.of(LOGIN_HEADER).answeredBy(actor) 
        && Visibility.of(NEW_USER_SIGNUP_HEADER).answeredBy(actor);
  }
}

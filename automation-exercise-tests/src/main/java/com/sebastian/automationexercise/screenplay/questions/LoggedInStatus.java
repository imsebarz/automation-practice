package com.sebastian.automationexercise.screenplay.questions;

import static com.sebastian.automationexercise.ui.HomePage.USERNAME_DISPLAY;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;

/**
 * Questions related to user login status and display.
 */
public final class LoggedInStatus implements Question<Boolean> {

  private final String expectedUsername;

  private LoggedInStatus(String expectedUsername) {
    this.expectedUsername = expectedUsername;
  }

  /**
   * Checks if the user is logged in and the correct username is displayed.
   *
   * @param username the expected username to be displayed
   * @return a Question that returns true if the user is logged in with the correct username
   */
  public static Question<Boolean> showsUsername(String username) {
    return new LoggedInStatus(username);
  }

  /**
   * Checks if any user is logged in (username display is visible).
   *
   * @return a Question that returns true if any user is logged in
   */
  public static Question<Boolean> isLoggedIn() {
    return actor -> Visibility.of(USERNAME_DISPLAY).answeredBy(actor);
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    if (!Visibility.of(USERNAME_DISPLAY).answeredBy(actor)) {
      return false;
    }
    
    String displayedUsername = Text.of(USERNAME_DISPLAY).answeredBy(actor);
    return displayedUsername.equals(expectedUsername);
  }
}

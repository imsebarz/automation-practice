package com.sebastian.automationexercise.screenplay.questions;

import static com.sebastian.automationexercise.ui.LoginPage.LOGIN_ERROR_MESSAGE;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;

/**
 * Questions related to error message visibility and content.
 */
public final class ErrorMessage implements Question<Boolean> {

  private final String expectedMessage;

  private ErrorMessage(String expectedMessage) {
    this.expectedMessage = expectedMessage;
  }

  /**
   * Checks if the specified error message is visible.
   *
   * @param message the expected error message
   * @return a Question that returns true if the error message is visible
   */
  public static Question<Boolean> isVisible(String message) {
    return new ErrorMessage(message);
  }

  /**
   * Checks if any login error message is visible.
   *
   * @return a Question that returns true if any login error message is visible
   */
  public static Question<Boolean> isDisplayed() {
    return actor -> Visibility.of(LOGIN_ERROR_MESSAGE).answeredBy(actor);
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    if (!Visibility.of(LOGIN_ERROR_MESSAGE).answeredBy(actor)) {
      return false;
    }
    
    String actualMessage = Text.of(LOGIN_ERROR_MESSAGE).answeredBy(actor);
    return actualMessage.contains(expectedMessage);
  }
}

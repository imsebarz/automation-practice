package com.sebastian.automationexercise.screenplay.interactions;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

/**
 * Interaction for handling modal dialogs (close or continue actions).
 */
public class HandleModal implements Interaction {

  private final Target primaryButton;
  private final Target fallbackButton;
  private final String action;

  private HandleModal(Target primaryButton, Target fallbackButton, String action) {
    this.primaryButton = primaryButton;
    this.fallbackButton = fallbackButton;
    this.action = action;
  }

  /**
   * Creates an interaction to handle modal with primary and fallback buttons.
   *
   * @param primaryButton the primary button to try first
   * @param fallbackButton the fallback button if primary fails
   * @param action description of the action being performed
   * @return a HandleModal interaction
   */
  public static HandleModal with(Target primaryButton, Target fallbackButton, String action) {
    return new HandleModal(primaryButton, fallbackButton, action);
  }

  /**
   * Creates an interaction to close a modal.
   *
   * @param closeButton the close button
   * @return a HandleModal interaction for closing
   */
  public static HandleModal close(Target closeButton) {
    return new HandleModal(closeButton, null, "close modal");
  }

  @Override
  @Step("{0} handles modal: {action}")
  public <T extends Actor> void performAs(T actor) {
    try {
      // Wait for modal and click primary button
      actor.attemptsTo(
          WaitUntil.the(primaryButton, isVisible()).forNoMoreThan(5).seconds(),
          Click.on(primaryButton)
      );
    } catch (Exception primaryException) {
      if (fallbackButton != null) {
        try {
          // Try fallback button
          actor.attemptsTo(Click.on(fallbackButton));
        } catch (Exception fallbackException) {
          // Modal might not exist, continue silently
        }
      }
    }
  }
}

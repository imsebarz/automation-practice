package com.sebastian.automationexercise.screenplay.tasks;

import static com.sebastian.automationexercise.ui.HomePage.CONTINUE_BUTTON;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

/**
 * Task for continuing to the home page after account operations.
 */
public class ContinueToHomePage implements Task {

  public ContinueToHomePage() {
    // Public default constructor for Serenity instrumentation
  }

  /**
   * Creates a task to continue to the home page.
   *
   * @return a ContinueToHomePage task
   */
  public static ContinueToHomePage after() {
    return new ContinueToHomePage();
  }

  @Override
  @Step("{0} continues to the home page")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Click.on(CONTINUE_BUTTON)
    );
  }
}

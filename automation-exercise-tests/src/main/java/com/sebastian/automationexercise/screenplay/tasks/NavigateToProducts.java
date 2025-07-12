package com.sebastian.automationexercise.screenplay.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Performable;

/**
 * Task for navigating to the products section.
 */
public class NavigateToProducts implements Task {

  @Override
  @Step("{0} navigates to the products section")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Navigate.toUrl("https://automationexercise.com/products"));
  }

  /**
   * Creates a task to navigate to the products section.
   *
   * @return a NavigateToProducts task
   */
  public static Performable now() {
    return new NavigateToProducts();
  }
}

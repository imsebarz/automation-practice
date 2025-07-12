package com.sebastian.automationexercise.screenplay.tasks;

import static com.sebastian.automationexercise.ui.HomePage.LOGOUT_LINK;

import com.sebastian.automationexercise.screenplay.interactions.NavigateTo;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

/**
 * Task for logging out of the application.
 */
public class Logout implements Task {

  public Logout() {
    // Public default constructor for Serenity instrumentation
  }

  /**
   * Creates a logout task.
   *
   * @return a Logout task
   */
  public static Logout now() {
    return new Logout();
  }

  @Override
  @Step("{0} logs out")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        NavigateTo.element(LOGOUT_LINK, "logout")
    );
  }
}

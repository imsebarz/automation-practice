package com.sebastian.automationexercise.screenplay.tasks;

import static com.sebastian.automationexercise.ui.HomePage.DELETE_ACCOUNT_LINK;

import com.sebastian.automationexercise.screenplay.interactions.NavigateTo;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

/**
 * Task for deleting a user account.
 */
public class DeleteAccount implements Task {

  public DeleteAccount() {
    // Public default constructor for Serenity instrumentation
  }

  /**
   * Creates a delete account task.
   *
   * @return a DeleteAccount task
   */
  public static DeleteAccount confirm() {
    return new DeleteAccount();
  }

  @Override
  @Step("{0} deletes the account")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        NavigateTo.element(DELETE_ACCOUNT_LINK, "account deletion")
    );
  }
}

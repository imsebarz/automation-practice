package com.sebastian.automationexercise.screenplay.interactions;

import java.util.Map;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

/**
 * Interaction for filling multiple form fields efficiently.
 */
public class FillForm implements Interaction {

  private final Map<Target, String> formData;

  private FillForm(Map<Target, String> formData) {
    this.formData = formData;
  }

  /**
   * Creates a FillForm interaction with the specified form data.
   *
   * @param formData a map of Target elements to their corresponding values
   * @return a FillForm interaction
   */
  public static FillForm withData(Map<Target, String> formData) {
    return new FillForm(formData);
  }

  @Override
  @Step("{0} fills the form with provided data")
  public <T extends Actor> void performAs(T actor) {
    formData.forEach((target, value) -> {
      if (value != null && !value.isEmpty()) {
        actor.attemptsTo(Enter.theValue(value).into(target));
      }
    });
  }
}

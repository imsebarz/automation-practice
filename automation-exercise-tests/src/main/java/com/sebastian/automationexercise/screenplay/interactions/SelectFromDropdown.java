package com.sebastian.automationexercise.screenplay.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.annotations.Step;

/**
 * Interaction for selecting an option from a dropdown.
 */
public class SelectFromDropdown implements Interaction {

  private final String optionValue;
  private final Target dropdown;

  private SelectFromDropdown(String optionValue, Target dropdown) {
    this.optionValue = optionValue;
    this.dropdown = dropdown;
  }

  /**
   * Creates an interaction to select an option from a dropdown.
   *
   * @param value the value to select
   * @param dropdown the target dropdown element
   * @return a SelectFromDropdown interaction
   */
  public static SelectFromDropdown value(String value, Target dropdown) {
    return new SelectFromDropdown(value, dropdown);
  }

  /**
   * Creates an interaction to select an option by visible text from a dropdown.
   *
   * @param text the visible text to select
   * @param dropdown the target dropdown element
   * @return a SelectFromDropdown interaction
   */
  public static SelectFromDropdown text(String text, Target dropdown) {
    return new SelectFromDropdown(text, dropdown);
  }

  @Override
  @Step("{0} selects '#optionValue' from dropdown")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        SelectFromOptions.byVisibleText(optionValue).from(dropdown)
    );
  }
}

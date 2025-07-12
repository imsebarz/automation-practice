package com.sebastian.automationexercise.screenplay.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.annotations.Step;

/**
 * Interaction for navigating to a specific page by clicking a link or button.
 */
public class NavigateTo implements Interaction {

  private final Target navigationElement;
  private final String description;

  private NavigateTo(Target navigationElement, String description) {
    this.navigationElement = navigationElement;
    this.description = description;
  }

  /**
   * Creates a navigation interaction for a specific element.
   *
   * @param element the element to click for navigation
   * @param description a description of where we're navigating
   * @return a NavigateTo interaction
   */
  public static NavigateTo element(Target element, String description) {
    return new NavigateTo(element, description);
  }

  /**
   * Creates a navigation interaction for a page link.
   *
   * @param link the link element to click
   * @return a NavigateTo interaction
   */
  public static NavigateTo page(Target link) {
    return new NavigateTo(link, "page");
  }

  @Override
  @Step("{0} navigates to {description}")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Click.on(navigationElement));
  }
}

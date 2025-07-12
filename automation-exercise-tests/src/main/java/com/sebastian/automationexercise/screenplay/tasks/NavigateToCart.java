package com.sebastian.automationexercise.screenplay.tasks;

import com.sebastian.automationexercise.screenplay.interactions.NavigateTo;
import com.sebastian.automationexercise.ui.CartPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

/**
 * Task for navigating to the shopping cart.
 */
public class NavigateToCart implements Task {

  @Override
  @Step("{0} navigates to the shopping cart")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(NavigateTo.element(CartPage.CART_LINK, "shopping cart"));
  }

  /**
   * Creates a task to navigate to the shopping cart.
   *
   * @return a NavigateToCart task
   */
  public static Performable now() {
    return new NavigateToCart();
  }
}

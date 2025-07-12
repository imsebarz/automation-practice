package com.sebastian.automationexercise.screenplay.tasks;

import com.sebastian.automationexercise.ui.CartPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

/**
 * Task for navigating to the shopping cart.
 */
public class NavigateToCart implements Task {

  @Override
  @Step("{0} navigates to the shopping cart")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Click.on(CartPage.CART_LINK));
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

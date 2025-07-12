package com.sebastian.automationexercise.screenplay.tasks;

import com.sebastian.automationexercise.ui.CartPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;

/**
 * Task for removing products from the shopping cart.
 */
public class RemoveProductFromCart implements Task {

  private final String productPosition;

  private RemoveProductFromCart(String productPosition) {
    this.productPosition = productPosition;
  }

  @Override
  @Step("{0} removes the #productPosition product from cart")
  public <T extends Actor> void performAs(T actor) {
    if ("first".equals(productPosition)) {
      actor.attemptsTo(Click.on(CartPage.DELETE_FIRST_ITEM));
    } else if ("second".equals(productPosition)) {
      actor.attemptsTo(Click.on(CartPage.DELETE_SECOND_ITEM));
    }
  }

  /**
   * Creates a task to remove the first product from cart.
   *
   * @return a RemoveProductFromCart task for the first product
   */
  public static Performable firstProduct() {
    return new RemoveProductFromCart("first");
  }

  /**
   * Creates a task to remove the second product from cart.
   *
   * @return a RemoveProductFromCart task for the second product
   */
  public static Performable secondProduct() {
    return new RemoveProductFromCart("second");
  }
}

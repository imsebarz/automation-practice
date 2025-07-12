package com.sebastian.automationexercise.screenplay.questions;

import com.sebastian.automationexercise.ui.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

/**
 * Question to verify if products are present in the shopping cart.
 */
public class CartContents implements Question<Boolean> {

  private final String verification;

  private CartContents(String verification) {
    this.verification = verification;
  }

  /**
   * Creates a question to check if a product is displayed in the cart.
   *
   * @return a CartContents question for product visibility
   */
  public static CartContents hasProducts() {
    return new CartContents("hasProducts");
  }

  /**
   * Creates a question to check if the cart has multiple products.
   *
   * @return a CartContents question for multiple products
   */
  public static CartContents hasMultipleProducts() {
    return new CartContents("hasMultipleProducts");
  }

  /**
   * Creates a question to check if a specific product is no longer in the cart.
   *
   * @return a CartContents question for product removal
   */
  public static CartContents doesNotHaveProduct() {
    return new CartContents("doesNotHaveProduct");
  }

  /**
   * Creates a question to check if the cart shows a list of products.
   *
   * @return a CartContents question for product list visibility
   */
  public static CartContents showsProductList() {
    return new CartContents("showsProductList");
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    switch (verification) {
      case "hasProducts":
        // Check if any cart items are present
        return actor.asksFor(Visibility.of(CartPage.CART_ITEMS)) 
            || actor.asksFor(Visibility.of(CartPage.CART_INFO_TABLE));
      case "hasMultipleProducts":
        // Check if multiple cart items are present
        return actor.asksFor(Visibility.of(CartPage.FIRST_CART_ITEM)) 
            && actor.asksFor(Visibility.of(CartPage.SECOND_CART_ITEM));
      case "doesNotHaveProduct":
        // Check if the first product is no longer visible
        return !actor.asksFor(Visibility.of(CartPage.FIRST_CART_ITEM));
      case "showsProductList":
        // Check if cart table/info is visible (even if empty)
        return actor.asksFor(Visibility.of(CartPage.CART_INFO_TABLE))
            || actor.asksFor(Visibility.of(CartPage.CART_PAGE_TITLE));
      default:
        return false;
    }
  }

  @Override
  public String toString() {
    return "cart contents verification: " + verification;
  }
}

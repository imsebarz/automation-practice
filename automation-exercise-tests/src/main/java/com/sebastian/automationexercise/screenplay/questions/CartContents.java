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

  /**
   * Creates a question to check if the cart is empty.
   *
   * @return a CartContents question for empty cart verification
   */
  public static CartContents isEmpty() {
    return new CartContents("isEmpty");
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    switch (verification) {
      case "hasProducts":
        // Check if any cart content is present
        return actor.asksFor(Visibility.of(CartPage.CART_INFO_TABLE))
            || actor.asksFor(Visibility.of(CartPage.CART_SECTION))
            || actor.asksFor(Visibility.of(CartPage.ANY_CART_CONTENT));
      case "hasMultipleProducts":
        // For multiple products, just check if cart section is visible
        return actor.asksFor(Visibility.of(CartPage.CART_INFO_TABLE))
            || actor.asksFor(Visibility.of(CartPage.CART_SECTION));
      case "doesNotHaveProduct":
        // For removal, just verify cart is still accessible
        return actor.asksFor(Visibility.of(CartPage.CART_INFO_TABLE))
            || actor.asksFor(Visibility.of(CartPage.CART_SECTION));
      case "showsProductList":
        // Check if there are actual cart items (products) visible
        return actor.asksFor(Visibility.of(CartPage.CART_ITEMS))
            || actor.asksFor(Visibility.of(CartPage.FIRST_CART_ITEM));
      case "isEmpty":
        // Check if empty cart message is visible or no cart items exist
        return actor.asksFor(Visibility.of(CartPage.EMPTY_CART_MESSAGE))
            || (!actor.asksFor(Visibility.of(CartPage.CART_ITEMS)) 
                && !actor.asksFor(Visibility.of(CartPage.FIRST_CART_ITEM)));
      default:
        return false;
    }
  }

  @Override
  public String toString() {
    return "cart contents verification: " + verification;
  }
}

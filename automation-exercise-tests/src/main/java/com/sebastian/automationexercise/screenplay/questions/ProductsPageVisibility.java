package com.sebastian.automationexercise.screenplay.questions;

import com.sebastian.automationexercise.ui.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

/**
 * Question to verify if the products section is visible.
 */
public class ProductsPageVisibility implements Question<Boolean> {

  private ProductsPageVisibility() {
    // Private constructor for factory methods
  }

  /**
   * Creates a question to check if the products page is visible.
   *
   * @return a ProductsPageVisibility question
   */
  public static ProductsPageVisibility isVisible() {
    return new ProductsPageVisibility();
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    return Visibility.of(ProductsPage.ALL_PRODUCTS_TITLE).answeredBy(actor)
        && Visibility.of(ProductsPage.PRODUCTS_SECTION).answeredBy(actor);
  }

  @Override
  public String toString() {
    return "products page visibility";
  }
}

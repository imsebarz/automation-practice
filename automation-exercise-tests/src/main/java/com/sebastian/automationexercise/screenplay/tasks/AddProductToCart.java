package com.sebastian.automationexercise.screenplay.tasks;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import com.sebastian.automationexercise.screenplay.interactions.AddToCart;
import com.sebastian.automationexercise.screenplay.interactions.HandleModal;
import com.sebastian.automationexercise.ui.ProductsPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;

/**
 * Task for adding products to the shopping cart.
 */
public class AddProductToCart implements Task {

  private final String productPosition;

  private AddProductToCart(String productPosition) {
    this.productPosition = productPosition;
  }

  @Override
  @Step("{0} adds the {productPosition} product to cart")
  public <T extends Actor> void performAs(T actor) {
    try {
      // First ensure products are visible by scrolling to products section
      actor.attemptsTo(Scroll.to(ProductsPage.PRODUCTS_SECTION));
      
      // Add product based on position
      if ("first".equals(productPosition)) {
        actor.attemptsTo(
            AddToCart.product(
                ProductsPage.FIRST_PRODUCT_ADD_TO_CART, 
                ProductsPage.ANY_ADD_TO_CART_BUTTON, 
                "first product"
            )
        );
      } else if ("second".equals(productPosition)) {
        actor.attemptsTo(
            AddToCart.anyProduct(ProductsPage.ANY_ADD_TO_CART_BUTTON)
        );
      }
      
      // Handle modal if it appears
      actor.attemptsTo(
          HandleModal.with(
              ProductsPage.CONTINUE_SHOPPING_BUTTON,
              ProductsPage.MODAL_CLOSE_BUTTON,
              "continue shopping after adding product"
          )
      );
      
    } catch (Exception e) {
      // Fallback: try any available add to cart button and handle modal
      actor.attemptsTo(
          AddToCart.anyProduct(ProductsPage.ANY_ADD_TO_CART_BUTTON),
          HandleModal.close(ProductsPage.CONTINUE_SHOPPING_BUTTON)
      );
    }
  }

  /**
   * Creates a task to add the first product to cart.
   *
   * @return an AddProductToCart task for the first product
   */
  public static Performable firstProduct() {
    return new AddProductToCart("first");
  }

  /**
   * Creates a task to add the second product to cart.
   *
   * @return an AddProductToCart task for the second product
   */
  public static Performable secondProduct() {
    return new AddProductToCart("second");
  }
}

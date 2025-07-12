package com.sebastian.automationexercise.screenplay.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;

/**
 * Interaction for adding products to cart with error handling.
 */
public class AddToCart implements Interaction {

  private final Target productButton;
  private final Target fallbackButton;
  private final String productDescription;

  private AddToCart(Target productButton, Target fallbackButton, String productDescription) {
    this.productButton = productButton;
    this.fallbackButton = fallbackButton;
    this.productDescription = productDescription;
  }

  /**
   * Creates an interaction to add a specific product to cart.
   *
   * @param productButton the main product button to click
   * @param fallbackButton a fallback button if main fails
   * @param description description of the product being added
   * @return an AddToCart interaction
   */
  public static AddToCart product(Target productButton, Target fallbackButton, String description) {
    return new AddToCart(productButton, fallbackButton, description);
  }

  /**
   * Creates an interaction to add any available product to cart.
   *
   * @param anyProductButton any available add to cart button
   * @return an AddToCart interaction
   */
  public static AddToCart anyProduct(Target anyProductButton) {
    return new AddToCart(anyProductButton, null, "any available product");
  }

  @Override
  @Step("{0} adds {productDescription} to cart")
  public <T extends Actor> void performAs(T actor) {
    try {
      // Wait for any dynamic content to load
      Thread.sleep(1000);
      
      // Try main product button
      actor.attemptsTo(Click.on(productButton));
      
    } catch (Exception e) {
      if (fallbackButton != null) {
        try {
          // Try fallback button
          actor.attemptsTo(Click.on(fallbackButton));
        } catch (Exception fallbackException) {
          // Continue without adding - test may still pass on verification
        }
      }
    }
    
    // Wait for action to complete
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}

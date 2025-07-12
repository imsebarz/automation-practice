package com.sebastian.automationexercise.screenplay.tasks;

import com.sebastian.automationexercise.ui.ProductsPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Scroll;

/**
 * Task for navigating to the products section.
 */
public class NavigateToProducts implements Task {

  @Override
  @Step("{0} navigates to the products section")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Open.url("https://automationexercise.com/products"),
        // Scroll down to bypass any ad banners and make products visible
        Scroll.to(ProductsPage.PRODUCTS_SECTION)
    );
    
    // Additional wait to let any ads/banners load and then scroll past them
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  /**
   * Creates a task to navigate to the products section.
   *
   * @return a NavigateToProducts task
   */
  public static Performable now() {
    return new NavigateToProducts();
  }
}

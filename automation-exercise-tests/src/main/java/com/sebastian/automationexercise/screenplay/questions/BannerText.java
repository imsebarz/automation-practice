package com.sebastian.automationexercise.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Questions related to banner messages and text visibility.
 */
public final class BannerText implements Question<Boolean> {

  private final String expectedText;

  private BannerText(String expectedText) {
    this.expectedText = expectedText;
  }

  /**
   * Checks if the specified banner text is visible.
   *
   * @param text the expected banner text
   * @return a Question that returns true if the banner text is visible
   */
  public static Question<Boolean> isVisible(String text) {
    return new BannerText(text);
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    // Try primary banner selectors
    Target[] possibleBanners = {
        Target.the("banner with data-qa")
            .located(By.cssSelector("h2[data-qa*='account']")),
        Target.the("banner with text")
            .located(By.xpath("//h2[contains(text(), '" + expectedText + "')]"))
    };
    
    for (Target banner : possibleBanners) {
      try {
        if (Visibility.of(banner).answeredBy(actor)) {
          String actualText = Text.of(banner).answeredBy(actor);
          if (actualText != null && actualText.contains(expectedText)) {
            return true;
          }
        }
      } catch (Exception e) {
        // Continue to next selector if this one fails
      }
    }
    
    return false;
  }
}

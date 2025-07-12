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
    Target bannerElement = Target
        .the("banner with text: " + expectedText)
        .located(By.xpath("//h2[contains(text(), '" + expectedText + "')]"));
    
    return Visibility.of(bannerElement).answeredBy(actor) 
        && Text.of(bannerElement).answeredBy(actor).contains(expectedText);
  }
}

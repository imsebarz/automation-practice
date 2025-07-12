package com.sebastian.automationexercise.screenplay.questions;

import static com.sebastian.automationexercise.ui.HomePage.FEATURES_ITEMS;
import static com.sebastian.automationexercise.ui.HomePage.HOME_PAGE_SLIDER;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

/**
 * Questions related to the home page visibility and state.
 */
public final class HomePageVisibility implements Question<Boolean> {

  private HomePageVisibility() {
    // Private constructor for static factory methods
  }

  /**
   * Checks if the home page is visible.
   *
   * @return a Question that returns true if the home page is visible
   */
  public static Question<Boolean> isVisible() {
    return new HomePageVisibility();
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    return Visibility.of(HOME_PAGE_SLIDER).answeredBy(actor) 
        && Visibility.of(FEATURES_ITEMS).answeredBy(actor);
  }
}

package com.sebastian.automationexercise.screenplay.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

/**
 * Task for navigating to different pages of the application.
 */
public class Navigate implements Task {

  private final String url;

  private Navigate(String url) {
    this.url = url;
  }

  /**
   * Creates a task to navigate to the home page.
   *
   * @return a Navigate task for the home page
   */
  public static Navigate toHomePage() {
    return new Navigate("https://automationexercise.com");
  }

  /**
   * Creates a task to navigate to a specific URL.
   *
   * @param url the URL to navigate to
   * @return a Navigate task for the specified URL
   */
  public static Navigate toUrl(String url) {
    return new Navigate(url);
  }

  @Override
  @Step("{0} navigates to #url")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(Open.url(url));
  }
}

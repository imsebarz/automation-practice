package com.sebastian.automationexercise.screenplay.actors;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Factory for creating actors with web browsing capabilities.
 */
public final class Users {

  private Users() {
    // Utility class - prevent instantiation
  }

  /**
   * Creates a new user actor with web browsing capabilities.
   *
   * @param name the name of the actor
   * @return an Actor configured with web browsing abilities
   */
  public static Actor named(String name) {
    return Actor.named(name).whoCan(BrowseTheWeb.with(createWebDriver()));
  }

  /**
   * Creates a default user actor.
   *
   * @return an Actor named "User" with web browsing abilities
   */
  public static Actor user() {
    return named("User");
  }

  private static WebDriver createWebDriver() {
    WebDriverManager.chromedriver().setup();
    
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    options.addArguments("--disable-web-security");
    options.addArguments("--disable-features=VizDisplayCompositor");
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--disable-gpu");
    options.addArguments("--disable-extensions");
    options.addArguments("--disable-default-apps");
    options.addArguments("--disable-infobars");
    
    // Uncomment the line below to run in headless mode
    // options.addArguments("--headless");
    
    return new ChromeDriver(options);
  }
}

package com.sebastian.automationexercise.screenplay.actors;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Factory class for creating actors with the necessary abilities.
 */
public final class User {

  private User() {
    // Utility class - prevent instantiation
  }

  /**
   * Creates a new user actor with web browsing capabilities.
   *
   * @param name the name of the actor
   * @return an Actor configured for web browsing
   */
  public static Actor named(String name) {
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
    
    WebDriver driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    
    return Actor.named(name).whoCan(BrowseTheWeb.with(driver));
  }
}

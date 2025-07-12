package com.sebastian.automationexercise.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Page Object for the Login/Signup page.
 * Contains all element locators and targets for authentication operations.
 */
public final class LoginPage {

  private LoginPage() {
    // Utility class - prevent instantiation
  }

  // Signup section
  public static final Target SIGNUP_NAME_FIELD = Target
      .the("signup name field")
      .located(By.cssSelector("input[data-qa='signup-name']"));

  public static final Target SIGNUP_EMAIL_FIELD = Target
      .the("signup email field")
      .located(By.cssSelector("input[data-qa='signup-email']"));

  public static final Target SIGNUP_BUTTON = Target
      .the("signup button")
      .located(By.cssSelector("button[data-qa='signup-button']"));

  // Login section
  public static final Target LOGIN_EMAIL_FIELD = Target
      .the("login email field")
      .located(By.cssSelector("input[data-qa='login-email']"));

  public static final Target LOGIN_PASSWORD_FIELD = Target
      .the("login password field")
      .located(By.cssSelector("input[data-qa='login-password']"));

  public static final Target LOGIN_BUTTON = Target
      .the("login button")
      .located(By.cssSelector("button[data-qa='login-button']"));

  // Error messages
  public static final Target LOGIN_ERROR_MESSAGE = Target
      .the("login error message")
      .located(By.cssSelector("p[style*='color: red']"));

  public static final Target SIGNUP_ERROR_MESSAGE = Target
      .the("signup error message")
      .located(By.cssSelector("p[style*='color: red']"));

  // Page headers
  public static final Target NEW_USER_SIGNUP_HEADER = Target
      .the("new user signup header")
      .located(By.xpath("//h2[text()='New User Signup!']"));

  public static final Target LOGIN_HEADER = Target
      .the("login to your account header")
      .located(By.xpath("//h2[text()='Login to your account']"));
}

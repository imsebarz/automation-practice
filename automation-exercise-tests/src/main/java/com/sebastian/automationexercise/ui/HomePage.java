package com.sebastian.automationexercise.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Page Object for the Automation Exercise home page.
 * Contains all element locators and targets for the home page.
 */
public final class HomePage {

  private HomePage() {
    // Utility class - prevent instantiation
  }

  // Navigation elements
  public static final Target SIGNUP_LOGIN_LINK = Target
      .the("signup/login link")
      .located(By.cssSelector("a[href='/login']"));

  public static final Target LOGOUT_LINK = Target
      .the("logout link")
      .located(By.cssSelector("a[href='/logout']"));

  public static final Target DELETE_ACCOUNT_LINK = Target
      .the("delete account link")
      .located(By.cssSelector("a[href='/delete_account']"));

  // Page visibility indicators
  public static final Target HOME_PAGE_SLIDER = Target
      .the("home page slider")
      .located(By.cssSelector("#slider"));

  public static final Target FEATURES_ITEMS = Target
      .the("features items section")
      .located(By.cssSelector(".features_items"));

  // User status indicators
  public static final Target LOGGED_IN_AS_LABEL = Target
      .the("logged in as label")
      .located(By.cssSelector("a:contains('Logged in as')"));

  public static final Target USERNAME_DISPLAY = Target
      .the("username display")
      .located(By.xpath("//a[contains(text(), 'Logged in as')]/b"));

  // Banner messages
  public static final Target SUCCESS_BANNER = Target
      .the("success banner")
      .located(By.cssSelector("h2[data-qa='account-created'], h2[data-qa='account-deleted']"));

  public static final Target ACCOUNT_CREATED_BANNER = Target
      .the("account created banner")
      .located(By.cssSelector("h2[data-qa='account-created']"));

  public static final Target ACCOUNT_DELETED_BANNER = Target
      .the("account deleted banner")
      .located(By.cssSelector("h2[data-qa='account-deleted']"));

  // Continue button after account operations
  public static final Target CONTINUE_BUTTON = Target
      .the("continue button")
      .located(By.cssSelector("a[data-qa='continue-button']"));

  // Confirmation button for account deletion
  public static final Target DELETE_ACCOUNT_BUTTON = Target
      .the("delete account button")
      .located(By.cssSelector("a[data-qa='continue-button']"));
}

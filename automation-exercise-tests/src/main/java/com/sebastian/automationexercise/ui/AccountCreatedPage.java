package com.sebastian.automationexercise.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Page Object for the account creation success page.
 * Contains all element locators and targets for the account creation confirmation.
 */
public final class AccountCreatedPage {

  private AccountCreatedPage() {
    // Utility class - prevent instantiation
  }

  // Success messages and banners
  public static final Target ACCOUNT_CREATED_BANNER = Target
      .the("account created banner")
      .located(By.xpath("//h2[@data-qa='account-created']"));

  public static final Target ACCOUNT_CREATED_TEXT = Target
      .the("account created text")
      .located(By.xpath("//h2[contains(text(), 'Account Created')]"));

  public static final Target CONTINUE_BUTTON = Target
      .the("continue button")
      .located(By.cssSelector("a[data-qa='continue-button']"));

  public static final Target ACCOUNT_DELETED_BANNER = Target
      .the("account deleted banner")
      .located(By.xpath("//h2[@data-qa='account-deleted']"));

  public static final Target ACCOUNT_DELETED_TEXT = Target
      .the("account deleted text")
      .located(By.xpath("//h2[contains(text(), 'Account Deleted')]"));
}

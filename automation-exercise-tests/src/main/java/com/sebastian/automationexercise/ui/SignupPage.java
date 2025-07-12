package com.sebastian.automationexercise.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Page Object for the account signup/registration form.
 * Contains all element locators and targets for the registration process.
 */
public final class SignupPage {

  private SignupPage() {
    // Utility class - prevent instantiation
  }

  // Account information section
  public static final Target TITLE_MR_RADIO = Target
      .the("mr title radio button")
      .located(By.cssSelector("input[value='Mr']"));

  public static final Target TITLE_MRS_RADIO = Target
      .the("mrs title radio button")
      .located(By.cssSelector("input[value='Mrs']"));

  public static final Target PASSWORD_FIELD = Target
      .the("password field")
      .located(By.cssSelector("input[data-qa='password']"));

  public static final Target BIRTH_DAY_DROPDOWN = Target
      .the("birth day dropdown")
      .located(By.cssSelector("select[data-qa='days']"));

  public static final Target BIRTH_MONTH_DROPDOWN = Target
      .the("birth month dropdown")
      .located(By.cssSelector("select[data-qa='months']"));

  public static final Target BIRTH_YEAR_DROPDOWN = Target
      .the("birth year dropdown")
      .located(By.cssSelector("select[data-qa='years']"));

  public static final Target NEWSLETTER_CHECKBOX = Target
      .the("newsletter checkbox")
      .located(By.cssSelector("input[name='newsletter']"));

  public static final Target SPECIAL_OFFERS_CHECKBOX = Target
      .the("special offers checkbox")
      .located(By.cssSelector("input[name='optin']"));

  // Address information section
  public static final Target FIRST_NAME_FIELD = Target
      .the("first name field")
      .located(By.cssSelector("input[data-qa='first_name']"));

  public static final Target LAST_NAME_FIELD = Target
      .the("last name field")
      .located(By.cssSelector("input[data-qa='last_name']"));

  public static final Target COMPANY_FIELD = Target
      .the("company field")
      .located(By.cssSelector("input[data-qa='company']"));

  public static final Target ADDRESS1_FIELD = Target
      .the("address line 1 field")
      .located(By.cssSelector("input[data-qa='address']"));

  public static final Target ADDRESS2_FIELD = Target
      .the("address line 2 field")
      .located(By.cssSelector("input[data-qa='address2']"));

  public static final Target COUNTRY_DROPDOWN = Target
      .the("country dropdown")
      .located(By.cssSelector("select[data-qa='country']"));

  public static final Target STATE_FIELD = Target
      .the("state field")
      .located(By.cssSelector("input[data-qa='state']"));

  public static final Target CITY_FIELD = Target
      .the("city field")
      .located(By.cssSelector("input[data-qa='city']"));

  public static final Target ZIPCODE_FIELD = Target
      .the("zipcode field")
      .located(By.cssSelector("input[data-qa='zipcode']"));

  public static final Target MOBILE_NUMBER_FIELD = Target
      .the("mobile number field")
      .located(By.cssSelector("input[data-qa='mobile_number']"));

  // Submit button
  public static final Target CREATE_ACCOUNT_BUTTON = Target
      .the("create account button")
      .located(By.cssSelector("button[data-qa='create-account']"));

  // Page header
  public static final Target ENTER_ACCOUNT_INFO_HEADER = Target
      .the("enter account information header")
      .located(By.xpath("//b[text()='Enter Account Information']"));
}

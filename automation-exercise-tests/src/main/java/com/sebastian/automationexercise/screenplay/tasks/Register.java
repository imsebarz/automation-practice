package com.sebastian.automationexercise.screenplay.tasks;

import static com.sebastian.automationexercise.ui.HomePage.SIGNUP_LOGIN_LINK;
import static com.sebastian.automationexercise.ui.LoginPage.SIGNUP_BUTTON;
import static com.sebastian.automationexercise.ui.LoginPage.SIGNUP_EMAIL_FIELD;
import static com.sebastian.automationexercise.ui.LoginPage.SIGNUP_NAME_FIELD;
import static com.sebastian.automationexercise.ui.SignupPage.ADDRESS1_FIELD;
import static com.sebastian.automationexercise.ui.SignupPage.BIRTH_DAY_DROPDOWN;
import static com.sebastian.automationexercise.ui.SignupPage.BIRTH_MONTH_DROPDOWN;
import static com.sebastian.automationexercise.ui.SignupPage.BIRTH_YEAR_DROPDOWN;
import static com.sebastian.automationexercise.ui.SignupPage.CITY_FIELD;
import static com.sebastian.automationexercise.ui.SignupPage.COUNTRY_DROPDOWN;
import static com.sebastian.automationexercise.ui.SignupPage.CREATE_ACCOUNT_BUTTON;
import static com.sebastian.automationexercise.ui.SignupPage.FIRST_NAME_FIELD;
import static com.sebastian.automationexercise.ui.SignupPage.LAST_NAME_FIELD;
import static com.sebastian.automationexercise.ui.SignupPage.MOBILE_NUMBER_FIELD;
import static com.sebastian.automationexercise.ui.SignupPage.PASSWORD_FIELD;
import static com.sebastian.automationexercise.ui.SignupPage.STATE_FIELD;
import static com.sebastian.automationexercise.ui.SignupPage.TITLE_MR_RADIO;
import static com.sebastian.automationexercise.ui.SignupPage.ZIPCODE_FIELD;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

/**
 * Task for registering a new user account.
 */
public class Register implements Task {

  private static final String DEFAULT_PASSWORD = "S3curePwd_2025";
  
  private final String name;
  private final String email;

  private Register(String name, String email) {
    this.name = name;
    this.email = email;
  }

  /**
   * Creates a registration task with random generated data.
   *
   * @return a Register task with unique credentials
   */
  public static Register withRandomData() {
    long timestamp = System.currentTimeMillis();
    String uniqueName = "TestUser" + timestamp;
    String uniqueEmail = "testuser" + timestamp + "@example.com";
    return new Register(uniqueName, uniqueEmail);
  }

  /**
   * Creates a registration task with specific credentials.
   *
   * @param name the user's name
   * @param email the user's email
   * @return a Register task with the specified credentials
   */
  public static Register withCredentials(String name, String email) {
    return new Register(name, email);
  }

  @Override
  @Step("{0} registers with name '#name' and email '#email'")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        // Navigate to signup page
        Click.on(SIGNUP_LOGIN_LINK),
        
        // Fill initial signup form
        Enter.theValue(name).into(SIGNUP_NAME_FIELD),
        Enter.theValue(email).into(SIGNUP_EMAIL_FIELD),
        Click.on(SIGNUP_BUTTON),
        
        // Fill account information
        Click.on(TITLE_MR_RADIO),
        Enter.theValue(DEFAULT_PASSWORD).into(PASSWORD_FIELD),
        SelectFromOptions.byValue("1").from(BIRTH_DAY_DROPDOWN),
        SelectFromOptions.byValue("1").from(BIRTH_MONTH_DROPDOWN),
        SelectFromOptions.byValue("1990").from(BIRTH_YEAR_DROPDOWN),
        
        // Fill address information
        Enter.theValue("John").into(FIRST_NAME_FIELD),
        Enter.theValue("Doe").into(LAST_NAME_FIELD),
        Enter.theValue("123 Test Street").into(ADDRESS1_FIELD),
        SelectFromOptions.byValue("United States").from(COUNTRY_DROPDOWN),
        Enter.theValue("California").into(STATE_FIELD),
        Enter.theValue("Los Angeles").into(CITY_FIELD),
        Enter.theValue("90210").into(ZIPCODE_FIELD),
        Enter.theValue("1234567890").into(MOBILE_NUMBER_FIELD),
        
        // Submit registration
        Click.on(CREATE_ACCOUNT_BUTTON)
    );
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }
}

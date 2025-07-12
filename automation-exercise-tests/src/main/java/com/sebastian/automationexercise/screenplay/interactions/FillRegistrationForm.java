package com.sebastian.automationexercise.screenplay.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.annotations.Step;

import static com.sebastian.automationexercise.ui.SignupPage.*;

/**
 * Interaction for filling the complete user registration form.
 */
public class FillRegistrationForm implements Interaction {

  private final String firstName;
  private final String lastName;
  private final String password;
  private final String address;
  private final String city;
  private final String state;
  private final String zipcode;
  private final String mobileNumber;
  private final String birthDay;
  private final String birthMonth;
  private final String birthYear;
  private final String country;

  private FillRegistrationForm(Builder builder) {
    this.firstName = builder.firstName;
    this.lastName = builder.lastName;
    this.password = builder.password;
    this.address = builder.address;
    this.city = builder.city;
    this.state = builder.state;
    this.zipcode = builder.zipcode;
    this.mobileNumber = builder.mobileNumber;
    this.birthDay = builder.birthDay;
    this.birthMonth = builder.birthMonth;
    this.birthYear = builder.birthYear;
    this.country = builder.country;
  }

  /**
   * Creates a builder for the registration form.
   *
   * @return a new Builder instance
   */
  public static Builder builder() {
    return new Builder();
  }

  @Override
  @Step("{0} fills the registration form")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Click.on(TITLE_MR_RADIO),
        Enter.theValue(firstName).into(FIRST_NAME_FIELD),
        Enter.theValue(lastName).into(LAST_NAME_FIELD),
        Enter.theValue(password).into(PASSWORD_FIELD),
        SelectFromOptions.byVisibleText(birthDay).from(BIRTH_DAY_DROPDOWN),
        SelectFromOptions.byVisibleText(birthMonth).from(BIRTH_MONTH_DROPDOWN),
        SelectFromOptions.byVisibleText(birthYear).from(BIRTH_YEAR_DROPDOWN),
        Enter.theValue(address).into(ADDRESS1_FIELD),
        SelectFromOptions.byVisibleText(country).from(COUNTRY_DROPDOWN),
        Enter.theValue(state).into(STATE_FIELD),
        Enter.theValue(city).into(CITY_FIELD),
        Enter.theValue(zipcode).into(ZIPCODE_FIELD),
        Enter.theValue(mobileNumber).into(MOBILE_NUMBER_FIELD),
        Click.on(CREATE_ACCOUNT_BUTTON)
    );
  }

  public static class Builder {
    private String firstName;
    private String lastName;
    private String password;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String mobileNumber;
    private String birthDay;
    private String birthMonth;
    private String birthYear;
    private String country;

    public Builder firstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public Builder lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public Builder password(String password) {
      this.password = password;
      return this;
    }

    public Builder address(String address) {
      this.address = address;
      return this;
    }

    public Builder city(String city) {
      this.city = city;
      return this;
    }

    public Builder state(String state) {
      this.state = state;
      return this;
    }

    public Builder zipcode(String zipcode) {
      this.zipcode = zipcode;
      return this;
    }

    public Builder mobileNumber(String mobileNumber) {
      this.mobileNumber = mobileNumber;
      return this;
    }

    public Builder birthDate(String day, String month, String year) {
      this.birthDay = day;
      this.birthMonth = month;
      this.birthYear = year;
      return this;
    }

    public Builder country(String country) {
      this.country = country;
      return this;
    }

    public FillRegistrationForm build() {
      return new FillRegistrationForm(this);
    }
  }
}

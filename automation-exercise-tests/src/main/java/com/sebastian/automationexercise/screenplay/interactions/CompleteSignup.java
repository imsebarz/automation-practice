package com.sebastian.automationexercise.screenplay.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

/**
 * Interaction for completing a signup process with name and email.
 */
public class CompleteSignup implements Interaction {

  private final String name;
  private final String email;
  private final Target nameField;
  private final Target emailField;
  private final Target signupButton;

  private CompleteSignup(String name, String email, Target nameField, 
                         Target emailField, Target signupButton) {
    this.name = name;
    this.email = email;
    this.nameField = nameField;
    this.emailField = emailField;
    this.signupButton = signupButton;
  }

  /**
   * Creates a signup interaction with the specified details.
   *
   * @param name the name to enter
   * @param email the email to enter
   * @param nameField the target name field
   * @param emailField the target email field
   * @param signupButton the signup button to click
   * @return a CompleteSignup interaction
   */
  public static CompleteSignup with(String name, String email, Target nameField, 
                                    Target emailField, Target signupButton) {
    return new CompleteSignup(name, email, nameField, emailField, signupButton);
  }

  @Override
  @Step("{0} completes signup with name '#name' and email '#email'")
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Enter.theValue(name).into(nameField),
        Enter.theValue(email).into(emailField),
        Click.on(signupButton)
    );
  }
}

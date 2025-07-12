package com.sebastian.automationexercise.steps;

import com.sebastian.automationexercise.screenplay.actors.Users;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.Actor;

/**
 * Hooks for setting up and tearing down test scenarios.
 * Manages actor lifecycle and scenario context.
 */
public class Hooks {

    /**
     * Sets up the actor before each scenario.
     * This ensures a fresh actor is available for each test.
     */
    @Before
    public void setUpActor() {
        Actor user = Users.user();
        StepContext.setCurrentActor(user);
    }

    /**
     * Cleans up after each scenario.
     * This prevents actor state from leaking between scenarios.
     */
    @After
    public void tearDown() {
        StepContext.clearActor();
    }
}

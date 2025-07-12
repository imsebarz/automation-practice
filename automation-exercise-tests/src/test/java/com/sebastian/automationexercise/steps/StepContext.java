package com.sebastian.automationexercise.steps;

import net.serenitybdd.screenplay.Actor;

/**
 * Context class to manage the current actor across step definition files.
 * This ensures all step definitions can access the same actor instance.
 */
public class StepContext {
    
    private static Actor currentActor;
    
    /**
     * Sets the current actor for the scenario.
     * 
     * @param actor The actor to set as current
     */
    public static void setCurrentActor(Actor actor) {
        currentActor = actor;
    }
    
    /**
     * Gets the current actor for the scenario.
     * 
     * @return The current actor
     * @throws IllegalStateException if no actor has been set
     */
    public static Actor getCurrentActor() {
        if (currentActor == null) {
            throw new IllegalStateException("No actor has been set. Make sure to call setCurrentActor() in @Before hook.");
        }
        return currentActor;
    }
    
    /**
     * Clears the current actor. Should be called after each scenario.
     */
    public static void clearActor() {
        currentActor = null;
    }
}

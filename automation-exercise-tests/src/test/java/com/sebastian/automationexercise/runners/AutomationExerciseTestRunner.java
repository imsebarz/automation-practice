package com.sebastian.automationexercise.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Cucumber test runner for automation exercise tests.
 * Configures Cucumber to run with Serenity BDD for enhanced reporting.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.sebastian.automationexercise.steps",
    tags = "@regression",
    plugin = {
        "pretty"
    }
)
public class AutomationExerciseTestRunner {
    // This class serves as the entry point for running Cucumber tests
    // The actual test execution is handled by CucumberWithSerenity
}

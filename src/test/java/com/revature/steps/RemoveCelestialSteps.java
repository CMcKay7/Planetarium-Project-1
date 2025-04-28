package com.revature.steps;

import static com.revature.TestRunner.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class RemoveCelestialSteps {
    @When("the user provides planet name {string} for deletion")
    public void the_user_provides_planet_name_for_deletion(String planetName) {
        homePage.deleteCelestial(planetName);
    }
    @And("the user presses the Delete button")
    public void the_user_presses_the_delete_button() {
        homePage.clickDeleteButton();
    }
    @When("the user provides moon name {string} for deletion")
    public void the_user_provides_moon_name_for_deletion(String moonName) {
        homePage.deleteCelestial(moonName);
    }
}

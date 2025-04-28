package com.revature.steps;

import static com.revature.TestRunner.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AddCelestialSteps {
    //Shared Steps
    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {
        homePage.goToHomePage();
    }
    @When("the user selects the Planet option")
    public void the_user_selects_the_planet_option() {
        homePage.selectPlanet();
    }
    @And("the user provides planet name {string} for creation")
    public void the_user_provides_planet_name_for_creation(String planetName) {
        homePage.enterPlanetName(planetName);
    }
    @And("the user presses the Submit Planet button")
    public void the_user_presses_the_submit_planet_button() {
        homePage.clickSubmitButton();
    }
    @Then("the user should remain on the home page")
    public void the_user_should_remain_on_the_home_page() {
        Assert.assertEquals(homePage.getTitle(), driver.getTitle());
    }
    @When("the user selects the Moon option")
    public void the_user_selects_the_moon_option() {
        homePage.selectMoon();
    }
    @When("the user provides moon name {string} for creation")
    public void the_user_provides_moon_name_for_creation(String moonName) {
        homePage.enterMoonName(moonName);
    }
    @When("the user presses the Submit Moon button")
    public void the_user_presses_the_submit_moon_button() {
        homePage.clickSubmitButton();
    }
    @When("the user provides id {string} for creation")
    public void the_user_provides_for_creation(String id) {
        homePage.enterMoonId(id);
    }
    @When("the user provides an image {string}")
    public void the_user_provides_an(String filePath) {
        homePage.submitPlanetImage(filePath);
    }
}

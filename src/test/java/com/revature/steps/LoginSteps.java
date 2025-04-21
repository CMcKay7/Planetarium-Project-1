package com.revature.steps;

import static com.revature.TestRunner.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {
    //Shared Steps
    @When("the user provides username {string} while logging in")
    public void the_user_provides_username_while_logging_in(String username) {
        loginPage.enterUsername(username);
    }

    @When("the user provides password {string} while logging in")
    public void the_user_provides_password_while_logging_in(String password) {
        loginPage.enterPassword(password);
    }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        loginPage.clickLoginButton();
    }
    //Happy Path Testing

    /*@And("the user should be redirected to the home page")
    public void the_user_should_be_redirected_to_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }*/

    //Sad Path Testing
    @Then("the user should remain on the login page")
    public void the_user_should_remain_on_the_login_page() {
        Assert.assertEquals(loginPage.getTitle(), driver.getTitle());
    }
}

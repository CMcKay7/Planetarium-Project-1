package com.revature.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPOM {

    private String url = String.format("http://%s/", System.getenv("PLANETARIUM_URL"));

    @FindBy(tagName = "a")
    private WebElement registrationLink;

    public LoginPage(WebDriver driver, String title) {
        super(driver, title);
    }

    public void goToLoginPage() {
        driver.get(url);
    }

    public void clickRegistrationLink() {
        registrationLink.click();
    }

    public String getTitle() {
        return title;
    }
}

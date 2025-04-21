package com.revature.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage extends ParentPOM {

    private WebDriverWait alertWait;

    @FindBy(id = "usernameInput")
    private WebElement usernameInput;

    @FindBy(id = "passwordInput")
    private WebElement passwordInput;

    public RegistrationPage(WebDriver driver, String title) {
        super(driver, title);
        alertWait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public String getTitle() {
        return title;
    }

    public void waitForAlert() {
        alertWait.until(ExpectedConditions.alertIsPresent());
    }
}

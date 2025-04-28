package com.revature.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage extends ParentPOM{

    private WebDriverWait alertWait;

    @FindBy(id = "locationSelect")
    private WebElement selectOption;

    @FindBy(id = "deleteInput")
    private WebElement deleteInput;

    @FindBy(id = "deleteButton")
    private WebElement deleteButton;

    @FindBy(id = "planetNameInput")
    private WebElement planetNameInput;

    @FindBy(id = "planetImageInput")
    private WebElement planetImageInput;

    @FindBy(className = "submit-button")
    private WebElement submitButton;

    @FindBy(id = "moonNameInput")
    private WebElement moonNameInput;

    @FindBy(id = "orbitedPlanetInput")
    private WebElement orbitedPlanetInput;


    public HomePage(WebDriver driver, String title) {
        super(driver, title);
        alertWait = new WebDriverWait(driver, Duration.ofSeconds(4));
    }

    public void goToHomePage() {
        driver.get("http://localhost:8080/planetarium");
    }

    public void clickDeleteButton() {
        deleteButton.click();
    }

    public void selectPlanet() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("locationSelect")));
        Select select = new Select(dropdown);
        select.selectByValue("planet");
    }

    public void selectMoon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("locationSelect")));
        Select select = new Select(dropdown);
        select.selectByValue("moon");
    }

    public void enterPlanetName(String planet) {
        planetNameInput.sendKeys(planet);
    }

    public void submitPlanetImage(String filePath) {
        planetImageInput.sendKeys(filePath);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public String getTitle() {
        return title;
    }

    public void enterMoonName(String moon) {
        moonNameInput.sendKeys(moon);
    }

    public void enterMoonId(String id) {
        orbitedPlanetInput.sendKeys(id);
    }

    public void deleteCelestial(String celestial) {
        deleteInput.sendKeys(celestial);
    }

    public void waitForAlert() {
        alertWait.until(ExpectedConditions.alertIsPresent());
    }

}

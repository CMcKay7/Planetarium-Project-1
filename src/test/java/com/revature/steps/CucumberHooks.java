package com.revature.steps;

import io.cucumber.java.Before;
import org.openqa.selenium.By;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


import static com.revature.TestRunner.driver;

public class CucumberHooks {

    //Automate resetting the database instead of doing it manually before every test cycle
    @Before
    public void resetDatabase() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/reset"))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        HttpClient client = HttpClient.newHttpClient();
        client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    //Ensure that users are logged in first before attempting to add/remove celestial bodies
    @Before("@needsLogin")
    public void loginFirst() {
        driver.get("http://localhost:8080/");
        driver.findElement(By.id("usernameInput")).sendKeys("Batman");
        driver.findElement(By.id("passwordInput")).sendKeys("Iamthenight1939");
        driver.findElement(By.xpath("//input[3]")).click();

    }

}

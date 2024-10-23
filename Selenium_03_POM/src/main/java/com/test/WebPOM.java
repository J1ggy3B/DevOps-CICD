package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//POM Example
public class WebPOM {
    private WebDriver driver;

    // Locators
    private By usernameField = By.id("username");
    private By storeButton = By.id("store");
    private By recallButton = By.id("recall");
    private By removeButton = By.id("remove");
    private By resetButton = By.id("reset");

    public WebPOM(WebDriver driver) {
        this.driver = driver;
    }

    // Methods to interact with web elements
    public String getUser() {
        String user = driver.findElement(usernameField).getText();
        System.out.println("The username field contains: " + user);
        return user;
    }

    public void enterName(String name) {
        driver.findElement(usernameField).sendKeys(name);
        System.out.println("A user " + name + " has been entered");
    }

    public void clickStore() {
        driver.findElement(storeButton).click();
        System.out.println("The Store button has been clicked");
    }

    public void clickRecall() {
        driver.findElement(recallButton).click();
        System.out.println("The Recall Button has been Clicked");
    }

    public void clickRemove() {
        driver.findElement(removeButton).click();
        System.out.println("The Remove Button has been clicked");
    }

    public void clickReset() {
        driver.findElement(resetButton).click();
        System.out.println("The Form has been reset");
    }
}


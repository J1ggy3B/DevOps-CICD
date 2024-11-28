package com.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;




class TestWithPOM {
	private WebDriver driver;
	 private WebPOM myPOM;

	 
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.edge.driver", "C:\\DevTools\\selenium-java-4.25.0\\msedgedriver.exe"); // Replace with actual path
        driver = new EdgeDriver();
        driver.get("http://localhost:10400/SeleniumIntro3/Index.html"); // Replace with actual local file path
        myPOM = new WebPOM(driver);
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
        		wait.withTimeout(Duration.ofSeconds(30));
	}

	@AfterEach
	void tearDown() throws Exception {
        driver.quit();
	}

	 @Test
	    @Timeout(value = 10, unit = TimeUnit.SECONDS)
	    public void testAddUser() {
	        WebElement usernameField = driver.findElement(By.id("username"));
	        usernameField.click();
	        usernameField.sendKeys("Graeme");

	        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));

	        driver.findElement(By.id("store")).click();

	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        String storedValue = (String) jsExecutor.executeScript("return localStorage.getItem('user');");
	        assertEquals("Graeme", storedValue);
	    }

	    @Test
	    @Timeout(value = 10, unit = TimeUnit.SECONDS)
	    public void testRecallUser() {
	        WebElement usernameField = driver.findElement(By.id("username"));
	        usernameField.click();
	        usernameField.sendKeys("Graeme");

	        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
	        WebElement storeButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("store")));
	        storeButton.click();

	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        String storedValue = (String) jsExecutor.executeScript("return localStorage.getItem('user');");
	        assertEquals("Graeme", storedValue);

	        driver.findElement(By.id("recall")).click();
	        wait.until(ExpectedConditions.textToBePresentInElementValue(usernameField, "Graeme"));
	        String usernameValue = usernameField.getAttribute("value");
	        assertEquals("Graeme", usernameValue);
	    }

	    @Test
	    @Timeout(value = 10, unit = TimeUnit.SECONDS)
	    public void testRemoveUser() {
	        WebElement usernameField = driver.findElement(By.id("username"));
	        usernameField.click();
	        usernameField.sendKeys("Graeme");

	        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));

	        driver.findElement(By.id("store")).click();

	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        String storedValue = (String) jsExecutor.executeScript("return localStorage.getItem('user');");
	        assertEquals("Graeme", storedValue);

	        driver.findElement(By.id("remove")).click();
	        wait.until(ExpectedConditions.textToBePresentInElementValue(usernameField, ""));
	        String usernameValue = usernameField.getAttribute("value");
	        assertEquals("", usernameValue);
	    }

	    @Test
	    @Timeout(value = 10, unit = TimeUnit.SECONDS)
	    public void testReset() {
	        WebElement usernameField = driver.findElement(By.id("username"));
	        WebElement legend = driver.findElement(By.id("leg"));

	        usernameField.click();
	        usernameField.sendKeys("Graeme");

	        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));

	        driver.findElement(By.id("store")).click();

	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        String storedValue = (String) jsExecutor.executeScript("return localStorage.getItem('user');");
	        assertEquals("Graeme", storedValue);

	        driver.findElement(By.id("reset")).click();
	        wait.until(ExpectedConditions.textToBePresentInElementValue(usernameField, ""));
	        String usernameValue = usernameField.getAttribute("value");
	        String legendText = legend.getText();
	        assertEquals("", usernameValue);
	        assertEquals("Enter Name:", legendText);
	    }
	}
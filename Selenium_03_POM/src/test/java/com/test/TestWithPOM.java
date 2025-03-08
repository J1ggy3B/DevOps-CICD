package com.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;




class TestWithPOM {
	private WebDriver driver;
	 private WebPOM myPOM;

	 
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.edge.driver", "C:\\DevTools\\edgedriver_win64_132_0_2957_127\\msedgedriver.exe"); // Replace with actual path
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
/*
 @Test
 	@Timeout(value = 10, unit = TimeUnit.SECONDS)
 	public void testAddUser() {
 	myPOM.enterName("Graeme");
 	FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
	myPOM.clickStore();
    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	        String storedValue = (String) jsExecutor.executeScript("return localStorage.getItem('user');");
	        assertEquals("Graeme", storedValue);
 }
 */	

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

/*
		 @Test
		 @Timeout(value = 20, unit = TimeUnit.SECONDS) // Increased timeout
		 public void testRecallUser() {
		     myPOM.enterName("Graeme");

		     FluentWait<WebDriver> wait = new FluentWait<>(driver)
		         .withTimeout(Duration.ofSeconds(50)) // Increased wait time
		         .pollingEvery(Duration.ofMillis(500))
		         .ignoring(NoSuchElementException.class);
		     myPOM.clickStore();
		     myPOM.clickRecall();
		     // Retrieve the username
		     System.out.println("Retrieving username...");
		     String usernameValue = myPOM.getUser();
		     System.out.println("The value of the username field is: " + usernameValue);
		     assertEquals("Graeme", usernameValue);
		 }

*/
	    
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
/*
	    @Test
	    @Timeout(value = 10, unit = TimeUnit.SECONDS)
	    public void testRemoveUser() {
		     myPOM.enterName("Graeme");
		     FluentWait<WebDriver> wait = new FluentWait<>(driver)
		         .withTimeout(Duration.ofSeconds(50)) // Increased wait time
		         .pollingEvery(Duration.ofMillis(500))
		         .ignoring(NoSuchElementException.class);
		     myPOM.clickStore();
		     myPOM.clickRecall();
		     myPOM.clickRemove();
		     // Retrieve the username
		     System.out.println("Retrieving username...");
		     String usernameValue = myPOM.getUser();
		     System.out.println("The value of the username field is: " + usernameValue);
		     assertEquals("", usernameValue);
		 }
*/

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
/*
	    @Test
	    @Timeout(value = 30, unit = TimeUnit.SECONDS)
	    public void testReset() {
		     myPOM.enterName("Graeme");
		     FluentWait<WebDriver> wait = new FluentWait<>(driver)
		         .withTimeout(Duration.ofSeconds(20)) // Increased wait time
		         .pollingEvery(Duration.ofMillis(500))
		         .ignoring(NoSuchElementException.class);
		     myPOM.clickStore();
		     myPOM.clickRecall();
		     myPOM.clickRemove();
		     myPOM.clickReset();
		     // Retrieve the username & legend
		     System.out.println("Retrieving username...");
		     String usernameValue = myPOM.getUser();
		     System.out.println("The value of the username field is: " + usernameValue);
		     assertEquals("", usernameValue);
		     String legendValue = myPOM.getLegend();
		     System.out.println("The value of the username legend is: " + legendValue);
		     assertEquals("Enter Name: ", legendValue);
		 } 
 */
 
	}
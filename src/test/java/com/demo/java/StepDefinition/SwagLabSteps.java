package com.demo.java.StepDefinition;

import java.io.ByteArrayInputStream;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.demo.java.Hooks.Hooks;
import com.demo.java.PageObjects.DemoPageObjects;
import com.demo.java.PageObjects.SwagLabPageObjects;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;

public class SwagLabSteps {


    private WebDriver driver;
    private String uniqueUsername;
    private SwagLabPageObjects swagLabPageObjects;


        public SwagLabSteps() {
        // Get the WebDriver instance from Hooks
        this.driver = Hooks.getDriver();
        swagLabPageObjects = new SwagLabPageObjects(driver);

        System.out.println("StepDefinitions initialized with driver: " + driver);
    }


    @Given("User launches chrome browser")
    public void user_launches_chrome_browser() {


            driver = new ChromeDriver();
            driver.manage().window().maximize();

        
        }


  
    // @Given("User launches {string} browser")
    // public void user_launches_browser(String browser) {
    
    //             if(browser.equalsIgnoreCase("chrome")) {
    //             //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
    //             demoPageObjects = new DemoPageObjects(driver);
    //             driver = new ChromeDriver();
    //             driver.manage().window().maximize();
    
    //         }
    // }




    
   @When("User opens url {string}")
public void user_opens_url(String url) {
    driver.get(url);
            
    byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    Allure.addAttachment("Landing Page", new ByteArrayInputStream(screenshot));
}




    @Then("User validates navigation is correct {string}")
public void user_validates_navigation_is_correct(String expectedTitle) {
    Assert.assertEquals(expectedTitle, driver.getTitle());

}

    @Then("User enters Username")
    public void user_enters_username() throws InterruptedException {
        Thread.sleep(10000);
                driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");

    }
    @Then("User enters password")
    public void user_enters_password() {
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("secret_sauce");
    }
    @Then("User Clicks on Login")
    public void user_clicks_on_login() {
        driver.findElement(By.xpath("//*[@name='login-button']")).click();
    }

    @Then("User adds item to Creat")
    public void user_adds_item_to_creat() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("User locates an item")
    public void user_locates_an_item() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }





}

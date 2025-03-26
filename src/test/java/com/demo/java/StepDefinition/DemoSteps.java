package com.demo.java.StepDefinition;

import com.demo.java.Hooks.Hooks;
import com.demo.java.PageObjects.DemoPageObjects;

import io.cucumber.java.en.*;
import io.qameta.allure.Allure;

//import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.Random;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class DemoSteps {

    private WebDriver driver;
    private DemoPageObjects demoPageObjects;
    private String uniqueUsername;
    private String Fname = "John";
    private String Sname = "Moodys";



    public DemoSteps() {
        // Get the WebDriver instance from Hooks
        driver = Hooks.getDriver();
        System.out.println("StepDefinitions initialized with driver: " + driver);
    }


    @Given("User Launch Chrome Browser")
    public void user_launch_chrome_browser() {
        demoPageObjects = new DemoPageObjects(driver);
        driver.manage().window().maximize();
    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
        
        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		Allure.addAttachment("Landing Page", new ByteArrayInputStream(screenshot));
    }

    @When("The page title should be {string}")
    public void the_page_title_should_be(String expectedTitle) {

        Assert.assertEquals(expectedTitle, driver.getTitle());

    }

    @Then("User clicks on the Add user button")
    public void user_clicks_on_the_add_user_button() {
        demoPageObjects.clickAddUserButton();

    }

    @Then("User enters a First Name")
    public void user_enters_a_first_name() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("User enters a Last Name")
    public void user_enters_a_last_name() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("User enters a User Name")
    public void user_enters_a_user_name() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("User enters a Password")
    public void user_enters_a_password() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Click the Company type")
    public void click_the_company_type() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Selects a Role")
    public void selects_a_role() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("User enters an Email Address")
    public void user_enters_an_email_address() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("User enters a Cell Phone Number")
    public void user_enters_a_cell_phone_number() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Click the save button")
    public void click_the_save_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Validate the data is saved")
    public void validate_the_data_is_saved() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Close Browser")
    public void close_browser() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    

}

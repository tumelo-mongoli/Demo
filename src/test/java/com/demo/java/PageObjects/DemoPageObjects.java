package com.demo.java.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoPageObjects {

    private WebDriver driver;

    public DemoPageObjects(WebDriver driver) {
        this.driver = driver;
    }

        public void clickAddUserButton() {
            driver.findElement(By.xpath("//button[contains(text(),'Add User')]")).click();
        }

        public void enterFirstName(String firstName) {
            driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys(firstName);
        }

    public void enterLastName(String lastName) {
        driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys(lastName);
    }

    public void enterUserName(String UserName) {
        driver.findElement(By.xpath("//input[@name='UserName']")).sendKeys(UserName);
    }

    public void enterPassword(String Password) {
        driver.findElement(By.xpath("//input[@name='Password']")).sendKeys(Password);
    }

    public void clickCompanyName() {
        driver.findElement(By.xpath("//*[text()='Customer']//../td/label[1]/input")).click();

    }

    public void SelectRole(String optionText) {

        WebElement dropdownToggle = driver.findElement(By.xpath("//*[@name='RoleId']"));
        dropdownToggle.click();
    
        // Locate and click the desired option
        String optionXpath = String.format("//*[@name='RoleId']/option[text()='Customer']", optionText);
        WebElement option = driver.findElement(By.xpath(optionXpath));
        option.click();
    }

    public void enterEmailAddress(String EmailAddress) {
        driver.findElement(By.xpath("//*[@name='Email']")).sendKeys(EmailAddress);
    }


    public void enterCellPhoneNUmber(String Mobilephone) {
        driver.findElement(By.xpath("//*[@name='Mobilephone']")).sendKeys(Mobilephone);
    }



    public void clickSaveButton() {
        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
    }


    
}

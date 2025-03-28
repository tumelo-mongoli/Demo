package com.demo.java.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwagLabPageObjects {

    private WebDriver driver;

    public SwagLabPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserName(String UserName) {
        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys(UserName);
    }


    public void enterUserPassword(String password) {
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys(password);
    }

    public void clickLoginButton() {

            driver.findElement(By.xpath("//*[@name='login-button']")).click();
            
        }


    public void clickAddToCart()
    {
        //find the item 

        //Click add to cart 
        driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']//..//..//..//*[text()='Add to cart']")).click();



    }     




    // public void validatePage() {

    //         driver.findElement(By.xpath("//*[@class='app_logo']")).click();
            
    //     }



    //*[text()='Sauce Labs Backpack']//..//..//..//*[text()='Add to cart']

    
    //standard_user


    //secret_sauce


    

}

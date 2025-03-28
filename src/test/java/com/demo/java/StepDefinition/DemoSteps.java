package com.demo.java.StepDefinition;

import com.demo.java.Hooks.Hooks;
import com.demo.java.PageObjects.DemoPageObjects;

import java.time.Duration;
import io.cucumber.java.en.*;
import io.qameta.allure.Allure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;





public class DemoSteps {

    private WebDriver driver;
    private String uniqueUsername;
    private DemoPageObjects demoPageObjects;

    private final Map<String, String> userData = new HashMap<>(); 
    

    public DemoSteps() {
        // Get the WebDriver instance from Hooks
        driver = Hooks.getDriver();
        System.out.println("StepDefinitions initialized with driver: " + driver);
    }
     
    @Given("User launches {string} browser")
    public void user_launches_browser(String browser) {
    
                if(browser.equalsIgnoreCase("chrome")) {
                //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
                demoPageObjects = new DemoPageObjects(driver);
                driver = new ChromeDriver();
                driver.manage().window().maximize();
    
            }
    }
    
    @When("User opens URL {string}")
    public void user_opens_url(String url) {
            driver.get(url);
            
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Landing Page", new ByteArrayInputStream(screenshot));
    }
    
    
    @When("User clicks on the Add user button")
    public void user_clicks_on_the_add_user_button() {
    
            try {
                    driver.findElement(By.xpath("//button[contains(text(),'Add User')]")).click(); 
            } 
            catch (Exception e) {
        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Landing Page", new ByteArrayInputStream(screenshot));
        throw e;
    }

    }
    
    @When("User enters profile details:")
    public void user_enters_profile_details(io.cucumber.datatable.DataTable dataTable) {
    
        Map<String, String> data = dataTable.asMap(String.class, String.class);
    
    // Generate unique username
    Random random = new Random();
    int randomNumber = random.nextInt(9000) + 1000; 
    uniqueUsername = data.get("User Name") + randomNumber;
    
    // Store original values EXACTLY as they appear in DataTable
    userData.put("First Name", data.get("First Name"));
    userData.put("Last Name", data.get("Last Name"));
    userData.put("User Name", uniqueUsername);
    userData.put("Password", data.get("Password"));
    userData.put("Email", data.get("Email"));
    userData.put("Cell Phone", data.get("Cell Phone"));
    
    // Debug output
    System.out.println("Stored user data: " + userData);
    
    // Enter data using consistent field names
    enterFieldSafely("FirstName", userData.get("First Name"));
    enterFieldSafely("LastName", userData.get("Last Name"));
    enterFieldSafely("UserName", userData.get("User Name"));
    enterFieldSafely("Password", userData.get("Password"));
    enterFieldSafely("Email", userData.get("Email"));
    enterFieldSafely("Mobilephone", userData.get("Cell Phone"));
        
    }
    
    private void validateEnteredValues() {
        
        Assert.assertEquals(userData.get("ExpectedFirstName"), getFieldValue("FirstName"));
        Assert.assertEquals(userData.get("ExpectedLastName"), getFieldValue("LastName"));
        Assert.assertEquals(userData.get("ExpectedUsername"), getFieldValue("UserName"));
        // Don't validate password field value for security reasons
        Assert.assertEquals(userData.get("ExpectedEmail"), getFieldValue("Email"));
        Assert.assertEquals(userData.get("ExpectedPhone"), getFieldValue("Mobilephone"));
    }
    
    private String getFieldValue(String fieldName) 
    {
        return driver.findElement(By.name(fieldName)).getDomAttribute("value");
    }
    
    private void enterFieldSafely(String fieldName, String value) {
          if (value == null) {
                System.err.println("NULL VALUE DETECTED FOR: " + fieldName);
                return;
            }
            
            try {
                By locator = By.name(fieldName.replace(" ", "")); // Remove spaces for name attribute
                WebElement field = driver.findElement(locator);
                field.clear();
                field.sendKeys(value);
                System.out.println("Entered '" + value + "' in " + fieldName);
            } catch (Exception e) {
                System.err.println("Failed to enter " + fieldName + ": " + e.getMessage());
            }
        }
    
    @When("User selects {string} as company")
    public void user_selects_as_company(String company) {
    
            switch(company.toUpperCase()) {
                case "COMPANY AAA":
                driver.findElement(By.xpath("//*[text()='Customer']//../td/label[1]/input")).click();
                    break;
                case "COMPANY BBB":
                driver.findElement(By.xpath("//*[text()='Customer']//../td/label[2]/input")).click();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid company: " + company);
            }
    }
    @When("User selects {string} as role")
    public void user_selects_as_role(String role) {
            new Select(driver.findElement(By.name("RoleId"))).selectByVisibleText(role);
    
        }
        @Then("Click the save button")
        public void click_the_save_button() {
            
            driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
    
        }
        
        @When("Validate the entered data appears correctly in the table")
        public void validate_the_entered_data_appears_correctly_in_the_table() {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    
            // 1. Debug output before validation
            System.out.println("Validating against stored data: " + userData);
            
            // 2. Wait for table and locate our row
            WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table[contains(@class,'table')]")));
            
            WebElement userRow = wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(table, By.xpath(".//tr[contains(.,'" + uniqueUsername + "')]")));
            
            // 3. Get all visible cells
            List<WebElement> cells = wait.until(ExpectedConditions.visibilityOfAllElements(userRow.findElements(By.xpath(".//td[not(contains(@style,'none'))]"))));
            
            // 4. Debug output - print actual table values
            System.out.println("Actual table values:");
            for (int i = 0; i < cells.size(); i++) {
                System.out.println("Column " + i + ": " + cells.get(i).getText().trim());
            }
            
            // 5. Validate with consistent key names
            Assert.assertEquals("First Name mismatch", 
                userData.get("First Name"), cells.get(0).getText().trim());
            Assert.assertEquals("Last Name mismatch", 
                userData.get("Last Name"), cells.get(1).getText().trim());
            Assert.assertEquals("Username mismatch", 
                userData.get("User Name"), cells.get(2).getText().trim());

        }

    
    @Then("The page title should be {string}")
    public void the_page_title_should_be(String expectedTitle) {
            Assert.assertEquals(expectedTitle, driver.getTitle());
    
    }
    @Then("Close browser")
    public void close_browser() {
                driver.quit();
    
    }
    
    

}

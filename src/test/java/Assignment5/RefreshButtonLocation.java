package Assignment5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utility.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class RefreshButtonLocation {

/**
 * User Story: "As a user when I am on Vytrack => Fleet => Vehicles,
 * I should be able to see Export Grid dropdown ,
 * Refresh, Reset and Grid Settings Buttons."
 */

    /**
     * Acceptance Criteria:
     * "Verify that Refresh button is on the left side of Reset button"
     */
    WebDriver driver;
    @BeforeClass
    public void setupMethod() {
        // Open Web browser and navigate to https://qa3.vytrack.com/user/login
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa3.vytrack.com/user/login");
    }

    // login method
    public void login() throws InterruptedException {
        // Given I am a Truck Driver
        // 1. When I enter valid username ("User153")
        WebElement username = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        username.sendKeys("User154");
        Thread.sleep(2000);

        // 2. And I enter valid password ("UserUser123")
        WebElement password = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        password.sendKeys("UserUser123");
        Thread.sleep(2000);

        // 3. And I click on Login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='_submit']"));
        loginButton.click();
        // 4. Then I should be able
        Thread.sleep(2000);
    }

    // Verify that Refresh button is on the left side of Reset button
    public void refreshOnTheLeftOfReset(String resetButton, String refreshButton) throws InterruptedException {

        String xpath = resetButton + "//preceding-sibling::" + refreshButton;
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(xpath));
        if (element.isDisplayed()&& element.isEnabled()){
            System.out.println("Refresh button  is on the left side of reset button ");
        }
    }

    //close method
    @AfterClass
    public void quit() throws InterruptedException {
        Thread.sleep(8000);
        driver.close();
    }

    @Test
    public void verifyLeftRightLocation() throws InterruptedException {
        // 1. Login to the application
        login();
        // 2. Hover over 'Fleet' module and click on 'Vehicles' function
        WebElement fleetModule = driver.findElement(By.xpath("//span[@class='title title-level-1']"));
        WebElement vehiclesModule = driver.findElement(By.xpath("//span[.='Vehicles']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(fleetModule).moveToElement(vehiclesModule).click().perform();
        Thread.sleep(2000);

        String refreshButton = "a[@title='Refresh']";
        String resetButton = "//a[@title='Reset']";

        // 3. Verify that Refresh button is on the left side of Reset button
        refreshOnTheLeftOfReset(resetButton, refreshButton);

    }

}

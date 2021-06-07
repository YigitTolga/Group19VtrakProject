import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VehicleFuelLogs {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://qa3.vytrack.com/user/login");
    }

    @Test
    public void Vytrack_Test() throws InterruptedException {
        //2. When:  I enter valid Username for Truck driver (user154)
        WebElement userNameLoginPage = driver.findElement(By.xpath("//*[@id='prependedInput']"));
        userNameLoginPage.sendKeys("user154");


        //4. And: I enter valid Password (UserUser123)
        WebElement passwordLoginPage = driver.findElement(By.xpath("//*[@id='prependedInput2']"));
        passwordLoginPage.sendKeys("UserUser123");


        //5. And: I Click Login button
        WebElement clickLoginButton = driver.findElement(By.xpath("//*[@id='_submit']"));
        clickLoginButton.click();
        Thread.sleep(1000);

        //6. Navigate fleet module
        WebElement fleetDroDown = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        fleetDroDown.click();
        Thread.sleep(1000);

        //7. Select Vehicle Fuel logs
        WebElement fuelLog = driver.findElement(By.xpath("(//*[@class='title title-level-2'])[5]"));
        fuelLog.click();

        //9. Verify actual and expected Title
        Thread.sleep(2000);

        String expectedFuelLogTitle = "Vehicle Fuel Logs - Entities - System - Car - Entities - System";
        String actualFuelLogTitle = driver.getTitle();

        Assert.assertEquals(actualFuelLogTitle, expectedFuelLogTitle, "Failed");

        WebElement refreshPage = driver.findElement(By.xpath("(//*[@class='fa-refresh'])[2]"));
        refreshPage.click();


    }

}

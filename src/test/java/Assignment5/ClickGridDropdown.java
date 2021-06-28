package Assignment5;

import com.sun.tools.internal.xjc.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utility.WebDriverFactory;

import java.util.concurrent.TimeUnit;


public class ClickGridDropdown {


    WebDriver driver;

    @BeforeClass
    public void setupMethod() throws InterruptedException {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://qa3.vytrack.com/user/login");
    }


    @Test
    public void VyTrack_test1() throws InterruptedException {

        //1. Open Chrome browser

        driver.get("https://qa3.vytrack.com/user/login");

        //2. Enter valid user name (user154)
        WebElement userName = driver.findElement(By.xpath("//*[@id='prependedInput']"));
        userName.sendKeys("user154");
        Thread.sleep(2);


        //3. Enter valid Password (UserUser123)
        WebElement password = driver.findElement(By.xpath("//*[@id='prependedInput2']"));
        password.sendKeys("UserUser123");
        Thread.sleep(2);


        //4. Click Login button
        WebElement clickLoginButton =driver.findElement(By.xpath("//*[@id='_submit']"));
        clickLoginButton.click();
        Thread.sleep(2);

        //5. Navigate Fleet module
        WebElement fleetDroDown = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        fleetDroDown.click();
        Thread.sleep(2);

        //6. Select Vehicle under Fleet module
        WebElement vehicle  = driver.findElement(By.xpath("(//*[@class='title title-level-2'])[1]"));
        vehicle.click();
        Thread.sleep(2);

        //6. Click Export Grid dropdown
        WebElement exportGrid = driver.findElement(By.xpath("(//a[@data-toggle = 'dropdown'])[4]"));
        exportGrid.click();

        // 7. Verify text displayed is as expected:
        String expectedExGridText = "Export Grid";
        String actualExGridText = exportGrid.getText();

        Assert.assertEquals(actualExGridText, expectedExGridText);



    }
}

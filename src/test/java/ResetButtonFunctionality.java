import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utility.WebDriverFactory;
import java.util.concurrent.TimeUnit;

/**
 * RESET BUTTON FUNCTIONALITY
 */
public class ResetButtonFunctionality {
    WebDriver driver;

    @BeforeClass
    public void setupMethod() {
        //1-Open Web Browser and navigate to  https://qa3.vytrack.com/user/login
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://qa3.vytrack.com/user/login");
    }

    @Test
    public void resetButtonFunctionality() throws InterruptedException {
        //2-Enter valid user name and password.(Username : User154 , Password: UserUser123)

        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("User154");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("UserUser123");

        //3-Click log-in button

        Thread.sleep(1000);
        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        button.click();

        //4-Click "Fleet Module" top on the left under the Fleet Management then click "Vehicles Fuel Logs"
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]")).click();
        Thread.sleep(1000);
        WebElement vehiclesFuelLogsButton = driver.findElement(By.xpath("//span[.='Vehicles Fuel Logs']"));
        vehiclesFuelLogsButton.click();

        //5-Click "Grid Setting" top on the right, under the Create Vehicle Fuel Logs button, right of the Reset Button and uncheck Odometer Value
        Thread.sleep(2000);
        WebElement gridSettingButton = driver.findElement(By.xpath("//i[@class='fa-cog hide-text']"));
        Thread.sleep(2000);
        gridSettingButton.click();
        Thread.sleep(1000);
        WebElement uncheckOdometerValue = driver.findElement(By.xpath("//input[@id='column-c91']"));
        Thread.sleep(1000);
        uncheckOdometerValue.click();
        Thread.sleep(1000);
        WebElement closeGridSettingPage = driver.findElement(By.xpath("//span[@class='close']"));
        Thread.sleep(1000);
        closeGridSettingPage.click();

        //6-Click "Reset Button" top of the right, under the Create Vehicle Fuel Logs button, right of the Refresh Button and Left of the Grid Setting button.
        Thread.sleep(1000);
        WebElement clickResetButton = driver.findElement(By.xpath("//a[@title='Reset']"));
        Thread.sleep(1000);
        clickResetButton.click();

        //7-Click "Grid Setting" button and check the list and verify it has been reset
        Thread.sleep(2000);
        WebElement verifyReset = driver.findElement(By.xpath("//i[@class='fa-cog hide-text']"));
        Thread.sleep(2000);
        verifyReset.click();
        //8-Verify the home page is displayed as expected.
        String expectedURLResult = "https://qa3.vytrack.com/entity/Extend_Entity_VehicleFuelLogs";
        String actualURL = driver.getCurrentUrl();
        if(actualURL.equals(expectedURLResult)){
            System.out.println("Url match, test PASSED!");
        }else{
            System.out.println("Url does not match, test FAILED!");
        }
    }

    @AfterClass
    public void quit() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}

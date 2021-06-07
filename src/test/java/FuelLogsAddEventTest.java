import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FuelLogsAddEventTest {


WebDriver driver;

    @BeforeClass
    public void setupMethod() throws InterruptedException {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://qa3.vytrack.com/user/login");
    }
        @Test
    public void login() throws InterruptedException {

        //3. When I enter valid user name:
        WebElement username = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        username.click();
        username.sendKeys("User153");
        Thread.sleep(1000);
        //4. And I enter valid Password
            WebElement password = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
            password.click();
            password.sendKeys("UserUser123");
            Thread.sleep(1000);
            //5. And Click Login button
            WebElement loginButton = driver.findElement(By.xpath("//button[@id='_submit']"));
            loginButton.click();
            Thread.sleep(1000);
            driver.navigate().refresh();
            WebElement fleet = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
            fleet.click();
            Thread.sleep(1000);
            WebElement fuelLog = driver.findElement(By.xpath("(//span[@class='title title-level-2'])[5]"));
            fuelLog.click();
            Thread.sleep(1000);
            WebElement viewLog = driver.findElement(By.xpath("//td[.='Exxon']"));
            viewLog.click();
            Thread.sleep(1000);

            WebElement addEventBtn = driver.findElement(By.xpath("(//a[@class='btn icons-holder-text no-hash'])[2]"));
            addEventBtn.click();
            WebElement addEventTitle = driver.findElement(By.xpath("//input[@data-name='field__title']"));
            addEventTitle.sendKeys("Receipt");
            Thread.sleep(2000);
            WebElement organizerName = driver.findElement(By.xpath("//input[@data-name='field__organizer-display-name']"));
            organizerName.sendKeys("Tolga");
            Thread.sleep(2000);

            WebElement organizerEmail = driver.findElement(By.xpath("//input[@data-name='field__organizer-email']"));
            organizerEmail.sendKeys("Tolga@Tolga.com");
            Thread.sleep(2000);
            WebElement summitBtn = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
            summitBtn.click();
            driver.findElement(By.xpath("//a[.='Activity']")).click();
        }


}
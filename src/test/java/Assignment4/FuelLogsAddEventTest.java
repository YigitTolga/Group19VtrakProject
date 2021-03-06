package Assignment4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utility.WebDriverFactory;

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
    @AfterClass
    public void quit() throws InterruptedException {
        Thread.sleep(8000);
        driver.quit();
    }
        public void login() throws InterruptedException {

        //1. When I enter valid user name:
        WebElement username = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        username.click();
        username.sendKeys("User153");
        Thread.sleep(1000);
        //2. And I enter valid Password
        WebElement password = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        password.click();
        password.sendKeys("UserUser123");
        Thread.sleep(1000);
        //3. And Click Login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='_submit']"));
        loginButton.click();
        Thread.sleep(1000);
        driver.navigate().refresh();
    }
    @Test
    public void addEvent() throws InterruptedException {
        //1.Login application
        login();
        //2. Click Fleet module on main page
        WebElement fleet = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        fleet.click();
        Thread.sleep(1000);

        //3. Then click Fuel Log button
        WebElement fuelLog = driver.findElement(By.xpath("(//span[@class='title title-level-2'])[5]"));
        fuelLog.click();
        Thread.sleep(5000);

        //4. Click on of fuel long and see view details
        WebElement viewLog = driver.findElement(By.xpath("//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-Vendor']"));
        viewLog.click();
        Thread.sleep(2000);

        //5. Click Add Event button
                WebElement addEventBtn = driver.findElement(By.xpath("(//a[@class='btn icons-holder-text no-hash'])[2]"));
        addEventBtn.click();
        Thread.sleep(2000);
//sadasd
        //6. Fill out required fields
                //1. Fill title of event
        WebElement addEventTitle = driver.findElement(By.xpath("//input[@data-name='field__title']"));
        addEventTitle.sendKeys("Receipt");
        Thread.sleep(2000);
                //2. Fill Organizer name
        WebElement organizerName = driver.findElement(By.xpath("//input[@data-name='field__organizer-display-name']"));
        organizerName.sendKeys("Tolga");
        Thread.sleep(2000);
                //3. Fill Organizer Email address
        WebElement organizerEmail = driver.findElement(By.xpath("//input[@data-name='field__organizer-email']"));
        organizerEmail.sendKeys("Tolga@Tolga.com");
        Thread.sleep(2000);

        //7. Summit Event
        WebElement summitBtn = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        summitBtn.click();
        Thread.sleep(2000);

        //8. Click activity button
        driver.findElement(By.xpath("//a[.='Activity']")).click();
    }

}
package Assignment5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.annotations.*;

import utility.WebDriverFactory;


import java.util.concurrent.TimeUnit;

public class GridSettingButtonLocation {
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

  //Login Method
    public void login() throws InterruptedException {

        //1. When I enter valid user name:
        Thread.sleep(1000);
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
    public void GridSettingLocation() throws InterruptedException {
        //1.Login application
        login();
        //2. Click Fleet module on main page
        WebElement fleet = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        fleet.click();
        Thread.sleep(1000);
        //3. Click Vehicle function
        WebElement vehicle = driver.findElement(By.xpath("//span[.='Vehicles']"));

        vehicle.click();

        //4.Find out Grid Setting button on the right side of Reset button


        Thread.sleep(2000);
        WebElement gridSettingBtn = driver.findElement(By.xpath("(//a[@href='#'])[18]"));
        Thread.sleep(2000);
        WebElement reset = driver.findElement(By.xpath("(//a[@href='#'])[17]"));

        Thread.sleep(1000);
        int resetLocationX = reset.getLocation().getX();
        int resetLocationY = reset.getLocation().getY();
        int settingLocationX = gridSettingBtn.getLocation().getX();
        int settingLocationY = gridSettingBtn.getLocation().getY();
        if (resetLocationX < settingLocationX && resetLocationY == settingLocationY) {
            System.out.println("Grid Setting button right side of the Reset button");
        }

    }
}

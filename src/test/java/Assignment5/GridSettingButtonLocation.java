package Assignment5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.*;

import utility.WebDriverFactory;


import java.sql.SQLOutput;
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
    //Is Button1 right side of Button2
    public void isBtn1RightOfBtn2(String button2, String button1) throws InterruptedException {

        String xpath = button2 + "//following-sibling::" + button1;
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(xpath));
        if (element.isDisplayed()&& element.isEnabled()){
            System.out.println("Button1  is right side of Button2 ");
        }
        element.click();

    }
    //quit Method
    @AfterClass
    public void quit() throws InterruptedException {
        Thread.sleep(8000);
        driver.quit();
    }

    @Test
    public void vehicleFunction() throws InterruptedException {
        //1.Login application
        login();
        //2. Click Fleet module on main page
        WebElement fleet = driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        fleet.click();
        Thread.sleep(1000);
        //3. Click Vehicle function
        WebElement vehicle = driver.findElement(By.xpath("//span[.='Vehicles']"));

        vehicle.click();
        Thread.sleep(2000);
        //4.Find out Grid Setting button on the right side of Reset button


        isBtn1RightOfBtn2("//a[@title='Reset']", "div[@class='column-manager dropdown']");
    }

}

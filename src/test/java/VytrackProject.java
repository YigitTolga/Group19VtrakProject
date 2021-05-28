import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

class VytrackProject {
    public static void main(String[] args) {

    }
    //aa
    public static void TruckDriver(String username1, String password1) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        // 1. Open Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Given I am on login page : https://qa3.vytrack.com/user/login
        driver.get("https://qa3.vytrack.com/user/login");

        //3. When I enter valid Truck Driver User name : User154
        WebElement username = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        username.click();
        username.sendKeys(username1);

        //5. And I enter valid Password for user User154 : UserUser123
        WebElement password = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        password.click();
        password.sendKeys(password1);

    }
}
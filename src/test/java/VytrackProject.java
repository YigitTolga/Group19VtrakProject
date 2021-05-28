import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

class VytrackProject {
    public static void main(String[] args) throws InterruptedException {
        Users("Invalid", "UserUser123");
    }

    public static void Users(String username1, String password1) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        // 1. Open Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Given I am on login page : https://qa3.vytrack.com/user/login
        driver.get("https://qa3.vytrack.com/user/login");
        Thread.sleep(3000);
        //3. When I enter valid user name:
        WebElement username = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        username.click();
        username.sendKeys(username1);
        Thread.sleep(3000);
        //4. And I enter valid Password
        WebElement password = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        password.click();
        password.sendKeys(password1);

        //5. And Click Login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='_submit']"));
        loginButton.click();
        Thread.sleep(3000);
        //6. Then I should be able to log in to the application : Verify Login
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Login Successful for User:" + username1 + "  password: " + password1);
        } else {
            System.out.println("Login Failed for User: " + username1 + "  password: " + password1);
        }
    }

}

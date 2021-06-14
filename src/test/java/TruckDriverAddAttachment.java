import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TruckDriverAddAttachment {
    public static void main(String[] args) throws InterruptedException {

        /**
         * As a truck driver I should be able to add attachment on Vehicle Fuel logs
         */

        // Step 1: Open Web browser and navigate to https://qa3.vytrack.com/user/login
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa3.vytrack.com/user/login");

        // Step 2: Enter valid username ("User153")
        WebElement username = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        username.sendKeys("User154");
        Thread.sleep(2000);

        // Step 3: Enter valid password ("UserUser123")
        WebElement password = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        password.sendKeys("UserUser123");
        Thread.sleep(2000);

        // Step 4: Click on Login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='_submit']"));
        loginButton.click();
        Thread.sleep(2000);


        // Step 5: Click on Fleet
        WebElement fleetModule = driver.findElement(By.xpath("//span[@class='title title-level-1']"));
        fleetModule.click();



        // Step 6: Click on "Vehicles Fuel Logs" section
        WebElement fuelLogsSection = driver.findElement(By.linkText("Vehicles Fuel Logs"));
        fuelLogsSection.click();


        // Step 7: Click on existing fuel log
        WebElement fuelLog = driver.findElement
                (By.xpath("//tr[@class='grid-row row-click-action']"));
        fuelLog.click();



        // Step 8: Click on "Add Attachment" button
        WebElement addAttachment = driver.findElement(By.cssSelector("a[class='btn icons-holder-text no-hash']"));
        addAttachment.click();

        // Step 9: Click on Choose File
        WebElement chooseFIle = driver.findElement(By.xpath
                ("//div[contains(@id,'uniform-oro_attachment_file')]/span[2]"));

        String expectedText = "Choose File";
        String actualText = chooseFIle.getText();
        System.out.println("actualText = " + actualText);

        if (actualText.equals(expectedText)) {
            System.out.println("User is able to add attachment on Vehicle Fuel logs --> PASSED");
        } else {
            System.out.println("User is not able to add attachment on Vehicle Fuel logs --> FAILED");
        }

    }
}

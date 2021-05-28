import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

class VytrackProject {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(" ");
        //3. When I enter valid Truck Driver User name : User154
        WebElement username = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        username.click();
        username.sendKeys(username1);

        //5. And I enter valid Password for user User154 : UserUser123
        WebElement password = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        password.click();
        password.sendKeys(password1);

        //6. And Click Login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='_submit']"));
        loginButton.click();
        Thread.sleep(3000);
        //7. Then I should be able to log in to the application : Verify Login
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
    }
}

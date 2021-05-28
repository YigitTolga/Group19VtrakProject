import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

class VytrackProject {
    public static void main(String[] args) {
        System.out.println(" ");
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

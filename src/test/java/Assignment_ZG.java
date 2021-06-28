import com.sun.tools.internal.xjc.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Assignment_ZG {


    @Test
    public void VyTrack_test1() {

        //1. Open Chrome browser
        Driver.getDriver().get("https://qa3.vytrack.com/user/login");

        //2. Enter valid user name (user154)
        WebElement userName = Driver.getDriver().findElement(By.xpath("//*[@id='prependedInput']"));
        userName.sendKeys("user154");
        BrowserUtils.sleep(2);


        //3. Enter valid Password (UserUser123)
        WebElement password = Driver.getDriver().findElement(By.xpath("//*[@id='prependedInput2']"));
        password.sendKeys("UserUser123");
        BrowserUtils.sleep(2);


        //4. Click Login button
        WebElement clickLoginButton = Driver.getDriver().findElement(By.xpath("//*[@id='_submit']"));
        clickLoginButton.click();
        BrowserUtils.sleep(2);

        //5. Navigate Fleet module
        WebElement fleetDroDown = Driver.getDriver().findElement(By.xpath("(//span[@class='title title-level-1'])[1]"));
        fleetDroDown.click();
        BrowserUtils.sleep(3);

        //6. Select Vehicle under Fleet module
        WebElement vehicle  = Driver.getDriver().findElement(By.xpath("(//*[@class='title title-level-2'])[1]"));
        vehicle.click();
        BrowserUtils.sleep(2);

        //6. Click Export Grid dropdown
        WebElement exportGrid = Driver.getDriver().findElement(By.xpath("(//a[@data-toggle = 'dropdown'])[4]"));
        exportGrid.click();

        // 7. Verify text displayed is as expected:
        String expectedExGridText = "Export Grid";
        String actualExGridText = exportGrid.getText();

        Assert.assertEquals(actualExGridText, expectedExGridText);



    }
}

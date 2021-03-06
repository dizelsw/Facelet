
package facelet.autotest;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

// Authentication check
// login is correct and  password is empty


public class Test7 {

    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.gecko.driver",
                "src\\test\\java\\lib\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://dev.facelet.com/#/");
    }
    @Test
    public void userLogin() {

        WebElement fieldPassword=driver.findElement(By.xpath("html/body/div[2]/ng-include/div/div[2]/form[2]/fieldset/sh-field[2]/input[1]"));
        fieldPassword.sendKeys("testtest");

        WebElement pageSignin1= driver.findElement(By.xpath("html/body/div[2]/ng-include/div/div[2]/form[2]/button"));
        String bottonSign = pageSignin1.getAttribute("enabled");
        System.out.println(bottonSign);

        if (bottonSign != "true")
            bottonSign = "disabled";
        else
            bottonSign = "enabled";


        System.out.println(bottonSign);


        Assert.assertEquals("disabled", bottonSign);

    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}

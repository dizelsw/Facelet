
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

//Authentication check
// Correct login and password

        public class Test1 {

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

        WebElement fieldName=driver.findElement(By.xpath("html/body/div[2]/ng-include/div/div[2]/form[2]/fieldset/sh-field[1]/input"));
        fieldName.sendKeys("TESTQA");

        WebElement fieldPassword=driver.findElement(By.xpath("html/body/div[2]/ng-include/div/div[2]/form[2]/fieldset/sh-field[2]/input[1]"));
        fieldPassword.sendKeys("testtest");
        WebElement buttonSignin=driver.findElement(By.xpath("html/body/div[2]/ng-include/div/div[2]/form[2]/button"));
       buttonSignin.click();
    }
    @AfterClass
    public static void tearDown() {
        WebElement buttonProf = driver.findElement(By.xpath("html/body/div[3]/ui-view/div/nav/div[2]/ul[1]/li[12]/a"));
//        buttonProf.click();
//        WebElement buttonLoginout = driver.findElement(By.xpath("/html/body/div[3]/ui-view/div/main/div/div/button"));
//        buttonLoginout.click();
       driver.quit();
    }
}
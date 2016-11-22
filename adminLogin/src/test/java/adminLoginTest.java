import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by korotkovay on 22.11.2016.
 */
public class adminLoginTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
         //DesiredCapabilities caps = new DesiredCapabilities();
        //caps.setCapability("unexpectedAlertBehaviour", "dismiss");
       // driver = new ChromeDriver(caps);



        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        System.out.println(((HasCapabilities) driver).getCapabilities());
    }

    @Test
    public void testAdminLogin() {
        driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.xpath("//a[@title=\"Logout\"]")).click();
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}

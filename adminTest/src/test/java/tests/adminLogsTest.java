package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testBase.TestBase;

import java.util.List;

/**
 * Created by korotkovay on 21.12.2016.
 */
public class adminLogsTest extends TestBase {

    @Test
    public void testBrowserLogs() throws InterruptedException {

        driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        String category = "http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1";
        driver.navigate().to(category);
        List<WebElement> products = driver.findElements(By.cssSelector("img + a"));
        for (int i = 0; i < products.size(); i++){
            List<WebElement> productLinks = driver.findElements(By.cssSelector("img + a"));
            productLinks.get(i).click();
            driver.manage().logs().get("browser").getAll().forEach(System.out::println);
            driver.findElement(By.name("cancel")).click();
        }

    }

}

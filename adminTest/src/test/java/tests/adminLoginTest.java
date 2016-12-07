package tests;


import org.junit.Test;
import org.openqa.selenium.By;
import testBase.TestBase;



/**
 * Created by korotkovay on 22.11.2016.
 */
public class adminLoginTest extends TestBase {

    @Test
    public void testAdminLogin() {
        driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.xpath("//a[@title='Logout']")).click();
    }

}

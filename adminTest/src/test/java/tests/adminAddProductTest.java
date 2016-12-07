package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import testBase.TestBase;

/**
 * Created by korotkovay on 07.12.2016.
 */
public class adminAddProductTest extends TestBase{

    @Test
    public void testAddProduct() {
        //login to admin interface
        driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        //go to product catalog
        driver.findElement(By.xpath("//li[@id='app-']/a[contains(@href, 'catalog')]")).click();
        driver.findElement(By.xpath("//li[@id='doc-catalog']/a")).click();

        //add new product
        driver.findElement(By.xpath("//a[contains(@href,'edit_product')]")).click();



    }
}

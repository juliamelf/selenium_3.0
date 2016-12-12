package tests;

import org.junit.Assert;
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

        //Status
        driver.findElement(By.cssSelector("label>input[value='1']")).click();

        //Name
        int productId = (int)(Math.random()*100);
        String productName = "Test Product" + productId;
        driver.findElement(By.name("name[en]")).sendKeys(productName);

        //Code
        driver.findElement(By.name("code")).sendKeys("test 123");

        //Categories
        driver.findElement(By.cssSelector("td>input[value='1']")).click();

        //Default Category
        Assert.assertEquals("Rubber Ducks", driver.findElement(By.name("default_category_id")).getText());

        //Product Groups
        driver.findElement(By.cssSelector("td>input[value='1-3']")).click();

        //Quantity
        driver.findElement(By.name("quantity")).clear();
        driver.findElement(By.name("quantity")).sendKeys("25");

        //Quantity Unit

        //Delivery Status

        //Sold Out Status
        driver.findElement(By.name("sold_out_status_id")).click();
        driver.findElement(By.cssSelector("select[name='sold_out_status_id']>option[value='2']")).click();

        //Upload Image

        //Date Valid From

        //Date Valid To

        //Manufacturer

        //Supplier

        //Keywords

        //Short Description

        //Description

        //Head Title

        //Meta Description

        //Purchase Price

        //Tax Class

        //Price USD

        //Price EUR

        driver.findElement(By.name("save")).click();




    }
}

package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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
        String productCode = "test 123";
        driver.findElement(By.name("code")).sendKeys(productCode);

        //Categories
        driver.findElement(By.cssSelector("td>input[value='1']")).click();

        //Default Category
        Assert.assertEquals("Rubber Ducks", driver.findElement(By.name("default_category_id")).getText());

        //Product Groups
        driver.findElement(By.cssSelector("td>input[value='1-3']")).click();

        //Quantity
        driver.findElement(By.name("quantity")).clear();
        driver.findElement(By.name("quantity")).sendKeys("25");

        //Sold Out Status
        driver.findElement(By.name("sold_out_status_id")).click();
        driver.findElement(By.cssSelector("select[name='sold_out_status_id']>option[value='2']")).click();

        //Upload Image
        WebElement image = driver.findElement(By.name("new_images[]"));
        //image.click();
        image.sendKeys("C:/Users/KorotkovaY.T1GROUP/Pictures/bender.jpg");

        //Date Valid From
        driver.findElement(By.name("date_valid_from")).sendKeys(Keys.HOME + "12-12-2016");

        //Date Valid To
        driver.findElement(By.name("date_valid_to")).sendKeys(Keys.HOME + "12-12-2017");

        //Information Tab
        driver.findElement(By.cssSelector("a[href='#tab-information']")).click();

        //Manufacturer
        driver.findElement(By.name("manufacturer_id")).click();
        driver.findElement(By.cssSelector("select[name='manufacturer_id']>option[value='1']")).click();

        //Keywords
        String keywords = "test product";
        driver.findElement(By.name("keywords")).sendKeys(keywords);

        //Short Description
        String shortDesc = "test description";
        driver.findElement(By.name("short_description[en]")).sendKeys(shortDesc);

        //Description
        String fullDesc = "full description";
        driver.findElement(By.name("description[en]")).sendKeys(fullDesc);

        //Head Title
        String headTitle = "test title";
        driver.findElement(By.name("head_title[en]")).sendKeys(headTitle);

        //Meta Description
        String meta = "test meta description";
        driver.findElement(By.name("meta_description[en]")).sendKeys(meta);

        //Prices tab
        driver.findElement(By.cssSelector("a[href='#tab-prices']")).click();

        //Purchase Price
        driver.findElement(By.name("purchase_price")).clear();
        driver.findElement(By.name("purchase_price")).sendKeys("100");
        driver.findElement(By.name("purchase_price_currency_code")).click();
        driver.findElement(By.cssSelector("select[name='purchase_price_currency_code']>option[value='USD']")).click();

        //Price USD
        driver.findElement(By.name("prices[USD]")).clear();
        driver.findElement(By.name("prices[USD]")).sendKeys(Keys.HOME + "100");

        //Price EUR
        Assert.assertEquals("72.60", driver.findElement(By.name("prices[EUR]")).getAttribute("placeholder"));

        //Save Product
        driver.findElement(By.name("save")).click();

        //go to product catalog
        driver.findElement(By.xpath("//li[@id='app-']/a[contains(@href, 'catalog')]")).click();
        driver.findElement(By.xpath("//li[@id='doc-catalog']/a")).click();

        //Check created product
        driver.findElement(By.linkText(productName)).click();
        Assert.assertEquals(productName, driver.findElement(By.name("name[en]")).getAttribute("value"));


    }
}

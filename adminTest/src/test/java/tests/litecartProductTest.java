package tests;

import org.apache.xpath.SourceTree;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import testBase.TestBase;

import static java.lang.Thread.sleep;

/**
 * Created by korotkovay on 06.12.2016.
 */
public class litecartProductTest extends TestBase {

    @Test
    public void testStickers() {
        driver.navigate().to("http://localhost/litecart/");

        //get 1st product from campaigns - main page
        WebElement campaigns = driver.findElement(By.xpath("//div[@id='box-campaigns']"));
        WebElement product = campaigns.findElement(By.xpath(".//a[@class='link']"));

        //get product data - main page
        String name = product.findElement(By.xpath(".//div[@class='name']")).getText();
        String regular_price = product.findElement(By.xpath(".//s[@class='regular-price']")).getText();
        String campaign_price = product.findElement(By.xpath(".//strong[@class='campaign-price']")).getText();

        //assert product style - main page
        Assert.assertEquals("s", product.findElement(By.cssSelector(".regular-price")).getTagName());
        Assert.assertEquals("rgba(119, 119, 119, 1)", product.findElement(By.cssSelector(".regular-price")).getCssValue("color"));
        Assert.assertEquals("line-through", product.findElement(By.cssSelector(".regular-price")).getCssValue("text-decoration"));
        Assert.assertEquals("strong", product.findElement(By.cssSelector(".campaign-price")).getTagName());
        Assert.assertEquals("rgba(204, 0, 0, 1)", product.findElement(By.cssSelector(".campaign-price")).getCssValue("color"));
        Assert.assertEquals("none", product.findElement(By.cssSelector(".campaign-price")).getCssValue("text-decoration"));

        //go to product page
        product.click();

        //assert product data - product page
        Assert.assertEquals(name, driver.findElement(By.cssSelector("h1")).getText());
        Assert.assertEquals(regular_price, driver.findElement(By.xpath("//s[@class='regular-price']")).getText());
        Assert.assertEquals(campaign_price, driver.findElement(By.xpath("//strong[@class='campaign-price']")).getText());

        //assert product style - product page
        Assert.assertEquals("s", driver.findElement(By.cssSelector(".regular-price")).getTagName());
        Assert.assertEquals("rgba(102, 102, 102, 1)", driver.findElement(By.cssSelector(".regular-price")).getCssValue("color"));
        Assert.assertEquals("line-through", driver.findElement(By.cssSelector(".regular-price")).getCssValue("text-decoration"));
        Assert.assertEquals("strong", driver.findElement(By.cssSelector(".campaign-price")).getTagName());
        Assert.assertEquals("rgba(204, 0, 0, 1)", driver.findElement(By.cssSelector(".campaign-price")).getCssValue("color"));
        Assert.assertEquals("none", driver.findElement(By.cssSelector(".campaign-price")).getCssValue("text-decoration"));

    }




}

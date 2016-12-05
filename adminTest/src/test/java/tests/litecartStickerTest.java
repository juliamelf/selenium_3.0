package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testBase.TestBase;

import java.util.Collection;

/**
 * Created by korotkovay on 05.12.2016.
 */
public class litecartStickerTest extends TestBase {

    void checkStickers(WebElement category) {

        int productsCount = category.findElements(By.xpath(".//a[@class='link']")).size();

        for (int i = 1; i <= productsCount; i = i + 1) {
            Collection<WebElement> stickers;
            stickers = category.findElements(By.xpath(".//li[" + i + "]//div[contains(@class, 'sticker')]"));
            int stickersCount = stickers.size();
            Assert.assertEquals(1, stickersCount);
        }

    }


    @Test
    public void testStickers() {
        driver.navigate().to("http://localhost/litecart/");
        driver.findElement(By.name("email")).sendKeys("testuser@email.com");
        driver.findElement(By.name("password")).sendKeys("testuser");
        driver.findElement(By.name("login")).click();

        //Most Popular
        WebElement mostPopular = driver.findElement(By.xpath("//div[@id='box-most-popular']"));
        checkStickers(mostPopular);

        //Campaigns
        WebElement campaigns = driver.findElement(By.xpath("//div[@id='box-campaigns']"));
        checkStickers(campaigns);

        //Latest Products
        WebElement latestProducts = driver.findElement(By.xpath("//div[@id='box-latest-products']"));
        checkStickers(latestProducts);

    }

}

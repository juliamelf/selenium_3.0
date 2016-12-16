package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testBase.TestBase;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;



/**
 * Created by korotkovay on 14.12.2016.
 */
public class litecartCartTest extends TestBase{

    @Test
    public void testAddToCart() {

        //Add first product
        addProduct(0);
        checkCartQuantity(1);

        //Add first product
        addProduct(1);
        checkCartQuantity(2);

        //Add first product
        addProduct(2);
        checkCartQuantity(3);

        //Go to Cart
        openCart();

        //Delete products from cart
        deleteProducts();

    }

    private void deleteProducts() {
        List<WebElement> products = driver.findElements(By.xpath("//div[@id='box-checkout-cart']//li[@class='item']"));
        driver.findElement(By.name("remove_cart_item")).click();
        wait.until(stalenessOf(products.get(0)));
        Assert.assertEquals(2, driver.findElements(By.xpath("//div[@id='box-checkout-cart']//li[@class='shortcut']")).size());
        driver.findElement(By.name("remove_cart_item")).click();
        wait.until(stalenessOf(products.get(1)));
        Assert.assertEquals(1, driver.findElements(By.xpath("//div[@id='box-checkout-cart']//li[@class='shortcut']")).size());
        //driver.findElement(By.name("remove_cart_item")).click();
        //wait.until(stalenessOf(products.get(2)));
       // Assert.assertEquals(0, driver.findElements(By.xpath("//div[@id='box-checkout-cart']//li[@class='shortcut']")).size());
    }


    private void openCart() {
        driver.findElement(By.xpath("//div[@id='cart']/a[@class='link']")).click();

    }

    public void addProduct(int id) {
        driver.navigate().to("http://localhost/litecart/");
        driver.findElement(By.xpath("//div[@id='box-category-tree']//a")).click();
        List<WebElement> products = driver.findElements(By.xpath("//ul[@class='listing-wrapper products']//a[@class='link']"));
        products.get(id).click();
        driver.findElement(By.name("add_cart_product")).click();

    }

    public void checkCartQuantity(int id) {
        Assert.assertTrue(isElementPresent(By.xpath("//div[@id='cart']//span[text() = '" + id + "']")));
    }


}
